package com.crawl.webchat.selenium;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crawl.util.DateUtil;
import com.crawl.util.StringUtils;
import com.crawl.webchat.dao.PgcWeekRankDao;
import com.crawl.webchat.entity.param.PgcWeekRankParam;
import com.crawl.webchat.entity.po.PgcWeekRank;

public class ParsePgcRank {

	public static void main(String[] args) throws Exception {
		// System.out.println(App.parseInt("46万+"));
		// parseFile("时事-2017-07-12.html");

		ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
		PgcWeekRankDao<PgcWeekRank, PgcWeekRankParam> pgcWeekRankDao = context.getBean(PgcWeekRankDao.class);

		String categoryNames[] = { "总排名", "金融财经", "健康养生", "科技智能", "乐活趣玩", "旅行户外", "美食餐饮", "美妆时尚", "汽车驾驶", "亲子育儿",
				"情感心理", "生活百科", "体育健身", "文化教育", "新闻资讯", "影视娱乐", "幽默搞笑", "游戏动漫" };
		Map<String, Integer> nameIdMap = new HashMap<String, Integer>();
		for (int i = 0; i < categoryNames.length; i++) {
			nameIdMap.put(categoryNames[i], i);
		}

		Date now = new Date();
		String dateStr = DateUtil.formatDate(now);
		String path = "./html/pgc/" + dateStr;
		File file = new File(path);
		String files[] = file.list();
		for (String fileName : files) {
			int pos = fileName.lastIndexOf(".");
			String cat = fileName.substring(0, pos);

			List<PgcWeekRank> pgcWeekRankList = parseFile(path + "/" + fileName);
			for (PgcWeekRank day : pgcWeekRankList) {
				day.setCategoryName(cat);
				day.setCategoryId(nameIdMap.get(cat));
				pgcWeekRankDao.insert(day);
			}
		}
	}

	public static List<PgcWeekRank> parseFile(String fileName) throws Exception {
		// "时事-2017-07-12.html"
		List<PgcWeekRank> pgcWeekRankList = new ArrayList<PgcWeekRank>();
		Document doc = Jsoup.parse(new File(fileName), "utf-8");

		String dateStr = doc.select(" #date_current").text();
		int pos = dateStr.indexOf("-");
		dateStr = dateStr.substring(0, pos);
		Date dat = DateUtil.parseChineseDate(dateStr);

		for (int i = 1; i <= 20; i++) {
			Element row = doc.select("#table_list > tbody > tr:nth-child(" + i + ")").get(0);
			PgcWeekRank rankDay = parseFromRow(row);
			rankDay.setRank(i);
			rankDay.setDayBegin(dat);
			pgcWeekRankList.add(rankDay);
		}
		// #more_list > tbody > tr:nth-child(1) > td:nth-child(2) > a
		if (doc.select("#more_list") != null) {
			for (int i = 1; i <= 80; i++) {
				Elements elements = doc.select("#more_list > tbody > tr:nth-child(" + i + ")");
				if (elements.isEmpty()){
					break;
				}
				Element row = doc.select("#more_list > tbody > tr:nth-child(" + i + ")").get(0);
				PgcWeekRank rankDay = parseFromRow(row);
				rankDay.setRank(i + 20);
				pgcWeekRankList.add(rankDay);
			}
		}
		return pgcWeekRankList;
	}

	public static PgcWeekRank parseFromRow(Element row) {
		Element link = row.select("td:nth-child(2) > a").get(0);
		Element youkuEle = row.select("td:nth-child(3)").get(0); //
		Element tecentEle = row.select("td:nth-child(4)").get(0);

		Element iqiyiEle = row.select("td:nth-child(5)").get(0);
		Element toutiaoEle = row.select("td:nth-child(6)").get(0);

		Element miaopaiEle = row.select("td:nth-child(7)").get(0);
		Element meipaiEle = row.select("td:nth-child(8)").get(0);
		Element pointEle = row.select("td:nth-child(9)").get(0);

		Element imgEle = row.select("td:nth-child(2) > div > img").get(0);

		String href = link.attr("href");
		int pos = href.lastIndexOf("/");
		String account = href.substring(pos + 1);

		PgcWeekRank rankDay = new PgcWeekRank();
		rankDay.setAccount(account);
		rankDay.setAccountName(link.attr("title"));

		rankDay.setIcon(imgEle.attr("src"));
		rankDay.setIqiyi(StringUtils.parseInt(iqiyiEle.text()));

		rankDay.setYouku(StringUtils.parseInt(youkuEle.text()));
		rankDay.setTecent(StringUtils.parseInt(tecentEle.text()));
		rankDay.setToutiao(StringUtils.parseInt(toutiaoEle.text()));
		rankDay.setMiaopai(StringUtils.parseInt(miaopaiEle.text()));
		rankDay.setMeipai(StringUtils.parseInt(meipaiEle.text()));
		rankDay.setPoint(StringUtils.parseDouble(pointEle.text()));
		return rankDay;
	}
}

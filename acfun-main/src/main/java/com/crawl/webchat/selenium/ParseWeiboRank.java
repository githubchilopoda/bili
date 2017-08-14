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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crawl.util.DateUtil;
import com.crawl.util.StringUtils;
import com.crawl.webchat.dao.WeiboWeekRankDao;
import com.crawl.webchat.entity.param.WeiboWeekRankParam;
import com.crawl.webchat.entity.po.WeiboWeekRank;

public class ParseWeiboRank {

	public static void main(String[] args) throws Exception {
		// System.out.println(App.parseInt("46万+"));
		// parseFile("时事-2017-07-12.html");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
		WeiboWeekRankDao<WeiboWeekRank, WeiboWeekRankParam> weiboWeekRankDao = context.getBean(WeiboWeekRankDao.class);
		
		Map<String, Integer> nameIdMap = new HashMap<String, Integer>();
		nameIdMap.put("personal", 1);
		nameIdMap.put("organization", 2);
		nameIdMap.put("unauthorized", 3);
		
		Date now = new Date();
		String dateStr = DateUtil.formatDate(now);
		String path = "./html/weibo/" + dateStr;
		File file = new File(path);
		String files[] = file.list();
		for (String fileName : files) {
			int pos = fileName.lastIndexOf(".");
			String cat = fileName.substring(0, pos);
			Integer type = nameIdMap.get(cat);			
			
			List<WeiboWeekRank> newRankDayList = parseFile(path + "/" + fileName);
			for (WeiboWeekRank day: newRankDayList){

				//day.setDayBegin(dayBegin);
				day.setType(type);
				weiboWeekRankDao.insert(day);
			}
		}
	}

	public static List<WeiboWeekRank> parseFile(String fileName) throws Exception {
		// "时事-2017-07-12.html"
		List<WeiboWeekRank> newRankDayList = new ArrayList<WeiboWeekRank>();
		Document doc = Jsoup.parse(new File(fileName), "utf-8");
		
		// 日期  #date_current    07月03日-09日		
		String dateStr = doc.select(" #date_current").text();
		int pos = dateStr.indexOf("-");
		dateStr = dateStr.substring(0, pos);
		Date dat = DateUtil.parseChineseDate(dateStr);

		for (int i = 1; i <= 20; i++) {
			Element row = doc.select("#table_list > tbody > tr:nth-child(" + i + ")").get(0);
			WeiboWeekRank rankDay = parseFromRow(row);
			rankDay.setRank(i);
			rankDay.setDayBegin(dat);
			newRankDayList.add(rankDay);
		}

		for (int i = 1; i <= 30; i++) {
			Element row = doc.select("#more_list > tbody > tr:nth-child(" + i + ")").get(0);
			WeiboWeekRank rankDay = parseFromRow(row);
			rankDay.setRank(i + 20);
			rankDay.setDayBegin(dat);
			newRankDayList.add(rankDay);
		}
		return newRankDayList;
	}

	public static WeiboWeekRank parseFromRow(Element row) {
		Element link = row.select("td:nth-child(2) > a").get(0);
		Element fanNumEle = row.select("td:nth-child(3)").get(0);  //
		Element pubNumEle = row.select("td:nth-child(4)").get(0);

		Element starNumEle = row.select("td:nth-child(5)").get(0);
		Element comentNumEle = row.select("td:nth-child(6)").get(0);

		Element forwardNumEle = row.select("td:nth-child(7)").get(0);
		
		Element imgEle = row.select("td:nth-child(2) > div > img").get(0);

		String href = link.attr("href");
		int pos = href.lastIndexOf("/");
		String account = href.substring(pos + 1);

		WeiboWeekRank rankDay = new WeiboWeekRank();
		rankDay.setAccount(account);
		rankDay.setAccountName(link.attr("title"));
		rankDay.setCommentNumber(StringUtils.parseInt(comentNumEle.text()));
		rankDay.setFansNumber(StringUtils.parseInt(fanNumEle.text()));
		rankDay.setForwardNumber(StringUtils.parseInt(forwardNumEle.text()));
		rankDay.setPublishNumber(StringUtils.parseInt(pubNumEle.text()));
		rankDay.setStarNumber(StringUtils.parseInt(starNumEle.text()));
		
		rankDay.setIcon(imgEle.attr("src"));
		return rankDay;
	}
}

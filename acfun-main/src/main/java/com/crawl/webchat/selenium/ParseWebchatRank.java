package com.crawl.webchat.selenium;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crawl.util.DateUtil;
import com.crawl.util.StringUtils;
import com.crawl.webchat.dao.NewRankDayDao;
import com.crawl.webchat.entity.param.NewRankDayParam;
import com.crawl.webchat.entity.po.NewRankDay;

public class ParseWebchatRank {

	public static void main(String[] args) throws Exception {
		// System.out.println(App.parseInt("46万+"));
		// parseFile("时事-2017-07-12.html");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
		NewRankDayDao<NewRankDay, NewRankDayParam> newRankDayDao = context.getBean(NewRankDayDao.class);
		
		Date now = new Date();
		String dateStr = DateUtil.formatDate(now);
		String path = WebchatDayRankCrawl.DIR + dateStr;
		File file = new File(path);
		String files[] = file.list();
		for (String fileName : files) {
			int pos = fileName.lastIndexOf(".");
			String cat = fileName.substring(0, pos);			
			
			List<NewRankDay> newRankDayList = parseFile(path + "/" + fileName);
			for (NewRankDay day: newRankDayList){
				day.setCategoryName(cat);
				newRankDayDao.insert(day);
			}
		}
	}

	public static List<NewRankDay> parseFile(String fileName) throws Exception {
		// "时事-2017-07-12.html"
		List<NewRankDay> newRankDayList = new ArrayList<NewRankDay>();
		Document doc = Jsoup.parse(new File(fileName), "utf-8");

		for (int i = 1; i <= 20; i++) {
			Element row = doc.select("#table_list > tbody > tr:nth-child(" + i + ")").get(0);
			NewRankDay rankDay = parseFromRow(row);
			rankDay.setRank(i);
			//System.out.println(rankDay);
			newRankDayList.add(rankDay);
		}

		for (int i = 1; i <= 30; i++) {
			Element row = doc.select("#more_list > tbody > tr:nth-child(" + i + ")").get(0);
			NewRankDay rankDay = parseFromRow(row);
			rankDay.setRank(i + 20);
			//System.out.println(rankDay);
			newRankDayList.add(rankDay);
		}
		return newRankDayList;
	}

	public static NewRankDay parseFromRow(Element row) {
		Element link = row.select("td:nth-child(2) > div > h4 > a").get(0);
		Element fabu = row.select("td:nth-child(3)").get(0);
		Element zongyuedu = row.select("td:nth-child(4)").get(0);

		Element toutiao = row.select("td:nth-child(5)").get(0);
		Element pingjun = row.select("td:nth-child(6)").get(0);

		Element zuigao = row.select("td:nth-child(7)").get(0);
		Element dianzhan = row.select("td:nth-child(8)").get(0);

		Element zishu = row.select("td:nth-child(9)").get(0);

		String href = link.attr("href");
		int pos = href.indexOf("=");
		String account = href.substring(pos + 1);

		NewRankDay rankDay = new NewRankDay();
		rankDay.setAccount(account);
		rankDay.setAccountName(link.attr("title"));
		rankDay.setCategoryName("时事");
		rankDay.setDay(new Date());
		rankDay.setDianzhan(StringUtils.parseInt(dianzhan.text()));

		String parts[] = fabu.text().split("/");
		rankDay.setFabu1(Integer.parseInt(parts[0]));
		rankDay.setFabu2(Integer.parseInt(parts[1]));

		rankDay.setPingjun(StringUtils.parseInt(pingjun.text()));
		// rankDay.setRank(i);
		rankDay.setToutiao(StringUtils.parseInt(toutiao.text()));
		rankDay.setZishu(Double.parseDouble(zishu.text()));
		rankDay.setZongyuedu(StringUtils.parseInt(zongyuedu.text()));
		rankDay.setZuigao(StringUtils.parseInt(zuigao.text()));
		return rankDay;
	}
}

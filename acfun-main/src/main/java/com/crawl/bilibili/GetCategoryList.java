package com.crawl.bilibili;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crawl.util.FileUtil;
import com.crawl.webchat.dao.BiliCategoryDao;
import com.crawl.webchat.entity.param.BiliCategoryParam;
import com.crawl.webchat.entity.po.BiliCategory;


public class GetCategoryList {

	public static void main(String[] args) throws Exception {
		//parse();
		parseCat();
		
		//String content = FileUtil.getFileContents("E:\\xujing\\webchat\\selenium\\动画.html", "utf-8");
		//Document doc = Jsoup.parse(content);
		//parseCat(doc);
	}
	
	public static void crawl(){
		String url = "https://www.bilibili.com/";
		
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Administrator\\workspace\\HelloPython\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get(url);
		
		String html = driver.getPageSource();
	}
	
	public static void parse() throws Exception{
		String file = "E:\\xujing\\webchat\\selenium\\src\\main\\resources\\billbili.html";
		String html = FileUtil.getFileContents(file, "utf-8");
		Document doc = Jsoup.parse(html);
		Elements elements = doc.select("#primary_menu > ul > li");
		for (Element element: elements){  // :nth-child(3) > a > div.nav-name
			Elements ele = element.select("a > div.nav-name");
			if (ele.isEmpty()){
				continue;
			}
			Element tag = ele.get(0);
			System.out.print(tag.text());
			
			Element alink = element.select("a").get(0);
			System.out.println("\t" + alink.attr("href"));
			
			Elements liElements = element.select("ul > li");
			
			for (Element liElement: liElements){
				Element link = liElement.select("a").get(0);
				String url = link.attr("href");
				System.out.print(url);
				
				Element span = liElement.select("span").get(0);
				System.out.println("\t" + span.text());
			}
			
			// #primary_menu > ul > li:nth-child(2) > ul
		}
	}
	
	public static void parseCat() throws Exception{
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
		BiliCategoryDao<BiliCategory, BiliCategoryParam> biliCategoryDao = context.getBean(BiliCategoryDao.class);
		
		String url = "https://www.bilibili.com/video/douga.html";
		
		System.setProperty("webdriver.gecko.driver",
				"G:\\Programs\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get(url);
		
		String content = driver.getPageSource();
		Document doc = Jsoup.parse(content);
		
		// body > div.header > div.num.nav-main > div > ul > li.m-i.on > a > em
		String cssQuery = "body > div.header > div.num.nav-main > div > ul > li.m-i.on > a > em";
		
		//String categorys[] = {"", "", ""};  
		
		// https://www.bilibili.com/video/douga.html
		
		//String content = HttpUtils.doGet(url, null, "utf-8");
		String catName = doc.select(cssQuery).get(0).text();
		FileUtil.filePutContent(catName + ".html", content, "utf-8");
		
		cssQuery = "body > div.header > div.num.nav-main > div > ul > li.m-i.on";
		String strTid = doc.select(cssQuery).get(0).attr("data-tid");
		int tid = Integer.parseInt(strTid);
		
		BiliCategory category = new BiliCategory();
		category.setId(tid);
		
		String enName = getEnNameFromUrl(url);
		
		
		category.setEnName(enName);
		category.setName(catName);
		category.setPid(0);
		category.setUrl(url);
		biliCategoryDao.insert(category);
		
		List<BiliCategory> subCategoryList = parseCat(doc);
		for (BiliCategory subCategory: subCategoryList){
			subCategory.setPid(tid);	
			biliCategoryDao.insert(subCategory);
		}
		
		//driver.close();
		
		// body > div.header > div.num.nav-main > div > ul > li.m-i.on
		// body > div.header > div.num.nav-main > div > ul > li:nth-child(3)
		
		
//		Elements elements = doc.select("body > div.header > div.num.nav-main > div > ul > li");
//		for (Element element: elements){
//			String strTid = element.attr("data-tid");
//			if (strTid == null){
//				continue;
//			}
//			System.out.print(strTid + "\t");
//			Element aLink = element.select("a").get(0);
//			System.out.print(aLink.attr("href") + "\t");
//			Element aTitle = element.select("a > em").get(0);
//			System.out.println(aTitle.text());
//			Elements subElements = element.select("ul > li");
//			for (Element subElement: subElements){
//				System.out.print("\t");
//				Element subLink = subElement.select("a").get(0);
//				Element subTitle = subElement.select("a > b").get(0);
//				System.out.println(subLink.attr("href") + "\t" + subTitle.text());
//			}
//			System.out.println();			
//		}
		// body > div.header > div.num.nav-main > div > ul > li:nth-child(3) > a
		// body > div.header > div.num.nav-main > div > ul > li:nth-child(14) > a
		for (int i = 3; i <= 14; i++){
			
			if (i == 12){
				continue;
			}
			
			String css = String.format("body > div.header > div.num.nav-main > div > ul > li:nth-child(%d) > a", i);
			driver.findElement(By.cssSelector(css)).click();
			
			content = driver.getPageSource();
			doc = Jsoup.parse(content);
			
			// body > div.header > div.num.nav-main > div > ul > li.m-i.on > a > em
			cssQuery = "body > div.header > div.num > div > ul > li.m-i.on > a > em";
			//          //body > div.header > div.num > div > ul > li.m-i.on > a > em
			//String categorys[] = {"", "", ""};  
			
			// https://www.bilibili.com/video/douga.html
			
			//String content = HttpUtils.doGet(url, null, "utf-8");
			catName = doc.select(cssQuery).get(0).text();
			FileUtil.filePutContent(catName + ".html", content, "utf-8");
			
			cssQuery = "body > div.header > div.num.nav-main > div > ul > li.m-i.on";
			if (doc.select(cssQuery).isEmpty()){
				continue;
			}
			
			strTid = doc.select(cssQuery).get(0).attr("data-tid");
			tid = Integer.parseInt(strTid);
			Element linkEle = doc.select("body > div.header > div.num.nav-main > div > ul > li.m-i.on > a").get(0);
			url = linkEle.attr("href");		
			
			category = new BiliCategory();
			category.setId(tid);
			enName = getEnNameFromUrl(url);
			
			category.setEnName(enName);
			category.setName(catName);
			category.setPid(0);
			category.setUrl(url);
			biliCategoryDao.insert(category);
			subCategoryList = parseCat(doc);
			for (BiliCategory subCategory: subCategoryList){
				subCategory.setPid(tid);	
				biliCategoryDao.insert(subCategory);
			}
			
			// body > div.b-page-body > div.container-top-wrapper > div > div.fcname > ul > li:nth-child(2)
		}
		driver.close();
	}
	
	static List<BiliCategory> parseCat(Document doc){
		List<BiliCategory> retList = new ArrayList<BiliCategory>();
		String cssQuery = "body > div.b-page-body > div.container-top-wrapper > div > div.fcname > ul > li";
		Elements elements = doc.select(cssQuery);
		if (elements.size() <= 1){
			return retList;
		}
		//elements.remove(0);
		for (int i = 1; i < elements.size(); i++){
			BiliCategory category = new BiliCategory();
			Element ele = elements.get(i);
			String strTid = ele.attr("tid");
			Element link = ele.select("a").get(0);
			String url = link.attr("href");
			String title = link.text();
			if (!strTid.equals("")) {
				Integer tid = Integer.parseInt(strTid);
				category.setId(tid);
			}
			
			category.setEnName(getEnNameFromUrl(url));
			category.setUrl(url);
			category.setName(title);
			retList.add(category);
			//System.out.println(strTid + "\t" + title + "\t" + url);
		}
		return retList;
	}
	
	private static String getEnNameFromUrl(String url){
		String enName = url.substring(url.lastIndexOf("/") + 1);
		if (enName.lastIndexOf(".") < 0){
			return enName;
		}
		enName = enName.substring(0, enName.lastIndexOf("."));
		return enName;
	}
	
	// http://api.bilibili.com/archive_rank/getarchiverankbypartion?callback=jQuery172029829570138479666_1501812844404&type=jsonp&tid=24&pn=2&_=1501812857961
}

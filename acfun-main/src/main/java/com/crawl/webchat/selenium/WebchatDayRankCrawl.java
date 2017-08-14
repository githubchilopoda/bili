package com.crawl.webchat.selenium;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crawl.util.DateUtil;
import com.crawl.util.FileUtil;
import com.crawl.webchat.dao.NewRankDayDao;
import com.crawl.webchat.entity.param.NewRankDayParam;
import com.crawl.webchat.entity.po.NewRankDay;

/**
 * Hello world!
 *
 */
public class WebchatDayRankCrawl {

	public static String DIR = "./html/rank/";

	public static void main(String[] args) throws Exception {
		//NewRankDayParam param = new NewRankDayParam();
		//int count = newRankDayDao.selectCount(param);
		//System.out.println(count);
		crawlPages();
	}

	public static void crawlPages() throws Exception{
		//DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		//String dateStr = df.format(new Date());
		
		Date now = new Date();
		String dateStr = DateUtil.formatDate(now);

		String[] row1 = { "时事", "民生", "财富", "科技", "创业", "汽车", "楼市", "职场", "教育", "学术", "政务", "企业" };
		String[] row2 = { "文化", "百科", "健康", "时尚", "美食", "乐活", "旅行", "幽默", "情感", "体娱", "美体", "文摘" };

		// System.out.println( "Hello World!" );
		System.setProperty("webdriver.gecko.driver",
				"./geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.newrank.cn/public/info/list.html?period=day&type=data");

		Thread.sleep(1000L);

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1200)");
		// driver.manage().
		Thread.sleep(1000L);

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1200)");
		// driver.manage().
		Thread.sleep(1000L);

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1200)");
		// driver.manage().
		Thread.sleep(2000L);

		String pageSource = driver.getPageSource();
		new File(DIR + dateStr + "/").mkdirs();
		FileUtil.filePutContents(DIR + dateStr + "/" + row1[0] + ".html", pageSource);

		Thread.sleep(2000L);

		for (int i = 2; i <= 12; i++) {
			String css = String.format("#day_zixun_links > a:nth-child(%d)", i);
			driver.findElement(By.cssSelector(css)).click();

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1200)");
			// driver.manage().
			Thread.sleep(1000L);

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1200)");
			// driver.manage().
			Thread.sleep(1000L);

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1200)");
			// driver.manage().
			Thread.sleep(2000L);

			pageSource = driver.getPageSource();
			FileUtil.filePutContents(DIR + dateStr + "/" + row1[i - 1]  + ".html", pageSource);
			Thread.sleep(2000L);
		}

		for (int i = 1; i <= 12; i++) {
			String css = String.format("#day_life_links > a:nth-child(%d)", i);
			driver.findElement(By.cssSelector(css)).click();

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1200)");
			// driver.manage().
			Thread.sleep(1000L);

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1200)");
			// driver.manage().
			Thread.sleep(1000L);

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1200)");
			// driver.manage().
			Thread.sleep(2000L);

			pageSource = driver.getPageSource();
			FileUtil.filePutContents(DIR + dateStr + "/" + row2[i - 1]  + ".html", pageSource);
			Thread.sleep(2000L);
		}

		// driver.findElement(By.cssSelector("#day_zixun_links >
		// a:nth-child(2)")).click();
		driver.close();

		System.out.println("Done");
	}	

}

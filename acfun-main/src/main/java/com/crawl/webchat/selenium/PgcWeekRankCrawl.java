package com.crawl.webchat.selenium;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crawl.util.DateUtil;
import com.crawl.util.FileUtil;

/**
 * Hello world!
 *
 */
public class PgcWeekRankCrawl {

	public static String DIR = "./html/pgc/";

	public static void main(String[] args) throws Exception {
		// NewRankDayParam param = new NewRankDayParam();
		// int count = newRankDayDao.selectCount(param);
		// System.out.println(count);
		crawlPages();
	}

	public static void crawlPages() throws Exception {
		// DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		// String dateStr = df.format(new Date());

		//String row1[] = { "个人认证", "机构认证", "未认证" };

		Date now = new Date();
		String dateStr = DateUtil.formatDate(now);

		// System.out.println( "Hello World!" );
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Administrator\\workspace\\HelloPython\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.newrank.cn/public/info/list.html?period=pgcweek&type=data");
		
		List<String> categoryNameList = new ArrayList<String>();
		WebElement webElement = driver.findElement(By.cssSelector("body > div.bang-top-menu > div.pgc-type-list.list > div.pgc-right-type"));
		int i = 1;
		for (; i <= 18; i++){
			String css = String.format("a:nth-child(%d)", i);
			String categoryName = webElement.findElement(By.cssSelector(css)).getText();
			categoryNameList.add(categoryName);
		}

		i = 0;
		new File(DIR + dateStr + "/").mkdirs();
		do {
			if (i == 0) {
				Thread.sleep(1000L);
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1200)");
				Thread.sleep(1000L);
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1200)");
				Thread.sleep(1000L);
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1200)");
			}

			Thread.sleep(2000L);

			String pageSource = driver.getPageSource();
			FileUtil.filePutContents(DIR + dateStr + "/" + categoryNameList.get(i) + ".html", pageSource);			
			
			// body > div.bang-top-menu > div.pgc-type-list.list > div.pgc-right-type > a:nth-child(2)
			
			i++;
			if (i != 18) {
				webElement.findElement(By.cssSelector("a:nth-child(" + (i + 1) +  ")")).click();
			}
			
		} while (i < 18);

		driver.close();

		System.out.println("Done");
	}	
}

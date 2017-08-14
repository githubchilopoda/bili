package com.crawl.webchat.selenium;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crawl.util.DateUtil;

/**
 * Hello world!
 *
 */
public class WeiboWeekRankCrawl {

	public static String DIR = "./html/weibo/";

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
		List<String> catList = new ArrayList<String>();
		// body > div.bang-top-menu > div.pgc-type-list.list > div.pgc-right-type > a:nth-child(2)
		// body > div.bang-top-menu > div.pgc-type-list.list > div.pgc-right-type > a.pgc-type-selected
		// body > div.bang-top-menu > div.pgc-type-list.list > div.pgc-right-type > a:nth-child(18)

		int i = 0;
		String caps[] = {"personal", "organization", "unauthorized"};
		do {

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
			filePutContents(DIR + dateStr + "/" + caps[i] + ".html", pageSource);			
			i++;
			if (i < 3){
				driver.findElement(By.cssSelector("#" + caps[i])).click();
			}

		} while (i < 3);

		driver.close();

		System.out.println("Done");
	}

	public static int parseInt(String strValue) {
		// 22万+
		strValue = strValue.replace(",", "");
		int pos = strValue.indexOf("万");
		if (pos < 0) {
			pos = strValue.indexOf("w");
		}
		if (pos > 0) {
			return Integer.parseInt(strValue.substring(0, pos)) * 10000;
		}
		return Integer.parseInt(strValue);
	}

	public static long parseLong(String strValue) {
		return Long.parseLong(strValue);
	}

	public static String base64Decode(String src) {
		return new String(Base64.getDecoder().decode(src), Charset.forName("utf-8"));
	}

	public static void filePutContents(String fileName, String contents) throws Exception {
		// Date now = new Date();
		// String dateStr = DateUtil.formatDate(now);
		// String path = DIR + dateStr + "/";
		// new File(path).mkdirs();
		FileOutputStream fos = new FileOutputStream(fileName);
		fos.write(contents.getBytes("utf-8"));
		fos.close();
	}
}

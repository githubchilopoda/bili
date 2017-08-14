package com.crawl.webchat.selenium;

import java.io.File;
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

public class LoginCrawl {

	public static void main(String[] args) throws Exception {
		String accountLoginTab = "div.login-normal-tap:nth-child(2)";
		String accountField = "#account_input";
		String passwordField = "#password_input";
		String loginBtn = "#pwd_confirm";
		
		String account = "18500233380";
		String password = "hong421122";
		
		String loginUrl = "http://www.newrank.cn/public/login/login.html";		
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Administrator\\workspace\\HelloPython\\geckodriver.exe");
    	WebDriver driver = new FirefoxDriver();
    	driver.get(loginUrl);
		
    	driver.findElement(By.cssSelector(accountLoginTab)).click();
    	
    	driver.findElement(By.cssSelector(accountField)).sendKeys(account);
    	driver.findElement(By.cssSelector(passwordField)).sendKeys(password);
    	
    	driver.findElement(By.cssSelector(loginBtn)).click();
    	
    	Date now = new Date();
    	String dayStr = DateUtil.formatDate(now);
    	String dir = "./html/author/" + dayStr;
    	new File(dir).mkdirs();
    
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
		NewRankDayDao<NewRankDay, NewRankDayParam> newRankDayDao = context.getBean(NewRankDayDao.class);
		
		NewRankDayParam dayParam = new NewRankDayParam();
		//dayParam.setDay(new Date());
		dayParam.setPageSize(2000);
		List<NewRankDay>  newRankDayList = newRankDayDao.selectList(dayParam);
		
		for (NewRankDay rankDay: newRankDayList){
			String acc = rankDay.getAccount();
			String destUrl = "http://www.newrank.cn/public/info/detail.html?account=" + acc;
			
			driver.get(destUrl);
			
			Thread.sleep(1000L);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1200)");
			// driver.manage().
			
			Thread.sleep(1000L);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1200)");
			// driver.manage().			
			
			Thread.sleep(2000);
	    	String pageSource = driver.getPageSource();
	    	FileUtil.filePutContents(dir +  "/" +  acc + ".html", pageSource);
	    	break;
		}
    	driver.close();
    	System.out.println("Done");
	}

}

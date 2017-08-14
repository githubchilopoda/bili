package com.crawl.webchat.selenium;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class CrawlWithEvent {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Administrator\\workspace\\HelloPython\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
    	WebDriverEventListener listener = new LogEventListener();
    	EventFiringWebDriver  eDriver = new EventFiringWebDriver(driver);
    	eDriver.register(listener);
    	
    	
    	String url = "http://www.newrank.cn/public/info/list.html?period=day&type=data";
    	eDriver.get(url);
    	FirefoxProfile profile = new FirefoxProfile();
    	
    	//driver.setFileDetector(detector);
	}

}

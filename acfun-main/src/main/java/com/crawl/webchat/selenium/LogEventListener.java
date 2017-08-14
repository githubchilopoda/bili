package com.crawl.webchat.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class LogEventListener implements WebDriverEventListener {

	public void afterAlertAccept(WebDriver arg0) {
		System.out.println("afterAlertAccept : " + arg0.getCurrentUrl());
	}

	public void afterAlertDismiss(WebDriver arg0) {
		System.out.println("afterAlertDismiss : " + arg0.getCurrentUrl());
	}

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		System.out.println("afterChangeValueOf : " + arg1.getCurrentUrl() + "," + arg0.getText());
	}

	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		System.out.println("afterClickOn : " + arg1.getCurrentUrl() + "," + arg0.getText());

	}

	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateBack(WebDriver arg0) {
		System.out.println("afterNavigateBack : " + arg0.getCurrentUrl());

	}

	public void afterNavigateForward(WebDriver arg0) {
		System.out.println("afterNavigateForward : " + arg0.getCurrentUrl());

	}

	public void afterNavigateRefresh(WebDriver arg0) {
		System.out.println("afterNavigateRefresh : " + arg0.getCurrentUrl());

	}

	public void afterNavigateTo(String arg0, WebDriver arg1) {
		System.out.println("afterNavigateTo : " + arg1.getCurrentUrl());
	}

	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	public void beforeAlertAccept(WebDriver arg0) {
		System.out.println("beforeAlertAccept : " + arg0.getCurrentUrl());

	}

	public void beforeAlertDismiss(WebDriver arg0) {
		System.out.println("beforeAlertDismiss : " + arg0.getCurrentUrl());

	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		System.out.println("afterNavigateTo : " + arg1.getCurrentUrl());

	}

	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateBack(WebDriver arg0) {
		System.out.println("beforeNavigateBack : " + arg0.getCurrentUrl());

	}

	public void beforeNavigateForward(WebDriver arg0) {
		System.out.println("beforeNavigateForward : " + arg0.getCurrentUrl());

	}

	public void beforeNavigateRefresh(WebDriver arg0) {
		System.out.println("beforeNavigateRefresh : " + arg0.getCurrentUrl());

	}

	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		System.out.println("beforeNavigateTo : " + arg1.getCurrentUrl() + ", " + arg0);

	}

	public void beforeScript(String arg0, WebDriver arg1) {
		System.out.println("beforeScript : " + arg1.getCurrentUrl() + ", " + arg0);

	}

	public void onException(Throwable arg0, WebDriver arg1) {
		System.out.println("onException : " + arg1.getCurrentUrl() + ", exeception: " + arg0);

	}

}

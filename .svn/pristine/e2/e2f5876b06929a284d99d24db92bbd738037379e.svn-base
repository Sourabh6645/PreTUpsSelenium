package com.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class seleniumActions {

	WebDriver driver;
	static WebDriverWait wait;
	static JavascriptExecutor jsDriver;

	public seleniumActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
		jsDriver = (JavascriptExecutor) driver;

	}
}

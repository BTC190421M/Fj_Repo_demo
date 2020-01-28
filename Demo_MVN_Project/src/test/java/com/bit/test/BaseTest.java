package com.bit.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	WebDriver dr;

	@Before
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/fayejahmed/Downloads/chromedriver");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("https://www.google.com/");

	}

	@Test
	public void test() {
		String actualUrl = dr.getCurrentUrl();
		System.out.println("Actual Url " + actualUrl);
		System.out.println("Title of the page " + dr.getTitle());
		if (actualUrl.equals("helo")) {
			Assert.assertTrue(true);
			System.out.println("URL matched");
		} else {
			Assert.assertTrue(false);
			System.out.println("URL did not matched");
		}

	}
	@Test
	public void test1() {
		String actualTitle = dr.getTitle();
		
		System.out.println("Actual title " + actualTitle);
		System.out.println("Title of the page " + "|"+ dr.getTitle() + "|");
		
		if (actualTitle.equals("Google")) {
			Assert.assertTrue(true);
			System.out.println("title matched");

		} else {
			Assert.assertTrue(false);
			System.out.println("title didn't match");
		}
		
	}

	@After
	public void closeBrowser() throws InterruptedException {

		Thread.sleep(3000);
		dr.quit();
	}

}

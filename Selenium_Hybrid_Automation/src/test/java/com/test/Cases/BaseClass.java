package com.test.Cases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.test.Utilities.ReadConfig;

public class BaseClass {

	ReadConfig readConfig = new ReadConfig();

	public String baseUrl = readConfig.getApplicationURL();
	public String username = readConfig.getUserName();
	public String password = readConfig.getPassWord();
	public String expectedTitle = "Login";

	public static WebDriver dr;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void openBrowser(String br) {

		logger = Logger.getLogger("Selenium Hybrid Automation");
		PropertyConfigurator.configure("Log4j.properties");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
			dr = new ChromeDriver();
		}
		else if (br.equals("firefox")) {
			dr = new FirefoxDriver();
		}
		else if (br.equals("ie")) {
			dr = new InternetExplorerDriver();
		}
		
		dr.get(baseUrl);


	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(4000);
		dr.quit();

	}

}

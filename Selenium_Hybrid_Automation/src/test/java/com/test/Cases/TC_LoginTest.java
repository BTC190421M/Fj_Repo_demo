package com.test.Cases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import com.page.Objects.LoginPage;

public class TC_LoginTest extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException {

		
		logger.info("URL is open");

		LoginPage lp = new LoginPage(dr);

		lp.setUserName(username);
		logger.info("username entered");

		lp.setPassWord(password);
		logger.info("password entered");

		Thread.sleep(1000);
		lp.clickSubmit();
		logger.info("clicked to login");
		
		String actualTitle = dr.getTitle();
		String currentURL = dr.getCurrentUrl();
		System.out.println("current title : " + actualTitle);
		
		
		
		if(actualTitle.equals(expectedTitle)) {
			AssertJUnit.assertTrue(true);
			logger.info("Title matched");
		}else {
			AssertJUnit.assertTrue(false);
			logger.info("Title didn't matched");
			
		}

		System.out.println("current url : " + currentURL);
		
		
		
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}

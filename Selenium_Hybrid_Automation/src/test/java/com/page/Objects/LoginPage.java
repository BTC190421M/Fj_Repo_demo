package com.page.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	WebDriver dr;

	public LoginPage(WebDriver dr) {
		this.dr = dr;
		PageFactory.initElements(dr, this);
	}

	@FindBy(name = "username")
	@CacheLookup
	WebElement txtUsername;

	@FindBy(name = "password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@type='submit'][@style='font-size: 16px;']")
	@CacheLookup
	WebElement btnLogin;
	
	public void setUserName(String uname) {
		txtUsername.sendKeys(uname);
	}
	
	public void setPassWord(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		btnLogin.click();
	}
	public void verifyText(WebElement ele,String containsText) {
		String actualText = ele.getText();
		if(actualText.contains(containsText)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

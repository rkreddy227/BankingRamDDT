package com.inetbanking.testCases;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_LoginTest extends BaseClass {
	
	@Test
	public void loginTest() {
		
		logger.info("url is opened");
		
		LoginPage lp= new LoginPage(driver);
		
		lp.setUserName(username);
		
		logger.info("Enter username");
		lp.setPassword(password);
		
		logger.info("Enter password");
		lp.clickSubmit();
		System.out.println(driver.getTitle());
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage" )) {
			
			Assert.assertTrue(true);
			logger.info("login test passed");
		}
		
		else 
		{
			Assert.assertTrue(false);
		}
		
	}

}

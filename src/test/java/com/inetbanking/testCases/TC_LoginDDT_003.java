package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilites.XLUtils;

import freemarker.template.utility.CaptureOutput;

public class TC_LoginDDT_003 extends BaseClass
{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		Thread.sleep(3000);
		logger.info("user name provided");
		lp.setPassword(password);
		logger.info("password provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		driver.manage().window().maximize();
		Thread.sleep(3000);

		addcust.clickAddNewCustomer();
		logger.info("Customer Validation started");
        Thread.sleep(3000);
		addcust.custName("Ranreet");
		addcust.custgender("male");
		addcust.custdob("10", "15", "1985");
		Thread.sleep(3000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("500027");
		addcust.custtelephoneno("2323232323");
		
		String email=randomstring()+"@gmail.com";
		addcust.custemailid(email);		
		addcust.custpassword("Ranjith");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res == true ) {
			Assert.assertTrue(true);
			logger.info("Customer Validation completed");
		}
		else
		{
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			logger.info("Customer Validation not completed");
		}
		
		

	}
	
	public String randomstring() {
		String generatestring =RandomStringUtils.randomAlphabetic(5);
		return(generatestring);
		
	}
	
}

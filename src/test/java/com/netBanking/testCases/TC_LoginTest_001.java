package com.netBanking.testCases;

import org.testng.annotations.Test;

import com.netBanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass
{
	
	@Test
	public void loginTest()
	{
		driver.get(baseURL);
		logger.info("URL entered");
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);

		}

	}
	

}

package com.netBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.netBanking.pageObjects.NewCustomerPage;
import com.netBanking.pageObjects.LoginPage;

public class TC_AddCustomer_002 extends BaseClass
{
	public String CustomerId;
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		driver.get(baseURL);
		logger.info("URL entered");
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		NewCustomerPage addcust=new NewCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		
		
		addcust.custName("Pavan");
		addcust.custgender("male");
		addcust.custdob("10","15","1985");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");	
		
		String email=randomestring()+"@gmail.com";
		logger.info("email entered is:"+email);
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		WebElement customerId=driver.findElement(By.xpath("//*[@id='customer']/tbody/tr[4]/td[2]"));
		WebElement link=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[14]/td/a"));

		CustomerId=customerId.getText();
		logger.info("customerid generated is:"+customerId.getText());
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			Assert.assertTrue(false);
		}
			
	}
	
	public String getCustomerId()
	{
		return CustomerId;
	}
	
}

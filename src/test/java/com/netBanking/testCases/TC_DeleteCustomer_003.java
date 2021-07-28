package com.netBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.netBanking.pageObjects.DeleteCustomerPage;

public class TC_DeleteCustomer_003 extends BaseClass
{
	public String Custid;
	
	@Test
	public void DeleteCustomer() throws InterruptedException, IOException
	{
		TC_AddCustomer_002 customeraddtc=new TC_AddCustomer_002();
		customeraddtc.addNewCustomer();
		Custid=customeraddtc.getCustomerId();
		
		DeleteCustomerPage delcust=new DeleteCustomerPage(driver);
		logger.info("Customerid for deletion:"+Custid);
		delcust.clickDeleteCustomer();
		delcust.enterCustomerId(Custid);
		delcust.clickSubmit();
		
		Alert deletealert=driver.switchTo().alert();
		deletealert.accept();
		Thread.sleep(2000);
		
		Alert deletealert1=driver.switchTo().alert();
		
		
		boolean res=deletealert1.getText().equals("Customer deleted Successfully");

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
		
		deletealert1.accept();
					
		logger.info("Customer deleted..");		
		
	}
}

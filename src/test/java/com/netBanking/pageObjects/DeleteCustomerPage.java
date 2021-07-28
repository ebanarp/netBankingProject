package com.netBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {
	
WebDriver ldriver;
	
	public DeleteCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[4]/a")
	@CacheLookup
	WebElement lnkDelCustomer;

	@FindBy(name="cusid")
	@CacheLookup
	WebElement txtCustomerId;
	
	@CacheLookup
	@FindBy(name="AccSubmit")
	WebElement btnSubmit;
	
	public void clickDeleteCustomer() {
		lnkDelCustomer.click();
			
	}
	
	public void enterCustomerId(String cid) {
		txtCustomerId.sendKeys(cid);
		
	}
	
	public void clickSubmit() {
		btnSubmit.click();
		
	}

}

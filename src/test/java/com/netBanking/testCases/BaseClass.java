package com.netBanking.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.netBanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readConfig=new ReadConfig();
	public String baseURL=readConfig.getApplicationURL();
	public String username=readConfig.getUsername();
	public String password=readConfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	@Parameters({"browser"})
	public void setup(String br)
	{			
		
		logger =Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("Chrome"))
				{
					System.setProperty("webdriver.chrome.driver",readConfig.getChromePath());
					driver=new ChromeDriver();
				}
		else if(br.equals("Firefox"))
				{
					System.setProperty("webdriver.gecko.driver",readConfig.getFirefoxPath());
					driver=new FirefoxDriver();
				}
		else if(br.equals("ie"))
				{
					System.setProperty("webdriver.ie.driver",readConfig.getIEPath());
					driver=new InternetExplorerDriver();
				}
		
		driver.get(baseURL);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
}

package com.omayo;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UsingTestNG 
{
	
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		 WebDriver  driver = new FirefoxDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("http://omayo.blogspot.com/");
		 String page = driver.getTitle();
		 System.out.println("The title of the page is " + page);
		 
	}
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
		
	
	@Test
	public void test1()
	{
		WebElement pageone = driver.findElement(By.xpath(".//*[@id='HTML31']/div[1]/form/input[1]"));
		 pageone.clear();
		 pageone.sendKeys("login");	 
	}
	
	
	

}

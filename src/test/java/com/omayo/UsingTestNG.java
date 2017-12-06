package com.omayo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UsingTestNG 
{
	
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		 FirefoxDriver driver = new FirefoxDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("http://omayo.blogspot.com/");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		
	}
	@Test
	public void test1()
	{
		WebElement pageone = driver.findElement(By.xpath(".//*[@id='Blog1']/div[1]/div/div/div/div[1]/h3"));
		 pageone.click();
		 String page = driver.getTitle();
		 System.out.println("The title of the page is " + page);
		 
		 WebElement homebutton = driver.findElement(By.id("home"));
		 homebutton.click();
		 
		 WebElement gernder = driver.findElement(By.id("radio2"));
		 gernder.click();
		 WebElement title =  driver.findElement(By.xpath(".//*[@id='ta1']"));
		 title.clear();
		 title.sendKeys("my name is mazhar");
	}
	
	
	

}

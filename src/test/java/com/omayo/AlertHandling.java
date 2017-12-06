package com.omayo;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;



public class AlertHandling
{
	public static void main(String[] args)
	{
		
		 System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		 WebDriver driver = new FirefoxDriver();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 driver.get("http://omayo.blogspot.com/");
		 //driver.manage().window().maximize();
		 WebElement Button3 = driver.findElement(By.id("prompt"));
		 boolean isenabled =  driver.findElement(By.id("prompt")).isDisplayed();
		 Button3.click();
		System.out.println("button is available : " +isenabled );
		Alert alert= driver.switchTo().alert();
		String altText = alert.getText();
		
		System.out.println(altText);
		alert.sendKeys("mazhar");
		alert.accept();
		String actual = "What is your name?";
		Assert.assertEquals(altText, actual);
		System.out.println("Both msg are same");
		driver.close();
		 
	}

}

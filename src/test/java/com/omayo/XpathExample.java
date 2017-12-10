package com.omayo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class XpathExample 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		 FirefoxDriver driver = new FirefoxDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("http://www.freecrm.com/index.html");
		 Thread.sleep(2000);
		 WebElement usernameButton = driver.findElement(By.xpath("//input[@type=\"text\"]"));
		 usernameButton.clear();
		 usernameButton.sendKeys("abchd");
		 WebElement  passwordbButton = driver.findElement(By.xpath("//input[@type=\"password\" and @name =\"password\"]"));
		 passwordbButton.sendKeys("1234345");
		 passwordbButton.clear();
		 WebElement featuresButton = driver.findElement(By.xpath("//a[contains(text(),'Features')]"));
		 featuresButton.click();
		 
		 File tss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 try {
			 FileUtils.copyFile(tss, new File("C:\\selenium\\Screenshot.png"));
		 }catch (IOException e) 
		 {
			 System.out.println(e.getMessage());
		 }
		
		 
		 
		 
		 
		 driver.close();
		 
	}

}

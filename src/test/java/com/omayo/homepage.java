package com.omayo;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class homepage 
{
	public static void main(String[] args) throws InterruptedException
	{
	
	 System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver-v0.18.0-win64\\geckodriver.exe");
	 FirefoxDriver driver = new FirefoxDriver();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.get("http://omayo.blogspot.com/");
	 driver.manage().window().maximize();
	 WebElement pageone = driver.findElement(By.xpath(".//*[@id='Blog1']/div[1]/div/div/div/div[1]/h3"));
	 pageone.click();
	 String page = driver.getTitle();
	 System.out.println("The title  is " + page);
	 
	 WebElement homebutton = driver.findElement(By.id("home"));
	 homebutton.click();
	 
	 WebElement gernder = driver.findElement(By.id("radio2"));
	 gernder.click();
	 Thread.sleep(5*1000);
	 WebElement title =  driver.findElement(By.xpath(".//*[@id='ta1']"));
	 title.clear();
	 title.sendKeys("my name is mazhar");
	 Thread.sleep(2*1000);
	 WebElement dropdown = driver.findElement(By.id("multiselect1"));
	 Select stct = new Select(dropdown);
	 stct.selectByVisibleText("Hyundai");
	 stct.selectByValue("audix");
	 stct.selectByIndex(2);
	 
	 WebElement dropbox = driver.findElement(By.id("drop1"));
	 Select  drp = new Select (dropbox);
	 drp.selectByIndex(2);
	 
	WebElement gender = driver.findElement(By.id("radio1"));
	gender.click();
	
	WebElement colorBx = driver.findElement(By.id("checkbox2"));
	colorBx.click();
	WebElement alertlink = driver.findElement(By.id("alert1"));
	alertlink.click();
	Alert alert = driver.switchTo().alert();
	String alertText = alert.getText();
	System.out.println(alertText +"is the alerttext");
	alert.accept();
	
	WebElement getpromft = driver.findElement(By.id("prompt"));
	getpromft.click();
	
	Alert alert1 = driver.switchTo().alert();
	 String alerttxt1 = alert1.getText();
	 System.out.println("alert text is " +alerttxt1 );
	 alert1.sendKeys("mazharul");
	 alert1.accept();
	 boolean isplyed = driver.findElement(By.id("sa")).isDisplayed();
	 System.out.println(isplyed);
	 
	WebElement link =  driver.findElement(By.id("link1"));
	link.click();
	
	 
	 
	 
	 
	 driver.close();
	 
	}

}

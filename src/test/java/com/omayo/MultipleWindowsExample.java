package com.omayo;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;




public class MultipleWindowsExample
{
	public static void main(String[] args) {
		//Setup and Open Browser
		System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.capitalone.com/credit-cards/?external_id=WWW_WR372_ZZZ_ONL-SE_ZZZGO_T_SEM2_ZZZZ_c_Zg_7313241f-493b-4c2d-925d-4dbdd6d8e246_171036591059_13998");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//Get HomePage
		String homePageId = driver.getWindowHandle();
		System.out.println("HomePage:"+homePageId);
		
		

		//Click on the LoginButton
		WebElement loginBtnElement = driver.findElement(By.xpath(".//*[@id='cchpRowCheckYourEligibilityForCreditCardOffers']/div/div/div[1]/a"));
		loginBtnElement.click();
	
		//Get Login Page Handle
		String windowId = driver.getWindowHandle();
		System.out.println("Printing Window again:"+windowId);
		
		//All Window Handle
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("No of windows opened:"+windowHandles.size());
		String secondWindowId = "";
		for (String id : windowHandles) {
			System.out.println(id);
			if(id.equalsIgnoreCase(homePageId))
			{
				System.out.println("We got first window id:"+id);
			}
			else
			{
				System.out.println("We got second window id:"+id);
				secondWindowId =id;
			}

		}//End of For Loop
		
		//Switch to LoginPage
		driver.switchTo().window(secondWindowId);
		//Enter UserName
		WebElement userInputElement = driver.findElement(By.id("User_Id"));
		userInputElement.clear();
		userInputElement.sendKeys("loginDemo");
		driver.close();
		windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles.size());
		driver.switchTo().window(homePageId);
		//Click on the LoginButton
		loginBtnElement = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[6]/div/div[1]/div[1]/p[2]/a/img"));
		loginBtnElement.click();
	}
}

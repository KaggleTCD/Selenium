package com.parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

	WebDriver webDriver;
	
	@Test
	@Parameters({"url","emailId"})
	public void yahooLoginTest(String url,String emailId) {
		
		System.setProperty("webdriver.chrome.driver", "C://chromedriver//chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		webDriver.get(url);
		webDriver.findElement(By.xpath("//*[@id=\"login-username\"]")).clear();
		webDriver.findElement(By.xpath("//*[@id=\"login-username\"]")).sendKeys(emailId);
		webDriver.findElement(By.xpath("//*[@id=\"login-signin\"]")).click();
		WebElement password = webDriver.findElement(By.id("login-passwd"));
		password.sendKeys("Knnnmj");
		
	}
}
package com.test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTitleTest {
	
	WebDriver webDriver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C://chromedriver//chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.manage().deleteAllCookies();
		webDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		webDriver.get("http://www.google.com");
		
	}

	@Test
	public void googleTitleTest() {
		
		String title = webDriver.getTitle();
		Assert.assertEquals(title, "Google","title is not matched");
	}
	@Test(priority=1,groups = "Logo")
	public void googleLogoTest() {
		boolean displayed = webDriver.findElement(By.xpath("//*[@id=\"hplogo\"]/a/img")).isDisplayed();
		Assert.assertTrue(displayed);
	}
	@AfterMethod
	public void tearDown() {
		webDriver.quit();
	}
}

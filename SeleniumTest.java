package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumTest {

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
	

	@Test(priority=1,groups = "Logo")
	public void googleLogoTest() {
		boolean displayed = webDriver.findElement(By.xpath("//*[@id=\"hplogo\"]/a/img")).isDisplayed();
		System.out.println(displayed);
	}
	@Test(priority=2,groups="Mail")
	public void googleMailTest() {
		boolean displayed = webDriver.findElement(By.linkText("Gmail")).isDisplayed();
		System.out.println(displayed);
	}
	
	@Test(priority=3,groups = "Test")
	public void test1() {
		System.out.println("Test1");
	}
	
	@Test(priority=4,groups = "Test")
	public void test2() {
		System.out.println("Test2");
	}
	@Test(priority=5,groups = "Test")
	public void test3() {
		System.out.println("Test3");
	}
	@AfterMethod
	public void tearDown() {
		webDriver.quit();
	}
}

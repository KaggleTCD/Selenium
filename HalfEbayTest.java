package com.datadriven.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HalfEbayTest {
	
	WebDriver webDriver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C://chromedriver//chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.manage().deleteAllCookies();
		webDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		webDriver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru=");
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		List<Object[]> data = new ArrayList<Object[]>();
		Object[] obj1 = {"Abhishek","Sarangi","Ranchi","Bajra","Ranchi","California","834005","a@a.com","a@a.com"};
		Object[] obj2 = {"A","S","R","B","R","California","8","a@a.com","a@a.com"};
		data.add(obj1);
		data.add(obj2);
		return data.iterator();
	}
	
	@Test(dataProvider = "getTestData")
	public void halfEbayRegPageTest(String firstName,String lastName,String address1,String address2,String city,String state,String zipCode,String emailAddress,String reTypeEmail) {
		
		webDriver.findElement(By.xpath("//*[@id=\"firstname\"]")).clear();
		webDriver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys(firstName);
		webDriver.findElement(By.xpath("//*[@id=\"lastname\"]")).clear();
		webDriver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys(lastName);
		webDriver.findElement(By.xpath("//*[@id=\"address1\"]")).clear();
		webDriver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys(address1);
		webDriver.findElement(By.xpath("//*[@id=\"address2\"]")).clear();
		webDriver.findElement(By.xpath("//*[@id=\"address2\"]")).sendKeys(address2);
		webDriver.findElement(By.xpath("//*[@id=\"city\"]")).clear();
		webDriver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys(city);
		
		Select select = new Select(webDriver.findElement(By.xpath("//*[@id=\"state\"]")));
		select.selectByVisibleText(state);
		
		webDriver.findElement(By.xpath("//*[@id=\"zip\"]")).clear();
		webDriver.findElement(By.xpath("//*[@id=\"zip\"]")).sendKeys(zipCode);
		webDriver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
		webDriver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(emailAddress);
		webDriver.findElement(By.xpath("//*[@id=\"retype_email\"]")).clear();
		webDriver.findElement(By.xpath("//*[@id=\"retype_email\"]")).sendKeys(reTypeEmail);
		
	}
	
	@AfterMethod
	public void tearDown() {
		webDriver.quit();
	}

}

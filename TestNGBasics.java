package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {
	
	@BeforeSuite
	public void setUp() {
		System.out.println("@BeforeSuite");
	}
	@BeforeClass
	public void launchBrowser() {
		System.out.println("@BeforeClass");
	}
	
	@BeforeMethod
	public void enterUrl() {
		System.out.println("@BeforeMethod");
	}
	
	@BeforeTest
	public void login() {
		System.out.println("@BeforeTest");
	}
	@Test
	public void googleTitleTest() {
	System.out.println("@Test");
	}
	@Test
	public void searchTest() {
	System.out.println("@Test");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("@AfterMethod");
	}
	
	@AfterTest
	public void deleteAllCookies() {
		System.out.println("@AfterTest");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("@AfterClass");
	}
	
	@AfterSuite
	public void generateTestReport() {
		System.out.println("@AfterSuite");
	}
}

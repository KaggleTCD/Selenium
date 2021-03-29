package com.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class DependentTest {
	
	@Test
	public void loginTest() {
		System.out.println("Login Test");
		//int i = 9/0;
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void homePageTest() {
		System.out.println("Home Page Test");
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void searchPageTest() {
		System.out.println("Search Page Test");
	}

}

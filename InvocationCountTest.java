package com.test;

import org.testng.annotations.Test;

public class InvocationCountTest {

	@Test(invocationCount = 10)
	public void loginTest() {
		System.out.println("Login Test");
		//int i = 9/0;
	}
}

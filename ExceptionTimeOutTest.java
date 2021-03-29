package com.test;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class ExceptionTimeOutTest {

	@Ignore
	@Test(invocationTimeOut = 2000,expectedExceptions = NumberFormatException.class)
	public void infiniteLoop() {
		int i = 1;
		while(i==1) {
			System.out.println(i);
		}
	}
	
	@Test(expectedExceptions = NumberFormatException.class)
	public void test1() {
		String x = "100A";
		Integer.parseInt(x);
	}
}

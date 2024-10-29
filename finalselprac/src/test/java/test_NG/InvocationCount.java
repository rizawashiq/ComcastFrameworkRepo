package test_NG;

import org.testng.annotations.Test;

public class InvocationCount {
	@Test(invocationCount = 1)
	public void test1() {
		System.out.println("Testing 1");
	}
	
	@Test(invocationCount = 2)
	public void test2() {
		System.out.println("Testing 2");
	}
	
	@Test(invocationCount = 3)
	public void test3() {
		System.out.println("Testing 3");
	}
}

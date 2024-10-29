package test_NG;

import org.testng.annotations.Test;

public class Priority {
	@Test(priority = 2)
	public void test1() {
		System.out.println("Testing 1");
	}
	
	@Test(priority = 1)
	public void test2() {
		System.out.println("Testing 2");
	}
	
	@Test
	public void test3() {
		System.out.println("Testing 3");
	}
	
}

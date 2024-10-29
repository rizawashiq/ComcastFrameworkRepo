package test_NG;

import org.testng.annotations.Test;

public class DependsOn {
	@Test(dependsOnMethods = "test5")
	public void test4() {
		System.out.println("Testing 4");
	}
	
	@Test(dependsOnMethods = "test6")
	public void test5() {
		System.out.println("Testing 5");
	}
	
	@Test
	public void test6() {
		System.out.println("Testing 6");
	}
}

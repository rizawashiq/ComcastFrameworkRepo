package test_NG;

import org.testng.annotations.AfterClass;
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.ListenerImp.class)
public class Annotationss {
	
	@BeforeSuite
	public void beforeS() {
		System.out.println("@BeforeSuite");
	}
	
	@AfterSuite
	public void afterS() {
		System.out.println("@AfterSuite");
	}
	
	@BeforeMethod
	public void beforeM()
	{
		System.out.println("@BeforeMethod");
	}
	
	@AfterMethod
	public void afterM() {
		System.out.println("@AfterMethod");
	}
	
	@Test
	public void test1() {
		System.out.println("Test 1 ");
	}
	
	@Test
	public void test2() {
		System.out.println("test 2");
	}
	
	@BeforeClass
	public void beforeC() {
		System.out.println("@BeforeClass");
	}
	
	@AfterClass
	public void afterC() {
		System.out.println("@AfterClass");
	}
	
	@BeforeTest
	public void beforet() {
		System.out.println("@BeforeTest");
	}
	
	@AfterTest
	public void aftert() {
		System.out.println("@AfterTest");
	}
	
}

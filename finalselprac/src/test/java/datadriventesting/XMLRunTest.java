package datadriventesting;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class XMLRunTest {

	@Test
	public void demo(XmlTest test)
	{
		System.out.println(test.getParameter("un"));
		System.out.println(test.getParameter("url"));
		System.out.println(test.getParameter("pwd"));
		
	}
	
	// run in testng suit 
	// in test ng  test file ...
	
}

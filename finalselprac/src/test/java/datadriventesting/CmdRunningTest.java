package datadriventesting;

import org.testng.annotations.Test;

public class CmdRunningTest {
	
	// download apache maven and go till bin and  copy the path in env variables
	// add MAVEN_HOME add there also
	//go to cmd ... mvn -version
	
	// add path of project 
	// mvn -Dtest=XmlRunningTest test
	
	@Test
	public void demo() {
		String url = System.getProperty("url");
		String un = System.getProperty("un");
		System.out.println("WElcome to CMD Line Execution");
		System.out.println(url + "    " + un);
	}
	/*
	 * mvn -Dtest=XmlRunningTest test -Durl=a.com -Dun=Riza
	 */
	

	
	 
}

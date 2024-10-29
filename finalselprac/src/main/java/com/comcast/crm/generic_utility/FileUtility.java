package com.comcast.crm.generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileUtility {
	public String getDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream f = new FileInputStream("./test_data/config.properties");
		Properties p = new Properties();
		p.load(f);
		
		return p.getProperty(key);
	}
	
	
	
}

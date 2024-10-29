package com.comcast.crm.generic_utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	public static  String getDataFromJsonFile(String key) throws FileNotFoundException, IOException, ParseException 
	{
		JSONParser p = new JSONParser();
		JSONObject jo = (JSONObject) p.parse(new FileReader("./test_data/config.json"));
		return (String) jo.get(key);
	}
}

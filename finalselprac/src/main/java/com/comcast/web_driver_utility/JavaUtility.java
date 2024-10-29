package com.comcast.web_driver_utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber()
	{
		Random r = new Random();
		return r.nextInt(5000);
	}
	
	public  String getDateInFormat(String format)
	{
		SimpleDateFormat s = new SimpleDateFormat(format);
		return s.format(new Date());
	}
	
	public   String getDateAfterDays(String format ,int days)
	{
		SimpleDateFormat s = new SimpleDateFormat(format);
		String date = s.format(new Date());
		Calendar c =   s.getCalendar();
		c.add(Calendar.DAY_OF_MONTH, days);
		return s.format(c.getTime());
		
	}
	
	
	
	
}

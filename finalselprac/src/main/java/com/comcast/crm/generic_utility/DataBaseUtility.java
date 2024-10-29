package com.comcast.crm.generic_utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection c ;
	
	
	public String getDataFromDB(String table , String column , int id) throws SQLException
	{
//		Driver d = new Driver();
//		DriverManager.registerDriver(d);
//		c =   DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","root");
//		System.out.println("Connected");
		
		Statement s = c.createStatement();
		ResultSet r =  s.executeQuery("Select " + column +" from " + table + " where " +table+"_id = "+ id);
		if (r.next()) {
		return r.getString(1);
		}
		else return "Null" ;
	}
	
	public void connectToDB() throws SQLException {
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		 c =   DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","root");
		System.out.println("Connected");
	}
	
	public void closeConnection() throws SQLException {
		c.close();
		System.out.println("connection closed");
	}
	
}

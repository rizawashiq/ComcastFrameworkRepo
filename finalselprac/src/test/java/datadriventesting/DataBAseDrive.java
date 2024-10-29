package datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

//import java.sql.Driver;

public class DataBAseDrive {
	public static void main(String[] args) throws SQLException {
		Driver d = new Driver();
		DriverManager.registerDriver(d);

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","root");
		System.out.println("Connected to database");

		Statement s = c.createStatement();
		ResultSet r = s.executeQuery("select * from actor");

		while(r.next())
			System.out.println(r.getString(1) + " " + r.getString(2) + " " + r.getString(3) + " " + r.getString(4) + " ");

		r = s.executeQuery("select * from actor limit 3");

		while(r.next())
			System.out.println(r.getString(1) + " " + r.getString(2) + " " + r.getString(3) + " " + r.getString(4) + " ");
		
//		int insert = s.executeUpdate("insert into actors values (1000 , null , null ,null)");
//		System.out.println(insert);

	}
}

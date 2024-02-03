package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider 
{
	 static Connection con;
	
	public static void Connect()
	{
		
		try 
		{
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//make connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_manage","root","developer");
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
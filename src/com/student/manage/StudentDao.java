package com.student.manage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao 
{
	public static boolean insertStudentToDB(Student st)
	{
		 boolean flag = false;
		try 
		{
			Connection c = ConnectionProvider.con;
			
			String q = "insert into students(sname,sphone,scity) values(?,?,?)";
			
			PreparedStatement pstmt = c.prepareStatement(q);
			
			//set the values of parameters
			
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			
			//execute
			pstmt.executeUpdate();
			flag= true;
			
			c.close();
			
			} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return flag;
	}

	public static boolean deleteStudent(int userid) 
	{

		 boolean flag = false;
		try 
		{
			Connection c = ConnectionProvider.con;
			
			String q = "delete from students where sid=?";
			
			PreparedStatement pstmt = c.prepareStatement(q);
			
			//set the values of parameters
			
			pstmt.setInt(1,userid);
			
			//execute
			pstmt.executeUpdate();
			flag= true;
			
			c.close();
			} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return flag;
	}

	public static boolean showAllInfo() 
	{
		 boolean flag = false;
			try 
			{
				Connection c = ConnectionProvider.con;
				
				String q = "select * from students";
				
				Statement stmt = c.createStatement();
				
				//making object of ResultSet
				ResultSet set = stmt.executeQuery(q);
				
				// process the data and show
				while(set.next())
				{
					int id = set.getInt(1);
					String name = set.getString(2);
					String phone = set.getString(3);
					String city = set.getString(4);
					System.out.println(id+"  "+name+"  "+phone+"  "+city);
				}
				flag= true;
				
				c.close();
				
				} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			return flag;
			
	}

	public static boolean updateInfo(Student st) 
	{
		boolean flag = false;
		try 
		{
			Connection c = ConnectionProvider.con;
			
			String q = "update students set sname =?,sphone=?,scity=? where sid=?";
			
			
			//set the values of parameters
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter new name");
			String name = br.readLine();
			System.out.println("Enter new phone");
			String phone = br.readLine();
			System.out.println("Enter new city");
			String city = br.readLine();
			System.out.println("Enter new id to be changed");
			int id = Integer.parseInt(br.readLine());
			
			PreparedStatement pstmt = c.prepareStatement(q);
			
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, city);
			pstmt.setInt(4, id);

			
			//execute
			pstmt.executeUpdate();
			flag= true;
			
			c.close();
			
			} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return flag;
	}
}

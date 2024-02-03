package com.student.manage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start 
{

	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			System.out.println("Press 1 to ADD the student's information");
			System.out.println("Press 2 to DELETE the student's information");
			System.out.println("Press 3 to Display the student's information");
			System.out.println("Press 4 to update the student's information");
			System.out.println("Press 5 to EXIT the application");
			
			int c = Integer.parseInt(br.readLine());
			
			ConnectionProvider.Connect();
			
			
			if(c==1)
			{
				//code for add student
				System.out.println("Enter the name of the student");
				String name = br.readLine();
				
				System.out.println("Enter student's contact number");
				String phone = br.readLine();
				
				System.out.println("Enter student's city");
				String city = br.readLine();
				
				//create student class's object to store data
				Student student = new Student(name,phone,city);
				System.out.println(student);
				
				
				boolean fact = StudentDao.insertStudentToDB(student);
				if(fact==true)
					System.out.println("Data inserted successfully");
				else
					System.out.println("Something went wrong");
			}
			else if(c==2)
			{
				//code for delete student
				System.out.println("Enter student id to delete");
				int userid = Integer.parseInt(br.readLine());
				
				boolean fact = StudentDao.deleteStudent(userid);
				if(fact==true)
				{
					System.out.println("Data deleted successfully");
				}
				else
				{
					System.out.println("Something went wrong");
				}
			}
			else if(c==3)
			{
				//code for display student
				boolean fact = StudentDao.showAllInfo();
				if(fact==true)
				{
					System.out.println("Data displayed successfully");
				}
				else
				{
					System.out.println("Something went wrong");
				}
			}
			else if(c==4)
			{
				// code for updating info
				
				//create student class's object to store data
				Student student = new Student();
				System.out.println(student);
				boolean fact = StudentDao.updateInfo(student);
				if(fact==true)
				{
					System.out.println("Data updated successfully");
				}
				else
				{
					System.out.println("Something went wrong");
				}
			}
			else if(c==5)
			{
				System.out.println("Thanks for using the Student Management Console Application");
				System.out.println("See you soon!");
				break;
			}
			else
			{
				System.out.println("Please provide a suitable input");
			}
		}
	}

}

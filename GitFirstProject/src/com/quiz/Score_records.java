package com.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Score_records {
	PreparedStatement ps = null;
	Connection connection = null;
	ResultSet rs = null;

	public void score() 
	{
		try (Scanner sc=new Scanner(System.in))
		{
			DataBaseConnection dbc = new DataBaseConnection();
			connection = dbc.getconnection();
			ps = connection.prepareStatement("select * from score_table order by score DESC");
			rs = ps.executeQuery();

			while (rs.next()) 
			{
				System.out.println("Student Id: " + rs.getInt(1));
				System.out.println("Name: " + rs.getString(2));
				System.out.println("Marks: " + rs.getInt(3) + "\n");
			}
			System.out.print("\nEnter any key to go on HomePage-->");
			String a=sc.next();
			if(a!=null)
			{
				HomePage.Start();
			}

		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public void score_specific()
	{	
		System.out.print("Enter Student Name:");
		
		try (Scanner sc=new Scanner(System.in))
		{
			String full_name=sc.nextLine();
			DataBaseConnection dbc=new DataBaseConnection();
			connection=dbc.getconnection();
			ps=connection.prepareStatement("select * from score_table WHERE full_name=?");
			ps.setString(1,full_name);
			rs = ps.executeQuery();
		 	 
			while (rs.next()) 
			{
				System.out.println();
				System.out.println("Student Id is " + rs.getInt(1));
				System.out.println("Name   is " + rs.getString(2));
				System.out.println("Marks is " + rs.getInt(3));
			}
			
			System.out.print("\nEnter any key to go on HomePage:");
			String a=sc.next();
			if(a!=null)
			{
				HomePage.Start();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

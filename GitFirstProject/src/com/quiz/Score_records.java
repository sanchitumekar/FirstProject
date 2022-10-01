package com.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Score_records {
	PreparedStatement ps = null;
	Connection connection = null;
	ResultSet rs = null;

	public void score() {

		try (Scanner sc=new Scanner(System.in)){
			DataBaseConnection dbc = new DataBaseConnection();
			connection = dbc.getconnection();
			ps = connection.prepareStatement("select * from score");
			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("Student Id is " + rs.getInt(1));
				System.out.println("Name  is " + rs.getString(2));
				System.out.println(" marks  is " + rs.getInt(3));
			}
			System.out.print("Enter any key to go on HomePage");
			String a=sc.next();
			if(a!=null){
				HomePage.Start();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void score_specific()
	{	
		
		System.out.print("Eneter a Student id");
		
	try (Scanner sc=new Scanner(System.in)){
		int s_id=sc.nextInt();
		DataBaseConnection dbc=new DataBaseConnection();
		connection=dbc.getconnection();
		ps=connection.prepareStatement("select * from score WHERE s_id=?");
		ps.setLong(1,s_id);
		 rs = ps.executeQuery();
		 
		 
			while (rs.next()) {
				System.out.println("Student Id is " + rs.getInt(1));
				System.out.println("Name   is " + rs.getString(2));
				System.out.println("Marks is " + rs.getInt(3));
			}
			
			
			System.out.print("Enter any key to go on HomePage");
			String a=sc.next();
			if(a!=null){
				HomePage.Start();
			}
		

	
	}
	catch(Exception e)
	{
		e.printStackTrace();

	}
	
}
	


}

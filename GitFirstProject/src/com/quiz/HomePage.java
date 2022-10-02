package com.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class HomePage 
{
	PreparedStatement ps = null;
	PreparedStatement ps1 = null;
	PreparedStatement ps2 = null;
	PreparedStatement ps3 = null;
	PreparedStatement ps4 = null;
	PreparedStatement ps5 = null;
	Connection con1 = null;
	ResultSet rs = null;
	ResultSet rs1 = null;
	ResultSet rs2 = null;
	ResultSet rs3 = null;
	Scanner sc = new Scanner(System.in);
	private void quiz() 
	{
		try
		{
			DataBaseConnection dbc1 = new DataBaseConnection();
			con1 = dbc1.getconnection();
			System.out.println("\nEnter Student Name: ");
			String name = sc.nextLine();
			ps = con1.prepareStatement("insert into score_table(full_name) values(?)");
			ps.setString(1, name);
			ps.execute();
			System.out.print("\n**Quiz Starts**\n");
			ps1 = con1.prepareStatement("select distinct * from questions order by rand() limit 5");
			rs1 = ps1.executeQuery();
			int num = 0;
			while(rs1.next())
				{
					System.out.println("\nQ" + ++num  + ". " + rs1.getString(2));
					System.out.println("1. " + rs1.getString(3));
					System.out.println("2. " + rs1.getString(4));
					System.out.println("3. " + rs1.getString(5));
					System.out.println("4. " + rs1.getString(6));
					System.out.println("Enter your option here: ");
					int ans = sc.nextInt();
					if (ans == rs1.getInt(7))
					{
						ps2 = con1.prepareStatement("update questions set marks=? where q_no = ?");
						ps2.setInt(1, 2);
						ps2.setInt(2, rs1.getInt(1));
						ps2.execute();
					}
					else
					{
						ps2 = con1.prepareStatement("update questions set marks=? where q_no = ?");
						ps2.setInt(1, 0);
						ps2.setInt(2, rs1.getInt(1));
						ps2.execute();
					}
				}
				ps3 = con1.prepareStatement("select sum(marks) from questions");
				rs2 = ps3.executeQuery();
				ps4 = con1.prepareStatement("select max(s_id) from score_table");
				rs3 = ps4.executeQuery();
				int id = 0;
				int result = 0;
				while(rs3.next()) 
				{
					id = rs3.getInt(1);
				}
				while(rs2.next())
				{
					result = rs2.getInt(1);
					ps3 = con1.prepareStatement("update score_table set score=? where s_id=?");
					ps3.setInt(1, result);
					ps3.setInt(2, id);
					ps3.execute();
				}
				if (result > 8 && result <= 10)
					System.out.println("Your score is " + result + "." + "\nYou get Class A.");
				else if (result >= 6 && result <= 8)
					System.out.println("Your score is " + result + "." + "\nYou get Class B.");
				else if (result == 5)
					System.out.println("Your score is " + result + "." + "\nYou get Class C.");
				else
					System.out.println("Your score is " + result + "." + "\nYou have failed.");
								
				ps5 = con1.prepareStatement("update questions set marks=0");
				ps5.execute();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		Start();
	}
	private static void Score_details() 
	{
		System.out.print("1 All Students score in Sorted Order\r\n" + "2 Specific Student Score by name\r\n" + "\r\n"
				+ "Enter a choice in number 1 or 2-->\n");
		try (Scanner sc = new Scanner(System.in))
		{
			Score_records sr= new Score_records();
			int i=sc.nextInt();
			if(i==1)
			{	
				sr.score();
			}
			if(i==2)
			{
				sr.score_specific();
			}
		}
	}
	static void Start() 
	{
		try (Scanner sc = new Scanner(System.in)) 
		{
			System.out.print("\n****Welcome to Quiz****\n\n" + "1.Attempt Quiz\r\n"
					+ "2.Get Score Details\r\n" +"3.Exit from Quiz\r\n" + "\nChoose an option by giving number 1, 2 or 3--> ");
			int i = sc.nextInt();

			HomePage hp = new HomePage();
			if (i == 1) 
			{
				hp.quiz();
			} 
			else if (i == 2) 
			{
				Score_details();
			} 
			else if (i == 3) 
			{
				System.out.println("Exited Successfully!"); 
				System.exit(0);
			}
			else 
			{
				System.out.print("Sorry invalid input");
				Start();
			}
		}
	
	}
	public static void main(String[] args) 
	{
		Start();
	}
}

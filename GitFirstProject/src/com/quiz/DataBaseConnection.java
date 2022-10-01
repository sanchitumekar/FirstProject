package com.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
public class DataBaseConnection {
	public Connection getconnection()
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mcq","root","");
			
		}
		catch(Exception e){
			System.out.println("Problem With Database");
		}
		return con;
	}

}

package com.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Score_DataBase {
	PreparedStatement ps=null;
	Connection connection=null;
	
	public void score()
	{
		
	
	try {
		DataBaseConnection dbc=new DataBaseConnection();
		connection=dbc.getconnection();
		ps=connection.prepareStatement("INSERT INTO score(full_name,score) VALUES(?,?)");
		String name="sanchit";
		ps.setString(1,name);
		int score=10;
		ps.setLong(2,score);
		ps.execute();
		System.out.print("Data Inserted");
		
	}
	catch(Exception e)
	{
		e.printStackTrace();

	}
	}

}

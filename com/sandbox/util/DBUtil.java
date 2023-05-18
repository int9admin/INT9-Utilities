package com.sandbox.util;

import java.sql.*;  

public class DBUtil implements Cloneable{

	private static Connection con = null;
	private static DBUtil dbIsntance;


	public static DBUtil getInstance(){
		if(dbIsntance==null){
			dbIsntance = new DBUtil();
		}
		return dbIsntance;
	}

	public static Connection getConnection()
	{
		 //con=null;
		
		try
		{  
			/*if (con.isClosed()) {
				
			}*/
			
			if(con==null) {
				Class.forName("com.mysql.jdbc.Driver");
  			    con = DriverManager.getConnection(
						 "jdbc:mysql://localhost:3308/db_stage?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true", "root", "");
				 		  
			}
			return con;
		}catch(Exception e)
		{ 
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}  
		
	}
	
	@Override
	public Object clone() throws RuntimeException
	{
		throw new RuntimeException("Object not Cloneable");
	}

	public static void closeConnection(Connection con) {
		try {
			con.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
}

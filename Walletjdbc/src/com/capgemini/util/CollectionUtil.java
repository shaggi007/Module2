package com.capgemini.util;
import java.sql.*;


public class CollectionUtil {

public Connection getConnection()
{
	try
	{
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String pass = "Capgemini123";
		Connection con = DriverManager.getConnection(url, user, pass);
		System.out.println("connected");
		return con;
	}
	catch(ClassNotFoundException ae) {
		System.out.println("error in loading class"+ae.getMessage());
	}
	catch(SQLException s)
	{
		System.out.println("sql exception"+s.getMessage());
	}
	return null;
	
		
	}
		// TODO Auto-generated constructor stub
	}


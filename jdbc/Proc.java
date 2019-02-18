package jdbc;

import java.sql.*;


public class Proc {

	public static void main(String[] a)throws Exception {

		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String pass = "Capgemini123";

		Connection con = DriverManager.getConnection(url, user, pass);
		
			CallableStatement st1 = con.prepareCall("{call INSERTR(?,?)}");
			
			st1.setInt(1, 4);
			st1.setString(2, "saif");
		st1.execute();
			
			System.out.println("success");

		// TODO Auto-generated constructor stub
	}
		

}

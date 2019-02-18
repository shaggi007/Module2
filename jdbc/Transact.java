package jdbc;
import java.sql.*;

public class Transact {
	public static void main(String []arg) throws Exception {

	Class.forName("oracle.jdbc.OracleDriver");
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="system";
	String pass="Capgemini123";
	
	Connection con=DriverManager.getConnection(url,user,pass);
	try {
		con.setAutoCommit(false);
		Statement st=con.createStatement();
		Savepoint save=con.setSavepoint("Savepoint1");
		ResultSet re=st.executeQuery("insert into registeration2 values(5,'rahulllllll')");
		ResultSet r=st.executeQuery("select * from registeration2");
		while(r.next()) {
			System.out.println(r.getInt(1)+" "+r.getString(2));
		}
	con.commit();
	}
		catch(Exception e) {
			try {
				con.rollback();
				System.out.println(e.getMessage());
				System.out.println("rollback");
			}
			catch(SQLException e1)
			{
			System.out.println(e1.getMessage());
			
		}
		}
	}
}

	
	
	
	
	
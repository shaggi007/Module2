package jdbc;

import java.sql.*;

public class Jdbc2 {

	public static void main(String args[]) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		// TODO Auto-generated constructor stub
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String pass = "Capgemini123";
		Connection con = DriverManager.getConnection(url, user, pass);
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("create table registeration7(id number(2),name varchar2(10))");
			ResultSet r1 = st.executeQuery("insert into registeration7 values(1,'syed')");
			ResultSet r2 = st.executeQuery("insert into registeration7 values(2,'ajaz')");
			ResultSet r3 = st.executeQuery("select * from registeration7 where id=1");
			ResultSet r4 = st.executeQuery("delete from registeration7 where id=1");

			while (r3.next()) {
				System.out.println(r3.getInt(1) + " " + r3.getString(2));
			}
		} catch (Exception ae) {
			System.out.println(ae);
		}
		con.close();

	}
}

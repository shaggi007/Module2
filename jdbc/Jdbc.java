package jdbc;

import java.sql.*;

class Jdbcexample {
	public static void main(String a[]) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String pass = "Capgemini123";

		Connection con = DriverManager.getConnection(url, user, pass);

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from student details");

			while (rs.next()) {

				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));

			}
		} catch (Exception ex) {
			System.out.println("ex");
		}
		con.close();

	}
}
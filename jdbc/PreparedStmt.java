package jdbc;

import java.sql.*;

class PreparedStmt {
	public static void main(String[] a) throws Exception {

		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String pass = "Capgemini123";

		Connection con = DriverManager.getConnection(url, user, pass);
		try {
			PreparedStatement st1 = con.prepareStatement("create table registeration5(id number(2),name varchar2(10))");
			ResultSet r2 = st1.executeQuery();
			PreparedStatement stm = con.prepareStatement("insert into registeration5 values(?,?)");
			stm.setInt(1, 3);
			stm.setString(2, "zaidi");
			ResultSet r1 = stm.executeQuery();
			PreparedStatement stm1 = con.prepareStatement("select * from registeration5");
			ResultSet r = stm1.executeQuery();
			while (r.next()) {
				System.out.println(r.getInt(1) + " " + r.getString(2));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		con.close();

		// TODO Auto-generated constructor stub
	}

}

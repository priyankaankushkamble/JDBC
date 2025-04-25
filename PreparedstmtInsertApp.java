package org.apriljdbc;

import java.sql.*;

public class PreparedstmtInsertApp {

	public static void main(String[] args) throws SQLException {
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apriladvjava", "root", "root");
		if (conn != null) {
			System.out.println("Database Connected..........");
			PreparedStatement stmt = conn.prepareStatement("insert into emp values(?,?,?)");
			stmt.setString(1, "priya");
			stmt.setString(2, "priya@gmail.com");
			stmt.setString(3, "9898989898");
			int value = stmt.executeUpdate();
		} else {
			System.out.println("Database not connect");
		}
	}

}

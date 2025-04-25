package org.apriljdbc;

import java.util.*;
import java.sql.*;

public class SelectEmailPreStmtApp {

	public static void main(String[] args) throws SQLException {
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apriladvjava", "root", "root");
		if (conn != null) {
			System.out.println("Database connected................");
			Scanner xyz = new Scanner(System.in);
			System.out.println("Enter email from keyboard");
			String email = xyz.nextLine();
			PreparedStatement stmt = conn.prepareStatement("Select name, contact from emp where email=?");
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("name") + "\t" + rs.getString("contact"));
			}
		} else {
			System.out.println("Database not connected");
		}
	}

}

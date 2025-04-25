package org.apriljdbc;

import java.util.*;
import java.sql.*;

public class UpdatePreStmtApp {

	public static void main(String[] args) throws SQLException {
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apriladvjava", "root", "root");
		if (conn != null) {
			System.out.println("Database Connected..........");
			Scanner xyz = new Scanner(System.in);
			System.out.println("Enter name email contact");
			String name = xyz.nextLine();
			String email = xyz.nextLine();
			String contact = xyz.nextLine();
			PreparedStatement stmt = conn.prepareStatement("UPDATE emp set name=?,contact=? where email=?");
			stmt.setString(1, name);
			stmt.setString(2, contact);
			stmt.setString(3, email);
			int value = stmt.executeUpdate();
			if (value > 0) {
				System.out.println("Updated Successfully......");
			} else {
				System.out.println("Some problem is there...........");
			}

		} else {
			System.out.println("Database not connected");
		}

	}

}

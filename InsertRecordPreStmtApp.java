package org.apriljdbc;

import java.util.*;
import java.sql.*;

public class InsertRecordPreStmtApp {

	public static void main(String[] args) throws SQLException {
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apriladvjava", "root", "root");

		if (conn != null) {
			System.out.println("Database Connected...........");
			Scanner xyz = new Scanner(System.in);
			System.out.println("Enter Name,Email,Contact");
			String name = xyz.nextLine();
			String email = xyz.nextLine();
			String contact = xyz.nextLine();
			PreparedStatement stmt = conn.prepareStatement("insert into emp values(?,?,?)");

			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, contact);
			int value=stmt.executeUpdate();
			if (value > 0) {
				System.out.println("Saved Successfullyy............");
			} else {
				System.out.println("Some Problem is there............");
			}
		} else {
			System.out.println("Database is not connected");
		}

	}

}

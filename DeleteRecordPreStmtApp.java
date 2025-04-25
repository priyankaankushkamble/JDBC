package org.apriljdbc;

import java.util.*;
import java.sql.*;

public class DeleteRecordPreStmtApp {

	public static void main(String[] args) throws SQLException {
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apriladvjava", "root", "root");
		if (conn != null) {
			System.out.println("Database Connected........");
			Scanner xyz = new Scanner(System.in);
			System.out.println("Enter Email");
			String email = xyz.nextLine();
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM emp WHERE email=?");
			stmt.setString(1, email);
			int value=stmt.executeUpdate();
			if (value > 0) {
				System.out.println("Deleted Successfuly.....");
			} else {
				System.out.println("Some Problem is there...........");
			}
		} else {
			System.out.println("Database not connected");
		}

	}

}

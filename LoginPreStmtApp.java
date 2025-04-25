package org.apriljdbc;

import java.sql.*;
import java.util.*;

public class LoginPreStmtApp {

	public static void main(String[] args) throws SQLException {
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apriladvjava", "root", "root");
		if (conn != null) {
			System.out.println("Database Connected...........");
			Scanner xyz = new Scanner(System.in);
			System.out.println("Enter username and password from keyboard");
			String u = xyz.nextLine();
			String p = xyz.nextLine();
			PreparedStatement stmt = conn.prepareStatement("Select * from register where username=? and password=?");
			stmt.setString(1, u);
			stmt.setString(2, p);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				System.out.println("Login Success.......................");
			} else {
				System.out.println("Login Failed...................");
			}
		} else {
			System.out.println("Dabase not connected");
		}

	}

}

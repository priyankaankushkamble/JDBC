package april.jdbc;

import java.sql.*;

public class PlayerStoreApp {
	public static void main(String[] args) throws Exception {
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apriladvjava", "root", "root");
		if (conn != null) {
			System.out.println("Database is connected...........");
			Statement stmt = conn.createStatement();
			int value = stmt.executeUpdate("insert into player values('abc','abc@gmail.com','1234567')");
			if (value > 0) {
				System.out.println("Recorde save success..............");
			} else {
				System.out.println("Some problem is there.......................");
			}
		} else {
			System.out.println("Database not connect");
		}

	}

}

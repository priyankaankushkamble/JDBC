package april.jdbc;

import java.util.*;
import java.sql.*;

public class ProductApp {
	public static void main(String[] args) throws Exception {
		Scanner xyz = new Scanner(System.in);
		System.out.println("Enter name and price of product");
		String name = xyz.nextLine();
		int price = xyz.nextInt();
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apriladvjava", "root", "root");
		if (conn != null) {
			Statement stmt = conn.createStatement();
			int value = stmt.executeUpdate("insert into product values('0','" + name + "','" + price + "')");
			if (value > 0) {
				System.out.println("Record Save Successfully.........");
			} else {
				System.out.println("Some problem is there");
			}
		} else {
			System.out.println("Database not connected...........");
		}

	}

}

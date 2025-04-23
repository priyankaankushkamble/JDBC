package april.jdbc;
import java.sql.*;
import java.util.*;

public class SelectApp {
	public static void main(String[] args) throws Exception {
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apriladvjava", "root", "root");
		if (conn != null) 
		{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from product");
			while (rs.next()) {
				int proId = rs.getInt("pid");
				String proName = rs.getString("name");
				int price = rs.getInt("price");
				System.out.println(proId + "\t" + proName + "\t" + price);
			}

		} else {
			System.out.println("Database not connected");
		}

	}

}

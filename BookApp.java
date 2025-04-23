package april.jdbc;

import java.sql.*;
import java.util.*;

public class BookApp {
	public static void main(String[] args) throws SQLException {
		Scanner xyz = new Scanner(System.in);
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		System.out.println("Driver Register Successfully...........");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apriladvjava", "root", "root");
		if (conn != null) {
			System.out.println("Database Connected Successfully.......");
		} else {
			System.out.println("Database is not connected........");
		}
		Statement stmt = conn.createStatement();
		while (true) {
			System.out.println("\n ---Book Table Operation---");
			System.out.println("1. Insert Book");
			System.out.println("2. Delete Book by ID and Author");
			System.out.println("3. Update Book by ID");
			System.out.println("4. Fetch All Books");
			System.out.println("5. Fetch Book by ID");
			System.out.println("6. Count Books Authour-wise");
			System.out.println("7. Display Book Names Author-wise");
			System.out.println("8. Exist");
			System.out.print("Enter Your Choice:");
			int choice = xyz.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter ID");
				int id = xyz.nextInt();
				xyz.nextLine();
				System.out.println("Enter Book Name:");
				String name = xyz.nextLine();
				System.out.println("Enter Price:");
				int price = xyz.nextInt();
				xyz.nextLine();
				System.out.println("Enter Author:");
				String author = xyz.nextLine();
				System.out.println("Enter Publication:");
				String publication = xyz.nextLine();

				int value = stmt.executeUpdate("INSERT INTO Book VALUES(" + id + ",'" + name + "','" + price + "','"
						+ author + "','" + publication + "')");
				System.out.println(value > 0 ? "Record Saved Successfully...." : "Some Problem Occured");
				break;

			}
			case 2: {
				System.out.println("Enter ID");
				int id = xyz.nextInt();
				xyz.nextLine();
				System.out.println("Enter Author:");
				String author = xyz.nextLine();

				int value = stmt.executeUpdate("DELETE FROM Book WHERE id='" + id + "'AND author='" + author + "'");
				System.out.println(value > 0 ? "Record Deleted Successfully...." : "Record Not Found");
				break;
			}
			case 3: {
				System.out.println("Enter ID:");
				int id = xyz.nextInt();
				xyz.nextLine();
				System.out.println("Enter New Name");
				String name = xyz.nextLine();
				System.out.println("Enter New Price");
				int price = xyz.nextInt();
				xyz.nextLine();

				System.out.println("Enter New Publication");
				String publication = xyz.nextLine();

				int value = stmt.executeUpdate("UPDATE Book SET price=" + price + ", name ='" + name + "',pulication='"
						+ publication + "' WHERE id=" + id);
				System.out.println(value > 0 ? "Record Updated Successfully" : "Update Failed");
				break;
			}
			case 4: {
				ResultSet rs = stmt.executeQuery("SELECT * FROM Book");
				while (rs.next()) {
					System.out.println(rs.getInt("id") + "\t" +

							rs.getString("name") + "\t" +

							rs.getInt("price") + "\t" +

							rs.getString("author") + "\t" +

							rs.getString("pulication"));

				}
				break;
			}
			case 5: {
				System.out.println("Enter ID:");
				int id = xyz.nextInt();
				ResultSet rs = stmt.executeQuery("SELECT * FROM Book WHERE Id=" + id);
				if (rs.next()) {
					System.out.println(rs.getString("name") + "\t" +

							rs.getInt("price") + "\t" +

							rs.getString("author") + "\t" +

							rs.getString("pulication"));
				} else {
					System.out.println("Book Not Found");
				}
				break;
			}
			case 6: {
				ResultSet rs = stmt.executeQuery("SELECT author,COUNT(*) AS count FROM Book GROUP BY author");
				System.out.println("Author\tBook Count");
				while (rs.next()) {
					System.out.println(rs.getString("author") + "\t" + rs.getInt("count"));

				}
				break;
			}
			case 7: {
				ResultSet rs = stmt.executeQuery("SELECT author,name FROM Book ORDER BY author");
				System.out.println("Author\tBook Name");
				while (rs.next()) {
					System.out.println(rs.getString("author") + "\t" + rs.getString("name"));

				}
				break;
			}
			case 8: {
				System.out.println("Existing.......");
				System.exit(0);
			}
			default:
				System.out.println("Inalid choice.Try Again");
			}
		}
	}

}

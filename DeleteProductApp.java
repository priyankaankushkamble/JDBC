package april.jdbc;
import java.sql.*;
import java.util.*;
public class DeleteProductApp
{

	public static void main(String[] args) throws Exception
	{
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/apriladvjava","root","root");
		
		if(conn!=null)
		{
			Statement stmt=conn.createStatement();
			Scanner xyz=new Scanner(System.in);
			System.out.println("Enter Product Id");
			int proId=xyz.nextInt();
			int value=stmt.executeUpdate("delete from product where pid="+proId);
			if(value>0)
			{
				System.out.println("Data Deleted Successfully.............");
			}
			else
			{
				System.out.println("Some Problem is there..........");
			}
		}
		else
		{
			System.out.println("Database not connected");
		}

	}

}

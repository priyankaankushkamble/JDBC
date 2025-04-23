package april.jdbc;
import java.util.*;
import java.sql.*;
public class UpdateProductPrice 
{
	public static void main(String[] args) throws Exception
	{
		Scanner xyz=new Scanner(System.in);
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/apriladvjava","root","root");
		if(conn!=null)
		{
			Statement stmt=conn.createStatement();
			System.out.println("Enter Product id");
			int proId=xyz.nextInt();
			System.out.println("Enter Product Price");
			int proPrice=xyz.nextInt();
			int value=stmt.executeUpdate("update product set price="+proPrice+" where pid="+proId);
			if(value>0)
			{
				System.out.println("Record Update Successfully.........");
			}
			else
			{
				System.out.println("Some poblem is there............");
			}
		}
		else
		{
			System.out.println("Database not connected");
		}
	}

}

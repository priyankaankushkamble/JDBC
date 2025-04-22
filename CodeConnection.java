package april.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CodeConnection
{
	public static void main(String[] args) throws SQLException
	{
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		System.out.println("Driver Register Successfully...........");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/apriladvjava","root","root");
		if(con!=null)
		{
			System.out.println("Database is connected");
		}
		else
		{
			System.out.println("Database is not connected");
		}
	}

}

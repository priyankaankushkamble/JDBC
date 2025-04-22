package april.jdbc;
import java.sql.*;
public class StatementInterface 
{
	public static void main(String[] args) throws SQLException
	{
	com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
	DriverManager.registerDriver(d);
	System.out.println("Driver Register Succesfullyy......");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/apriladvjava","root","root");
	if(con!=null)
	{
		Statement stmt=con.createStatement();
		int value=stmt.executeUpdate("insert into employee Values('Priya','priya@gmail.com','86728')");
		if(value>0)
		{
			System.out.println("Record Save Successfully....");
		}
		else
		{
			System.out.println("Some Problem is there....");
		}
	}
		else
	{
		System.out.println("Database Not connected....");
	}
	}
}

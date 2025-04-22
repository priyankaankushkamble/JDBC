package april.jdbc;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnectionApp 
{

	public static void main(String[] args) throws SQLException
	{
	com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
	DriverManager.registerDriver(d);
	System.out.println("Driver registered successfully...........");
	}
	

}

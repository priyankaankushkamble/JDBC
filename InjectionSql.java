package april.jdbc;
import java.util.*;
import java.sql.*;
public class InjectionSql 
{

	public static void main(String[] args) throws Exception
	{
		Scanner xyz=new Scanner(System.in);
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:/apriladvjava","root","root");
		if(conn!=null)
		{
			System.out.println("Database connect Successfully.........");
			Statement stmt=conn.createStatement();
			System.out.println("Enter Name Email,Contact");
			String name=xyz.nextLine();
			String email=xyz.nextLine();
			String contact=xyz.nextLine();
			
			int value=stmt.executeUpdate("insert into player values('"+name+"','"+email+"','"+contact+"')");
			if(value>0)
			{
				System.out.println("Record Update Successfully");
			}
			else
			{
				System.out.println("Some Problem is there.............");
			}
		}
		else
		{
			System.out.println("Database not connected............");
		}
	}
	

}

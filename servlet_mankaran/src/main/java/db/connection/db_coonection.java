package db.connection;


import java.sql.Connection;
import java.sql.DriverManager;

public class db_coonection {
	
	public static Connection con;
	public static Connection getConnection()  {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost/task","root","root");
		
			System.out.println("OK :/");}
		catch (Exception e) {
            // TODO Auto-generated catch block
           System.out.println("Connection failed"+e.toString());
        }
		return con;
	}

}
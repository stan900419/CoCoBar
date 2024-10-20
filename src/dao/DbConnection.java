package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static void main(String[] args) {
//		System.out.println(new DbConnection().getDb());
	}
	
	public static Connection getDb()
	{
		String url="jdbc:mysql://localhost:3306/cocobar";
		String user="root";
		String password="1234";
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(url,user,password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return conn;
	}

}

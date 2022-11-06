package com.projectG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StdDipsplay {
	
	static ResultSet result=null;
	public static Connection getConnection() {
		
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/Prime?characterEncoding=utf8";
			con=DriverManager.getConnection(url,"root","root");
			
			String sql="Select * from Score order by id";
			PreparedStatement pre=con.prepareStatement(sql);
			
			 result=pre.executeQuery();
			
			while(result.next()) {
				System.out.println("\t\t\tid-->"+result.getInt(1)+"\n"+"\t\t\tName-->>"+result.getString(2)+"\n"+"\t\t\tScore-->>"+result.getString(3));
				System.out.println("---------------------");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public static void main(String[] args) {
		getConnection();
	
	}
}

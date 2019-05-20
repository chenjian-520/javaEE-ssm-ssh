package com.lee.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
	
	static{
		Properties properties = new Properties();
		InputStream is = Util.class.getClassLoader().getResourceAsStream("jdbc.properties");
		
		try {
			properties.load(is);
			is.close();
			Class.forName(properties.getProperty("driver"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getuser() throws ClassNotFoundException, SQLException {
		Properties properties = new Properties();
		InputStream is = Util.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			properties.load(is);
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return DriverManager.getConnection(
				 properties.getProperty("url"),
				 properties.getProperty("root"),
				 properties.getProperty("password"));
	}
	
	public static void getClose(
				Connection conn ,
				PreparedStatement ps,
				ResultSet rs ) {
		try {
			if(conn!=null){
			conn.close();
			}
			if(ps!=null){
			ps.close();
			}
			if(rs!=null){
			rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

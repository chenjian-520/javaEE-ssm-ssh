package com.lee.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 工具类
 * 	所有的连接和资源释放
 */
public class JdbcUtil {
	
	static{
		Properties properties = new Properties();
		InputStream is = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
		
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
	
	//关闭资源
	public static void closeRes(ResultSet rs,Connection conn,PreparedStatement ps) {
		try {
			if(rs != null){
				rs.close();
			}
			if(ps != null){
				ps.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//获取连接
	public static Connection getConnection() throws  IOException, SQLException {
		Properties properties = new Properties();
		InputStream is = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
		properties.load(is);
		is.close();
		
	
		return  DriverManager.getConnection(
				properties.getProperty("url"), 
				properties.getProperty("username"), 
				properties.getProperty("password"));
		
	}
}

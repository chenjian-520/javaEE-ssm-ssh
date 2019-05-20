package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

	static String url = null;
	static String username = null;
	static String password = null;
	static{
		Properties pros = new Properties();
		try {
			InputStream is = JdbcUtils.class.getClassLoader()
				.getResourceAsStream("jdbc.properties");
			pros.load(is);
			is.close();
			url = pros.getProperty("url");
			username=pros.getProperty("user");
			password = pros.getProperty("password");
			Class.forName(pros.getProperty("driver"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("加载驱动失败");
		}
	}
	
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("获取连接失败");
		}
	}
	
	public static void closeRes(Connection conn,PreparedStatement ps,ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

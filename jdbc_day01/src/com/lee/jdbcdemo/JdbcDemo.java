package com.lee.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lee.entity.Userinfo;

public class JdbcDemo {

	public static void main(String[] args) {
		Userinfo info = new Userinfo();
		info.setUname("ww");
		info.setPassword("123");
		//insert(info);
		
		//delete(3);
		//demo1();
		
		login2("ls", "123");
	}
	
	//增加
	public static void insert(Userinfo info){
		Connection conn = null;
		Statement stmt = null;
		try {
			//1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取连接
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bd1807?useSSL=true", 
					"root", 
					"root");
			//3.发送sql
			stmt = conn.createStatement();
			String sql = "insert into userinfo(uname,password) values('"+info.getUname()+"','"+info.getPassword()+"')";
			int rows = stmt.executeUpdate(sql);
			System.out.println(rows);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(stmt != null){
					stmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//修改
	public static void update(Userinfo info){
	}
	//删除
	public static void delete(int uid){
		Connection conn = null;
		Statement stmt = null;
		try {
			//1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取连接
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bd1807?useSSL=true", 
					"root", 
					"root");
			//3.发送sql
			stmt = conn.createStatement();
			String sql = "delete from userinfo where uid = "+uid;
			int rows = stmt.executeUpdate(sql);
			System.out.println(rows);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(stmt != null){
					stmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void demo1() {
		ResultSet rs = null;
		Connection conn = null;
		Statement stmt = null;
		List<Userinfo> users = new ArrayList<>();
		try {
			//1.注册驱动,DriverManager管理具体的驱动程序，实现对底层屏蔽,对开发人员提供统一访问。
			//java.sql.Driver: jdbc的接口
			//com.mysql.jdbc.Driver: mysql对jdbc的Driver接口实现类
			//DriverManager.registerDriver(new Driver());
			Class.forName("com.mysql.jdbc.Driver");
			//2.建立连接  java.sql.Connection
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bd1807?useSSL=true", 
					"root", 
					"root");
			//conn代表连接
			//获取连接的元数据信息
			/*DatabaseMetaData md = conn.getMetaData();
			System.out.println(md.getDatabaseProductName());
			System.out.println(md.getDriverName());
			System.out.println(md.getURL());
			System.out.println(md.getUserName());*/
			
			
			//3.发送sql给数据库服务
			String sql = "select * from userinfo";
			//Statement对象:实现sql发送
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			//获取结果集的元数据
			/*ResultSetMetaData md = rs.getMetaData();
			//获取列
			int count = md.getColumnCount();*/
			//String name = md.getColumnName(column);
			//遍历获取每一个字段的名称
			//类属性和表字段保持一致
			//用于封装对象
			
			//4.处理响应结果(ResultSet底层维护了一个指向结果集的游标)
			while(rs.next()){  //向前移动游标(遍历一行)
				Userinfo info = new Userinfo();
				//获取游标指向行的字段的信息(遍历每列)
				int uid = rs.getInt("uid");
				String uname = rs.getString("uname");
				String password = rs.getString("password");
				info.setUid(uid);
				info.setUname(uname);
				info.setPassword(password);
				
				users.add(info);
			}
			
			System.out.println(users);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs != null){
					rs.close();
				}
				if(stmt != null){
					stmt.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//登录
	public static void login(String uname,String password){
		ResultSet rs = null;
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//2.建立连接  java.sql.Connection
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bd1807?useSSL=true", 
					"root", 
					"root");
			//3.发送sql
			stmt = conn.createStatement();
			String sql = "select * from userinfo where uname = '"+uname+"'  and password = '"+password+"'";
			rs = stmt.executeQuery(sql);
			//4.处理结果
			if(rs.next()){
				System.out.println("登陆成功");
			}else{
				System.out.println("登录失败");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs != null){
					rs.close();
				}
				if(stmt != null){
					stmt.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void login2(String uname,String password){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql:///bd1807", 
					"root", 
					"root");
			//3.创建PreparedSatement发送sql
			String sql = "select * from userinfo where uname = ? and password = ?";
			//预编译(语法语义检查)
			ps = conn.prepareStatement(sql);
			//赋值
			ps.setString(1, uname);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			
			//4.处理结果
			if(rs.next()){
				System.out.println("登陆成功");
			}else{
				System.out.println("登录失败");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
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
		
		
		
	}
	
	
	
	
	
	
	

}

package com.lee.jdbcdemo;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lee.entily.Userinfo;


@SuppressWarnings("unused")
public class JdbcDemo {

	public static void main(String[] args) {
	/*	Userinfo i1= new Userinfo(1,"chen","111");
		Userinfo i2= new Userinfo(2,"jian","222");
		insert(i1);
		insert(i2);*/
		System.out.println(delete(2));
		
	}
	
	//增加
	public static void insert(Userinfo info){
		Connection conn =null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bd1807?useSSL=true", 
					"root", 
					"root");
			String sql = "insert into userinfo(uname,password) values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1,info.getUname());
			ps.setString(2,info.getPassword());
			
			int rows = ps.executeUpdate();
			
			System.out.println(rows);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(conn!=null){
				conn.close();
				}
				if(ps!=null){
				ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//修改
	public static void updata(Userinfo info){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
				Class.forName("com.mysql.jdbc.Driver");
			   conn = DriverManager.getConnection(
					   "jdbc:mysql://localhost:3306/bd1807?useSSL=true", 
					  "root",
					  "root");
			   String sql = "update userinfo set uname = ?,password = ? where uid = ?";
			   ps = conn.prepareStatement(sql);
			   ps.setString(1,info.getUname() );
			   ps.setString(2, info.getPassword());
			   ps.setLong(3, info.getUid());
			   
			   int a =ps.executeUpdate(sql);
			   System.out.println(a);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(ps!=null){
				ps.close();
				}
				if(conn!=null){
				conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static int delete( int uid){
		Connection conn = null;
		PreparedStatement ps = null;
		int rows = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bd1807?useSSL=true",
					"root",
					"root");
			String sql = "delete from userinfo where uid = ?";
			ps = conn.prepareStatement(sql);
			ps.setLong(1, uid);
			rows = ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}
	
	
	
	// 查询
	public static void select(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null ;
		List<Userinfo> users = new ArrayList<>();
		try {
			//1.注册驱动，Drivermanager管理具体的驱动程序，实现对底层的屏蔽，对开发人员提供统一访问
			//DriverManager.registerDriver(new Driver());
			Class.forName("com.mysql.jdbc.Driver");
			//2.建立连接
			 conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bd1807?useSSL=true",
					"root", 
					"root");
			//获取连接的元数据信息
			 DatabaseMetaData md = conn.getMetaData();
			 System.out.println(md.getDriverName());
			 System.out.println(md.getURL());
			 System.out.println(md.getUserName());
			 
			System.out.println(conn);
			//3.发送sql给数据库服务
			String sql = "select * from userinfo";
			//Statement对象：实现sql发送
			 ps = conn.prepareStatement(sql);
			 rs = ps.executeQuery();
			 
			 //获取结果集的元数据
	//		 ResultSetMetaData md1 = rs.getMetaData();
			 //获取列
	//		 int count = md1.getColumnCount();
			 //String name = md1.getColumnName(column);
			 //遍历获取每一个字段的名称
			 //类属性和表字段保持一致
			 //用于封装对象
			 
			//4.处理相应的结果(ResultSet底层维护了一个指向结果集的游标)
			while(rs.next()){	//向前移动游标(遍历一行)
				Userinfo u1 = new Userinfo();
				int uid = rs.getInt("uid");
				String uname = rs.getString("uname");
				String password = rs.getString("password");
				u1.setUid(uid);
				u1.setUname(uname);
				u1.setPassword(password);
				users.add(u1);
				System.out.printf("deptno:%d,dname:%s,loc:%s\n",uid,uname,password);
			}
			System.out.println(users);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){
					rs.close();
				}
				if(ps!=null){
					ps.close();
				}
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

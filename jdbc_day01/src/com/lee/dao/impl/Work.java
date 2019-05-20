package com.lee.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lee.dao.IUserinfoDao;
import com.lee.entity.Userinfo;

public class Work implements IUserinfoDao {
	@Override
	public List<Userinfo> findAll() {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;
		List<Userinfo> dept = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bd1807?useSSL=true", 
					"root", 
					"root");
			String sql = "select * from dept";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){  //向前移动游标(遍历一行)
				Userinfo info = new Userinfo();
				//获取游标指向行的字段的信息(遍历每列)
				int uid = rs.getInt("deptno");
				String uname = rs.getString("dname");
				String password = rs.getString("loc");
				info.setUid(uid);
				info.setUname(uname);
				info.setPassword(password);
				dept.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
		return dept;
	}

	public Userinfo select(int deptno) {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;
		Userinfo info = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bd1807?useSSL=true", 
					"root", 
					"root");
			String sql = "select * from dept where deptno = ?";
			ps = conn.prepareStatement(sql);
			ps.setLong(1, deptno);
			rs = ps.executeQuery();
			
			while(rs.next()){  //向前移动游标(遍历一行)
				 info = new Userinfo();
				//获取游标指向行的字段的信息(遍历每列)
					int uid = rs.getInt("deptno");
					String uname = rs.getString("dname");
					String password = rs.getString("loc");
				info.setUid(uid);
				info.setUname(uname);
				info.setPassword(password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
		return info;
	}
	
	@Override
	public int insert(Userinfo userinfo) {
		Connection conn = null;
		PreparedStatement ps = null;
		int rows = 0;
		try {
			//1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取连接
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bd1807?useSSL=true", 
					"root", 
					"root");
			//3.发送sql
			String sql = "insert into dept values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt( 1, userinfo.getUid());
			ps.setString(2, userinfo.getUname());
			ps.setString(3, userinfo.getPassword());
			
			rows = ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(ps != null){
					ps.close();
				}
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows;
	}

	@Override
	public int update(Userinfo userinfo) {
		return 0;
	}

	@Override
	public int delete(int deptno) {
		Connection conn = null;
		PreparedStatement ps = null;
		int rows = 0;
		try {
			//1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取连接
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bd1807?useSSL=true", 
					"root", 
					"root");
			//3.发送sql
			String sql = "delete from dept where deptno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, deptno);
			rows = ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(ps != null){
					ps.close();
				}
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows;
	}
}

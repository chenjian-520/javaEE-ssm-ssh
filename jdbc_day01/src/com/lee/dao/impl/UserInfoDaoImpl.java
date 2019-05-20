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
/**
 * 具体实现
 *
 */
public class UserInfoDaoImpl implements IUserinfoDao {

	@Override
	public List<Userinfo> findAll() {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;
		List<Userinfo> users = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bd1807?useSSL=true", 
					"root", 
					"root");
			String sql = "select * from userinfo";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
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
		return users;
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
			String sql = "insert into userinfo(uname,password) values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userinfo.getUname());
			ps.setString(2, userinfo.getPassword());
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
			String sql = "update userinfo set uname = ?,password = ? where uid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userinfo.getUname());
			ps.setString(2, userinfo.getPassword());
			ps.setInt(3, userinfo.getUid());
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
	public int delete(int uid) {
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
			String sql = "delete from userinfo where uid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
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

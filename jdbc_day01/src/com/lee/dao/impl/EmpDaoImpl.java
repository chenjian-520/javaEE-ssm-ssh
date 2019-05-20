package com.lee.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.lee.dao.EmpDao;
import com.lee.entity.Userinfo;

public class EmpDaoImpl implements EmpDao {
	
	ResultSet rs = null;
	Connection conn = null;
	PreparedStatement ps = null;
	
	//关闭资源
	public void closeRes() {
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
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/bd1807?useSSL=true", 
				"root", 
				"root");
		return conn;
	}
	
	@Override
	public List<Userinfo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Userinfo userinfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Userinfo userinfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int uid) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

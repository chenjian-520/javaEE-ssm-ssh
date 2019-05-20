package com.lee.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lee.dao.IUserinfoDao;
import com.lee.entily.Userinfo;
import com.lee.util.Util;

public class UserInfoDaoImpl implements IUserinfoDao {
	Connection conn =null;
	PreparedStatement ps = null;
	ResultSet rs =null;
	int rows = 0;
	
	@Override //²é
	public List<Userinfo> findAll() {
		List<Userinfo> users = new ArrayList<>();
		try {
			conn = Util.getuser();
			String sql = "select * from Userinfo";
			 ps = conn.prepareStatement(sql);
			 rs = ps.executeQuery();
			 while(rs.next()){
				Userinfo info = new Userinfo();
				int uid = rs.getInt("uid");
				String uname = rs.getString("uname");
				String password = rs.getString("password");
				info.setUid(uid);
				info.setUname(uname);
				info.setPassword(password);
				users.add(info);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Util.getClose(conn,ps,rs);
		}
		return users;
	}





	@Override//Ôö
	public int insert(Userinfo info) {
		
		
		try {
			conn = Util.getuser();
			 String sql = "insert into userinfo(uname,password) values(?,?)";
			 ps = conn.prepareStatement(sql);
			 ps.setString(1, info.getUname());
			 ps.setString(2, info.getPassword());
			 
			 rows = ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Util.getClose(conn,ps,rs);
		}
		return rows;
	}

	@Override//É¾
	public int delete(int i) {

		
		try {
			conn = Util.getuser();
			 String sql = "delete from userinfo where uid = ?";
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, i);
			 rows = ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Util.getClose(conn,ps,rs);
		}
								
		return rows;
	}

	@Override//¸Ä
	public int updata(Userinfo info) {
		
		try {
			conn = Util.getuser();
			 String sql = "update userinfo set uname = ?,password = ? where uid = ?";
			 ps = conn.prepareStatement(sql);
			 ps.setString(1, info.getUname());
			 ps.setString(2, info.getPassword());
			 ps.setInt(3, info.getUid());
			 
			 rows = ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Util.getClose(conn,ps,rs);
		}
		return rows;
	}

}

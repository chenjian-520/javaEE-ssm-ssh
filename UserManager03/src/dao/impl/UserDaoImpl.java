package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import entity.Userinfo;
import util.JdbcUtils;

public class UserDaoImpl implements UserDao {
	
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	int temp = 0;
	@Override
	public int delete(int uid) {
		// TODO Auto-generated method stub
		try {
			conn=JdbcUtils.getConnection();
			String sql = "delete from userinfo where uid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			temp = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeRes(conn, ps, rs);
		}
		return temp;
	}
	
	
	@Override
	public int insert(String username, String password) {
		// TODO Auto-generated method stub
		
	try {	
			conn = JdbcUtils.getConnection();
			String sql = "insert into userinfo(uname,password) values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			temp = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeRes(conn, ps, rs);
		}
		
		return temp;
	}

	
	@Override
	public Userinfo login(String username, String password) {
		// TODO Auto-generated method stub
		Userinfo userinfo = null;
		conn = JdbcUtils.getConnection();
		String sql = "select * from userinfo where uname = ? and password = ?";
				
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				userinfo = new Userinfo();
				userinfo.setUid(rs.getInt("uid"));
				userinfo.setUname(rs.getString("uname"));
				userinfo.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeRes(conn, ps, rs);
		}
		return userinfo;
	}

	@Override
	public List<Userinfo> findAll() {
		// TODO Auto-generated method stub
		List<Userinfo> userinfo = new ArrayList<>();
		 conn = JdbcUtils.getConnection();
		 String sql = "select * from userinfo ";
		 try {
			 ps = conn.prepareStatement(sql);
			 rs = ps.executeQuery();
			 while(rs.next()){
				Userinfo user = new Userinfo();
				user.setUid(rs.getInt("uid"));
				user.setUname(rs.getString("uname"));
				user.setPassword(rs.getString("password"));
				userinfo.add(user);	 
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeRes(conn, ps, rs);
		}
		 
		return userinfo;
	}



	
}

package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;

import dao.UserDao;
import entity.UserInfo;
import util.JdbcUtils;

public class UserDaoImpl implements UserDao {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	@Override
	public UserInfo login(String username, String password) {
		UserInfo userinfo = null;
		conn = JdbcUtils.getConnection();
		String sql = "select * from userinfo where uname = ? and password = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()){
				userinfo = new UserInfo();
				userinfo.setUid(rs.getInt("uid"));
				userinfo.setUname(username);
				userinfo.setPassword(password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.closeRes(conn, ps, rs);
		}
		return userinfo;
	}

	@Override
	public List<UserInfo> findAll() {
		List<UserInfo> users = new ArrayList<>();
		conn = JdbcUtils.getConnection();
		String sql = "select * from userinfo";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				UserInfo userinfo = new UserInfo();
				userinfo.setUid(rs.getInt("uid"));
				userinfo.setUname(rs.getString("uname"));
				userinfo.setPassword(rs.getString("password"));
				users.add(userinfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.closeRes(conn, ps, rs);
		}
		return users;
	}

}

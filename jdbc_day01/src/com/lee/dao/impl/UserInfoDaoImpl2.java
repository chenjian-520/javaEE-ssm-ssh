package com.lee.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lee.dao.IUserinfoDao;
import com.lee.entity.Userinfo;
import com.lee.util.JdbcUtil;
/**
 * 具体实现
 *
 */
public class UserInfoDaoImpl2 implements IUserinfoDao {
	
	ResultSet rs = null;
	Connection conn = null;
	PreparedStatement ps = null;
	
	
	@Override
	public List<Userinfo> findAll() {

		List<Userinfo> users = new ArrayList<>();
		try {
			conn =JdbcUtil.getConnection();
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtil.closeRes(rs,conn,ps);
		}
		return users;
	}
	


	@Override
	public int insert(Userinfo userinfo) {

		int rows = 0;
		try {
			conn =JdbcUtil.getConnection();
			//3.发送sql
			String sql = "insert into userinfo(uname,password) values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userinfo.getUname());
			ps.setString(2, userinfo.getPassword());
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.closeRes(rs,conn,ps);
		}
		return rows;
	}

	@Override
	public int update(Userinfo userinfo) {

		int rows = 0;
		try {
			conn =JdbcUtil.getConnection();
			//3.发送sql
			String sql = "update userinfo set uname = ?,password = ? where uid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userinfo.getUname());
			ps.setString(2, userinfo.getPassword());
			ps.setInt(3, userinfo.getUid());
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.closeRes(rs,conn,ps);
		}
		return rows;
	}

	@Override
	public int delete(int uid) {

		int rows = 0;
		try {
			conn =JdbcUtil.getConnection();
			//3.发送sql
			String sql = "delete from userinfo where uid = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			rows = ps.executeUpdate();
		}  catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.closeRes(rs,conn,ps);
		}
		return rows;
	}

}

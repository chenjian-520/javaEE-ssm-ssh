package user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lee.util.JdbcUtil;


public class Jdbc {
	public static List<User> util() {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement ps = null;
		List<User> users = new ArrayList<>();
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from userinfo";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){  //向前移动游标(遍历一行)
				User info = new User();
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
		}finally{
			JdbcUtil.closeRes(rs, conn, ps);
		}
		return  users;
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
	//	System.out.println(Jdbc.util());
		
	}
}

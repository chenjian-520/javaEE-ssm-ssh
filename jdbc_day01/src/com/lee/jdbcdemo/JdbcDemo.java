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
	
	//����
	public static void insert(Userinfo info){
		Connection conn = null;
		Statement stmt = null;
		try {
			//1.ע������
			Class.forName("com.mysql.jdbc.Driver");
			//2.��ȡ����
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bd1807?useSSL=true", 
					"root", 
					"root");
			//3.����sql
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
	//�޸�
	public static void update(Userinfo info){
	}
	//ɾ��
	public static void delete(int uid){
		Connection conn = null;
		Statement stmt = null;
		try {
			//1.ע������
			Class.forName("com.mysql.jdbc.Driver");
			//2.��ȡ����
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bd1807?useSSL=true", 
					"root", 
					"root");
			//3.����sql
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
			//1.ע������,DriverManager����������������ʵ�ֶԵײ�����,�Կ�����Ա�ṩͳһ���ʡ�
			//java.sql.Driver: jdbc�Ľӿ�
			//com.mysql.jdbc.Driver: mysql��jdbc��Driver�ӿ�ʵ����
			//DriverManager.registerDriver(new Driver());
			Class.forName("com.mysql.jdbc.Driver");
			//2.��������  java.sql.Connection
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bd1807?useSSL=true", 
					"root", 
					"root");
			//conn��������
			//��ȡ���ӵ�Ԫ������Ϣ
			/*DatabaseMetaData md = conn.getMetaData();
			System.out.println(md.getDatabaseProductName());
			System.out.println(md.getDriverName());
			System.out.println(md.getURL());
			System.out.println(md.getUserName());*/
			
			
			//3.����sql�����ݿ����
			String sql = "select * from userinfo";
			//Statement����:ʵ��sql����
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			//��ȡ�������Ԫ����
			/*ResultSetMetaData md = rs.getMetaData();
			//��ȡ��
			int count = md.getColumnCount();*/
			//String name = md.getColumnName(column);
			//������ȡÿһ���ֶε�����
			//�����Ժͱ��ֶα���һ��
			//���ڷ�װ����
			
			//4.������Ӧ���(ResultSet�ײ�ά����һ��ָ���������α�)
			while(rs.next()){  //��ǰ�ƶ��α�(����һ��)
				Userinfo info = new Userinfo();
				//��ȡ�α�ָ���е��ֶε���Ϣ(����ÿ��)
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
	
	//��¼
	public static void login(String uname,String password){
		ResultSet rs = null;
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//2.��������  java.sql.Connection
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bd1807?useSSL=true", 
					"root", 
					"root");
			//3.����sql
			stmt = conn.createStatement();
			String sql = "select * from userinfo where uname = '"+uname+"'  and password = '"+password+"'";
			rs = stmt.executeQuery(sql);
			//4.������
			if(rs.next()){
				System.out.println("��½�ɹ�");
			}else{
				System.out.println("��¼ʧ��");
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
			//3.����PreparedSatement����sql
			String sql = "select * from userinfo where uname = ? and password = ?";
			//Ԥ����(�﷨������)
			ps = conn.prepareStatement(sql);
			//��ֵ
			ps.setString(1, uname);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			
			//4.������
			if(rs.next()){
				System.out.println("��½�ɹ�");
			}else{
				System.out.println("��¼ʧ��");
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

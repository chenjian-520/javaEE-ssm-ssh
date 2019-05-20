package com.lee.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lee.entily.Emp;

public class Work {

	public static void main(String[] args) {
		List<Emp> emp=Work.select(2,5);
		
	}
	public static List<Emp> select(int a,int b){
		List<Emp> emp = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bd1807?useSSL=true",
					"root",
					"root");
			String sql ="select * from emp limit ?,?;";
			
			 ps = conn.prepareStatement(sql);
			ps.setInt(1, (a-1)*b);
			ps.setInt(2, b);
			 rs = ps.executeQuery();
			while(rs.next()){
				Emp e = new Emp();
				 int empno=rs.getInt("empno");
				 String ename = rs.getString("ename");
				 String job = rs.getString("job");
				 int mgr = rs.getInt("mgr");
				 int hiredate = rs.getInt("hiredate");
				 int sal = rs.getInt("sal");
				 int comm = rs.getInt("comm");
				 int deptno = rs.getInt("deptno");
				 e.setEmpno(empno);
				 e.setEname(ename);
				 e.setJob(job);
				 e.setMgr(mgr);
				 e.setHiredate(hiredate);
				 e.setSal(sal);
				 e.setComm(comm);
				 e.setDeptno(deptno);
				 emp.add(e);
				 System.out.println(empno+".."+ename+".."+job+".."+mgr+".."
				 +hiredate+".."+sal+".."+comm+".."+deptno);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		return emp;
	}

}

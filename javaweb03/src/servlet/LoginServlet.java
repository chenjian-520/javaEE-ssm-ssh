package servlet;


import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lee.util.JdbcUtil;

import user.Jdbc;
import user.User;





/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//修改post 请求编码
		request.setCharacterEncoding("utf-8");
		//修改响应编码
		response.setCharacterEncoding("utf-8");
		//设置数据类型响应的类型（响应头）
		response.setContentType("text/html;charset=utf-8");
		
		
		
		//2获取参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.printf("username:%s,password:%s",username,password);
		
		
			
		List<User> util = Jdbc.util();
		System.out.println(util);
		boolean a1 = true;
		for(User a : util){
		if(a.getUname().equals(username)&&a.getPassword().equals(password)){
			a1 = false;
			request.getRequestDispatcher("show.jsp").forward(request, response);
			break;
		}
	}
		if(a1){
			PrintWriter writer = response.getWriter();
			writer.println("登录失败");
			writer.close();
		}
		
		//3.响应(转发，重定向)
	//	request.getRequestDispatcher("show.jsp").forward(request, response);
		
	//	response.sendRedirect("show.jsp");
	}

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}

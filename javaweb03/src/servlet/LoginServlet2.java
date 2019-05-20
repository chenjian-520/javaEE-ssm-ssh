package servlet;


import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lee.util.JdbcUtil;

import user.Jdbc;
import user.User;





/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login2")
public class LoginServlet2 extends HttpServlet {
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
		
		/*ServletContext application = getServletContext();
		application.setAttribute("user", username);*/
		
	/*	Cookie cookie = new Cookie("user",username);
		cookie.setMaxAge(30);  //设置时长 30 秒
		response.addCookie(cookie);
		request.getRequestDispatcher("main.jsp").forward(request, response);
		
		//获取所有cookies
		Cookie[] cookies = request.getCookies();
		cookies[0].getName();
		cookies[0].getValue();*/
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(5);
		session.setAttribute("user", username);
		
		request.getRequestDispatcher("main.jsp").forward(request, response);
		//3.响应(转发，重定向)
	//	request.getRequestDispatcher("main.jsp").forward(request, response);
		
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

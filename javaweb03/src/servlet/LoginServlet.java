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
		//�޸�post �������
		request.setCharacterEncoding("utf-8");
		//�޸���Ӧ����
		response.setCharacterEncoding("utf-8");
		//��������������Ӧ�����ͣ���Ӧͷ��
		response.setContentType("text/html;charset=utf-8");
		
		
		
		//2��ȡ����
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
			writer.println("��¼ʧ��");
			writer.close();
		}
		
		//3.��Ӧ(ת�����ض���)
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

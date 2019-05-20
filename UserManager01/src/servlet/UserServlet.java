package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.UserInfo;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		
		
		//2.��ȡ����
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//�ж�
		UserDao dao = new UserDaoImpl();
		UserInfo userInfo = dao.login(username, password);
		if(userInfo == null){
			request.setAttribute("msg", "��¼ʧ��");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			//�����û���
			request.getSession().setAttribute("user", username);
			List<UserInfo> users = dao.findAll();
			request.setAttribute("users", users);
			request.getRequestDispatcher("show.jsp").forward(request, response);
		}
		
	}

}

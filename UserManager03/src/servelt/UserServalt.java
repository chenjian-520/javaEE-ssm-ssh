package servelt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.Userinfo;

/**
 * Servlet implementation class UserServalt
 */
@WebServlet("/User")
public class UserServalt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 接收数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String value = request.getParameter("method");
		String uid= request.getParameter("uid");
		UserDao dao = new UserDaoImpl();
		if (value.equals("tijiao")) {
			// 判断
			
			Userinfo userinfo = dao.login(username, password);
			if (userinfo == null) {
				request.setAttribute("msg", "登录失败");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				request.getSession().setAttribute("user", username);
				List<Userinfo> users = dao.findAll();
				request.setAttribute("users", users);
				request.getRequestDispatcher("show.jsp").forward(request, response);
			}

		}else if(value.equals("zhuce")){
			
			dao.insert(username, password);
			request.setAttribute("msg", "注册成功请登录！！！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}else if(value.equals("delete")){
			int udd = Integer.valueOf(uid);
			dao.delete(udd);
			request.setAttribute("msg", "删除用户成功！！！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
		
	}

}

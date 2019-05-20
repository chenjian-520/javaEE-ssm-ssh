package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import service.UserService;
import service.impl.UserServiceImpl;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//加载容器
		//spring-web: 从application域中获取容器。
		WebApplicationContext ac = 
				WebApplicationContextUtils.getWebApplicationContext(getServletContext());
				//getServletContext().getAttribute(WebApplicationContext
				//.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		//获取对象
		UserService userService = ac.getBean("userservice",UserService.class);
		userService.addUser();
		userService.deleteUser();
	}

}

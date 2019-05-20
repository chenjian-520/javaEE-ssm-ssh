<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  欢迎你 ， ${user }
  
  <% 
  		Object obj = session.getAttribute("user");
  		if(obj == null){
  			request.setAttribute("msg", "非法访问");
  			request.getRequestDispatcher("login.jsp").forward(request, response);
  		}
  %>
  
  
  <a href="phone.jsp?user=${user }"> 手机 </a>
</body>
</html>
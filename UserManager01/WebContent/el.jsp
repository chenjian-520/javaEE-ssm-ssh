
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entity.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<% 
		    request.setAttribute("user", "zs");
		UserInfo info=new UserInfo();
		info.setUname("zs");
		    request.setAttribute("user", info);
		    
		    List list =new ArrayList();
		    list.add("aa");
		    list.add("bb");
		    list.add("cc");
		    request.setAttribute("li", list);
		    
		    Map map = new HashMap();
		    map.put("name", "zs");
		    map.put("age",12);
		    request.setAttribute("map", map);
		%>
		${user.uname}
		${li[0] }
		${map.name }
</body>
</html>
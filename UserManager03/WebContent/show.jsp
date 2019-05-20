<%@page import="entity.Userinfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1 align="center">分IP统计访问次数</h1>
<table align="center" width="60%" border="1">
	<tr>
		<th>IP地址</th>
		<th>访 问 量</th>
	</tr>
	<!--循环遍历在ServletContext中的map，其中key是ip地址，value是访问次数 -->
	<c:forEach items="${applicationScope.map }" var="entry">
		<tr>
			<td>${entry.key }</td>
			<td>${entry.value }</td>
		</tr>
	</c:forEach>
</table>




		欢迎你。，，，${user } &nbsp; <a href="lougout.jsp">注销</a>
		
		<%
		List<Userinfo> users = (List<Userinfo>)request.getAttribute("users");
		%>
		<table border="1"  cellpadding="5" cellspacing="0">
			<tr>
				<td>uid</td>
				<td>uname</td>
				<td>password</td>
				<td>operation</td>
			</tr>
		
			<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.uid}</td>
				<td>${user.uname }</td>
				<td>${user.password }</td>
				<td><a href="User?method=delete&uid=${user.uid }">删除  </a> ${mgg} </td>
			</tr>
			
			</c:forEach>
			
			
			
			
			
			
			
			
		</table>
		
		
</body>
</html>
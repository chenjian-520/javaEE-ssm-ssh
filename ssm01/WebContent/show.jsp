<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<table border="1" cellpadding="5px" cellspacing="0px" width="300px">
		<tr>
			<td>uid</td>
			<td>uname</td>
			<td>password</td>
		</tr>
		
		<c:forEach items="${users }" var="user">
			<tr>
				<td>${user.uid}</td>
				<td>${user.uname}</td>
				<td>${user.password}</td>
			</tr>
		</c:forEach>	
		
		
	</table>
</body>
</html>
<%@page import="entity.UserInfo"%>
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
   欢迎你,${user } &nbsp; <a href="logout.jsp">注销</a>
   <%
      List<UserInfo> users = (List<UserInfo>)request.getAttribute("users");
   %>
   
   <table border="1" cellpadding="5" cellspacing="0" width="300px">
   	  <tr>
   	  	<td>uid</td>
   	  	<td>uname</td>
   	  	<td>password</td>
   	  </tr>
   	<%--   <%
   	  	  for(int i=0;i<users.size();i++){
   	  		  UserInfo info = users.get(i);
   	  		  request.setAttribute("user", info);
   	  		%> 
   	  		 <%  } %>  --%>
   	  	<c:forEach items="${users }" var="user" >
   	  		<tr>
		   	  	<td>${user.uid } </td>
		   	  	<td>${user.uname }</td>
		   	  	<td>${user.password }</td>
   	  		</tr>
   	  	</c:forEach>
   	 
   	  
   </table>
</body>
</html>
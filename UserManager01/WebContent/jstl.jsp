<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setAttribute("score", 90); %>
	
	<!-- 分支   test:支持使用el表达式-->
	<%
		request.setAttribute("score", 70);
	
		List list = new ArrayList();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		request.setAttribute("li", list);
	%>
	 <c:if test="${score>80 }">
		奖励一个大红花!
	</c:if> 
	
	<!-- 多分枝 -->
	 <c:choose>
		<c:when test="${score>80 }">
			奖励一个大红花!
		</c:when>
		<c:otherwise>
			奖励一个大巴掌!
		</c:otherwise>
	</c:choose>
	
	<!-- items:遍历的内容，支持el表达式    var:每个元素名称-->
	<c:forEach items="${li }" var="aa">
		<p>${aa }</p>
	</c:forEach>

	
</body>
</html>
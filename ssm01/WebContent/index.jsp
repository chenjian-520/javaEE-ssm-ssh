<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<a href="queryAll.do">查询</a>
	
	<form action="delete.do" method="get">
		<input type="text" name="uid" />
		<input type="submit" name="submit" value="删除"/>
	</form>
	<br />
	<form action="insert.do" method="get">
		<input type="text" name="uid" />uid<br />
		<input type="text" name="uname" />uname<br />
		<input type="text" name="password" />password<br />
		<input type="submit" name="submit1" value="插入信息"/>
	</form>
	${zhuantai}<br/>
	${del}
		<br />
	<form action="update.do" method="get">
		<input type="text" name="uid" />需要修改的uid<br />
		<input type="text" name="uname" />新的uname<br />
		<input type="text" name="password" />新的password<br />
		<input type="submit" name="submit2 " value="修改信息"/>
	</form>
</body>
</html>
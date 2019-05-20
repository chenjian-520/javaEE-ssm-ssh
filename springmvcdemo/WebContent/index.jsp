<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="user.do?uid=1">删除</a>
	<form action="user.do" method="get">
		用户名<input type="text" name="uname" /><br />
		密码<input type="text" name="password" /><br />
		
		爱好：<input type="checkbox" name="hobby" value="play">玩
		<input type="checkbox" name="hobby" value="movie">看电影
		<input type="checkbox" name="hobby" value="book">看书<br/>
		其他：
		<input type="text" name="list[0]" /><br />
		<input type="text" name="list[1]" /><br />
		map：
	  	<input type="text" name="map['name']">
		  <input type="text" name="map['age']"> 
		
		<input type="submit" name="submit" /><br />
		
	</form>
</body>
</html>
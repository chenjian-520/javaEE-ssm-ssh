<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#div1{
		width: 300px;
		height: 300px;
		margin: 0 auto;
		text-align: center;
	}
</style>
<!-- <script type="text/javascript">
	function send(ele){
		var val = ele.value;
		//1.创建XMLHttpRequest对象
		var xhr = new XMLHttpRequest();
		//2.打开链接(发送的url，请求方式)
		xhr.open("get","ajax?key="+val);
		//3.发送请求
		xhr.send(null);
		//4.处理响应数据
		 //监听请求状态
		 //xhr.readyState:请求状态 (0-4)
		 var oDiv = document.getElementById("div2");
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				oDiv.innerHTML=xhr.responseText;
			}
		}
	}
</script> -->
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	function send(ele){
		var val = ele.value;
		$.get("ajax?key="+val,function(data){
			$("#div2").html(data);
		}); 
		$.post("ajax",{"key":val},function(data){
			$("#div2").html(data);
		});
	}
</script>
</head>
<body>
	<div id="div1">
		<img alt="" src="//www.baidu.com/img/bd_logo1.png" width="270px" height="129px">
		<input type="text" onkeyup="send(this)"><input type="button" value="百度一下">
		<div id="div2"></div>
	</div>
</body>
</html>
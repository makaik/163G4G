<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
<form action="user" method="post">
用户名:<input type="text" name="user.uname"/>
<br/>
密&nbsp&nbsp&nbsp&nbsp码:<input type="password" name="user.upwd"/>
<br/>
年&nbsp&nbsp&nbsp&nbsp龄:<input type="text" name="user.age"/>
<br/>
性&nbsp&nbsp&nbsp&nbsp别:<input type="radio" value="男" name="user.sex"/>男
	<input type="radio" value="女" name="user.sex"/>女
<br/>
住&nbsp&nbsp&nbsp&nbsp址:<input type="text" name="user.address"/> 
<br/>
<input type="submit" value="登录"/>
</form>
</body>
</html>
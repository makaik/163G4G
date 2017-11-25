<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="login" method="post">
		<center>
			<h2>用户登录</h2>
			<input type="text" name="user.uname"><br> <br>
			<input type="password" name="user.pwd"><br> <br>
			<input type="submit" value="提交">
		</center>
	</form><br>
	<s:set name="stu" value="{'Sea','河南邓州','13989898888','软件开发，前端设计'}"></s:set>
	技术支持：<s:property value="#stu[0]"/><br>
	位于：<s:property value="#stu[1]"/><br>
	电话：<s:property value="#stu[2]"/><br>
	主营产品：<s:property value="#stu[3]"/><br>
</body>
</html>
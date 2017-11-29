<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录成功</title>
</head>
<body>
	用户名:
	<s:property value="user.uname" />
	<br /> 
	密码:
	<s:property value="user.upwd" />
	<br /> 
	性别:
	<s:property value="user.sex" />
	<br /> 
	住址:
	<s:property value="user.address" />
	<br /> 
	年龄:
	<s:property value="user.age" />
	<br />
	<br />
	<br />
	<br />
	登录时间:<s:property value="date" />
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户页面</title>
</head>
<body>
<center>
		<h2>修改用户</h2>
		<form action="user?update" method="post">
		用户名:<s:textfield name="user.userName" value="${user.userName}"/><br/><br/>
		密码:<s:password name="user.userPassword" /><br/><br/>
		性别:<s:radio name="user.userSex" list="#{'m':'男','f':'女'}" value="m" /><br/><br/>
		年龄:<s:textfield name="user.userAge" /><br/><br/>
		电话:<s:textfield name="user.phone" /><br/><br/>
		QQ:<s:textfield name="user.QQ" /><br/><br/>
		地址:<s:textfield name="user.address" /><br/><br/>
		<input type="submit" value="添加">
  		</form>
	</center>
</body>
</html>
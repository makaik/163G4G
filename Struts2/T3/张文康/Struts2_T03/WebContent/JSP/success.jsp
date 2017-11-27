<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录成功</title>
</head>
<body>
 	Struts2标签：
 	<s:property value = "user.name"/>
 	<s:property value = "user.sex"/>
 	<s:property value = "user.national"/>
 	<s:property value = "user.date"/>
 	<br />
 	<br />
 	<br />
 	
 	EL标签：
 	${user.name }
 	${user.sex }
 	${user.national }
 	${user.date }
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<form action="/login.jsp" method="post">
		用户名:<input type="text" name="userinfo.name" value=""/><br/> 
		密码:<input type="password" name="userinfo.password" value=""/><br/>
		 <input type="submit" value="登录" />
	</form>
	<hr>
	<s:set name="stu"
		value="#{'name':'毒药有限公司','address':'湖北襄阳','phone':'0710-3333333','products':{'系统集成','软件开发'}}"/>

	技术支持:
	<s:property value="#stu['name']" />
	位于:
	<s:property value="#['address']" />
	<s:property value="#['phone']" />
	主营产品:
	<s:property value="#['products'][0]" />
	、
	<s:property value="#stu['phoducts'][1]" />
</body>
</html>

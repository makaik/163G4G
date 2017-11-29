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
    
    <title>My JSP 'index.jsp' starting page</title>
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
    <form action="Struts2T3/login" method="post">
    	用户名：<input type="text" name="userinfo.name">
    	<br>
    	密码：<input type="password" name="userinfo.password">
    	<br>
    	<input type="submit" value="登录">
    	<br>
    	
    	<s:set name="stu" value="#{'name':'XXX','address':'河南','phone':'123456789' }" />
    	名称：<s:property value="#stu['name']" />
    	地址：<s:property value="#stu['address']" />
    	电话：<s:property value="#stu['phone']" />
    </form>
  </body>
</html>

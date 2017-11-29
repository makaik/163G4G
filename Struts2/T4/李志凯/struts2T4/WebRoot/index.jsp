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
	<s:form action="user/add" method="post">
		<s:textfield label="用户名" name="user.uname" required="ture"></s:textfield>
		<s:password label="密码" name="user.upwd" showPassword="false" required="ture"></s:password>
		<s:select label="学历" list="{'高中','大专','大学','研究生','博士','院士'}"  size="2" name="user.edu"></s:select>
		<s:radio label="性别" list="#{1:'男',0:'女',2:'保密'}" value="1" name="user.sex" required="ture"></s:radio>
		<s:submit value="注册"></s:submit>
	</s:form>
  </body>
</html>

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
    <s:form action="user/add" method="get">
    	<s:textfield label="用户名" name="user.uname" required="true"></s:textfield>
    	<s:password label="密码" name="user.upwd" showPassword="false" required="true"> </s:password>
    	<s:select label="学历" list="{'初中','高中','大专','本科','硕士','研究生','博士'}" size="3" name="user.edu"></s:select>
    	<s:radio label="性别" list="#{1:'男',2:'女',0:'保密'}" value="1" name="user.sex" required="true"></s:radio>
    	<s:submit value="注册"></s:submit>
    </s:form>
  </body>
</html>

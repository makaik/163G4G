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
    
    <title>My JSP 'success.jsp' starting page</title>
    
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
  	<h2>用户信息列表</h2>
	<table border="1">
		<tr>
			<td>用户名</td><td>密码</td><td>学历</td><td>性别</td>
		</tr>
		<s:iterator value="user">
		<tr>
			<td><s:property value="uname" /></td>
			<td><s:property value="pswd" /></td>
			<td><s:property value="edu" /></td>
			<td><s:if test='sex=="M"'>男</s:if><s:if test='sex=="F"'>女</s:if><s:else></s:else></td>
		</tr>
		</s:iterator>
	</table>
  </body>
</html>

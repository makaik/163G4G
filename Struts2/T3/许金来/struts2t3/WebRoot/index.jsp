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
    <form action="name" method="post">
    	用户名:<input type="text" name = "userinfo.name" /><br/>
    	密码:<input type="password" name = "userinfo.password" /><br>
    	<input type = "submit" value = "登录">
    </form>
    <hr>
    <s:set name = "stu" value="#{'name':'XXX有限公司','address':'河南','phone':'12457856','product':{'系统集成','软件开发'}}"></s:set>
  	技术支持:<s:property value="#stu['name']"/><br>
  	位于:<s:property value = "#stu['address']"/><br>
  	电话:<s:property value="#stu['phone']"/><br>
  	主营产品:<s:property value="#stu['product'][0]"/>、<s:property value="#stu['product'][1]"/><br>
  
  </body>
</html>

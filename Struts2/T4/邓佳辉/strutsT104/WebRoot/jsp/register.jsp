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

  </head>
  
  <body>
	<s:form action="add" method="get" theme="simple">
		用户名:<s:textfield name="user.uname" /><br>
		密码:<s:password name="user.pswd" /><br>
		学历:<s:select name="user.edu" label="学历" list="{'小学','初中','高中','大专','大学','研究生','博士','院士'}"  size="3" ></s:select><br>
		性别:<s:radio name="user.sex" list="#{'M':'男','F':'女'}" value="M" /><br>
		<input type="submit" value="提交">
	</s:form>
  </body>
</html>

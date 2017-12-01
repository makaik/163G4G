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
    <s:form action="user" method="post">
    	<s:textfield label="用户名" name="user.name" required="true"></s:textfield>
    	<s:password label="密码" name="user.pwd" required="true"></s:password>
    	<s:textfield label="出生日期" name="user.date" required="true"></s:textfield>
    	<s:radio label="性别" list=" {'男','女'} " value="'男'" name="user.sex" required="true"></s:radio>
    	<s:checkboxlist label="爱好" list="{'唱歌','跳舞','游泳','上网','打球','睡觉'}" name="user.like"></s:checkboxlist>
    	<s:select label="籍贯"  list="{'河南','河北','北京','上海','杭州'}" headerValue="请选择...." name="user.nativeplace" required="true"></s:select>
    	<s:textarea label="备注" name="user.memo" cols="20" rows="5"></s:textarea>
    	<s:submit value="注册"></s:submit>
    </s:form>
  </body>
</html>

<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="UTF-8"%>
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
    <s:form action="JSP/text.jsp" method="post">
      <s:textfield label="用户名" name="user.name" required="true"></s:textfield>
      <s:password label="密码" name="user.pwd" showPassword="false" required="true"></s:password>
      <s:checkboxlist label="爱好" list="{'睡觉','玩','吃','北冥有鱼','女'}" name="user.like"></s:checkboxlist>
      <s:select label="学历" list="{'幼儿园','小学','初中','高中','本科','研究生','硕士','博士'}" size="1"></s:select>
      <s:radio label="性别" list="{'男','女','不详','不定'}" name="user.sex" value="男"></s:radio>
      <s:submit value="提交"></s:submit>
    </s:form>
  </body>
</html>

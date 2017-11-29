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
    <s:form action="/Struts2T4/reg" method="post" theme="simple">
    	用户名： <s:textfield name="user.name"></s:textfield><br>
    	密码： <s:password name="user.password"></s:password><br>
    	出生日期： <s:textfield name="user.birthday"></s:textfield><br>
    	性别： <s:radio name="user.sex" list="#{'M':'男','F':'女' }" value="'M'"></s:radio><br>
    	爱好：<s:checkboxlist name="user.love" list="{'聊天','旅游'}"></s:checkboxlist><br>
    	是否启用： <s:checkbox name="user.active" fieldValue="true"></s:checkbox><br>
    	<input type="submit" value="提交" />
    	
    	<br><br><br>
    	
    	<s:set name="score" value="" scope="session"></s:set>
    	<s:if test="#session.score > 90">
    	优秀
    	</s:if>
    	<s:elseif test="#session.score <60">
    		不及格
    	</s:elseif>
    </s:form>
  </body>
</html>

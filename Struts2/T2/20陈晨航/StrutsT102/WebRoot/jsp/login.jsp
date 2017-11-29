<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<style type="text/css">
	#d1{
		margin-top: 10%;
		text-align: center;
	}
	#s1{
		height: 30px;
		width: 100px;
	}
	</style>

  </head>
  
  <body>
     <div id="d1">
		<form action="StrutsT102/login" method="post">
			请输入用户名：<br>
			<input type="text" name="uname"><br>
			请输入密码:<br>
			<input type="password" name="pswd"><br><br><br>
			<input id="s1" type="submit" value="提交">
		</form>
		<p style="color: red;">${errorMsg }</p>
	</div>
  </body>
</html>

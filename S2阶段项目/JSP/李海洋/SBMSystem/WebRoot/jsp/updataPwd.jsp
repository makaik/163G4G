<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updataPwd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript">
		function checkit() {
			if (checkEmpty("userPassword") && 
				checkEmpty("userPassword1")&&
				checkEmpty("userPassword2")
			) {
				//非空验证通过
				if(checkPassword()){
					//密码确认通过
						return true;//提交数据
				}else {
					//密码确认不通过
					alert("两次密码输入不一致，请重新输入！");
					return false;
				}
			} else {
				//非空验证不通过
				alert("请检查用户信息是否完整!");
				return false;
			}
		}
		function checkPassword() {
			var userPassword1 = document.getElementById("userPassword1").value;
			var userPassword2 = document.getElementById("userPassword2").value;
				if(userPassword1 == userPassword2){
					return true;
				}else{
					return false;
				}
		}
		function checkEmpty(id) {
			var renyi = document.getElementById(id).value;
			if(renyi != null && renyi != ""){
				return true;
			}else{
				return false;
			}
		}
	</script>
  </head>
  
  <body>
    <div class="menu">
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">修改密码&gt;&gt;</div>
		</div>
		<form action="user?cmd=updatePwd" method="post" onsubmit="return checkit();">
			<div class="content">
				<table class="box">
					<tr>
						<td class="field">旧的密码：</td>
						<td><input type="password" name="userPassword" class="text" id="userPassword" /></td>
					</tr>
					<tr>
						<td class="field">新的密码：</td>
							<td><input type="password" name="userPassword1" class="text" id="userPassword1" /></td>
					</tr>
					<tr>
						<td class="field">确认密码：</td>
							<td><input type="password" name="userPassword2" class="text" id="userPassword2" /></td>
					</tr>
				</table>
			</div>
			<div class="buttons">
				<input type="button" name="button" value="返回" class="input-button" onclick="history.back();" />
				<input type="submit" name="submit" value="修改密码" class="input-button" />
			</div>
		</form>
	</div>
  </body>
</html>

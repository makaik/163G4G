<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'modify.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript">
function checkit() {
	//判断是否是数字的正则表达式
	if(
		checkEmpty("userName") &&
		checkEmpty("userSex") &&
		checkEmpty("userAge") &&
		checkEmpty("telephone") &&
		checkEmpty("address") &&
		checkEmpty("type")		
	){
		//非空验证通过
			if(checkAge()){
				//年龄验证通过
				return true;//提交表单数据
			}else {
				alert("年龄只能在0-120之间!");
				return false;
			}
	}else {
		//非空验证不通过
		alert("请检查用户信息是否完整!");
		return false;
	}
}
function checkAge() {
	var userAge = document.getElementById("userAge").value;
	if(userAge > 0 && userAge < 120){
		//满足数据要求
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
			<div class="title">用户管理&gt;&gt;</div>
		</div>
		<form method="post" action="user?cmd=updataUser" onsubmit="return checkit();">
			<div class="content">
				<table class="box">
					<tr>
						<td class="field">用户编号：</td>
						<td><input readonly="readonly" type="text" name="userId" class="text" value="${param.userId}" /></td>
					</tr>
					<tr>
						<td class="field">用户名称：</td>
						<td><input type="text" name="userName" class="text" id="userName" />
						<font color="red">*</font></td>
					</tr>
					<tr>
						<td class="field">用户性别：</td>
						<td>
							<select name="userSex" id="userSex">
								<option selected="selected" value="m">男</option>
								<option value="f">女</option>
							</select>
							<font color="red">*</font>
						</td>
					</tr>
					<tr>
						<td class="field">用户年龄：</td>
						<td><input type="text" name="userAge" class="text" id="userAge" />
						<font color="red">*</font></td>
					</tr>
					<tr>
						<td class="field">用户电话：</td>
						<td><input type="text" name="telephone" class="text" id="telephone" />
						<font color="red">*</font></td>
					</tr>
					<tr>
						<td class="field">用户地址：</td>
						<td><textarea name="address" id="address" cols="45" rows="5"></textarea>
						<font color="red">*</font></td>
					</tr>
					<tr>
						<td class="field">用户权限：</td>
						<td>
							<input type="radio" name="type" value="0" id="type" />经理
							<input type="radio" name="type" value="1" checked="checked" id="type" />普通用户
							<font color="red">*</font>
						</td>
					</tr>
				</table>
			</div>
			<div class="buttons">
				<input type="button" name="button" value="返回" class="input-button" onclick="history.back();" />
				<input type="submit" name="submit" value="修改" class="input-button" />
				<a style="text-decoration: none;" class="input-button" href="user?cmd=deleteUser&&userId=${param.userId}" >删除</a>
			</div>
		</form>
	</div>
</body>
</html>

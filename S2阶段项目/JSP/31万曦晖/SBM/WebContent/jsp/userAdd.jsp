<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理_添加数据</title>
<link type="text/css" rel="stylesheet" href="../css/style.css">
<script type="text/javascript">
	function checkit() {
		if(
			checkEmpty("userName")&&	
			checkEmpty("userPassword")&&	
			checkEmpty("userPassword1")&&	
			checkEmpty("userSex")&&	
			checkEmpty("userAge")&&	
			checkEmpty("telephone")&&	
			checkEmpty("address")&&	
			checkEmpty("pic")&&	
			checkEmpty("type")
		){
			if(checkPassword()){
				if(checkAge()){
					return true;
				}else{
					alert("年龄只能在0-120之间 !");
					return false;
				}
				
			}else{
				alert("密码不一致 !");
				return false;
			}
			
		}else{
			alert("请检查用户信息是否完整 !");
			return false;
		}
		return true;
	}
	
	function checkEmpty(id) {	
		var sy = document.getElementById(id).value;
		if(sy != null && sy != ""){
			return true;
		}else{
			return false;
		}
	}
	function checkPassword() {
		var userPassword = document.getElementById("userPassword").value;
		var userPassword1 = document.getElementById("userPassword1").value;
		if(userPassword == userPassword1){
			return true;
		}else{
			return false;
		}
	}
	
	function checkAge() {
		var userAge = document.getElementById("userAge").value;
		if(userAge > 0 && userAge < 120){
			return true;
		}else{
			return false;
		}
	}
</script>
</head>
<body>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">用户管理&gt;&gt;</div>

		</div>
		<form  method="post" action="../user?cmd=uploadPic" onsubmit="return checkit();">
			<input type="hidden" name="flag" value="doAdd">
			<div class="content">
				<table class="box">
					<font color="red"></font>
					<tr>
						<td class="field">用户编号：</td>
						<td>
							<input type="text" name="userId" id="userId" class="text" /> 
							<font color="red">*</font>
						</td>

					</tr>
					<tr>
						<td class="field">用户名称：</td>
						<td>
							<input type="text" name="userName" class="text" id="userName" />
						 	<font color="red">*</font>
						</td>
					</tr>
					<tr>
						<td class="field">用户密码：</td>
						<td>
							<input type="password" name="userPassword" class="text" id="userPassword" /> 
							<font color="red">*</font>
						</td>
					</tr>
					<tr>
						<td class="field">确认密码：</td>
						<td>
							<input type="password" name="userPassword1" id="userPassword1" class="text" /> 
							<font color="red">*</font>
						</td>
					</tr>

					<tr>
						<td class="field">用户性别：</td>
						<td>
							<select name="userSex" id="userSex">
								<option value="0" selected="selected">女</option>
								<option value="1">男</option>
							</select>
							<font color="red">*</font>
						</td>
					</tr>

					<tr>
						<td class="field">用户年龄：</td>
						<td>
							<input type="text" name="userAge" class="text" id="userAge" />
							<font color="red">*</font>
						</td>
					</tr>
					<tr>
						<td class="field">用户电话：</td>
						<td>
							<input type="text" name="telephone" class="text" id="telephone" /> 
							<font color="red">*</font>
						</td>

					</tr>
					<tr>
						<td class="field">用户地址：</td>
						<td>
							<textarea name="address" id="address" class="text" cols="45" rows="5">
							</textarea>
							<font color="red">*</font>
						</td>
					</tr>
					<tr>
						<td class="field">用户权限：</td>
						<td>
							<input type="radio" name="type" id="type" value="0" checked="checked" />
								普通用户
							<input type="radio" name="type" id="type" value="1" />
								经理
							<font color="red">*</font>
						</td>
					</tr>
					<tr>
						<td class="field">用户头像</td>
						<td>
							<input type="file" name="pic" class="text" />
							<font color="red">*只允许png,jpg,jpeg,gif</font>
						</td>
					</tr>
				</table>
			</div>
			<div class="buttons">
				<input type="submit" name="button" id="button" value="数据提交"
					class="input-button" /> <input type="button" name="button"
					id="button" onclick="window.location='user.do';" value="返回"
					class="input-button" />
			</div>

		</form>
	</div>
</body>
</html>
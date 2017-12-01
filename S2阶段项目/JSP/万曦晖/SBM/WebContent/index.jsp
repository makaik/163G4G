<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/style.css" />
<title>系统登录 - 超市账单管理系统</title>
</head>
<<body class="blue-style">
	<c:if test="${param.loginMsg == 'failed'}">
		<script type="text/javascript">
			alert("用戶名或密码错误！");
		</script>
	</c:if>
	
	<div id="login">
		<div class="icon"></div>
		<div class="login-box">
			<form method="post" action="user?cmd=userLogin">
				<dl>
					<dt>用户名：</dt>
					<dd>
						<input type="text" name="userName" class="input-text" />
					</dd>
					<dt>密 码：</dt>
					<dd>
						<input type="password" name="userPassword" class="input-text" />
					</dd>
				</dl>
				<div class="buttons">
					<input type="submit" name="submit" value="登录系统" class="input-button" />
					<input type="reset" name="reset" value="重　　填" class="input-button" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>

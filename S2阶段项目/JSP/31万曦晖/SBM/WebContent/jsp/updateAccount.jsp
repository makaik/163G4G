<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
</head>
<body>
	<div class="menu">
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">账单管理&gt;&gt;</div>
		</div>
		<form method="post" action="../account?cmd=updateAccount">
			<div class="content">
				<table class="box">
					<tr>
						<td class="field">账单编号：</td>
						<td><input readonly="readonly" type="text" name="accountId" class="text" value="${param.accountId}" /></td>
					</tr>
					<tr>
						<td class="field">是否付款：</td>
						<td>
							<select name="isPayed">
								<option selected="selected" value="1">是</option>
								<option value="0">否</option>
							</select>
						</td>
					</tr>
				</table>
			</div>
			<div class="buttons">
				<input type="button" name="button" value="返回" class="input-button" onclick="history.back();" />
				<input type="submit" name="submit" value="修改" class="input-button" />
				<a  style="text-decoration: none;" class="input-button" href="../account?cmd=deleteAccount&&accountId=${param.accountId}" >删除</a>
			</div>
		</form>
	</div>
</body>
</html>

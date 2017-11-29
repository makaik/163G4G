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

<title>My JSP 'providerAdd.jsp' starting page</title>

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
		checkEmpty("providerName") &&
		checkEmpty("providerDetail") &&
		checkEmpty("contact") &&
		checkEmpty("telephone") &&
		checkEmpty("facsimile") &&
		checkEmpty("address")		
	){
		//非空验证通过
		return true;//提交表单数据
	}else {
		//非空验证不通过
		alert("请检查用户信息是否完整!");
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
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">供应商管理&gt;&gt;</div>
		</div>
		<form id="form1" name="form1" method="post" action="provider?cmd=addProvider"
			onsubmit="return checkit();">
			<div class="content">
				<font color="red"></font> <input name="flag" value="doAdd"
					type="hidden">
				<table class="box">
					<tr>
						<td class="field">供应商名称：</td>
						<td><input type="text" name="providerName" class="text" id="providerName" />
						<font color="red">*</font></td>
					</tr>
					<tr>
						<td class="field">供应商描述：</td>
						<td><textarea name="providerDetail" id="providerDetail" cols="45" rows="3"></textarea>
						<font color="red">*</font></td>
					</tr>
					<tr>
						<td class="field">联系人：</td>
							<td><input type="text" name="contact" class="text" id="contact" />
							<font color="red">*</font></td>
					</tr>
					<tr>
						<td class="field">供应商电话：</td>
						<td><input type="text" name="telephone" class="text" id="telephone" />
						<font color="red">*</font></td>
					</tr>
					<tr>
						<td class="field">供应商传真：</td>
						<td><input type="text" name="facsimile" class="text" id="facsimile" />
						<font color="red">*</font></td>
					</tr>
					<tr>
						<td class="field">供应商地址：</td>
						<td><input type="text" name="address" class="text" id="address" />
						<font color="red">*</font></td>
					</tr>
				</table>
			</div>

			<div class="buttons">
				<input name="button" id="button" value="添加供应商" class="input-button"
					type="submit"> <input name="button" id="button"
					onclick="history.back();" value="返回"
					class="input-button" type="button">
			</div>
		</form>
	</div>
</body>
</html>
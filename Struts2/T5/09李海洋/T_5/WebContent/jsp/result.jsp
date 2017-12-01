<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示用户列表信息</title>
</head>
<body>
	<center>
	<h2>所有用户信息</h2>
		<table border="1">
		   <tr>
		    <td>用户id</td>
		    <td>用户名</td>
		    <td>性别</td>
		    <td>年龄</td>
		    <td>电话</td>
		    <td>QQ</td>
		    <td>地址</td>
		    <td>操作</td>
		   </tr>
		   <s:iterator value="userlist">
		   	<tr>
			   	<td><s:property value="userId"/></td>
			   	<td><s:property value="userName"/></td>
			   	<td><s:property value="userSex"/></td>
			   	<td><s:property value="userAge"/></td>
			   	<td><s:property value="phone"/></td>
			   	<td><s:property value="QQ"/></td>
			   	<td><s:property value="address"/></td>
			   	 <td>
				   	 <a href="del?user.userId=<s:property value="userId" />">删除</a>
				   	 <a href="perUpdate?user.userId=<s:property value="userId" />">修改</a>
			   	 </td>
		   	</tr>
		   </s:iterator>
		 </table>
	</center>
</body>
</html>
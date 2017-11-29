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
		   <s:iterator value="list">
		   	<tr>
			   	<td><s:property value="#list.userId"/></td>
			   	<td><s:property value="#list.userName"/></td>
			   	<td><s:property value="#list.userSex"/></td>
			   	<td><s:property value="#list.userAge"/></td>
			   	<td><s:property value="#list.phone"/></td>
			   	<td><s:property value="#list.QQ"/></td>
			   	<td><s:property value="#list.address"/></td>
			   	 <td>
				   	 <a href="user!del?userId=<s:property value="#user.userId" />">删除</a>
				   	 <a href="user!perUpdate?userId=<s:property value="#user.userId" />">修改</a>
			   	 </td>
		   	</tr>
		   </s:iterator>
		 </table>
	</center>
</body>
</html>
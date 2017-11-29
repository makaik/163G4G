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

<title>My JSP 'userAdmin.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="menu">
		<table>
			<tbody>
				<tr>
					<td><form method="post" action="user?cmd=findUser">
							<input name="flag" value="search" class="input-text"
								type="hidden"> 用户名称：<input name="userName"
								class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp;
							<input value="查 询" type="submit">
						</form></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<em><input value="添加数据" class="input-button"
				onclick="window.location='jsp/userAdd.jsp'" type="button"></em>
			<div class="title">用户管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
						<td width="80"><div class="STYLE1" align="center">用户名称</div></td>
						<td width="100"><div class="STYLE1" align="center">性别</div></td>
						<td width="100"><div class="STYLE1" align="center">年龄</div></td>

						<td width="150"><div class="STYLE1" align="center">电话</div></td>
						<td width="150"><div class="STYLE1" align="center">地址</div></td>
						<td width="150"><div class="STYLE1" align="center">权限</div></td>
						<td width="150"><div class="STYLE1" align="center">操作</div></td>
					</tr>
					<c:forEach items="${pb.data }" var="user">
						<tr>
						<td>${user.userId }</td>
						<td>${user.userName }</td>
						<td>
							<c:if test="${user.userSex == 'm' }">
								男
							</c:if>
							<c:if test="${user.userSex == 'f' }">
								女
							</c:if>
						</td>
						<td>${user.userAge }</td>
						<td>${user.telephone }</td>
						<td>${user.address }</td>
						<td>
							<c:if test="${user.type == 0 }">
								经理
							</c:if>
							<c:if test="${user.type == 1 }">
								普通用户
							</c:if>
						</td>
						<td><a href="jsp/updataUser.jsp?userId=${user.userId}">修改</a></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<form id="formPagebean" action="user?cmd=allUser" method="post" >
    		<label class="input-button">跳转到</label>
    		<select id="pSelect" name="p" onchange="getPagebeanByP();">
    			<c:forEach var="i" begin="1" end="${pb.pagetotal }">
    				<c:if test="${pb.p == i }">
    					<option value="${i }" selected="selected">第${i }页</option>
    				</c:if>
    				<c:if test="${pb.p != i }">
    					<option value="${i }">第${i }页</option>
    				</c:if>
    			</c:forEach>
    		</select>
    		<a style="text-decoration: none;" class="input-button" href="user?cmd=allUser&p=${pb.p - 1 }">上一页</a>
    		<a style="text-decoration: none;" class="input-button" href="user?cmd=allUser&p=${pb.p + 1 }">下一页</a>
    	</form>
	</div>
	<script type="text/javascript">
		function getPagebeanByP() {
			var formPagebean = document.getElementById("formPagebean");
			formPagebean.submit();
		}
	</script>
</body>
</html>
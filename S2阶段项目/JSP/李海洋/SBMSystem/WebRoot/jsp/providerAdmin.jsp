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

<title>My JSP 'providerAdmin.jsp' starting page</title>

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
					<td><form method="post" action="provider?cmd=allProvider">
							<input name="flag" value="search" type="hidden"> 供应商名称：<input
								name="providerName" class="input-text" type="text">
							&nbsp;&nbsp;&nbsp;&nbsp;供应商描述：<input name="providerDesc"
								class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp;<input
								value="组 合 查 询" type="submit">
						</form></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<em><input value="添加数据" class="input-button"
				onclick="window.location='jsp/providerAdd.jsp'" type="button"></em>
			<div class="title">供应商管理&gt;&gt;</div>
		</div>

		<div class="content">
			<table class="list">
					<tr>
						<td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
						<td width="80"><div class="STYLE1" align="center">供应商名称</div></td>
						<td width="100"><div class="STYLE1" align="center">供应商描述</div></td>
						<td width="100"><div class="STYLE1" align="center">联系人</div></td>
						<td width="100"><div class="STYLE1" align="center">电话</div></td>
						<td width="100"><div class="STYLE1" align="center">地址</div></td>
						<td width="100"><div class="STYLE1" align="center">操作</div></td>
					</tr>
					
					<c:forEach items="${pb.data }" var="provider">
						<tr>
							<td>${provider.providerId }</td>
							<td>${provider.providerName }</td>
							<td>${provider.providerDetail }</td>
							<td>${provider.contact }</td>
							<td>${provider.telephone }</td>
							<td>${provider.address }</td>
							<td><a href="jsp/updataProvider.jsp?providerId=${provider.providerId}">修改</a></td>
						</tr>
					</c:forEach>
			</table>
		</div>
		<form id="formPagebean" action="provider?cmd=allProvider" method="post" >
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
    		<a style="text-decoration: none;" class="input-button" href="provider?cmd=allProvider&p=${pb.p - 1 }">上一页</a>
    		<a style="text-decoration: none;" class="input-button" href="provider?cmd=allProvider&p=${pb.p + 1 }">下一页</a>
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

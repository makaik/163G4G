<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:set var ="username"  value=" ' Hello World' "   />
	<s:property value="#username"  />
		<br />
	<s:set var="loveList" value="{'登山','游泳','滑雪'}"></s:set>
	<s:property value ="#loveList[1]"/>
	<br />
	<s:property value ="#loveList[0]"/>
	<br />
	<br />
	
	<s:set var="person"  value="#{'姓名':'王','性别':'男','民族':'汉' }"></s:set>
	姓名：<s:property value = "#person['姓名']"/>
		<br />
	性别：<s:property value = "#person['性别']"/>
		<br />
	民族：<s:property value = "#person['民族']"/>
	<br />
	<br />
	<s:property value = "(3 gt 2) ? #person['姓名'] : #person['性别']"/>
	<br />
	<s:property value = "(3 lt 2) ? #person['姓名'] : #person['性别']"/>
	<br />
	<s:property value = "(3 gt 2) or (2<3)? #person['姓名'] : #person['性别']"/>
	<br />
	<s:property value = "(3 gt 2) and (2<3)? #person['姓名'] : #person['性别']"/>
	<br />
	<br />
	
	<form action = "loginAction"  method = "post">
	姓名：<input type="text"  name = "user.name"/>
	<br />
	<br />
	性别：<input type="text"  name = "user.sex"/>
	<br />
	<br />
	民族：<input type="text"  name = "user.national"/>
	<br />
	<br />
	<input type = "submit"  value = "提交" />
	</form>
</body>
</html>
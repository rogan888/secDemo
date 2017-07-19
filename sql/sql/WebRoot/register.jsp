<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>

</head>

<body style="text-align:center">
<p>${requestScope.mess }&nbsp;</p>
	<form action="Register" method="post">
	<table cellpadding="10px" cellspacing="0" border="1px" align="center">
		<tr>
			<td>用户名</td>
			<td><input type="text" name="name" id="name"></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="text" name="password" id="password"></td>
		</tr>
		<tr>
			<td>年龄</td>
			<td><input type="text" name="age" id="age"></td>
		</tr>
		<tr>
			<td>地址</td>
			<td><textarea rows="3" cols="20" name="address" id="address"></textarea></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="注册"></td>
		</tr>
	</table>
	</form>
</body>
</html>

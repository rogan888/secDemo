<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	<p id="mess" >&nbsp;</p>
	<table>
		<tr>
			<td><a href="login.jsp" target="_blank"></a></td>
		</tr>
		<tr>
			<td><a href="register.jsp" target="_blank"></a></td>
		</tr>
		<tr>
			<td><a href="upload.jsp" target="_blank">上传</a></td>
		</tr>
		
		<tr>
			<td><a href="FileDownload?filename=../WEB-INF/web.xml" target="_blank">下载</a></td>
		</tr>
	</table>

</body>
</html>

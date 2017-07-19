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
<script type="text/javascript">
	function doLogin() {
		var name = $("#name").val();
		var password = $("#password").val();
		// 			alert("");
		$.ajax({
			url : "Login.do",
			type : "post",
			data : {
				"name" : name,
				"password" : password
			},
			dataType : "json",
			success : function(data) {
				$("#mess").html(data[0]);
				if(data[1]){
					window.location="ListUser";
				}
			}
		});
}
</script>
</head>

<body style="text-align:center">
	<p id="mess" >&nbsp;</p>
	<!--     <form action="Login.do" method="post"> -->
	<table cellpadding="5px" cellspacing="0" border="0" align="center">
		<tr>
			<td>用户名：</td>
			<td><input type="text" name="name" id="name"></td>
		</tr>
		<tr>
			<td>用户名：</td>
			<td><input type="text" name="password" id="password"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="登录" id="sub"
				onclick="doLogin()"></td>

		</tr>
	</table>
	<!--     </form> -->

</body>
</html>

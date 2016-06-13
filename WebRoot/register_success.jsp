<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册成功</title>
</head>
<body>

	<center>
		<div>
			<p>注册成功！</p>
			<p>
				欢迎您，
				<s:property value="username" />
			</p>
			<a href="<%=path%>/login.jsp">登录</a>
		</div>
	</center>

</body>
</html>
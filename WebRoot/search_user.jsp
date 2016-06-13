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
<title>查找用户</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/common.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/content.css">
<style type="text/css">
label {
	width: 70px;
	height: 30px;
	text-align: left;
	display: inline-block;
}

.input {
	width: 150px;
}
.search_form {
	margin-top: 25%;
}
</style>
</head>
<body>
	<img alt="search" src="<%=basePath%>img/search.jpg" width="70" height="60">
	<center>
		<form action="<%=basePath%>user/searchUser.action" method="get" class="search_form">
			<label for="name">用户名：</label>
			<input class="input" id="user" type="text" name="username" /><br> 
			<input type="submit" value="搜索" class="main_btn btn_blue" />&nbsp;
			<input type="reset" value="重置" class="main_btn btn_blue" />
		</form>
	</center>
</body>
</html>
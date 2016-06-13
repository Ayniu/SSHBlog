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
<title>注册</title>
</head>
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
</style>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/common.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/content.css">
<body>
	<center>
		<form action="user/register.action" method="post">
			<div id="content">
				<div class="rightMenu">
					<div class="accScr">
						<ul>
							<li><label for="name">用户名：</label> <input class="input"
								id="user" type="text" name="username" /></li>
							<li><label for="password">密码：</label> <input class="input"
								id="password" type="password" name="password" /></li>
						</ul>
						<s:hidden value="0" name="type" />
						<input type="submit" class="main_btn btn_blue" value="注册" /> <input
							type="reset" class="main_btn btn_blue" value="重置" />
					</div>
				</div>
			</div>
		</form>
	</center>
</body>
</html>
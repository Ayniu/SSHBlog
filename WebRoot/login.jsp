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
<title>登录</title>
</head>
<style type="text/css">
label {
	width: 70px;
	height: 30px;
	text-align: left;
	display: inline-block;
}

.w90 {
	width: 100px;
}
.w90>input {
	width: 15px !important;
  height: 20px !important;
  float: left !important;
  margin-right: 5px;
  margin-left: 10px;
}
</style>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/common.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/content.css">
<body>
	<center>
		<form action="user/login.action" method="post" name="login">
			<div id="content">
				<div class="rightMenu">
					<div class="accScr">
						<ul>
							<li><label for="name">用户名：</label><input class="input"
								id="name" type="text" name="username" /></li>
							<li><label for="password">密码：</label><input class="input"
								id="password" type="password" name="password" /></li>
							<li><label class="w90"><input type="radio"
									name="type" value="0" />普通用户</label>&nbsp; <label class="w90"><input
									type="radio" name="type" value="1" />管理员</label><br></li>
						</ul>
						<input type="submit" class="main_btn btn_blue" value="登录" />&nbsp;
						<input type="reset" class="main_btn btn_blue" value="重置" /> </span>
					</div>
				</div>
			</div>
		</form>
	</center>
</body>
</html>
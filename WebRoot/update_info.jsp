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

.input {
	width: 150px;
}
</style>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/common.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/content.css">
<body>
	<center>
		<form action="<%=basePath%>user/updateUser.action" method="post"
			name="updateUser">
			<s:set value="#session.curUser" name="user" />
			<div id="content">
				<div class="rightMenu">
					<div class="accScr">
						<ul>
							<li><label for="name">用户id：</label> <input class="input"
								id="id" type="text" name="userid"
								value='<s:property value="#user.userid" />' readonly="readonly" /></li>
							<li><label for="name">用户名：</label> <input class="input"
								id="name" type="text" name="username"
								value='<s:property value="#user.username" />' /></li>
							<li><label for="password">密码：</label> <input class="input"
								id="password" type="password" name="password"
								value='<s:property value="#user.password" />' /></li>
							<li><label for="gender">性别：</label> <select id="gender"
								name="gender" value='<s:property value="#user.gender" />'>
									<option value="0">男</option>
									<option value="1">女</option>
									<option value="2">保密</option>
							</select></li>
							<li><label for="age">年龄：</label> <input class="input"
								id="age" type="text" name="age"
								value='<s:property value="#user.age" />' /><br> <s:hidden
									value="0" name="type" /></li>
						</ul>
						<input type="submit" value="修改" class="main_btn btn_blue" />
						<input type="button" value="返回" class="main_btn btn_blue" id="back" />
					</div>
				</div>
			</div>
		</form>
	</center>
	<script type="text/javascript">
		var gender = document.getElementById('gender');
		var gid = gender.getAttribute('value');
		var option = document.getElementsByTagName('option');
		var optionArray = Array.prototype.slice.call(option);
		optionArray.forEach(function(ele, index){
			if(index == gid){
				ele.setAttribute('selected', 'selected');
				return true;
			}
		});
		
		var back = document.getElementById('back');
		back.onclick = function(){
			window.location.href = '<%=basePath%>welcome.jsp';
		}
	</script>
</body>
</html>
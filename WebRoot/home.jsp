<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
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
<title>index</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/index.css">
<style type="text/css">
.resultIframe {
	height: 300px;
	width: 970px;
	border: 1px dotted #888;
	box-shadow: 4px 3px #eee;
	margin-top: 20px;
	display: none;
}

form {
	width: 500px;
	border: 1px dotted #888;
	box-shadow: 4px 3px #eee;
}
</style>
<script type="text/javascript"
	src="<%=basePath%>js/jquery-2.1.3.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/index.js"></script>
</head>
<body>
	<header>
	<s:set value="#session.curUser" var="curUser" />
	<div id="header1">
		<div class="logo"><img src="<%=basePath%>img/logo.png" width="100" height="55" style="float: left;" />nodeJothy</div>
		<s:if test="#curUser!=null">
			<button id="logout_btn"><a href="<%=basePath %>user/logout.action">退出</a></button>
			<button id="user_center" onclick="toCenter()">
				<s:property value="#curUser.username" /><i></i>
			</button>
		</s:if>
	</div>
	</header>

	<section>
	<table id="index_table">
		<tbody>
			<tr>
				<td id="nav_td"><nav id="left_nav">
					<ul class="left-ul">
						<li>账号<i></i>
							<ul class="account-ul">
								<li><a href="<%=basePath%>welcome.jsp">登录</a></li>
								<li><a href="<%=basePath%>register.jsp">注册</a></li>
							</ul>
						</li>
						<s:if test="#curUser!=null">
							<li>用户<i></i>
								<ul class="account-ul">
								<s:if test="#curUser.type==1">
									<li><a href="<%=basePath%>user/getAllUsers.action">查看所有用户</a></li></li>
									<li><a href="<%=basePath%>search_user.jsp">搜索用户</a></li>
								</s:if>
									<li><a href="<%=basePath %>welcome.jsp">我的主页</a></li>
									<li><a href="<%=basePath %>user/getUserById.action?userid=<s:property value="#curUser.userid" />">个人中心</a></li>
								</ul>
							</li>
							<li>社交<i></i>
								<ul class="account-ul">
									<li><a href="<%=basePath %>attention/getAttentions.action">我关注的人</a></li>
									<li><a href="<%=basePath %>attention/getFollowers.action">我的粉丝</a></li>
								</ul>
							</li>
						</s:if>
					</ul>
					</nav></td>
				<td id="iframe_td"><iframe src="<%=basePath%>/welcome.jsp"
						frameborder="0" id="index_iframe" scrolling="no"></iframe></td>
			</tr>
		</tbody>
	</table>
	</section>

	<script type="text/javascript">
		function toCenter() {
			$('#iframe_td iframe').attr('src', '<%=basePath %>user/getUserById.action?userid=<s:property value="#curUser.userid" />');
		}
		$('#logout_btn a').click(function(){
			window.location.href = '<%=basePath%>home.jsp';
			return true;
		})
	</script>

</body>
</html>
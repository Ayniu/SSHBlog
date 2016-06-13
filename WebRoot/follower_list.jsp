<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	int avatorId = (int) (Math.random() * 2);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>查询user</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script type="text/javascript"
	src="<%=basePath%>js/jquery-2.1.3.min.js"></script>
<style>
.folention {
	display: none;
}

.folention {
	display: none;
}

.fol_area {
	width: 300px;
	height: 80px;
	border: 1px solid #eee;
	box-shadow: 4px 3px #eee;
	margin: 5px 0;
	padding: 13px 0;
}

.fol_info {
	padding-left: 50px;
}
</style>

</head>


<body style="padding: 45px;">
	<s:set value="#session.folUsers" name="folUsers"></s:set>
	<p>
		我的粉丝（
		<s:property value="#session.folNum" />
		）
	</p>
	<s:iterator value="#folUsers" var="folUser">
		<div class="fol_area">
			<a
				href="<%=basePath%>/weibo/getWeibosByUserid?userid=<s:property value="#folUser.userid" />">
				<div class="col-md-2">
					<img src="<%=basePath%>img/avator<%=avatorId%>.png" class="avator"
						width="50" height="50">
				</div>
				<div class="col-md-10 fol_info">
					<span class="username"><s:property value="#folUser.username" /></span><br>
					<span class="gender"><s:property value="#folUser.gender" /></span>
				</div>
			</a>
		</div>
	</s:iterator>

	<script type="text/javascript">
		$('.gender').each(function(index, value) {
			genNum = value.innerHTML;
			switch (genNum) {
			case "0":
				gentext = '男';
				break;
			case "1":
				gentext = '女';
				break;
			case "2":
				gentext = '性别保密';
				break;
			default:
				gentext = '性别保密';
			}
			value.innerHTML = gentext;
		});
	</script>
</body>
</html>

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

<title>weibolist</title>
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
<script type="text/javascript" src="<%=basePath%>js/jquery-2.1.3.min.js"></script>
<style>
.weiboid {
	display: none;
}
.weiboContent {
	height: 140px;
	border-bottom: 1px dotted #888;
	margin-top: 20px;
}
.username {
    font-size: 15px;
    font-weight: bold;
    text-align: left;
}
.weibodate {
	font-size: 13px;
	text-align: left;
}
.delete {
	float: right;
}
.weibotext {
	text-align: left;
	height: 50px;
	margin-bottom: 5px;
}
.weibo_list {
	border: 1px dotted #888;
	box-shadow: 4px 3px #eee;
}
input.btn_red {
    line-height: 25px;
    padding: 0 10px;
    font-size: 14px;
    letter-spacing: 1px;
}
.avator {
    border: 1px solid #8CD92A;
    border-radius: 50%;
}
</style>

</head>

<body>
	<s:if test="#session.weibos==null">
		<p>暂无微博！</p>
	</s:if>
	<form action="<%=basePath%>weibo/deleteWeiboById.action" class="weibo_list">
		<input name="weiboid" value="0" class="weiboid" />
		<s:iterator value="#session.weibos" var="weibo">
			<div class="weiboContent">
				<div class="col-md-2">
					<img src="<%=basePath%>img/avator<%=avatorId %>.png" class="avator" width="50" height="50">
				</div>
				<div class="col-md-10">
				<div class="username"><s:property value="#weibo.user.username" /></div>
				<div class="weibodate"><s:property value="#weibo.publishDate" /></div>
				<div class="weibotext">
					<s:property value="#weibo.text" />
				</div>
				<s:if test="#session.owner==1">
					<input type="submit" class="delete main_btn btn_red" wid="<s:property value="#weibo.weiboid"/>" value="删除" />
				</s:if>
				</div>
			</div>
		</s:iterator>
	</form>
	<script type="text/javascript">
		$('.delete').click(function() {
			$('.weiboid').attr('value', $(this).attr('wid'));
			if (window.confirm('您确定要删除吗？'))
				return true;
			return false;
		});
	</script>
</body>
</html>

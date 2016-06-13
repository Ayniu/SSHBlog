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
<title>关注成功</title>
</head>
<body>

	<center>
		<div>
			<p>关注成功！</p>
			<a id="viewAtt" href="#">查看关注列表</a>
		</div>
	</center>
	<script type="text/javascript">
		var view = document.getElementById('viewAtt');
		view.onclick = function () {
			window.parent.location.href = '<%=basePath%>/attention/getAttentions.action';
			return false;
		}
	</script>
</body>
</html>
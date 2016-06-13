<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/common.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/content.css">
<script type="text/javascript" src="<%=basePath%>js/jquery-2.1.3.min.js"></script>
<style>
.attention {
	display: none;
}
.back {
	float: right;
	margin-top: 50%;
}
input.btn_red {
    line-height: 25px;
    padding: 0 10px;
    font-size: 14px;
    letter-spacing: 1px;
    margin: 0;
}
</style>

</head>

<body>
	<s:set value="#session.curUser" name="curUser"></s:set>
	<s:if test="#curUser.type==1">
		<form action="user/deleteUserById.action">
			<table class="table"
				style="margin: 0; padding: 0; background-color: #f3f3f3;">
				<thead>
					<tr>
						<td class="col-md-2">用户编号</td>
						<td class="col-md-4">用户名</td>
						<td class="col-md-2">性别</td>
						<td class="col-md-2">年龄</td>
						<td class="col-md-2">操作</td>
					</tr>
				</thead>
				<tbody>
					<tr class="attention">
						<td><input class="userid" value="0" name="userid" /></td>
					</tr>
					<s:iterator value="#session.users" var="user">
						<tr>
							<td><s:property value="#user.userid" /></td>
							<td><s:property value="#user.username" /></td>
							<td><s:if test="#user.gender==1">男</s:if> <s:else>女</s:else></td>
							<td><s:property value="#user.age" /></td>
							<td><input class="delete main_btn btn_red" type="submit" value="删除"
								uid='<s:property value="#user.userid" />' /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</form>
	</s:if>
	<s:else>
		<form action="attention/addAttention.action">
			<table class="table"
				style="margin: 0; padding: 0; background-color: #f3f3f3;">
				<thead>
					<tr>
						<td class="col-md-2">用户编号</td>
						<td class="col-md-4">用户名</td>
						<td class="col-md-2">性别</td>
						<td class="col-md-2">年龄</td>
						<td class="col-md-2">操作</td>
					</tr>
				</thead>
				<tbody>
					<tr class="attention">
						<td><input value="<s:property value="#curUser.userid" />"
							name="useridA"></td>
						<td><input class="userid" value="0" name="useridB" /></td>
						<td><input value="1" name="relation" /></td>
					</tr>
					<s:iterator value="#session.users" var="user">
						<tr>
							<td><s:property value="#user.userid" /></td>
							<td><s:property value="#user.username" /></td>
							<td><s:if test="#user.gender==1">男</s:if> <s:else>女</s:else></td>
							<td><s:property value="#user.age" /></td>
							<td><input class="delete main_btn btn_red" type="submit" value="关注"
								uid='<s:property value="#user.userid" />' /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</form>
	</s:else>
	<a class="main_btn btn_blue back" href="<%=basePath%>search_user.jsp">返回</a>
	
	<script type="text/javascript">
		$('.delete').click(function() {
			$('.userid').attr('value', $(this).attr('uid'));
			var operationStr = $(this).attr('value');
			if (window.confirm('您确定要' + operationStr + '吗？'))
				return true;
			return false;
		});
	</script>
</body>
</html>

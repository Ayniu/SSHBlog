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
<style type="text/css">
.resultIframe {
	height: 300px;
	width: 970px;
	border: 1px dotted #888;
	box-shadow: 4px 3px #eee;
	margin-top: 20px;
	display: none;
}
form{
	width: 500px;
	border: 1px dotted #888;
	box-shadow: 4px 3px #eee;
}
</style>
<script type="text/javascript" src="<%=basePath %>js/jquery-2.1.3.min.js"></script>
</head>
<body>
	<center>
		<%
			Date date = new Date();
			String pubDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			/* SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
			String dateStr = dateFormat.format(date);
			String str = "今天是 " + dateStr;
			out.println(str); */
		%>
		<s:if test="#session.curUser==null">
			<s:action name="logout" executeResult="true" namespace="/user" />
		</s:if>
		<s:else>
			<s:set value="#session.curUser" name="user" />
			<s:if test="#user.type==0">
				<p>
					<s:property value="#user.username" />
					欢迎您来到微博主页，
				</p>
				<form action="user/getUserById.action" method="get"
					name="getUserById">
					修改个人信息：
					<input class="input" id="userid" type="text" name="userid"
						value='<s:property value="#user.userid" />' style="display: none;" />
					<input type="submit" value="修改信息" />
				</form>
				<br />
				<form action="<%=basePath%>/weibo/publishWeibo.action" method="post" name="publishWeibo" enctype="multipart/form-data">
					<!-- <input type="text" name="text" id="text" /> -->
					发布微博：
					<textarea rows="3" cols="5" name="text" id="text"></textarea>
					<input class="input" id="userid" type="text" name="userid"
						value='<s:property value="#user.userid" />' style="display: none;" />
					<input type="text" value="<%=pubDate %>" name="publishDate" style="display: none;" />
					<input type="submit" value="发布微博" />
				</form>
				<br />
				
				个人微博：<s:action name="showWeibo" executeResult="true" namespace="/weibo" />
				following：<s:action name="getAttentions" executeResult="true" namespace="/attention" />
				followers：<s:action name="getFollowers" executeResult="true" namespace="/attention" />
				
				<div class="operation">
					<a href="<%=basePath %>search_user.jsp">搜索用户</a> 
				</div>
				<iframe class="resultIframe" src="">
					<p>欢迎查询!</p>
				</iframe>
				
			</s:if>
			<s:else>
				<p>
					管理员
					<s:property value="#user.username" />
					, 您好！
				</p>
				<p>请选择操作：</p>
				<div class="operation">
					<a href="<%=basePath %>user/getAllUsers.action">查看所有用户</a><br>
					<a href="<%=basePath %>search_user.jsp">搜索用户</a> 
				</div>
				<iframe class="resultIframe" src="">
					<p>欢迎查询!</p>
				</iframe>
			</s:else>
		</s:else>
	</center>

	<script type="text/javascript">
		$('.operation a').click(function(e) {
			var src = $(this).attr('href');
			$('.resultIframe').attr('src', src).css('display', 'block');
			return false;
		});
	</script>
</body>
</html>
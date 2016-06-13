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
<title>welcome</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/common.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/content.css">
<style type="text/css">
body {
	padding-top: 20px;
}

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
	margin: 10px 0;
}

.text textarea {
	width: 100%;
	height: 90px;
}

.pub_area {
	height: 150px;
}

.publish {
	float: right;
	margin-top: 10px;
}

.searchIframe {
	border: 1px dotted #ccc;
	box-shadow: 4px 3px #eee;
	width: 90%;
	min-height: 400px;
}
</style>
<script type="text/javascript" src="<%=basePath%>js/jquery-2.1.3.min.js"></script>
</head>
<body>
	<s:set value="#session.curUser" name="user" />
	<s:if test="#user==null">
		<script type="text/javascript">
			window.location.href = '<%=basePath%>login.jsp';
		</script>
	</s:if>
	<s:else>
		<s:if test="#user.type==0">
			<div class="col-md-8" style="padding-left: 10%;">
				<%
					Date date = new Date();
							String pubDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
									.format(date);
							/* SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
							String dateStr = dateFormat.format(date);
							String str = "今天是 " + dateStr;
							out.println(str); */
				%>
				<p>
					<s:property value="#user.username" />
					欢迎您来到微博主页，
				</p>

				<div class="pub_area">
					<form action="<%=basePath%>/weibo/publishWeibo.action"
						method="post" name="publishWeibo" enctype="multipart/form-data">
						<div class="text">
							<textarea rows="3" cols="5" name="text" id="text"></textarea>
						</div>
						<input class="input" id="userid" type="text" name="userid"
							value='<s:property value="#user.userid" />'
							style="display: none;" /> <input type="text"
							value="<%=pubDate%>" name="publishDate" style="display: none;" />
						<input type="submit" value="发布微博"
							class="publish main_btn btn_blue" />
					</form>
				</div>

				<s:action name="showWeibo" executeResult="true" namespace="/weibo" />
			</div>
			<div class="col-md-4">
				<iframe class="searchIframe" src="<%=basePath%>search_user.jsp">
				</iframe>
			</div>
		</s:if>
		<s:else>
		<div style="padding: 10px 20px;">
			<p>
				管理员
				<s:property value="#user.username" />
				, 您好！
			</p>
			<br>
			<p>请选择操作：</p>
			<div class="operation">
				<a href="<%=basePath%>user/getAllUsers.action">查看所有用户</a><br> <a
					href="<%=basePath%>search_user.jsp">搜索用户</a>
			</div>
			<iframe class="resultIframe" src="">
				<p>欢迎查询!</p>
			</iframe>
		</s:else>
		</div>
	</s:else>

	<script type="text/javascript">
	// 页面加载之后只执行一次
		function reload(){
			if (window.parent.location.href.indexOf('?reload=true') < 0) {
				window.parent.location.href+='?reload=true';
			}
		}
		setTimeout(reload, 50);
		
		$('.operation a').click(function(e) {
			var src = $(this).attr('href');
			$('.resultIframe').attr('src', src).css('display', 'block');
			return false;
		});
	</script>
</body>
</html>
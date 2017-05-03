<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-1.7.2.js"></script>
<script type="text/javascript">
	function sestest() {
		var $v =
<%=session.getAttribute("username")%>
	if ($v == null || $v.length == 0) {
			alert("请先登录");
			location.href = "index.jsp";
		}
	}
	$(function() {

		$("#submit").click(function() {
			sestest();
			var url = "apply-simple.action";
			var args = {
				"time" : new Date
			}
			$.post(url, args, function(data) {
				if (data == "0") {
					alert("报名成功");
				} else if (data == "1") {
					alert("您已报名，请不要重复报名");
				} else {
					alert("服务器错误");
				}
			})
			return false;
		})

		$("#leave").click(function() {
			var v = $("#content").val();
			var url = "apply-leave.action";
			var args = {
				"time" : new Date,
				"content" : v
			}
			$.post(url, args, function(data) {
				if (data == "0") {
					alert("请假成功");
				} else if (data == "1") {
					alert("服务器已收到请假信息，请不要着急");
				} else {
					alert("服务器错误");
				}
			})

			return false;
		})

	})
</script>
</head>
<body>
	<table rules="all" border="1" width="962" height="525" align="center">
		<tr>
			<td colspan="2"><img src="image/0.png" height="135" width="962"></td>
		</tr>
		<tr>
			<td width="150" height="390" valign="top">
				<table border="0">
					<tr>
						<td width="150" height="30" bgcolor="#FFCCCC"><img
							src="image/user.jpg" width="25" height="25"><B>个人中心</B></td>
					</tr>
					<tr>
						<td><p>
								<img src="image/timgs.jpg" width="15" height="15"><a
									href="index.jsp">注销登录</a><br> <br> <img
									src="image/timgs.jpg" width="15" height="15"><a
									href="teacher-simple1.jsp">我要请假</a><br>
								<!--<a href="teacher-input.action">个人中心</a><br>使用帮助</td>-->
					</tr>
					<!--<tr>
						<td width="150" height="30" bgcolor="#FFCCCC">项目资源管理</td>
					</tr>
					 	<tr>
						<td height="60"><p>
								<a href="project-list.action">查看项目</a></td>
					</tr> 
					<tr>
						<td width="150" height="30" bgcolor="#FFCCCC">在线网络课程</td>
					</tr>
					<tr>
						<td height="60"><p>
								<a href="course-list.action">在线选课</a></td>
					</tr> 
					<tr>
						<td width="150" height="30" bgcolor="#FFCCCC">网站版权信息</td>
					</tr>
					<tr>
						<td width="150" height="60"><p>
								Copyrights@<br>教师发展中心</td>
					</tr>-->

				</table>
			</td>
			<td height="300" width="812" align="center">
				<p>
					<img src="image/infor.png" height="600" width="746">
				</p> <img src="image/timgs.jpg" width="15" height="15"><a
				href="apply-simple.action" id="submit">点击报名</a>
			</td>
			<td><form action="" method="post">
					请假:
					<textarea id="content" rows="5" cols="40" name="content"
						onfocus="if (value =='请输入文字..'){value =''}"
						onblur="if (value ==''){value='请输入文字..'}">请输入文字..</textarea>
					<input id="leave" type="submit">
				</form></td>
		</tr>
	</table>
	<table align="center">
		<tr>
			<td><img src="image/1.png" width="962" height="62"></td>
		</tr>
	</table>
</body>
</html>
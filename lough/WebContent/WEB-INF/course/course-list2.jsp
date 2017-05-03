<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		var $v =
<%=session.getAttribute("username")%>
	if ($v == null || $v.length == 0) {

			alert("请先登录");
			location.href = "index.jsp";
		}

	})

	function backspace() {
		if (event.keyCode == 8 && event.srcElement.tagName != "INPUT"
				&& event.srcElement.type != "text")
			event.returnValue = false;
	}
	if (navigator.appName == "Microsoft Internet Explorer") {
		window.history.forward(1);
	} else // if it is Mozilla than
	{
		window.history.forward(-1);
	}
</script>
</head>
<body>
	<table rules="all" border="1" width="972" height="525" align="center">
		<tr>
			<td colspan="2"><img src="image/0.png" height="135" width="962"></td>
		</tr>
		<tr>
			<td width="150" height="390">
				<table border="1">
					<tr>
						<td width="150" height="30" bgcolor="#FFCCCC">个人信息中心</td>
					</tr>
					<tr>
						<td height="90"><p>
								<a href="logout.action">注销登录</a><br> <a
									href="teacher-input.action">个人中心</a></td>
					</tr>

					<tr>
						<td width="150" height="60" bgcolor="#FFCCCC">在线网络课程<br>
							<p style="color: red">(最多选3门课)</p></td>
					</tr>
					<tr>
						<td height="60"><p>
								<a href="course-list1.action"><font size="3">新教师在线点播培训课程</font></a><br>
								<br> <a href="course-list2.action"><font size="3">在线点播培训课程</font></a><br>
								<br> <a href="course-list3.action"><font size="3">在线点播培训自选组课专题</font></a></td>

					</tr>
					<tr>
						<td width="150" height="30" bgcolor="#FFCCCC">网站版权信息</td>
					</tr>
					<tr>
						<td width="150" height="60"><p>
								Copyrights@<br>教师发展中心</td>
					</tr>

				</table>
			</td>
			<td height="300" width="822" align="center"><s:form
					action="course-save.action">

					<s:select list="#request.courses2" listKey="id" listValue="name"
						label="课程列表" name="course.id"></s:select>
					<s:submit value="提交"></s:submit>
				</s:form> <br>
			<br>
				<table border="1" cellspacing="0">
					<s:if test="#request.chooses == null || #request.chooses.size ==0">无信息</s:if>
					<tr>
						<td>id</td>
						<td>课程号</td>
						<td>课程名</td>
						<td>点击取消</td>
					</tr>
					<s:iterator value="#request.chooses">
						<tr>
							<td>${id}</td>
							<td>${course.courseId}</td>
							<td>${course.name}</td>
							<td><a href="course-cancel.action?id=${id }">取消</a></td>
						</tr>
					</s:iterator>
				</table></td>
		</tr>
	</table>
</body>
</html>
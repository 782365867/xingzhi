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
	<table rules="all" border="1" width="962" height="435" align="center">
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
			<td height="300" width="812" align="center"><a><font
					size="3" style="font-weight: bold;">个人信息完善</font></a><br> <br>
				<s:form action="teacher-save.action">
					<s:select list="#request.departments" listKey="id"
						listValue="departmentName" name="department.id" label="学院"></s:select>
					<s:textfield name="banji" label="系别"></s:textfield>
					<%-- <s:textfield name="leibie" label="类别"></s:textfield> 
					<s:select name="leibie" list="{'A','B','C','D'}" label="类别"></s:select>--%>
					<s:textfield name="phone" label="手机"></s:textfield>
					<s:textfield name="email" label="邮箱"></s:textfield>
					<%-- 	<s:textfield name="xiaoqu" label="校区"></s:textfield> --%>
					<s:select name="xiaoqu" list="{'合肥校区','宣城校区'}" label="校区"></s:select>

					<s:submit value="提交"></s:submit>
				</s:form></td>
	</table>
</body>
</html>
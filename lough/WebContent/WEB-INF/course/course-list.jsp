<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<table rules="all" border="1" width="962" height="525">
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
								<a href="index.jsp">注销登录</a><br> <a
									href="teacher-input.action">个人中心</a><br>使用帮助</td>
					</tr>
					<tr>
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
					</tr>

				</table>
			</td>
			<td height="300" width="812" align="left">
				<s:form action="course-save.action">
					<s:select list="#request.courses" listKey="id" listValue="name" label="课程列表" name="course.id"></s:select>
					<s:submit></s:submit>
				</s:form>
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
				</table>
		</td>
		</tr>
	</table>
</body>
</html>
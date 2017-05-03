<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/jquery-1.7.2.js""></script>
<script type="text/javascript">
	$(function() {
		$("#apply").click(function() {
			var val = $(this).parent().parent().children(" :eq(1)").text();
			var str = "确定要报名" + val + "吗？";
			var cf = confirm(str);
			if (!cf) {
				return false;
			}
		})
	})
</script>
</head>
<body>
	<table rules="all" border="1" width="962" height="435">
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
			<td height="300" width="812" align="center"><s:if
					test="#request.projects==null || #request.projects.size ==0">无项目内容
	    </s:if> <s:else>
					<table border="1" cellpadding="10" cellspacing="0">
						<tr>
							<td>id</td>
							<td>项目名</td>
							<td>起时间</td>
							<td>止时间</td>
							<td>人数上限</td>
							<td>备注</td>
							<td>报名</td>
						</tr>
						<s:iterator value="#request.projects">
							<tr>
								<td>${id }</td>
								<td>${projectName }</td>
								<td>${startTime }</td>
								<td>${overTime }</td>
								<td>${numberLimit }</td>
								<td>${remarks }</td>
								<%-- 	<td><a href="apply-show.action?id=${id}">查看报名</a></td> --%>
								<td><a id="apply" href="apply-apply.action?id=${id}">报名</a></td>
							</tr>
						</s:iterator>
					</table>
				</s:else></td>
		</tr>
	</table>
</body>
</html>
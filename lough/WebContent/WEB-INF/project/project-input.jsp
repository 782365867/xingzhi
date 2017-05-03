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
	<table rules="all" border="1" width="962" height="600">
		<tr>
			<td colspan="2"><img src="image/0.png" height="135" width="962"></td>
		</tr>
		<tr>
			<td width="150" height="400">
				<table border="1">
					<tr>
						<td width="150" height="30" bgcolor="#FFCCCC">使用帮助</td>
					</tr>
					<tr>
						<td height="80"><p>
								<a href="index.jsp">注销登录</a><br>查看使用帮助<br>技术支持论坛</td>
					</tr>
					<tr>
						<td width="150" height="30" bgcolor="#FFCCCC">项目资源管理</td>
					</tr>
					<tr>
						<td height="80"><p>
								<a href="project-input.action">添加项目</a><br> <a
									href="project-list.action">查看项目</a></td>
					</tr>
					<tr>
						<td width="150" height="30" bgcolor="#FFCCCC">在线选课管理
					</tr>
					<tr>
						<td height="40"><p><a href="course-listAdm.action">查看选课</a></td>
					</tr>						
					<tr>
						<td width="150" height="30" bgcolor="#FFCCCC">网站用户管理</td>
					</tr>
					
					<tr>
						<td height="80"><p>
								<a>管理网站用户</a><br>管理后台管理员<br></td>
					</tr>
					<tr>
						<td width="150" height="30" bgcolor="#FFCCCC">网站信息管理</td>
					</tr>
					<tr>
						<td height="80"><p>
								<a>添加首页新闻</a><br> <a>新闻修改删除</a><br>首页公告设置<br></td>
					</tr>
					<tr>
						<td width="150" height="30" bgcolor="#FFCCCC">网站常规设置</td>
					</tr>
					<tr>
						<td height="80"><p>
								网站信息设置<br>网站广告设置<br>友情链接设置<br></td>
					</tr>
					<tr>
						<td width="150" height="30" bgcolor="#FFCCCC">网站版权信息</td>
					</tr>
					<tr>
						<td width="150" height="80"><p>
								Copyrights@<br>教师发展中心</td>
					</tr>
				</table>
			</td>
  <td height="414" align="center"> 
  		<h3>添加项目</h3>
  		<s:form action="project-save.action">
			<s:textfield name="projectName" label="项目名"></s:textfield>
			<s:textfield name="startTime" label="起时间"></s:textfield>
			<s:textfield name="overTime" label="止时间"></s:textfield>
			<s:textfield name="numberLimit" label="人数限制"></s:textfield>
			<s:textfield name="remarks" label="备注"></s:textfield>
			<s:submit></s:submit>
		</s:form>
 </td>
</tr>
</table>		
</body>
</html>
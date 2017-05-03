<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Teacher Center</title>
<script type="text/javascript" src="scripts/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		$(".hidden").hide();

		$("#img").click(function() {
			$(".hidden").show();
		});
	});
</script>
</head>
<body>
	<table align="center">
		<tr>
			<td><img id="img" src="image/0.png" width="962" height="135"></td>
		</tr>
	</table>



	<table align="center" height="400">
		<tr>
			<td><h2 align="center">安全登录</h2> <script language="javascript">
				function submitcheck() {
					if (document.form1.username.value.length == 0) {
						alert("用户名不能为空！");
						return false;
					}
					if (document.form1.password.value.length == 0) {
						alert("请输入密码！");
						return false;
					}
					if (form1.check.value == "") {
						alert("请输入验证码！");
						return false;
					}
				}
			</script>

				<form id="form1" name="form1" method="post" action="log"
					onsubmit="return submitcheck();">
					<p align="center">
						用户名：<input id="username" type="text" name="username" />
					</p>
					<p align="center">
						密&nbsp;码： <input id="password" type="password" name="password">
					</p>
					<p align="center">
						<!-- 						验证码：<input id="txt_num" type="text" name="txt_num" />&nbsp;<input
							id="txt_btn" type="button" name="txt_btn" />

						<script type="text/javascript">
							var time = new Date().getTime();
							document.getElementById("txt_btn").value = time
									.toString().substr(
											time.toString().length - 4, 4);
							function getNum() {
								if (document.getElementById("txt_num").value != document
										.getElementById("txt_btn").value) {
									alert("验证码不正确");
									return false;
								}
							}
						</script> -->
					<div class="hidden">
						教师：<input type="radio" name="role" value="1"> 管理：<input
							type="radio" name="role" value="2">
					</div>
					<p align="center">
						<input type="submit" name="ok" value="登录"
							onclick="return getNum();">
					</p>
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

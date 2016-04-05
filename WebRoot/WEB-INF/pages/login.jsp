<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>mvc权限登陆login</title>
	</head>
	<body>
		<h3>
			mvc权限登陆login
		</h3>
		<form action="submit.htm" method="post">
			<!-- 记录重定向的url -->
			<input type="hidden" name="redirectURL" value="${redirectURL}" />
			<table>
				<tr>
					<td>
						账号
					</td>
					<td>
						<input type="text" name="username" />
					</td>
					<td>
						密码
					</td>
					<td>
						<input type="password" name="password" />
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="提交" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
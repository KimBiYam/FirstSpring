<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>
<body>
	<div align="center">
		<a href="gInsert">[홈으로 돌아가기]</a>
		<form action="login" id="loginform" method="post">
			<table>
				<tr>
					<th>ID</th>
					<td><input type="text" id="id" name="id"></td>
				</tr>
				<tr>
					<th>PW</th>
					<td><input type="text" id="pwd" name="pwd"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="로그인">
					</td>
				</tr>
				<tr>
				<td colspan="2" align="center">
				<span style="color: red">${errMsg }</span>				
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form name="form1" method="post" action="member_update.go">
<input type="hidden" name="id" value="${user.id }">
		<p align="center"><b>회원수정</b></p>
		<table width="400" border="1">
			<tr>
				<td>회원아이디</td>	<td>${user.id}</td>
			</tr>
			<tr>
				<td>회원성명</td>	<td><input type="text" name="name"  value="${user.name}"></td>
			</tr>
			<tr>
				<td>회원주소</td><td><input type="text" name="addr"  value="${user.addr}"></td>
			</tr>
			<tr>
				<td>회원메모</td><td><textarea name="memo" >${user.memo}</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="수정하기">
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>
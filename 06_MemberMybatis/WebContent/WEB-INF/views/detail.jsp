<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<table width="400" border="1">
			<tr>
				<td>회원아이디</td>
				<td>${user.id}</td>
			</tr>
			<tr>
				<td>회원비밀번호</td>
				<td>${user.pass}</td>
			</tr>
			<tr>
				<td>회원성명</td>
				<td>${user.name}</td>
			</tr>
			<tr>
				<td>회원주소</td>
				<td>${user.addr}</td>
			</tr>
			<tr>
				<td>회원메모</td>
				<td>${user.memo}</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" value="수정하기"
				onclick="location.href='member_update.mb?id=${user.id}'"/>
			
				<input type="button" value="목록보기"
				onclick="location.href='member_list.mb'"/>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
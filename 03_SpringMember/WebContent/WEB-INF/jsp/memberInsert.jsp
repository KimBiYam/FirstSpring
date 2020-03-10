<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<body bgcolor="white" >
	<form name="form1" method="post" action="member_insert.go">
		<table align="center">
		<tr>
			<td  colspan="2">
			<p align="center"><b>회원가입</b></p>
			</td>
		</tr>
		<tr>
			<td colspan="2">
			<hr>
			</td>
		</tr>
		<tr>
			<td width="104">
			<p><code><b>아이디</b></code></p>
			</td>
			<td width="359">
			<p><code><input type="text" name="id" size="30"></code></p>
			</td>
		</tr>
		<tr>
			<td width="104">
			<p><code><b>비밀번호</b></code></p>
			</td>
			<td width="359">
			<p><code><input type="password" name="pass" size="30"></code></p>
			</td>
		</tr>
		<tr>
			<td width="104">
			<p><code><b>성명</b></code></p>
			</td>
			<td width="359">
			<p><code><input type="text" name="name" size="30"></code></p>
			</td>
		</tr>
		<tr>
			<td width="104">
			<p><code><b>주소</b></code></p>
			</td>
			<td width="359">
			<p><code><input type="text" name="addr" size="51"></code></p>
			</td>
		</tr>
		<tr>
			<td width="104">
			<p><code><b>메모</b></code></p>
			</td>
			<td width="359">
			<p><textarea name="memo" rows="10" cols="50"></textarea></p>
			</td>
		</tr>
		<tr>
			<td width="479" colspan="2">
			<hr>
			</td>
		</tr>
		<tr>
			<td width="479" colspan="2">
			<p align="center">
			<input type="submit" name="formbutton1"	value="가입"></p>
			</td>
		</tr>
		</table>
	</form>
</body>
</html>
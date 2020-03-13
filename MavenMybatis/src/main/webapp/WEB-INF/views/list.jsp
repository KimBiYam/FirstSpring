<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<table>
			<tr align="center">
				<th>ID</th>
				<th>Name</th>
				<th>Addr</th>
				<th>Memo</th>
				<th>삭제</th>
			</tr>
			<c:forEach items="${userlist }" var="user">
				<tr>
					<td>${user.id }</td>
					<td><a href="mView?id=${user.id }">${user.name }</a></td>
					<td>${user.addr}</td>
					<td>${user.memo}</td>
					<td><a href="mDelete?id=${user.id}">삭제</a></td>
				</tr>
			</c:forEach>
		</table>
		<form action="mList">
			<select name="field">
				<option value="name">이름</option>
				<option value="addr">주소</option>
			</select>
			<input type="text" name="word">
			<button type="submit">검색</button>
		</form>
		<a href="mInsert">추가하기</a>

	</div>
</body>
</html>
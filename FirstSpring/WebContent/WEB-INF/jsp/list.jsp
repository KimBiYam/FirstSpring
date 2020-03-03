<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<h1>회원목록보기</h1>
	<h2><a href="member_form_insert.do">회원가입</a></h2>
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
			<td><a href="member_detail.do?id=${user.id }">${user.name }</a></td>
			<td>${user.addr }</td>
			<td>${user.memo }</td>
			<td><a href="member_delete.do?id=${user.id }">삭제</a></td>					
			</tr>
			</c:forEach>
		</table>
		<a href="index.jsp">메인</a>		
	</div>
	
</body>
</html>
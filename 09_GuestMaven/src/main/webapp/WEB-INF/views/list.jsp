<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		게시물 수 : ${count }
		<form action="gList">
			<select name="field">
				<option value="name">이름</option>
				<option value="content">내용</option>
			</select> <input type="text" name="word"> <input type="submit"
				value="검색">
		</form>
		<table>
			<tr>
				<th>이름</th>
				<th>내용</th>
				<th>등급</th>
				<th>날짜</th>
				<th>IP주소</th>
			</tr>
			<c:forEach items="${guestlist}" var="gl">
				<tr>
					<td>${gl.name }</td>
					<td><a href="gView?num=${gl.num }">${gl.content }</a></td>
					<td>${gl.grade }</td>
					<td>${gl.created }</td>
					<td>${gl.ipaddr }</td>
				</tr>
			</c:forEach>
		</table>
		<a href="gInsert">추가하기</a>
	</div>
</body>
</html>
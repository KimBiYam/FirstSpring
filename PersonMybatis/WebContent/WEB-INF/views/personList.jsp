<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th>아이디</th>
<th>이름</th>
<th>직업</th>
<th>성별</th>
</tr>
<c:forEach items="${list }" var="list">
<tr>
<td>${list.id }</td>
<td><a href="personView.mb?id=${list.id }">${list.name }</a></td>
<td>${list.job }</td>
<td>${list.gender }</td>
</tr>
 </c:forEach>
</table>
<a href="personForm.mb">Person 추가하기</a>
<a href="index.jsp">돌아가기</a>
</body>
</html>

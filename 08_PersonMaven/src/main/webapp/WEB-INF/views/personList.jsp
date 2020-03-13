<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
사람 수 : ${count }
<form action="personList.go">
<select name="field">
<option value="name">이름</option>
<option value="job">직업</option>
</select>
<input type="text" name="word">
<input type="submit" value="검색">
</form>
</div>
 <c:forEach items="${personlist }" var="ps">
 이름 : <a href="personView.go?id=${ps.id  }">${ps.name }</a><br>
 아이디 : ${ps.id }<br>
 성별 : ${ps.gender }<br>
 직업 : ${ps.job }<hr>
 </c:forEach>
 <a href="personForm.go">추가하기</a>
</body>
</html>







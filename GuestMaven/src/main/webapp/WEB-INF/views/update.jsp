<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<body>
<form action="gUpdate" method="post">
<input type="hidden" name="num" value="${guest.num }">
<label>글쓴이</label>
<input type="text" value="${guest.name }" disabled="disabled"><br>
<label for="content">내용</label>
<input type="text" name="content" id="content" size="150" value="${guest.content }"><br>
평가
<input type="radio" id="grade_1" name="grade" value="아주잘함(excellent)">아주잘함(excellent)
<input type="radio" id="grade_2" name="grade" value="잘함(good)">잘함(good)
<input type="radio" id="grade_3" name="grade" value="보통(normal)">보통(normal)
<input type="radio" id="grade_4" name="grade" value="노력(fail)">노력(fail)
<br>
<input type="submit" value="수정">
</form>
<script>
if("${guest.grade}"=="아주잘함(excellent)"){
	$("#grade_1").prop("checked",true);
}else if("${guest.grade}"=="잘함(good)"){
	$("#grade_2").prop("checked",true);	
}else if("${guest.grade}"=="보통(normal)"){
	$("#grade_3").prop("checked",true);	
}else if("${guest.grade}"=="노력(fail)"){
	$("#grade_4").prop("checked",true);	
}
</script>
</body>
</html>
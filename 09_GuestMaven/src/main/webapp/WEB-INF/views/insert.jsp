<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="gInsert" method="post">
<label for="name">글쓴이</label>
<input type="text" name="name" id="name"><br>
<label for="content">내용</label>
<input type="text" name="content" id="content" size="150"><br>
평가
<input type="radio" name="grade" value="아주잘함(excellent)" checked="checked">아주잘함(excellent)
<input type="radio" name="grade" value="잘함(good)">잘함(good)
<input type="radio" name="grade" value="보통(normal)">보통(normal)
<input type="radio" name="grade" value="노력(fail)">노력(fail)
<br>
<input type="submit" value="입력">
</form>
</body>
</html>
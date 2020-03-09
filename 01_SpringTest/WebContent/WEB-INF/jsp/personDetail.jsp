<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>개인 정보 수정</h2>
<form action="personUpdate.sp" method="post">
<input type="hidden" name="id" value="${dto.id }"> 
이름 : <input type="text" name="name" value="${dto.name }"><br>
아이디 : <input type="text" value="${dto.id }" disabled="disabled"><br>
패스워드 : <input type="password" name="password"><br>
성별 : 
<label for="man">남</label>
<input type="radio" name="gender" id="man" value="남" checked>
<label for="woman">여</label>
<input type="radio" name="gender" id="woman" value="여"><br>
직업 : 
<select name="job">
<option value="회사원">회사원
<option value="학생">학생
<option value="기타">기타
</select><br><br>
<input type="submit" value="수정">
<button type="button" onclick="location.href='personDelete.sp?id=${dto.id}'">삭제</button>
<input type="reset" value="취소">
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<body>
	<h2>개인 정보 수정</h2>
	<form action="personUpdate.go" method="post">
		<input type="hidden" name="id" value="${dto.id }">
		 이름 : <input type="text" name="name" value="${dto.name }"><br>
		 아이디 : <input type="text" value="${dto.id }" disabled="disabled"><br>
		패스워드 : <input type="password" name="password"><br>
		 성별 :
			<label for="man">남</label>
			<input type="radio" name="gender" id="man" value="남">
			<label for="woman">여</label>
			<input type="radio" name="gender" id="woman" value="여">
			<br>
		직업 : <select name="job" id="job">
			<option value="회사원">회사원
			<option value="학생">학생
			<option value="기타">기타
		</select><br> <br> <input type="submit" value="수정">
		<button type="button"
			onclick="location.href='personDelete.go?id=${dto.id}'">삭제</button>
		<input type="reset" value="취소">
	</form>
	<a href="personList.go">돌아가기</a>
	
	<script>
		if ("${dto.gender}" == "남") {
			$("input:radio[value='남']").prop("checked", true);
		} else {
			$("input:radio[value='여']").prop("checked", true);
		}

		$("#job option").each(function() { //for
			if ($(this).val() == "${dto.job}") {
				$(this).prop("selected", true);
			}
		})
	</script>
</body>
</html>
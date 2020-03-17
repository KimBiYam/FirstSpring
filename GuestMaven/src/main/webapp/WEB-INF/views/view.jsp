<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h3>상세보기</h3>
 이름 : ${guest.name }<br>
 내용 : ${guest.content }<br>
 등급 : ${guest.grade } <br>
 날짜 : ${guest. created } <br>
 IP주소 : ${guest.ipaddr } <br>
 <input type="button" onclick="location.href='gUpdate?num=${guest.num}'" value="수정하기">
 <input type="button" onclick="location.href='gDelete.go?num=${guest.num}'" value="삭제하기">
 </div>
</body>
</html>
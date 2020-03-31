<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="//unpkg.com/bootstrap@4/dist/css/bootstrap.min.css">
<script src='//unpkg.com/jquery@3/dist/jquery.min.js'></script>
<script src='//unpkg.com/popper.js@1/dist/umd/popper.min.js'></script>
<script src='//unpkg.com/bootstrap@4/dist/js/bootstrap.min.js'></script>
</head>
<body>
	<div class="container text-center my-2">
		<p class="h3">비밀번호 입력</p>
		<div class="form-group">
			<input type="password" name="password" id="password"
				class="form-control">
		</div>
		<div class="text-right">
			<button type="button" name="checkBtn" id="checkBtn"
				class="btn btn-outline-primary">체크</button>
		</div>
	</div>
	<script type="text/javascript">
	$(function() {
		$("#checkBtn").click(function() {
			if ($("#password").val() == "") {
				alert("패스워드를 입력하세요");
				return false;
			}
			$.get("passwordCheck", {
				"num" : ${num },
				"password" : $("#password").val()
			}, function(data) {
				if(data == "yes"){
					opener.location.href="boardDelete?num=${num}";
					self.close();
					}
				if(data == "no"){
					alert("패스워드가 틀렸습니다!");
					return false;
					}
			})
			
		})
	})
</script>
</body>
</html>
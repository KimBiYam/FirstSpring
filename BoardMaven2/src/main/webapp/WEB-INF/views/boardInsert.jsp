<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<div class="container">
		<div class="card my-5">
			<form action="boardInsert" method="post" id="frm">
				<div class="card-body">
					<div class="form-group">
						<label for="title">제목</label> <input type="text" name="title"
							id="title" class="form-control" placeholder="제목을 입력해 주세요">
					</div>
					<div class="form-group">
						<label for="writer">글쓴이</label> <input type="text" name="writer"
							id="writer" class="form-control" placeholder="작성자를 입력해 주세요">
					</div>
					<div class="form-group">
						<label for="password">패스워드</label> <input type="password"
							name="password" id="password" class="form-control"
							placeholder="패스워드를 입력해 주세요">
					</div>
					<div class="form-group">
						<label for="content">내용</label>
						<textarea id="content" name="content" class="form-control"></textarea>
					</div>
					<div class="form-group text-right">
						<button type="button" name="writeBtn" id="writeBtn"
							class="btn btn-sm btn-outline-info">글쓰기</button>
						<a href="boardList" class="btn btn-sm btn-outline-secondary">목록으로</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$("#writeBtn").click(function() {
				if ($("#title").val() == "") {
					alert("제목을 입력하세요");
					return false;
				}
				if ($("#writer").val() == "") {
					alert("작성자를 입력하세요");
					return false;
				}
				if ($("#password").val() == "") {
					alert("패스워드를 입력하세요");
					return false;
				}
				if ($("#content").val() == "") {
					alert("내용을 입력하세요");
					return false;
				}
				$("#frm").submit();
			})

		})
	</script>
</body>
</html>
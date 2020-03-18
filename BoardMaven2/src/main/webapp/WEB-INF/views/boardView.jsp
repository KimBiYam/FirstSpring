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
	<div class="container my-5">
		<table class="table small table-bordered my-5">
			<tr>
				<td style="width: 10%">번호</td>
				<td>${board.num }</td>
			</tr>
			<tr>
				<td style="width: 10%">제목</td>
				<td>${board.title }</td>
			</tr>
			<tr>
				<td style="width: 10%">작성자</td>
				<td>${board.writer }</td>
			</tr>
			<tr>
				<td style="width: 10%">작성일</td>
				<td>${board.regdate }</td>
			</tr>
			<tr>
				<td style="width: 10%">조회수</td>
				<td>${board.hitcount }</td>
			</tr>
			<tr>
				<td colspan="2">${board.content }</td>
			</tr>
		</table>
		<div class="text-right">
			<a href="boardUpdate?num=${board.num }"
				class="btn btn-sm btn-outline-info">수정하기</a>
			<button type="button" name="deleteBtn" id="deleteBtn"
				class="btn btn-sm btn-outline-danger">삭제하기</button>
			<a href="boardList" class="btn btn-sm btn-outline-secondary">목록으로</a>
		</div>
	</div>
	<script type="text/javascript">
	$(function(){
		$("#deleteBtn").click(function(){
			window.open("deletePopup?num=${board.num}","deletePopup",
					"width=500,height=300,top=300,left=700");
			})			
		})
	</script>

</body>
</html>
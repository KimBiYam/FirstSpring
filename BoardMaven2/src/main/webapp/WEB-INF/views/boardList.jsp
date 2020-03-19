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
	<div class="container my-5">
		<p class="h2 text-center">게 시 판</p>
		<div id="result"></div>
		<div class="text-center my-5">
			<form action="boardList" method="get">
				<div class="input-group">
					<select class="input-group-prepend custom-select col-lg-2"
						id="field" name="field">
						<option value="">선택하세요</option>
						<option value="title">제목</option>
						<option value="content">내용</option>
						<option value="writer">작성자</option>
					</select> <input type="text" id="word" name="word"
						class="form-control input-group-text">
					<div class="input-group-append">
						<button type="button" id="search" name="search"
							class="btn btn-outline-primary">검색</button>
					</div>
				</div>
			</form>
		</div>
		<div class="text-right">
			<a href="boardInsert" class="btn btn-outline-dark btn-sm">글쓰기</a>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			getData(1, "", "");
			$("#search").click(function() {
				if ($("#field").val() == "") {
					alert("검색 내용을 선택하세요");
					return false;
				}
				getData(1, $("#field").val(), $("#word").val());
				$("#word").val("");
			})
		})
		function getData(pageNum, field, word) {
			$.getJSON("boardList", {
				"pageNum" : pageNum,
				"field" : field,
				"word" : word
			}, function(data) {
				$("#result").empty();
				$("#result").append(
						"<p class='h3'>게시물 수 : "+data.count+"</p>"
						)
				var htmlStr = "";
				htmlStr += "<table class='table small table-bordered my-5'>";
				htmlStr += "<thead><tr>";
				htmlStr += "<th style='width: 10%'>번호</th>";
				htmlStr += "<th style='width: 40%'>제목</th>";
				htmlStr += "<th style='width: 20%'>작성자</th>";
				htmlStr += "<th style='width: 20%'>작성일</th>";
				htmlStr += "<th style='width: 10%'>조회수</th>";
				htmlStr += "</tr></thead>";
				for(i=0;i<data.list.length;i++){	
					htmlStr+= "<tr>";
					htmlStr += "<td>"+eval(data.rowNo-i)+"</td>";
					htmlStr += "<td><a href='boardView?num="+data.list[i].num+"'>"+data.list[i].title+"</a></td>";
					htmlStr += "<td>"+data.list[i].writer+"</td>";
					htmlStr += "<td>"+data.list[i].regdate+"</td>";
					htmlStr += "<td>"+data.list[i].hitcount+"</td>";
					htmlStr += "</tr>";			
					}
				$("#result").append(htmlStr);
				htmlStr += "</table>";
				$("#result").append("<div align='center'>"+data.pageHtml+"</div>");
			})
		}
	</script>

</body>
</html>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<label for="name">글쓴이</label> <input type="text" name="name" id="name"><br>
		<label for="content">내용</label> <input type="text" name="content"
			id="content" size="150"><br> 평가 <input type="radio"
			name="grade" value="아주잘함(excellent)">아주잘함(excellent) <input
			type="radio" name="grade" value="잘함(good)">잘함(good) <input
			type="radio" name="grade" value="보통(normal)">보통(normal) <input
			type="radio" name="grade" value="노력(fail)">노력(fail) <br>
		<input type="button" id="submit" onclick="javascrpit:search()"
			value="입력">
	</div>
	<div align="right">
		<select name="field" id="field">
			<option value="name">이름</option>
			<option value="content">내용</option>
		</select> <input type="text" name="word" id="word"> <input
			type="button" id="search" value="검색">
	</div>
	<br>
	<hr>
	<div id="result" align="center"></div>
	<div id="pageHtml" align="center"></div>
	<br>
	<hr>
	<div id="views" align="center"></div>

	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<script>
	$(function() {
		$("#submit").click(sendIt);
		$("#search").click(function() {
			getData(1, $("#field").val(), $("#word").val());
			$("#word").val("");
		});
		getData(1,"","");
	})
	// 리스트
	function getData(pageNum, field, word) {
		$.getJSON("gList", {
			"pageNum" : pageNum,
			"field" : field,
			"word" : word
		}, function(data) {
			$("#result").empty();
			$("#result").append(
				"<div align='right'>총게시물 수 : " + data[0] + "</div>");
			var htmlStr = "";
			htmlStr += "<table border width=500px align=cenber>";
			htmlStr += "<tr>";
			htmlStr += "<td>번호</td>";
			htmlStr += "<td>이름</td>";
			htmlStr += "<td>등급</td>";
			htmlStr += "<td>날짜</td>";
			htmlStr += "<td>삭제</td>";
			htmlStr += "</tr>";
			for(i=0;i<data[1].length;i++){				
				htmlStr+= "<tr>";
				htmlStr += "<td>"+data[1][i].num+"</td>";
				htmlStr += "<td><a href='javascript:fview("+data[1][i].num+")'>"+data[1][i].name+"</a></td>";
				htmlStr += "<td>"+data[1][i].grade+"</td>";
				htmlStr += "<td>"+data[1][i].created+"</td>";
				htmlStr += "<td><a href='javascript:fdelete("+data[1][i].num+",\""+data[1][i].name+"\")'>삭제</a></td>";
				htmlStr += "</tr>";			
				}
			$("#result").append(htmlStr);
			$("#result").append("</table>");
			$("#result").append("<div align='center'>"+data[2]+"</div>");
		})
		}	
	
	// 삭제
	function fdelete(num, name) {
		if (confirm("[" + name + "]의 게시물을 삭제할까요?")) {
			$.get("gDelete", {
				"num" : num
			}, function(retData) {
				$("#result").html(retData);
			})
		}
	}

	// 상세보기
	function fview(num) {
		$.getJSON("gView", {
			"num" : num
		}, function(data) {
			var htmlStr = "";
			htmlStr += "<table border=1 align='center'>";
			htmlStr += "<tr>";
			htmlStr += "<td>이름</td>";
			htmlStr += "<td>" + data.name + "</td>";
			htmlStr += "</tr>";
			htmlStr += "<tr>";
			htmlStr += "<td>내용</td>";
			htmlStr += "<td>" + data.content + "</td>";
			htmlStr += "</tr>";
			htmlStr += "<tr>";
			htmlStr += "<td>등급</td>";
			htmlStr += "<td>" + data.grade + "</td>";
			htmlStr += "</tr>";
			htmlStr += "<tr>";
			htmlStr += "<td>작성일</td>";
			htmlStr += "<td>" + data.created + "</td>";
			htmlStr += "</tr>";
			htmlStr += "<tr>";
			htmlStr += "<td>IP주소</td>";
			htmlStr += "<td>" + data.ipaddr + "</td>";
			htmlStr += "</tr>";
			htmlStr += "</table>";
			$("#views").html(htmlStr);
		})
	}

	function sendIt() {
		var name = $("#name").val();
		var content = $("#content").val();
		var grade = $("input:radio[name=grade]:checked").val();
		var postString = "name=" + name + "&content=" + content + "&grade=" + grade;
		$.ajax({
			type : "post",
			url : "gInsert",
			data : postString,
			success : function(retData) {
				$("#result").html(retData)
				$("#name").val("");
				$("#content").val("");
				$("input:radio[name=grade]").prop("checked", false);
			},
			beforeSend : showRequest,
			error : function(e) {
				alert("error : " + e);
			}
		});

		function showRequest() {
			if (!$("#name").val()) {
				alert("글쓴이를 입력하세요");
				$("#name").focus();
				return false;
			}
			if (!$("#content").val()) {
				alert("내용을 입력하세요");
				$("#content").focus();
				return false;
			}
			// $("input:radio[name=grade]:checked").length==0
			// !$("input:radio[name=grade]:checked").val()
			// 셋 다 사용 가능
			if (!$("input:radio[name=grade]").is(":checked")) {
				alert("등급을 선택하세요");
				return false;
			}
			return true;
		}
	}
</script>
</body>
</html>
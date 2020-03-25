<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="includes/header.jsp"%>
<script type="text/javascript">
	$(function() {
		getData(1, "", "");
		var result = '<c:out value="${result}"/>';

		checkModal(result);

		history.replaceState({}, null, null);
		function checkModal(result) {
			if (result === '' || history.state) {
				return;
			}
			if (parseInt(result) > 0) {
				$(".modal-body").html(
						"게시글 " + parseInt(result) + " 번이 등록되었습니다.");
			}
			$("#myModal").modal("show");
		}

		$("#regBtn").on("click", function() {
			self.location = "/board/register";
		})

	})

	function getData(pageNum, field, word) {
		$.getJSON("/board/list", {
			"pageNum" : pageNum,
			"field" : field,
			"word" : word
		}, function(data) {
			$("#result").empty();
			var htmlStr = "";
			htmlStr += "<table width='100%' class='table table-striped"
					+ " table-bordered table-hover' id='dataTables-example'";
			htmlStr += "<thead>";
			htmlStr += "<tr>";
			htmlStr += "<th style='width: 10%'>번호</th>";
			htmlStr += "<th style='width: 40%'>제목</th>";
			htmlStr += "<th style='width: 10%'>작성자</th>";
			htmlStr += "<th style='width: 20%'>작성일</th>";
			htmlStr += "<th style='width: 20%'>수정일</th>";
			htmlStr += "</tr>";
			htmlStr += "</thead>";
			for (i = 0; i < data.list.length; i++) {
				var regdate = new Date(data.list[i].regdate);
				var updateDate= new Date(data.list[i].updateDate);
				htmlStr += "<tr>";
				htmlStr += "<td>" + eval(data.rowNo - i) + "</td>";
				htmlStr += "<td><a href='/board/get?bno=" + data.list[i].bno+ "'>" + data.list[i].title + "</a></td>";
				htmlStr += "<td>" + data.list[i].writer + "</td>";
				htmlStr += "<td>" + regdate + "</td>";
				htmlStr += "<td>" + updateDate + "</td>";
				htmlStr += "</tr>";
			}
			$("#result").append(htmlStr);
			htmlStr += "</table>";
			$("#result").append(
					"<div align='center'>" + data.pageHtml + "</div>");

		})
	}
</script>

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">게시판</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">글 목록</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div id="result"></div>
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">&times;</button>
									<h4 class="modal-title" id="myModalLabel">Modal title</h4>
								</div>
								<div class="modal-body">처리가 완료되었습니다.</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
									<button type="button" class="btn btn-primary">save
										changes</button>
								</div>
								<!-- modal-footer  -->
							</div>
							<!-- modal-content  -->
						</div>
						<!-- modal-dialog  -->
					</div>
					<!-- modal  -->
				</div>
				<!-- /.row -->

				<%@include file="includes/footer.jsp"%>
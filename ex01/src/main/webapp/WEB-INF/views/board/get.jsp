<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="includes/header.jsp"%>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">상세보기</h1>
		</div>
		<!-- col-lg-12  -->
	</div>
	<!-- /.row  -->

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">상세보기</div>
				<!-- /.panel-heading  -->
				<div class="panel-body">
						<div class="form-group">
							<label>제목</label> <input class="form-control" type="text"
								name="title" id="title" disabled="disabled" value="${board.title }">
						</div>						
						<div class="form-group">
							<label>내용</label>
							<textarea class="form-control" rows="3" name="content"
								id="content" disabled="disabled">${board.content }</textarea>
						</div>

						<div class="form-group">
							<label>작성자</label> <input class="form-control" type="text"
								name="writer" id="writer" disabled="disabled" value="${board.writer }"> 
						</div>
						<a href="/board/modify?bno=${board.bno }" class="btn btn-default">수정하기</a>
						<a href="/board/list" class="btn btn-default">리스트</a>								

				</div>
				<!-- end panel-body  -->
			</div>
			<!-- end panel  -->
		</div>
	</div>
	<!-- ./row  -->
</div>
<!-- ./page-wrapper  -->

</body>
<%@include file="includes/footer.jsp"%>

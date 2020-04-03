<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html lang="en">
<%@include file="includes/header.jsp"%>
<div id="layoutSidenav_content">	
<div class="card mb-4">
	<div class="card-header">
		<i class="fas fa-table mr-1"></i>DataTable Example</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
				<thead>
					<tr>
						<th style="width: 10%">글 번호</th>
						<th style="width: 30%">제목</th>
						<th style="width: 20%">작성자</th>
						<th style="width: 30%">작성일</th>
						<th style="width: 20%">조회수</th>
					</tr>
				</thead>
				<c:forEach items="${list }" var="list">
					<tr>
						<td>${list.bno }</td>
						<td><a href="/myapp/board/get?bno=${list.bno }">${list.title }</a></td>
						<td>${list.writer }</td>
						<td><fmt:formatDate value="${list.regDate }" pattern="yyyy-MM-dd"/></td>
						<td>${list.viewcnt }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
</div>
</body>
</html>

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
			<i class="fa fa-cloud mr-1"></i>오늘의 날씨
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable">
					<thead>
						<tr>
							<th>지역</th>
							<th>예보일자</th>
							<th>강수확률</th>
							<th>습도</th>
							<th>최저기온</th>
							<th>최고기온</th>
						</tr>
					</thead>
					<c:forEach items="${weather }" var="weather">
					<tr>
						<td>${weather.area}</td>
						<td>${weather.date}</td>
						<td>${weather.pop}%</td>
						<td>${weather.reh}%</td>
						<td>${weather.tmn}°C</td>
						<td>${weather.tmx}°C</td>
					</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</div>
</body>
</html>

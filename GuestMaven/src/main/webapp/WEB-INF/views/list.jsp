<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div align="center">
		게시물 수 : ${count }
		<table border="1">
			<tr>
				<th>NO_SEQ</th>
				<th>이름</th>
				<th>등급</th>
				<th>날짜</th>
				<c:if test="${login!=null }">
				<th>삭제</th>
				</c:if>
			</tr>
			<c:forEach items="${guestlist}" var="gl">
				<tr>
					<td>${gl.num }</td>
					<td><a href="javascript:fview(${gl.num })">${gl.name }</a></td>
					<td>${gl.grade }</td>
					<td>${gl.created }</td>
					<c:if test="${login!=null }">
					<td>
					<a href="javascript:fdelete(${gl.num},'${gl.name }')">삭제</a>					
					</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
		<div>
		${pageHtml }
		</div>
	</div>
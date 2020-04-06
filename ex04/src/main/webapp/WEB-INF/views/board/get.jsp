<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@include file="includes/header.jsp"%>
<div id="layoutSidenav_content">
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-9 my-5">
                                        <input type="hidden" name="bno" value="${board.bno }">
                                            <div class="form-group">
                                            	<label class="small mb-1" for="title">제목</label>
                                            	<input class="form-control py-4" name="title" id="title" type="text" value="${board.title }" disabled="disabled" />
                                           	</div>
	                                        <div class="form-group">
	                                        	<label class="small mb-1" for="writer">작성자</label>
	                                        	<input class="form-control py-4" name="writer" id="writer" type="text" value="${board.writer }" disabled="disabled" />
                                        	</div>
                                        	<div class="form-group">
	                                        	<label class="small mb-1" for="writer">작성일</label>
	                                        	<input class="form-control py-4" type="text" value='<fmt:formatDate pattern="yyyy-MM-dd" value="${board.regDate}" />' disabled="disabled" />
                                        	</div>
                     						<div class="form-group">
												<label class="small mb-1" for="content">내용</label>
												<textarea class="form-control" rows="5" name="content" id="content" disabled="disabled">${board.content }</textarea>
											</div>
                                            <div class="form-group mt-4 mb-0">
                           	                  <div class="row justify-content-center">
                                                <div class="col-md-2">
                                   	    	     	<button class="btn btn-outline-primary btn-block" data-oper='modify'>수정</button>
                                            	</div>
                                   	            <div class="col-md-2">
                                          		  	<button class="btn btn-outline-secondary btn-block" data-oper='list'>리스트</button>
                                       		  	</div>
                                              </div>
                                           	</div>
                                    </div>
                            </div>
                        </div>
                        <form id="operForm" action="/myapp/board/modify" method="get">
                        <input type="hidden" id="bno" name="bno" value='<c:out value="${board.bno }"/>'>
                        <input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum }"/>'>
                        <input type="hidden" name="amount" value='<c:out value="${cri.amount }"/>'>
          				<input type="hidden" name="type" value='<c:out value="${cri.type }"/>'>
						<input type="hidden" name="keyword" value='<c:out value="${cri.keyword }"/>'>
                        </form>
					</div>
<script type="text/javascript">
	$(function(){
		$("#btnDelete").click(function(){
			if(confirm("정말 삭제하시겠습니까?")){
				location.href = "/myapp/board/delete?bno=${board.bno}";
				}
			})
	var operForm = $("#operForm");
		$("button[data-oper='modify']").on("click", function(e) {
			operForm.attr("action", "/myapp/board/modify").submit();
		});
		$("button[data-oper='list']").on("click", function(e) {
			operForm.find("#bno").remove();
			operForm.attr("action", "/myapp/board/list").submit();
		});
			
		})

</script>	

</body>

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
                                            	<label class="small mb-1" for="title">글번호</label>
                                            	<input class="form-control py-4" name="title" id="title" type="text" value="${board.bno }" disabled="disabled" />
                                           	</div>                                        
                                            <div class="form-group">
                                            	<label class="small mb-1" for="title">제목</label>
                                            	<input class="form-control py-4" name="title" id="title" type="text" value="${board.title }" disabled="disabled" />
                                           	</div>
	                                        <div class="form-group">
	                                        	<label class="small mb-1" for="writer">작성자</label>
	                                        	<input class="form-control py-4" name="writer" id="writer" type="text" value="${board.writer }" disabled="disabled" />
                                        	</div>
                     						<div class="form-group">
												<label class="small mb-1" for="content">내용</label>
												<textarea class="form-control" rows="5" name="content" id="content" disabled="disabled">${board.content }</textarea>
											</div>
                                            <div class="form-group mt-4 mb-0">
                           	                  <div class="row justify-content-center">
                                                <div class="col-md-2">
                                   	    	     	<a class="btn btn-outline-primary btn-block" href="/myapp/board/modify?bno=${board.bno }">수정</a>
                                            	</div>
                                            	<div class="col-md-2">
                                   	    	     	<a class="btn btn-outline-danger btn-block" id="btnDelete" href="#">삭제</a>
                                            	</div>
                                   	            <div class="col-md-2">
                                          		  	<a class="btn btn-outline-secondary btn-block" href="/myapp">리스트</a>
                                       		  	</div>
                                              </div>
                                           	</div>
                                    </div>
                            </div>
                        </div>
					</div>
<script type="text/javascript">
	$(function(){
		$("#btnDelete").click(function(){
			if(confirm("정말 삭제하시겠습니까?")){
				location.href = "/myapp/board/delete?bno=${board.bno}";
				}
			})
		})

</script>	

</body>

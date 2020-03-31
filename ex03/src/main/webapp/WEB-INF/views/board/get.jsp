<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="includes/header.jsp"%>


<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">글보기</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">

			<div class="panel-heading">글보기</div>
			<!-- /.panel-heading -->
			<div class="panel-body">

				<div class="form-group">
					<label>번호</label> <input class="form-control" name='bno'
						value='<c:out value="${board.bno }"/>' readonly="readonly">
				</div>

				<div class="form-group">
					<label>제목</label> <input class="form-control" name='title'
						value='<c:out value="${board.title }"/>' readonly="readonly">
				</div>

				<div class="form-group">
					<label>내용</label>
					<textarea class="form-control" rows="3" name='content'
						readonly="readonly"><c:out value="${board.content}" /></textarea>
				</div>

				<div class="form-group">
					<label>작성자</label> <input class="form-control" name='writer'
						value='<c:out value="${board.writer }"/>' readonly="readonly">
				</div>

				<c:if test="${member.id == board.id }">
				<button data-oper='modify' class="btn btn-default">수정하기</button>
				</c:if>
				<button data-oper='list' class="btn btn-info">리스트</button>

				<form id='operForm' action="/board/modify" method="get">
					<input type='hidden' id='bno' name='bno' value='<c:out value="${board.bno}"/>'>
					<input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum}"/>'>
					<input type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>
					<input type="hidden" name="type" value='<c:out value="${cri.type }"/>' >
					<input type="hidden" name="keyword" value='<c:out value="${cri.keyword }"/>' >
				</form>
			</div>
			<!--  end panel-body -->

		</div>
		<!--  end panel-body -->
	</div>
	<!-- end panel -->
</div>
<!-- /.row -->

<div class='row'>

	<div class="col-lg-12">

		<!-- /.panel -->
		<div class="panel panel-default">
			<!--       <div class="panel-heading">
        <i class="fa fa-comments fa-fw"></i> Reply
      </div> -->

			<div class="panel-heading">
				<i class="fa fa-comments fa-fw"></i> 댓글
				<c:if test="${member != null }">
				<button id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>댓글 쓰기</button>
				</c:if>
			</div>


			<!-- /.panel-heading -->
			<div class="panel-body">

				<ul class="chat">

				</ul>
				<!-- ./ end ul -->
			</div>
			<!-- /.panel .chat-panel -->
			

			<div class="panel-footer"></div>


		</div>
	</div>
	<!-- ./ end row -->
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">댓글</h4>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label>내용</label> <input class="form-control" name='reply'
						value='New Reply!!!!'>
				</div>
				<div class="form-group">							
					<label>작성자</label>
					 <input class="form-control" name='replyer' id="replyer"
						value='replyer' disabled="disabled">
				</div>
				<input type="hidden" name="id" value="id">
				<div class="form-group">
					<label>작성일</label> <input class="form-control"
						name='replyDate' value='2018-01-01 13:13'>
				</div>

			</div>
			<div class="modal-footer">
				<button id='modalModBtn' type="button" class="btn btn-warning">수정하기</button>
				<button id='modalRemoveBtn' type="button" class="btn btn-danger">삭제하기</button>
				<button id='modalRegisterBtn' type="button" class="btn btn-primary">글쓰기</button>
				<button id='modalCloseBtn' type="button" class="btn btn-default">닫기</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->
<script type="text/javascript" src="/resources/js/reply.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
						var bnoValue = '<c:out value="${board.bno}"/>';
						var replyUL = $(".chat");
						showList(1);

						function showList(page) {
							console.log("show list " + page);
							replyService.getList(
											{
												bno : bnoValue,
												page : page || 1
											},
											function(replyCnt, list)
											 {
												console.log("replyCnt: " + replyCnt);
												console.log("list: " + list);
												console.log(list);
												if (page == -1) {
													pageNum = Math.ceil(replyCnt / 10.0);
													showList(pageNum);
													return;
												}

												var str = "";

												if (list == null || list.length == 0) {
													replyUL.html("");
												}

												for (var i = 0, len = list.length || 0; i < len; i++) {
													str += "<li class='left clearfix' data-rno='"+list[i].rno+"'>";
													str += "<div><div class='header'><strong class='primary-font'>["+eval(1+i)+"]"
															+list[i].replyer+"</strong>";
													str += "<small class='pull-right text-muted'>"+replyService.displayTime(list[i].replyDate)+"</small></div>";
													str += "<p>"+list[i].reply+"</p></div></li>";
												}

												replyUL.html(str);

												showReplyPage(replyCnt);

											});//end function

						}//end showList

						var pageNum = 1;
						var replyPageFooter = $(".panel-footer");

						function showReplyPage(replyCnt) {
							//	alert("replyCnt :"+ replyCnt)

							var endNum = Math.ceil(pageNum / 10.0) * 10;
							var startNum = endNum - 9;

							var prev = startNum != 1;
							var next = false;

							if (endNum * 10 >= replyCnt) {
								endNum = Math.ceil(replyCnt / 10.0);
							}

							if (endNum * 10 < replyCnt) {
								next = true;
							}
							// alert("endNum :"+ endNum)

							var str = "<ul class='pagination pull-right'>";

							if (prev) {
								str += "<li class='page-item'><a class='page-link' href='"
										+ (startNum - 1)
										+ "'>Previous</a></li>";
							}

							for (var i = startNum; i <= endNum; i++) {

								var active = pageNum == i ? "active" : "";

								str += "<li class='page-item "+active+" '><a class='page-link' href='"+i+"'>"
										+ i + "</a></li>";
							}

							if (next) {
								str += "<li class='page-item'><a class='page-link' href='"
										+ (endNum + 1) + "'>Next</a></li>";
							}

							str += "</ul></div>";

							console.log(str);

							replyPageFooter.html(str);
						}

						replyPageFooter.on("click", "li a", function(e) {
							e.preventDefault();
							console.log("page click");

							var targetPageNum = $(this).attr("href");

							console.log("targetPageNum: " + targetPageNum);

							pageNum = targetPageNum;

							showList(pageNum);
						});

						var modal = $(".modal");
						var modalInputReply = modal.find("input[name='reply']");
						var modalInputReplyer = modal.find("input[name='replyer']");
						var modalInputReplyDate = modal.find("input[name='replyDate']");
						var modalInputReplyId = modal.find("input[name='id']");
						var modalModBtn = $("#modalModBtn");
						var modalRemoveBtn = $("#modalRemoveBtn");
						var modalRegisterBtn = $("#modalRegisterBtn");
						//var bnoValue = $("#bno").val();
						//alert(bnoValue)
						$("#modalCloseBtn").on("click", function(e) {
							modal.modal('hide');
						});
						$("#addReplyBtn").on("click", function(e) {
							modal.find("input").val("");
							$("#replyer").val("${member.name}");
							modalInputReplyDate.closest("div").hide();							
							modal.find("button[id !='modalCloseBtn']").hide();
							modalRegisterBtn.show();							
							$(".modal").modal("show");
						});
						modalRegisterBtn.on("click", function(e) {
							if(modalInputReply.val()==""){
								alert("댓글 내용을 입력하세요!");
								return false;
								}
							var reply = {
								reply : modalInputReply.val(),
								replyer : "${member.name}",
								id : "${member.id}",								
								bno : bnoValue
							};
							replyService.add(reply, function(result) {
								alert(result);
								modal.find("input").val("");
								modal.modal("hide");
								showList(1);
							});
						});
						
						$(".chat").on("click","li",function(e){
							var rno = $(this).data("rno");
							var id = "${member.id}";

							replyService.get(rno, function(reply){
								modalInputReplyDate.closest("div").show();
								modalInputReply.val(reply.reply);
								modalInputReplyer.val(reply.replyer);
								modalInputReplyDate.val(replyService.displayTime(reply.replyDate)).attr("readonly","readonly");
								modal.data("rno",reply.rno);

								modal.find("button[id != 'modalCloseBtn']").hide();
								
								modalInputReply.attr("disabled", "disabled");

								if(id == reply.id){
								modalModBtn.show();
								modalRemoveBtn.show();
								modalInputReply.removeAttr("disabled");
								}

								$(".modal").modal("show");
								
								})
							
							})
						
						modalModBtn.on("click",function(e){
							if(modalInputReply.val()==""){
								alert("댓글 내용을 입력하세요!");
								return false;
								}
							
							var reply = {rno:modal.data("rno"), reply: modalInputReply.val()};

							replyService.update(reply,function(result){

								alert(result);
								modal.modal("hide");
								showList(1);								
								})
							
							})	

						modalRemoveBtn.on("click",function(e){
							var rno = modal.data("rno");

							replyService.remove(rno, function(result){

								alert(result);
								modal.modal("hide");
								showList(1);
								
								})
							
							})

							
					});
</script>



<script type="text/javascript">
	$(document).ready(function() {

		var operForm = $("#operForm");
		$("button[data-oper='modify']").on("click", function(e) {
			operForm.attr("action", "/board/modify").submit();
		});
		$("button[data-oper='list']").on("click", function(e) {
			operForm.find("#bno").remove();
			operForm.attr("action", "/board/list").submit();
		});
	});
</script>


<%@include file="includes/footer.jsp"%>

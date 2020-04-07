<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dashboard - SB Admin</title>
        <link href="/myapp/resources/dist/css/styles.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    
    <body class="sb-nav-fixed">

        
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <a class="navbar-brand" href="/myapp">게시판</a>
            <button class="btn btn-link btn-sm order-1 order-lg-0" id="sidebarToggle" href="#"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <!-- <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2" />
                    <div class="input-group-append">
                        <button class="btn btn-primary" type="button"><i class="fas fa-search"></i></button>
                    </div>
                </div>
            </form> -->
            <!-- Navbar-->
            <ul class="d-none d-md-inline-block navbar-nav ml-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                   	    <sec:authorize access="isAnonymous()">
                        <a class="dropdown-item" href="/myapp/member/login" >로그인</a>
                        <a class="dropdown-item" href="javascript:register()">회원가입</a>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                        <a class="dropdown-item" href="/myapp/member/modify">회원정보</a>
                     	<a class="dropdown-item logoutBtn" href="#">로그아웃</a>
                        </sec:authorize>
                    </div>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">게시판</div>
                            <a class="nav-link" href="/myapp/board/register">
                            <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
	                       	글쓰기</a>
                            <div class="sb-sidenav-menu-heading">회원정보</div>
                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts"
                                ><div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                          		회원정보
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div
                            ></a>                            
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="/myapp/member/login">로그인</a>                                
                                <a class="nav-link" href="javascript:register()">회원가입</a>                                
                                <a class="nav-link" href="/myapp/member/modify">회원정보</a>
                                <a class="nav-link logoutBtn" href="#">로그아웃</a>
                                <form id="logoutForm" action="/myapp/logout" method="post">
                                <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
                                </form>
                            </nav>
                            </div>
                            <div class="sb-sidenav-menu-heading">기타</div>
                            <a class="nav-link" href="charts.html">
                            	<div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>날씨 정보
                           	</a>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">해당 사용자로 로그인 됨:</div>
                        Start Bootstrap
                    </div>
                </nav>
               </div>
<!-- registerModal -->
<div class="modal fade" id="registerModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header justify-content-center font-weight-light my-4">
				<h3 class="modal-title" id="myModalLabel">회원가입</h3>
			</div>
			<div class="modal-body">
	            <form id="registerForm" action="/myapp/member/register" method="post">
	            <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
	            <input type="hidden" class="regsiterInput" name="userid" id="userid">
	            <input type="hidden" class="regsiterInput" name="addr" id="addr">
	            <input type="hidden" class="regsiterInput" name="zipNo" id="zipNo">
	            <input type="hidden" name="idcheck" id="idcheck" value="0">
	                <div class="form-group">
	              	  <label class="small mb-1" for="userid">ID</label>
					  <div class="input-group">
	              	  	<input class="form-control input-group-prepend regsiterInput" name="idView" id="idView" type="text" placeholder="아이디를 입력하세요" />
	               	 	<button type="button" id="idcheckBtn" class="btn btn-outline-info input-group-append">중복체크</button>
		              </div>
	                </div>
	                <div class="form-group">
		                <label class="small mb-1" for="userpw">Password</label>
		                <input class="form-control regsiterInput" name="userpw" id="userpw" type="password" placeholder="패스워드를 입력하세요" />
	                </div>
	                <div class="form-group">
		                <label class="small mb-1" for="userpw">Password 확인</label>
		                <input class="form-control regsiterInput" id="pwdcheck" type="password" placeholder="패스워드를 입력하세요" />
	                </div>
   	                <div class="form-group">
		                <label class="small mb-1" for="username">이름</label>
		                <input class="form-control regsiterInput" name="username" id="username" type="text" placeholder="이름을 입력하세요" />
	                </div>
					<div class="form-group">
						<label class="small mb-1">우편번호</label>
						<input class="form-control regsiterInput" type="text" name="zipNoView" id="zipNoView" disabled="disabled">
					</div>						
					<div class="form-group">
						<label class="small mb-1">주소</label>
						<div class="input-group">
							<input class="form-control input-group-prepend regsiterInput" type="text" name="addrView" id="addrView" disabled="disabled">
							<button type="button" id="addrBtn" onclick="javascript:goPopup()"
							class="btn btn-outline-primary input-group-apeend">주소 검색</button>
						</div>
					</div>
	                <div class="form-group">
	                    <div class="custom-control custom-radio">
	                    <input class="custom-control-input" checked="checked" type="radio" value="ROLE_ADMIN" name="auth" id="radio"/>
	                    <label class="custom-control-label" for="radio">관리자</label>
	                    </div>
	                    <div class="custom-control custom-radio">
	                    <input class="custom-control-input" type="radio" name="auth" value="ROLE_USER" id="radio2"/>
	                    <label class="custom-control-label" for="radio2">유저</label>
	                    </div>
	                </div>
	                <div class="form-group mt-4 mb-0">
	                	<button class="btn btn-primary float-right" id="registerBtn">회원가입</button>
	                </div>
	            </form>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="/myapp/resources/dist/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<!--    <script src="/myapp/resources/dist/assets/demo/chart-area-demo.js"></script>
        <script src="/myapp/resources/dist/assets/demo/chart-bar-demo.js"></script> -->
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
        <!-- <script src="/myapp/resources/dist/assets/demo/datatables-demo.js"></script> -->
        
        <script type="text/javascript">
        $(function(){
            $(".logoutBtn").click(function(){
                alert("로그아웃 되었습니다.");
                $("#logoutForm").submit();                                
                })

            
            $("#registerBtn").click(function(){
            	if ($("#idView").val() == "") {
    				alert("ID를 입력해주세요");
    				return false;
    			}
    			if ($("#idcheck").val() == "0") {
    				alert("아이디 중복확인을 하세요");
    				return false;
    			}
    			if ($("#userpw").val() == "") {
    				alert("패스워드를 입력해주세요");
    				return false;
    			}
    			if ($("#pwdcheck").val() == "") {
    				alert("패스워드 확인을 입력해주세요");
    				return false;
    			}
    			if ($("#username").val() == "") {
    				alert("이름을 입력해주세요");
    				return false;
    			}
      			if ($("#addr").val() == "") {
    				alert("주소를 입력해주세요");
    				return false;
    			}
    			if ($("#userpw").val() != $("#pwdcheck").val()) {
    				alert("패스워드가 틀립니다");
    				return false;
    			}
    			alert("회원가입이 완료 되었습니다!");
                $("#registerForm").submit();
            })
      		$("#idcheckBtn").click(function() {
			if ($("#idView").val() == "") {
				alert("ID를 입력해주세요");
				return false;
			}
			if ($("#idcheck").val() == "1") {
				$("#idView").removeAttr("disabled");
				$("#idView").val("");
				$("#idcheck").val("0");
				return false;
			}
			$.get("/myapp/member/idcheck", {
				"id" : $("#idView").val()
			}, function(data) {
				//alert(data);
				if (data == "no") {
					alert("이미 가입된 아이디 입니다!");
					$("#idView").val("");
					return false;
				} else {
					alert("사용 가능한 아이디 입니다!");
					$("#idcheck").val("1");
					$("#userid").val($("#idView").val());
					$("#idView").attr("disabled", true);
				}
			})
		})
     })
			function register(){
				$(".regsiterInput").val("");
				
				$("#registerModal").modal("show");
				$("#idView").removeAttr("disabled");
				$("#idcheck").val("0");
				}
			function goPopup() {
				// 주소검색을 수행할 팝업 페이지를 호출합니다.
				// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
				var pop = window.open("/myapp/member/popup", "pop",
						"width=570,height=420, scrollbars=yes, resizable=yes");

				// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
				//var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
			}

			function jusoCallBack(roadFullAddr, roadAddrPart1, addrDetail,
					roadAddrPart2, engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,
					detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn,
					buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo) {
				// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
				$("#addr").val(roadFullAddr);
				$("#addrView").val(roadFullAddr);
				$("#zipNo").val(zipNo);
				$("#zipNoView").val(zipNo);
			}
        </script>
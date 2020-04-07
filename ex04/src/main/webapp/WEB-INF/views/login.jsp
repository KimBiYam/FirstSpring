<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
   		<title>Page Title - SB Admin</title>
        <link href="/myapp/resources/dist/css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-5">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">로그인</h3></div>
                                    <div class="card-body">
                                        <form action="/myapp/login" method="post">
                                        <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
                                            <div class="form-group">
	                                            <label class="small mb-1" for="username">ID</label>
	                                            <input class="form-control py-4" name="username" id="username" type="text" placeholder="아이디를 입력하세요" />
                                            </div>
                                            <div class="form-group">
	                                            <label class="small mb-1" for="inputPassword">Password</label>
	                                            <input class="form-control py-4" name="password" id="password" type="password" placeholder="패스워드를 입력하세요" />
                                            </div>
                                            <div class="form-group">
                                                <div class="custom-control custom-checkbox">
                                                <input class="custom-control-input" name="remember-me" id="remember-me" type="checkbox" />
                                             	   <label class="custom-control-label" for="remember-me">자동 로그인</label>
                                                </div>
                                            </div>
                                            <div class="form-group mt-4 mb-0">
                                         	   <button class="btn btn-primary">Login</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div id="layoutAuthentication_footer">
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2019</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="/myapp/resources/dist/js/scripts.js"></script>
            <script type="text/javascript">
    	$(".btn-primary").on("click",function(e){
        	if($("input[name='username']").val()==""){
            	alert("아이디를 입력하세요");
            	return false;
            	}
        	if($("input[name='password']").val()==""){
            	alert("패스워드를 입력하세요");
            	return false;
            	}
        	e.preventDefault();
        	$("form").submit();
        	})
    </script>
    </body>
</html>

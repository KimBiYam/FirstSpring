<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Custom Login Page</h1>
	<h2><c:out value="${error }"/></h2>
	<h2><c:out value="${logout }"/></h2>
	<form role="form" action="/security/login" method="post">
		<div>
			<input name="username" type="text" placeholder="Userid" autofocus="autofocus">
		</div>
		<div>
			<input name="password" type="password" placeholder="Password">
		</div>
		<div>
			<input type="checkbox" name="remember-me"> Remember Me
		</div>
		<div>
			<input type="submit">
		</div>
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
	</form>
</body>
</html>
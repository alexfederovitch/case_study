<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/homeinsurance_case_study/admin/adminValidation"
		method="post">
		<div>
			<label>Name:</label> <input type="text" name="userName" />
		</div>
		<div>
			<label>Password:</label> <input type="text" name="password" />
		</div>
		<div>
			<input type="submit" value="Login" name="login" />
		</div>
	
	</form>
	<button id="reset">
		<a href="/homeinsurance_case_study/showLogin">Reset</a>
	</button>
	${message}
	<c:forEach items="${errorList}" var="error">
		<p style="color: red;">${error}</p>
	</c:forEach>
</body>
</html>
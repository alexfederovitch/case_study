<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<script type="text/javascript"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Page</h1>
	<div id="demo"></div>
	<form action="/homeinsurance_case_study/login" method="post">
		<div>
			<label>Name:</label>
			<input type="text" name="userName"/>
		</div>
		<div>
			<label>Password:</label>
			<input type="text" name="password"/>
		</div>
		<div>
			<input type="submit" value="Login" name="login"/>
		</div>

	</form>
	
		<%@ page import="java.util.ArrayList"%>
	<button id="adminLogin"><a href="${pageContext.request.contextPath}/admin/showAdminLoginPage">Admin Login</a></button>
	<button id="reset"><a href="/homeinsurance_case_study/showLogin">Reset</a></button>
	<button id="register"><a href="/homeinsurance_case_study/showRegistrationPage">Register Here</a></button>
	
	<c:forEach items="${errorList}" var="error"> 
	    <p style="color: red;">${error}</p>
	</c:forEach>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/script.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<div id="header">
		<%@include file="header.html"%>
	</div>
</head>
<body>
	<h1>Welcome ${currentUser.userName}!</h1>
	<h2>${currentUser.adminRole}</h2>
	
	<button type="button" name="getQuote" onclick="window.location.href = '/homeinsurance_case_study/getQuote';">Get a Quote</button>
	<button type="button" name="retreiveQuote" onclick=>Retrieve a Quote</button>

	<button type="button" name="logout"><a href="/homeinsurance_case_study/logout">Logout</a></button>
	<h2>Users</h2>

</body>
</html>
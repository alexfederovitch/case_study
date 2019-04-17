<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="/homeinsurance_case_study/registerUser" method="post">
		<div>
			<label>User Name:</label> <input type="text" name="userName" />
		</div>
		<div>
			<label>Password:</label> <input type="text" name="password" />
		</div>
		<div>
			<label>Confirm Password:</label> <input type="text" name="passwordConfirm" />
		</div>
		<div>
			<label>Admin Role:</label> <input type="text" name="adminRole" />
		</div>
		<div>
			<input type="submit" value="Register" name="register" />
		</div>
	</form>
	<a href="/homeinsurance_case_study/showLoginPage">Back to Login
		Page</a>

</body>
</html>
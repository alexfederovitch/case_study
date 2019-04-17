<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="column1">
		<form action="/homeinsurance_case_study/registerHomeowner" method="POST">
			<table>
				<tr>
					<td><label>firstName</label></td>
					<td><input name="firstName" type="text" id="firstName">
					<td>
				</tr>
				<tr>
					<td><label>lastName</label></td>
					<td><input name="lastName" type="text" id="lastName"></td>
				</tr>
				<tr>
					<td><label>Date of Birth</label></td>
					<td><input name="dob" type="date" id="dob" required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"></td>
				</tr>
				<tr>
					<td><label>Are you Retired?</label></td>
					<td>
					<input type="radio" name="isRetired" value="1" id="r1"/>Yes 
					<input type="radio" name="isRetired" value="0" id="r2"/>No
					</td>
				</tr>
				<tr>
					<td><label>Social Security Number</label></td>
					<td><input name="ssn" required maxLength="15" type="text"
						id="ssn"></td>
				</tr>
				<tr>
					<td><label>Email Address</label></td>
					<td><input name="email" required type="text" id="email"
						maxlength="50">
					</td>
				</tr>
			</table>
			<div class=button>
				<button type="submit" name="submit">Continue</button>
			</div>
		</form>
	</div>
</body>
</html>
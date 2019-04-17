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
		<form action="/homeinsurance_case_study/registerLocation"
			method="POST">
			<label id="residenceType">Residence Type</label> <select
				name="residenceType" required>
				<option value="single_family">Single Family Home</option>
				<option value="condo">Condo</option>
				<option value="townhouse">Townhouse</option>
				<option value="rowhouse">Rowhouse</option>
				<option value="duplex">Duplex</option>
				<option value="apartment">Apartment</option>
			</select>
			<table>
				<tr>
					<td><label> Address Line 1</label></td>
					<td><input name="addressLine1" type="text" id="addressLine1">
					<td>
				</tr>
				<tr>
					<td><label>Address Line 2 </label></td>
					<td><input name="addressLine2" type="text" id="addressLine2"></td>
				</tr>
				<tr>
					<td><label> State</label></td>
					<td><input name="state" required type="text" id="state"></td>
				</tr>
				<tr>
					<td><label> City</label></td>
					<td><input name="city" required maxLength="15" type="text"
						id="city"></td>
				</tr>
				<tr>
					<td><label> Zip</label></td>
					<td><input name="zip" required type="text" id="zip"
						pattern="^\s*?\d{5}(?:[-\s]\d{4})?\s*?$" maxlength="10"
						title="Five digit zip code"></td>
				</tr>
			</table>
			<label>Residence Use</label> <select name="residenceUse" type="text"
				id="residenceUse">
				<option value="primary">Primary</option>
				<option value="secondary">Secondary</option>
				<option value="rental_property">Rental Property</option>
			</select>
			<div class=button>
				<button type="submit" name="submit">Continue</button>
			</div>
		</form>
	</div>



</body>
</html>
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
		<form action="/homeinsurance_case_study/registerProperty"
			method="POST">
			<table>
				<tr>
					<td><label>What is the market value of your home?</label></td>
					<td>$<input name="marketValue" type="text" id="marketValue">
					<td>
				</tr>
				<tr>
					<td><label>What year was your home originally built?</label></td>
					<td><input name="yearBuilt" type="text" id="yearBuilt"></td>
				</tr>
				<tr>
					<td><label>Square Footage</label></td>
					<td><input name="squareFootage" type="text" id="squareFootage"></td>
				</tr>
				<tr>
					<td><label id="dwellingType">Dwelling Style</label></td>
					<td><select name="dwellingType" required>
							<option value="1">1 Story</option>
							<option value="1.5">1 1/2 Stories</option>
							<option value="2">2 Stories</option>
							<option value="2.5">2 1/2 Stories</option>
							<option value="3">3 Stories</option>
					</select></td>
				</tr>
				<tr>
					<td><label id="roofMaterial">Roofing Material</label></td>
					<td><select name="roofMaterial" required>
							<option value="concrete">Concrete</option>
							<option value="clay">Clay</option>
							<option value="rubber">Rubber</option>
							<option value="steel">Steel</option>
							<option value="tin">Tin</option>
							<option value="wood">Wood</option>
					</select></td>
				</tr>
				<tr>
					<td><label id="garage">Type of Garage</label></td>
					<td><select name="garage" required>
							<option value="attached">Attached</option>
							<option value="detached">Detached</option>
							<option value="basement">Basement</option>
							<option value="builtIn">Built-In</option>
							<option value="none">None</option>
					</select></td>
				</tr>
				<tr>
					<td><label id="fullBath">Number of Full Baths</label></td>
					<td><select name="fullBath" required>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4 or more</option>
					</select></td>
				</tr>
				<tr>
					<td><label id="halfBath">Number of Half Baths</label></td>
					<td><select name="halfBath" required>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4 or more</option>
					</select></td>
				</tr>
				<tr>
					<td><label>Swimming Pool</label></td>
					<td><input type="radio" name="isPool" value="1" id="sp1" required/>Yes <input
						type="radio" name="isPool" value="0" id="sp2"/>No</td>
				</tr>
			</table>
			<div class=button>
				<button type="submit" name="submit">Continue</button>
			</div>
		</form>
	</div>
</body>
</html>
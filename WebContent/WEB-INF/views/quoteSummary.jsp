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
<div id="header">
	<%@include file="header.html"%>
</div>
</head>
<body>

	<form action="/homeinsurance_case_study/showBuyPolicy" method="post">
		<table align="center">
			<tr>
				<td><h2>Monthly Premium: $</h2></td>
				<td><h2>${currentQuote.monthlyPremium}</h2></td>
			</tr>
			<tr>
				<td><button name="Buy1" value="Buy" type="submit">Buy
						Quote</button></td>
			</tr>
			<tr>
				<td colspan=2><h2>Location Details</h2></td>
			</tr>
			<tr>
				<td>Quote Id</td>
				<td>${currentQuote.quoteId}</td>
			</tr>
			<tr>
				<td>Residence Type</td>
				<td>${currentLocation.residenceType}</td>
			</tr>
			<tr>
				<td>Address Line 1</td>
				<td>${currentLocation.addressLine1}</td>
			</tr>
			<tr>
				<td>Address Line 2</td>
				<td>${currentLocation.addressLine2}</td>
			</tr>
			<tr>
				<td>City</td>
				<td>${currentLocation.city}</td>
			</tr>
			<tr>
				<td>State</td>
				<td>${currentLocation.locationState}</td>
			</tr>
			<tr>
				<td>Zip</td>
				<td>${currentLocation.zipCode}</td>
			</tr>
			<tr>
				<td>Residence Use</td>
				<td>${currentLocation.residenceUse}</td>
			</tr>
			<tr>
				<td>userName</td>
				<td>${currentUser.userName}</td>
			</tr>
			<tr>
				<td colspan=2><hr />
					<h2>Homeowner Details</h2></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td>${currentHomeowner.firstName}</td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td>${currentHomeowner.lastName}</td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td>${currentHomeowner.dob}</td>
			</tr>
			<tr>
				<td>Is Retired ? -</td>
				<td>${currentHomeowner.isRetiredStatus()}</td>
			</tr>
			<tr>
				<td>Social Security Number</td>
				<td>${currentHomeowner.ssn}</td>
			</tr>
			<tr>
				<td>Email Address</td>
				<td>${currentHomeowner.email}</td>
			</tr>
			<tr>
				<td colspan=2><hr />
					<h2>Property Details</h2></td>
			</tr>
			<tr>
				<td>Market Value</td>
				<td>${currentProperty.marketValue}</td>
			</tr>
			<tr>
				<td>Year Built</td>
				<td>${currentProperty.yearBuilt}</td>
			</tr>
			<tr>
				<td>Square Footage</td>
				<td>${currentProperty.squareFootage}</td>
			</tr>
			<tr>
				<td>Dwelling Style</td>
				<td>${currentProperty.dwellingType}</td>
			</tr>
			<tr>
				<td>Roof Material</td>
				<td>${currentProperty.roofMaterial}</td>
			</tr>
			<tr>
				<td>Garage Type</td>
				<td>${currentProperty.garageType}</td>
			</tr>
			<tr>
				<td>Number of Full Baths</td>
				<td>${currentProperty.fullBaths}</td>
			</tr>
			<tr>
				<td>Number of Half Baths</td>
				<td>${currentProperty.halfBaths}</td>
			</tr>
			<tr>
				<td>Has Swimming Pool? -</td>
				<td>${currentProperty.hasPool}</td>
			</tr>
			<tr>
				<td colspan=2><hr />
					<h2>Coverage Details</h2></td>
			</tr>
			<tr>
				<td>Monthly Premuim</td>
				<td>${currentQuote.monthlyPremium}</td>
			</tr>
			<tr>
				<td>Dwelling Coverage</td>
				<td>${currentQuote.dwellingCoverage}</td>
			</tr>
			<tr>
				<td>Detached Structures</td>
				<td>${currentQuote.detatchedStructures}</td>
			</tr>
			<tr>
				<td>Personal Property</td>
				<td>${currentQuote.personalProperty}</td>
			</tr>
			<tr>
				<td>Additional living expense</td>
				<td>${currentQuote.addLivingExp}</td>
			</tr>
			<tr>
				<td>Medical expense</td>
				<td>${currentQuote.medicalExpenses}</td>
			</tr>
			<tr>
				<td>Deductible</td>
				<td>${currentQuote.deductible}</td>
			</tr>
			<tr>
				<td colspan=2><hr /></td>
			</tr>
			<tr>
				<td><button name="Buy2" value="Buy" type="submit">Buy
						Quote</button></td>
			</tr>
		</table>
</body>
</html>
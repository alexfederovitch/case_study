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
</head>
<body>
<form action="/homeinsurance_case_study/quoteSummary" method="post">
	<table style="width: 800px;">
		<tr>
			<td><img src="getstartedpage.PNG" width="275px" height="180px" /></td>
			<td>
				<!-- 	<form action="/homeinsurance_case_study/CoverageDetails" method="get"> -->
				<table>
					<tr>
						<td></td>
						<td><a href="addlinfo.html" target="_blank">Additional
								info</a></td>
					<tr>
						<td>Quote Id</td>
						<td>${currentQuote.quoteId}</td>
					</tr>
					<tr>
						<td>Monthly Premium</td>
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
						<td>Medical Expense</td>
						<td>${currentQuote.medicalExpenses}</td>
					</tr>
					<tr>
						<td>Deductible</td>
						<td>${currentQuote.deductible}</td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" name="submit"
							value="Proceed to buy" /></td>
					</tr>
				</table> <!-- 			</form> -->
			</td>
		</tr>
	</table>
	</form>
</body>
</html>
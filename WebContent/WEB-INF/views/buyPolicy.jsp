<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="center">
		<h2>Buy Policy</h2>
		
		<br />
		<br />
		<br />
		<br />
		<p>
			<b>Quote Id:</b>${currentQuote.quoteId}</p>
		<p>
			<b><span style="color: red;">Note:</span> Policy start date
				cannot be more than 60 days from today's date</b>
		</p>
		<form action = "/homeinsurance_case_study/buyPolicy" method="POST">
			<p>
				Enter Policy Start Date: <input name="policyStart" type="date" id="policyStart" required pattern="[0-9]{2}-[0-9]{2}-[0-9]{4}">
				mm/dd/yyyy -- (for any month you must use today's date)
			</p>
			<p>
				<a href="terms.jsp" target="_blank">Please click and read terms
					and conditions before buying policy</a>
			</p>
			<p>
				<input type="radio" id="read" value="read" onClick="enable()" />This
				is to acknowledge that I have read the terms and conditions of the
				policy
			</p>
			<p>
				<input type="submit" id="submit" name="submit" value="Submit" />
			</p>
		</form>
	</div>
</body>
</html>
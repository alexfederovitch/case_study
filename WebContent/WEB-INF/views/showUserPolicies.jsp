<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<%@page import="java.util.List"%>
<%@page import="homeinsurance.model.Policy"%>
<title>Insert title here</title>
</head>
<body>

	User Policies
	<%
		List<Policy> policies = (List<Policy>) request.getAttribute("policies");
		if (policies.size() == 0) {
			request.setAttribute("message", "No policies to display.");
		} else {
			request.setAttribute("message", "");
		}
	%>
	${message}
	<table>
		<%
			for (Policy p : policies) {
		%>
		<tr>
			<td>PolicyId:<br /><%=p.getPolicyId()%></td>
			<td>UserId:<br /><%=p.getUserId()%></td>
			<td>QuoteId:<br /><%=p.getQuoteId()%></td>
			<td>Effective Date:<br /><%=p.getEffectiveDate()%></td>
			<td>End Date:<br /><%=p.getEndDate()%></td>
			<td>Term:<br /><%=p.getTerm()%></td>
			<td>Status:<br /><%=p.getPolicyStatus()%></td>
			<td><a
				href="cancelorrenewpolicy?userid=<%=p.getUserId()%>&action=CANCELLED&policyid=<%=p.getPolicyId()%>">
					<button>Cancel</button>
			</a> <a
				href="cancelorrenewpolicy?userid=<%=p.getUserId()%>&action=RENEWED&policyid=<%=p.getPolicyId()%>">
					<button>Renew</button>
			</a> <a
				href="cancelorrenewpolicy?userid=<%=p.getUserId()%>&action=ACTIVE&policyid=<%=p.getPolicyId()%>">
					<button>Active</button>
			</a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>
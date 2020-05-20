<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pocetna stranica clan</title>
</head>
<body>
	<div>
		
		<c:url value="/clan/add" var="clanAdd"></c:url>
		<a href="<c:out value="${clanAdd}"/>">dodaj clana</a>
	</div>

	<div>
		<c:url value="/clan/all" var="clanAll"></c:url>
		<a href="<c:out value="${clanAll}"/>">svi clanovi</a>
	</div>
	<div>
		<c:url value="/clan/details" var="clanDetails"></c:url>
		<a href="<c:out value="${clanDetails}"/>">detalji o clanu</a>
	</div>
</body>
</html>
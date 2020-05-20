<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>pocetna strana autori</title>
</head>
<body>
<div>
		<c:url value="/autor/add" var="autorAdd"></c:url>
		<a href="<c:out value="${autorAdd}"/>">dodaj autora</a>
	</div>

	<div>
		<c:url value="/autor/all" var="autorAll"></c:url>
		<a href="<c:out value="${autorAll}"/>">svi autori</a>
	</div>
	<div>
		<c:url value="/autor/details" var="autorDetails"></c:url>
		<a href="<c:out value="${autorDetails}"/>">detalji o autoru</a>
	</div>

</body>
</html>
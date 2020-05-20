<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
		<c:url value="/knjiga/add" var="knjigaAdd"></c:url>
		<a href="<c:out value="${knjigaAdd}"/>">dodaj knjigu</a>
	</div>

	<div>
		<c:url value="/knjiga/all" var="knjigaAll"></c:url>
		<a href="<c:out value="${knjigaAll}"/>">sve knjige</a>
	</div>
	<div>
		<c:url value="/knjiga/details" var="knjigaDetails"></c:url>
		<a href="<c:out value="${knjigaDetails}"/>">detalji o knjizi</a>
	</div>


</body>
</html>
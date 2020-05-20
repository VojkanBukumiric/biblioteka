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
		<c:url value="/iznajmiknjigu/add" var="iznajmiknjiguAdd"></c:url>
		<a href="<c:out value="${iznajmiknjiguAdd}"/>">iznajmi knjigu</a>
	</div>

	<div>
		<c:url value="/iznajmiknjigu/all" var="iznajmiknjiguAll"></c:url>
		<a href="<c:out value="${iznajmiknjiguAll}"/>">sve iznajmljene knjige</a>
	</div>

</body>
</html>
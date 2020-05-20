<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/pages/index.jsp"></jsp:include>
	<div class="container fill">
		<table class="table table-striped">
			<tbody>
				<tr>
					<th>Clan</th>
					<th>Knjiga</th>
				</tr>
				<c:forEach items="${iznajmljeneKnjige}" var="iznajmljeneknjige">
					<tr>
						<td>${iznajmljeneknjige.clanDto.imeIPrezime}</td>
						<td>${iznajmljeneknjige.knjigaDto.naziv}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>
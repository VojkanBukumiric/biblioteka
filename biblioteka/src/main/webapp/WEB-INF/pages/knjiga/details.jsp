<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>detalji o knjizi</title>
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
					<th>Naziv</th>
					<th>Zanr</th>
					<th>Autor</th>
					<th>Broj stranica</th>
				</tr>
				<tr>
					<td>${knjigaDto.naziv}</td>
					<td>${knjigaDto.zanrDto.vrsta}</td>
					<td>${knjigaDto.autorDto.imeIPrezime}</td>
					<td>${knjigaDto.brojStrana}</td>
				</tr>
			</tbody>
		</table>
	</div>


</body>
</html>
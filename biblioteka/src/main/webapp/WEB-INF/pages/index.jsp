<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>pocetna stranica</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	<style>
	.nav-item{
	padding: 10px;
	}
	.navbar-nav{
	text-align: center;
	}
	</style>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-light">
		
		<div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
   Rad sa clanovima
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <a class="dropdown-item" href="${pageContext.request.contextPath}/clan/add">Dodaj clana</a>
    <a class="dropdown-item" href="${pageContext.request.contextPath}/clan/all">Lista clanova</a>
    <a class="dropdown-item" href="${pageContext.request.contextPath}/clan/details">Detalji o clanu</a>
  </div>
</div>
<div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
   Rad sa knjigama
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <a class="dropdown-item" href="${pageContext.request.contextPath}/knjiga/add">Dodaj knjigu</a>
    <a class="dropdown-item" href="${pageContext.request.contextPath}/knjiga/all">Lista knjiga</a>
    <a class="dropdown-item" href="${pageContext.request.contextPath}/knjiga/details">Detalji o knjizi</a>
  </div>
</div>
<div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
   Rad sa autorima
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <a class="dropdown-item" href="${pageContext.request.contextPath}/autor/add">Dodaj autora</a>
    <a class="dropdown-item" href="${pageContext.request.contextPath}/autor/all">Lista autora</a>
    <a class="dropdown-item" href="${pageContext.request.contextPath}/autor/details">Detalji o autoru</a>
  </div>
</div>
<div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
   Iznajmljivanje knjige
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <a class="dropdown-item" href="${pageContext.request.contextPath}/iznajmiknjigu/add">Iznajmi knjigu</a>
    <a class="dropdown-item" href="${pageContext.request.contextPath}/iznajmiknjigu/all">Lista iznajmljenih knjiga</a>
  
  </div>
</div>
	</nav>


</body>
</html>
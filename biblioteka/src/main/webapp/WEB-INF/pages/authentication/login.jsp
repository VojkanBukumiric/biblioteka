<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style type="text/css">
.error {
	color: red;
}
body{
    background-color:#5286F3;
    font-size:14px;
    color:#fff;
}
.simple-login-container{
    width:300px;
    max-width:100%;
    margin:50px auto;
}
.simple-login-container h2{
    text-align:center;
    font-size:20px;
}

.simple-login-container .btn-login{
    background-color:#FF5964;
    color:#fff;
}
</style>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

	<form:form action="${pageContext.request.contextPath}/authentication/login" method="post" modelAttribute="korisnikDto">
	<div class="container">
		<div class="row">
			<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
				<div class="card card-signin my-5">
					<div class="card-body">
						<h5 class="card-title text-center">Sign In</h5>
						<form class="form-signin">
							<div class="form-label-group">
								<form:input type="ime" path="ime"  id="imeId" class="form-control"  placeholder="Username"></form:input>
								<label for="username">Username</label>
							</div>
							

							<div class="form-label-group">
								<form:input type="password"  id="lozinkaId" class="form-control"  path="lozinka" placeholder="Password"></form:input>
								<label for="password">Password</label>
							</div>
							<form:errors path="lozinka" />


							<button class="btn btn-lg btn-primary btn-block text-uppercase"
								type="submit">Login</button>
						</form>
						
 

							
	
	
					</div>
					<c:if test="${not empty errorMessage }"><div class="alert alert-danger" role="alert"> ${errorMessage}</div></c:if>
				</div>
			</div>
		</div>
	</div>
	</form:form>

</body>





</html>
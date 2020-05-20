<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>iznajmi knjigu</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<style>
.error {
	color: red;
}

body {
	padding-top: 56px;
	display: flex;
	position: relative;
	flex-direction: column;
	height: 100vh;
}

.fill {
	flex: 1;
}
</style>
</head>
<body data-gr-c-s-loaded="true">
	<div>
		<jsp:include page="/WEB-INF/pages/index.jsp"></jsp:include>
		<div class="container fill">
			<div class="row">
				<div class="col-md-7 offset-3">
					<br>
					<div class="card mb-4">
						<div class="card-body">
							<h2 class="card-title">Iznajmi knjigu</h2>

							<form:form class="horizontal"
								action="${pageContext.request.contextPath}/iznajmiknjigu/save"
								method="post" modelAttribute="clanKnjigaDto">
								<fieldset>
									<div class="form-group row">
										<form:label path="clanDto" class="col-sm-3 col-form-label">Clan</form:label>
										<div class="col-sm-8">
											<form:select path="clanDto" class="form-control">
												<form:options items="${clanovi}" itemValue="id"
													itemLabel="imeIPrezime" />
											</form:select>
											<div>
												<form:errors path="clanDto" cssClass="alert-danger" />
											</div>
										</div>
									</div>
									<div class="form-group row">
										<form:label path="knjigaDto" class="col-sm-3 col-form-label">Knjiga</form:label>
										<div class="col-sm-8">
											<form:select path="knjigaDto" class="form-control">
												<form:options items="${knjige}" itemValue="id"
													itemLabel="naziv" />
											</form:select>
											<div>
												<form:errors path="knjigaDto" cssClass="alert-danger" />
											</div>
										</div>
									</div>

									<button id="save" class="btn btn-primary">Sacuvaj</button>
								</fieldset>
							</form:form>
							<c:if test="${not empty errorMessage }">
								<div class="alert alert-danger" role="alert">
									${errorMessage}</div>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
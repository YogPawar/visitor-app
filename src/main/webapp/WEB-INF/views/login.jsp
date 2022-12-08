<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
</head>
<body style="background-color: #E9F7F6">
	<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<div align="center">
				<font color="Purple" size="15px"> <b>Login </b>
				</font>
			</div>
			<div class="panel panel-info">
				<div class="form-group">
					<form:form action="login" cssClass="form-horizontal" method="POST"
						modelAttribute="login" id="login-form">
						<p>
							<font color="red">${login.errorMessage} </font>
						</p>
						<!-- need to associate this data with customer id -->
						<div class="form-group">
							<label for="userName" class="col-md-3 control-label">User
								Name </label>
							<div class="col-md-9">
								<form:input path="userName" cssClass="form-control"
									required="required" />
							</div>
							<div class="col-md-9">
								<form:errors path="userName" cssClass="text-danger" />
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-md-3 control-label">Password
							</label>
							<div class="col-md-9">
								<form:password path="password" cssClass="form-control" />
							</div>
							<div class="col-md-9">
								<form:errors path="password" cssClass="text-danger" />
							</div>
						</div>
						<!-- Button -->
						<div class="col-md-offset-3 col-md-9">
							<form:button class="btn btn-success">Sign in</form:button>
							<input type="reset" value="Clear"
								class="btn btn-default btn-primary" id="clear">
						</div>
						<div class="col-md-offset-3 col-md-9">
						New User?<a 
							href="/visitors/user/add">Click here to create account</a>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
	<script src="<c:url value="/resources/js/jquery.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>
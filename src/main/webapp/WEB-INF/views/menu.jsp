<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
</head>
<body style="background-color: #E9F7F6">

	<nav class="navbar navbar-expand-lg navbar-light bg-light">

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="#">Menu
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/visitors/user/add">User</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/visitors/member/add">Member</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/visitors/visit/add">Visitor</a></li>
				<li class="nav-item"><a class="nav-link" href="/visitors/"
					tabindex="-1" aria-disabled="true">Logout</a></li>
			</ul>
		</div>
	</nav>
	<a class="navbar-brand" href="#">Welcome to 25 Glory Apartment
		${login.userName} </a>


	<ul class="list-group">

		<li class="list-group-item list-group-item-success"><a
			href="/visitors/member/add">Register Member</a></li>
		<li class="list-group-item list-group-item-success"><a
			href="/visitors/member/list"> Member List</a></li>
		<li class="list-group-item list-group-item-light"><a
			href="/visitors/user/add"> Register User</a></li>
		<li class="list-group-item list-group-item-light"><a
			href="/visitors/user/list"> User List</a></li>
		<li class="list-group-item list-group-item-warning"><a
			href="/visitors/visit/add"> Register Visitor</a></li>
		<li class="list-group-item list-group-item-warning"><a
			href="/visitors/visit/list">Visitor List</a></li>
	</ul>

	<script src="<c:url value="/resources/js/jquery.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>
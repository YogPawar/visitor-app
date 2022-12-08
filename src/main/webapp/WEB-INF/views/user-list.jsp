<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User List</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body style="background-color: #E9F7F6">
	<div class="container">
		<div class="col-md-offset-1 col-md-10">
		<div align="center">
				<font color="Blue" size="20"> <b>User List</b>
				</font>
			</div>
			<hr />
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
							href="/visitors/user/list">List</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/visitors/member/add">Member</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/visitors/member/list">List</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/visitors/visit/add">Visitor</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/visitors/visit/list">List</a></li>
						<li class="nav-item"><a class="nav-link" href="/visitors/"
							tabindex="-1" aria-disabled="true">Logout</a></li>
					</ul>
				</div>
			</nav>

			<input type="button" value="Add User"
				onclick="window.location.href='add'; return false;"
				class="btn btn-primary" /> <br /> <br />
			<div class="panel panel-info">
				<div class="panel-body">
					<table class="table table-striped table-bordered table-hover">
						<tr>
							<th><font color="purple">First Name</font></th>
							<th><font color="purple">Last Name</font></th>
							<th><font color="purple">User Name</font></th>
							<th><font color="purple">Contact Number</font></th>
							<th><font color="purple">Email</font></th>
							<th><font color="purple">Action</font></th>
						</tr>

						<!-- loop over and print our Users -->
						<c:forEach var="tempUser" items="${users}">

							<!-- construct an "update" link with User id -->
							<c:url var="updateLink" value="/visitors/user/edit">
								<c:param name="userId" value="${tempUser.userId}" />
							</c:url>

							<!-- construct an "delete" link with User id -->
							<c:url var="deleteLink" value="/visitors/user/delete">
								<c:param name="userId" value="${tempUser.userId}" />
							</c:url>

							<tr>
								<td>${tempUser.firstName}</td>
								<td>${tempUser.lastName}</td>
								<td>${tempUser.userName}</td>
								<td>${tempUser.contatNumber}
								<td>${tempUser.email}</td>

								<td>
									<!-- display the update link --> <a href="${updateLink}">Update</a>
									| <a href="${deleteLink}"
									onclick="if (!(confirm('Are you sure you want to delete this User?'))) return false">Delete</a>
								</td>

							</tr>

						</c:forEach>

					</table>

				</div>
			</div>
		</div>

	</div>
</body>
</html>
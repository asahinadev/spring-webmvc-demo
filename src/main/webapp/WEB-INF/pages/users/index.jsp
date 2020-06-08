<!doctype html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="ja" class="h-100">
<head>
<meta charset="utf-8">
<meta name="description" content="">
<title>users</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

/* Custom page CSS
-------------------------------------------------- */
/* Not required for template or sticky footer method. */
main>.container-fluid {
	padding: 60px 15px 0;
}

.footer {
	background-color: #f5f5f5;
}

.footer>.container {
	padding-right: 15px;
	padding-left: 15px;
}

code {
	cc font-size: 80%;
}
</style>
<meta name="theme-color" content="#563d7c">

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<!-- Custom styles for this template -->
<link href="sticky-footer-navbar.css" rel="stylesheet">
</head>
<body class="d-flex flex-column h-100">
	<header>
		<!-- Fixed navbar -->
		<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
			<a class="navbar-brand" href="#">Fixed navbar</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarCollapse" aria-controls="navbarCollapse"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="#">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#"
						tabindex="-1" aria-disabled="true">Disabled</a></li>
				</ul>
				<form class="form-inline mt-2 mt-md-0">
					<input class="form-control mr-sm-2" type="text"
						placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
			</div>
		</nav>
	</header>

	<!-- Begin page content -->
	<main role="main" class="flex-shrink-0">
		<div class="container-fluid">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>id</th>
						<th>username</th>
						<th>email</th>
						<th>created</th>
						<th>updated</th>
						<th>action</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>id</td>
						<td>username</td>
						<td>email</td>
						<td>created</td>
						<td>updated</td>
						<th>
							<!--  --> <form:form
								action="${pageContext.request.contextPath}/users/0" method="GET">
								<button class="btn btn-primary btn-sm">new</button>
							</form:form> <!--  --> <form:form
								action="${pageContext.request.contextPath}/users/0"
								method="DELETE">
								<button class="btn btn-danger btn-sm">del</button>
							</form:form>
						</th>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<th>&nbsp;</th>
						<th>&nbsp;</th>
						<th>&nbsp;</th>
						<th>&nbsp;</th>
						<th>&nbsp;</th>
						<th><form:form
								action="${pageContext.request.contextPath}/users/create"
								method="GET">
								<button class="btn btn-primary btn-sm">new</button>
							</form:form></th>
					</tr>
				</tfoot>
			</table>


		</div>
	</main>

	<footer class="footer mt-auto py-3">
		<div class="container">
			<span class="text-muted">Place sticky footer content here.</span>
		</div>
	</footer>
</body>
</html>

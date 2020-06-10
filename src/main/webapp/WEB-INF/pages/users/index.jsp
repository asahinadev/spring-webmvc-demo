<!doctype html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="app"%>

<html lang="ja" class="h-100">
<head>
<meta charset="utf-8">
<meta name="description" content="">
<title>users</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
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
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

</head>
<body class="d-flex flex-column h-100">
	<header>
		<!-- Fixed navbar -->
		<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
			<a class="navbar-brand" href="#">Fixed navbar</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="#">Home <span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a></li>
				</ul>
				<form class="form-inline mt-2 mt-md-0">
					<input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
			</div>
		</nav>
	</header>

	<!-- Begin page content -->
	<main role="main" class="flex-shrink-0">
		<div class="container-fluid">
			<table class="table table-bordered">
				<col width="10%">
				<col width="10%">
				<col width="20%">
				<col width="10%">
				<col width="10%">
				<col width="40%">
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
					<c:forEach items="${list}" var="item">
						<c:set var="rowClass" value="table-secondary" />
						<spring:url value="/users/${item.id}" var="url" />
						<c:if test="${item.enabled }">
							<c:set var="rowClass" value="table-primary" />
						</c:if>
						<tr class='<c:out value="${rowClass}"/>'>
							<td><c:out value="${item.id}" /></td>
							<td><c:out value="${item.username}" /></td>
							<td><c:out value="${item.email}" /></td>
							<td><app:localdatetime value="${item.created}" format="yy/mm/dd" /></td>
							<td><app:localdatetime value="${item.updated}" format="yy/mm/dd" /></td>
							<th>
								<div class="row">
									<div class="col px-2">
										<form:form action="${url}" method="GET">
											<button class="btn btn-primary btn-sm btn-block">mod</button>
										</form:form>
									</div>
									<div class="col px-2">
										<c:choose>
											<c:when test="${item.enabled}">
												<app:simplefoam url="${url}/deactive" type="secondary">無効化</app:simplefoam>
											</c:when>
											<c:otherwise>
												<app:simplefoam url="${url}/active" type="primary">有効化</app:simplefoam>
											</c:otherwise>
										</c:choose>
									</div>
									<div class="col px-2">
										<app:simplefoam url="${url}/delete" type="danger">削除</app:simplefoam>
									</div>
								</div>
							</th>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<th>&nbsp;</th>
						<th>&nbsp;</th>
						<th>&nbsp;</th>
						<th>&nbsp;</th>
						<th>&nbsp;</th>
						<th>
							<div class="row">
								<spring:url value="/users/create" var="url" />
								<div class="col">
									<form:form action="${url}" method="GET">
										<button class="btn btn-primary btn-sm btn-block">new</button>
									</form:form>
								</div>
								<div class="col"></div>
							</div>
						</th>
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

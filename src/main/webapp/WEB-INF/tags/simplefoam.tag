<%@ tag pageEncoding="UTF-8"%>

<%@ attribute name="url" type="java.lang.String" required="true"%>
<%@ attribute name="type" type="java.lang.String" required="true"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form action="${url}" method="POST">
	<button class="btn btn-${type} btn-sm btn-block">
		<jsp:doBody />
	</button>
</form:form>
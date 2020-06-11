<%@ tag pageEncoding="UTF-8"%>
<%@ tag import="java.time.format.DateTimeFormatter"%>
<%@ tag import="java.time.LocalDateTime"%>

<%@ attribute name="value" type="java.time.LocalDateTime" required="true"%>
<%@ attribute name="format" type="java.lang.String" required="true"%>

<%=value.format(DateTimeFormatter.ofPattern(format))%>

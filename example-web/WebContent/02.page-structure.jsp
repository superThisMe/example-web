<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- Declaration<%! %> : method 또는 variable 선언  --%>
<%!String getTimeString() {
		return new Date().toString();
	}%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Page Structure</title>
</head>
<body>

	<%-- Scriptlet<% %> : 일반 실행문 삽입 --%>
	<h2>
		<%
			out.println(new Date().toString());
		%>
	</h2>

	<%-- Expression<%= %> : 출력문 삽입 (out.pringln의 약식표현) --%>
	<h2><%=new Date().toString()%></h2>
	<h2><%=getTimeString()%></h2>

	<!-- HTML 주석 (서버에서는 문자열로 해석 / 브라우저에서는 주석으로 해석) -->
	<%-- JSP 주석 (서버에서 주석으로 해석 / 브라우저에서는 응답되지 않음) --%>

</body>
</html>
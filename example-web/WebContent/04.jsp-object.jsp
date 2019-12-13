<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Object</title>
</head>
<body>

	
	<%
	// request 객체는 JSP 내장객체이므로 선언없이 바로 사용할 수 있음
	String user = request.getParameter("user");
	String result = null;
	if (user != null && user.length() > 0) {
		int iUser = Integer.parseInt(user);
		int com = (int) (Math.random()*3) + 1;
		
		if ((iUser == 1 && com == 2) || (iUser == 2 && com == 3) || (iUser == 3 && com == 1)) {
				result = "YOU LOSE";
		} else if (iUser == com) {
				result = "DRAW";
		} else {
			result = "YOU WIN";
		}
	}
	
	// 내장객체 중에는 데이터 저장 기능을 제공하는 것도 있음
	// (request, pageContext, session, application)
	pageContext.setAttribute("my-data", new Date());
	%>

	<form action="04.jsp-object.jsp">
		<select name="user">
			<option value="1">가위</option>
			<option value="2">바위</option>
			<option value="3">보</option>
		</select>
		<input type="submit" value="게임시작">
	</form>
	<hr>
	<div>
	<%= result == null ? "" : result %>
	</div>
	
	<h3><%= pageContext.getAttribute("my-data") %></h3>

</body>
</html>
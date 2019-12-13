<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lotto</title>
<style type="text/css">
td {
	border: solid 1px;
	width: 100px;
	height: 50px;
	font-size: 15pt;
	text-align: center;
	font-weight: bold;
}
</style>
</head>
<body>

	<%
		int[] numbers = new int[6];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int) (Math.random() * 45) + 1;
			for (int j = 0; j < i; j++) {
				if (numbers[i] == numbers[j]) {
					i--;
					break;
				}
			}
		}
	%>

	<h3>
		<a href="03.exercise.jsp">당첨예상번호 뽑기</a>
	</h3>
	<hr>
	<table>
		<tr>
			<%--
			<%
				for (int i = 0; i < numbers.length; i++) {
					out.println("<td>");
					out.println(numbers[i]);
					out.println("</td>");
				}
			%>
		--%>
			<%
				for (int i = 0; i < numbers.length; i++) {
			%>
			<td><%=numbers[i]%></td>
			<%
				}
			%>
		</tr>
	</table>

</body>
</html>
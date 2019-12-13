<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fortune Telling</title>
<style type="text/css">
div {
	border: solid 2px;
	color: red;
	font-weight: bold;
	text-align: center;
	font-size: 20pt;
	width: 500px;
	height: 50px;
}
</style>
</head>
<body>

	<%
		String[] msgs = { "너 자신을 알라", "사공이 많으면 배가 산으로 간다", "식은 죽 먹기", "천리길로 한걸음부터", "언 발에 오줌누기", "세 살 버릇 여든까지 간다",
				"절이 싫으면 중이 떠나라", "미운놈 떡 하나 더 준다", "천길 물속은 알아도 열길 사람 속은 모른다", "돌 다리도 두드리고 건너라" };

		int rNo = (int) (Math.random() * 10);
		String msg = msgs[rNo];
	%>

	<h2>
		<a href="03.exercise2.jsp">오늘의 행운 메시지</a>
	</h2>
	<hr>
	<div>
		<%=msg%>
	</div>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VOCA TEST</title>
<style>
	body {
		text-align: center;
	}
	table {
		border-collapse: collapse;
	}
	td {
		padding: 5px;
		border: 1px solid black;
	}
</style>
</head>
<body>
	<br><br>
		<table align="center">
			<tbody>
				<h3>VOCA TEST</h3>
				<tr><td><a href="${pageContext.request.contextPath}/voca?action=member_list">시험 치기</a></td></tr>
				<tr><td><a href='${pageContext.request.contextPath}/voca?action=member_info'>결과 보기</a></td></tr>
				<tr><td><a href='${pageContext.request.contextPath}/loginform.jsp'>되돌아가기</a></td></tr>
			</tbody>
		</table>
</body>
</html>
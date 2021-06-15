<%@page import="com.wp.voca.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보</title>
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
<%
	VocamemberDO vocamember = (VocamemberDO)request.getAttribute("vocamember");
%>
		<form method='POST'>
			<table align="center">
				<thead>
					<tr><td>이 름</td><td><%= vocamember.getName() %></td></tr>
					<tr><td>1회차</td><td><%= vocamember.getTotal() %></td></tr>
					<tr><td>2회차</td><td><%= vocamember.getTotal2() %></td></tr>
					<tr><td>3회차</td><td><%= vocamember.getTotal3() %></td></tr>
					<tr><td colspan=2><a href='<%= request.getContextPath() + "/loginform.jsp"%>'>리스트로돌아가기</a></td></tr>
				</thead>		
			</table>
		</form>
</body>
</html>
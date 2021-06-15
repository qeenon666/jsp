<%@page import="java.util.List"%>
<%@page import="com.wp.voca.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
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
<script>
function ck() {
		let formEl = document.getElementById('for');
		formEl.setAttribute("action", '${pageContext.request.contextPath}/voca?action=joinform');
		formEl.submit();
}
function ok() {
	let formEl = document.getElementById('for');
	formEl.setAttribute("action", '${pageContext.request.contextPath}/voca?action=join');
	formEl.submit();
}
</script>
</head>
<body>
	<form id='for' method='POST'>
		<table align="center">
			<tbody>
				<tr><td colspan=2><h3>로그인 페이지</h3></td></tr>
				<tr><td>아이디 :</td><td><input type="text" name="id" /></td></tr> 
				<tr><td>비밀번호 :</td><td><input type="password" name="passwd" /></td></tr> 
				<tr><td colspan=2><a href='#' onclick='ok()'>로그인</a> <a href='#' onclick='ck()'>회원가입</a></td></tr>
			</tbody>
		</table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
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
		let formEl = document.getElementById('asd');
		formEl.setAttribute("action", '${pageContext.request.contextPath}/voca?action=register' );
		formEl.submit();
}
</script>
</head>
<body>
	<br><br>
	<form id="asd" action='${pageContext.request.contextPath}/voca?action=register' method='POST'>
		<table align="center">
			<tbody>
				<tr><td colspan=2><h3>회원가입 페이지</h3></td></tr>
				<tr><td>아이디 :</td><td><input type="text" name="id" required /></td></tr> 
				<tr><td>비밀번호 :</td><td><input type="password" name="passwd" required /></td></tr> 
				<tr><td>이름 :</td><td><input type="text" name="name" required /></td></tr> 
				<tr><td colspan=2><a href='#' onclick='ck()'>회원가입</a> <a href='${pageContext.request.contextPath}/voca?action=joinform'>다시작성</a></td></tr>
			</tbody>
		</table>
	</form>
</body>
</html>
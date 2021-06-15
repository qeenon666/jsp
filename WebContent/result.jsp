<%@ page import = "com.wp.voca.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>voca 테스트</title>
	<style>
		body{
			width: 600px;
			margin-top:50px;
			margin-left:50px;
		}
		header{
			height:100px;
		}
		.question {
			padding-top: 25px;
		}
	</style>
</head>
<body>
	<%
		String name = (String)session.getAttribute("id");
	%>
	<header>
		<h1>voca 테스트</h1>
		<div style='text-align: right;'>
			<p>반갑습니다, <%= name %> !...</p>
		</div>
	</header>
	<article>
		<form action='${pageContext.request.contextPath}/member_list.jsp' method='POST'>
			<div>
				<h3>voca 테스트 결과</h3>
			</div>
			<div>
				<p><b>1. 평가 점수 : </b></p>
				<p><b>2. 분석 결과 : </b></p>
				<div style='padding-left: 25px;'>
				</div>
			</div>
			<div style='padding-top: 50px; text-align: right'>
			<input type='submit' value='돌아가기' />
			</div>
		</form>
	</article>
</body>
</html>
<%
	session.invalidate();
%>

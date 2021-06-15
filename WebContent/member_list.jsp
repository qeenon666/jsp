<%@page import="com.wp.voca.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LIST 페이지</title>
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
	function confirmAndDelete(id) {
		let result = confirm('"' + id + '" 상품을 정말로 삭제하시겠습니까?');
		if (result) {
			let formEl = document.getElementById('list_form');
			formEl.setAttribute("action", '<%=request.getContextPath() + "/voca?action=delete&id="%>' + id);
			formEl.submit();
		}
	}
</script>
</head>
<body>
<%
	List<VocamemberDO> vocamemberList = (List<VocamemberDO>)request.getAttribute("member_list");
	if (vocamemberList != null) {
%>		
		<form id='list_form' method='POST'>
			<table align="center">
				<thead>
					<tr><td colspan=2>회원목록</td></tr>
				</thead>
				<tbody>
<%
	for (VocamemberDO member : vocamemberList) {
%>
					<tr><td><a href='<%= request.getContextPath() + "/voca?action=update_form&id=" + member.getId()%>'><%= member.getId() %></a></td>
					<td><a href='#' onclick='confirmAndDelete("<%= member.getId() %>");'>삭제</a>	</td></tr>
<%			
		}
	}
%>			
				</tbody>
			</table>
		</form>
</body>
</html>
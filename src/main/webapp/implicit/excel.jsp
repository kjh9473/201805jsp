<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="application/vnd.ms-excel; charset=UTF-8">
<%
	response.setHeader("Content-Disposition","attachment; filename=excel.xls");
%>
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>userId</td>
			<td>name</td>
		</tr>
		<tr>
			<td>brwon</td>
			<td>브라운</td>
		</tr>
		<tr>
			<td>sally</td>
			<td>샐리</td>
		</tr>
	</table>
</body>
</html>
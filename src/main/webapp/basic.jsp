<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="kr.or.ddit.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- 스크립틀릿 : 자바 코드 작성  -->
<!-- 표현식 : 출력을 표현-->
<%
	Date date = new Date();
	SimpleDateFormat sdate = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
	
%>
<body>

	<%
		UserVO userVo = (UserVO)session.getAttribute("userVo");
	%>
	
	userName[Alias] : <%=userVo.getName() + "[" + userVo.getAlias() + "]님 안녕하세요" %>
	
	hello, world
	<br>
	<%=sdate.format(date)%>
</body>
</html>
<!-- http://localhost:8081/basic.jsp -->

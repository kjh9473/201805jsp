<%@page import="kr.or.ddit.user.model.UserVO"%>
<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	main.jsp
	
	userId	 : <%=request.getParameter("userId") %>
	<br>
	password : <%=request.getParameter("password") %>
	<br>
<%-- 	userName[Alias] : <%= session.getAttribute("userVo") %> --%>

	<%
		UserVO userVo = (UserVO)session.getAttribute("userVo");
	%>
	
	userName[Alias] : <%=userVo.getName() + "[" + userVo.getAlias() + "]님 안녕하세요" %>
</body>
</html>
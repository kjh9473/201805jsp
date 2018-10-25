<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>logging tag</h2>
<tags:loggingTag />
<c:forEach var="i" begin="1" end="10" step="1">
		${i } <br>
</c:forEach>
<tags:loggingTag />

<h2>color logging tag</h2>
<tags:colorLogging  color="blue" />
<c:forEach var="i" begin="1" end="10" step="1">
	${i } <br>
</c:forEach>
<tags:colorLogging length="5" color="red"/>
</body>
</html>
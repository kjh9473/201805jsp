<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="length" type="java.lang.Integer" required="false" %>
<%@ attribute name="color" type="java.lang.String" required="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- length 속성이 없을경우 length 기본값 20으로 표현 --%>

length : ${length} <br>

<%--
	length : 5
	=====loging=====
--%>
<c:set var="length" value="${length == null ? 20 : length }" />
<font color = "${color }">
<c:forEach begin="1" end="${length }" step="1">=</c:forEach>
loging
<c:forEach begin="1" end="${length }" step="1">=</c:forEach>
</font>
<br>


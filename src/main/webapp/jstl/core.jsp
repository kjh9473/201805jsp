<%@page import="kr.or.ddit.util.model.PageVO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.or.ddit.user.service.UserService"%>
<%@page import="kr.or.ddit.user.service.UserServiceInf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>core.jsp</title>
</head>
<body> <!-- core tag prefix : c -->
	<!-- 스크립틀릿 -> jstl로 변경 -->
	<%-- jstl 태그 사용법 : <prefix : 태그명> --%>
	<h2> core set </h2>
	<%--pageContext.setAttribut("attribute", "cSetValue"); 와 같다 --%>
	<c:set var="attribute" value="cSetValue" scope="request" />
	
	el : ${attribute} <br>
	pageContext : <%=pageContext.getAttribute("attribute") %><br>
	request : <%=request.getAttribute("attribute") %> <br>

	<h2> core remove </h2>
	<c:remove var="attribute"/>
	el : ${attribute} <br>
	
	<h2> 단일 if </h2>
	<%--
		if(){
		} else if(){
		}
	 --%>
	<c:set var="code" value="01" />
	
	<%-- code가 "01"이면 if 안쪽 코드가 실행 --%>
	<c:if test="${code == '01'}">
		if안쪽
	</c:if>
	
	<h2> core choose : 실질적인 if 구문 </h2>
	<c:choose>
		<c:when test="${code == '00' }"> 공공 </c:when>
		<c:when test="${code == '01' }"> 공일 </c:when>
		<c:when test="${code == '02' }"> 공이 </c:when>
		<c:when test="${code == '03' }"> 공삼 </c:when>
		<c:otherwise> else </c:otherwise>
	</c:choose>
	
	<h2> core foreach : 반복문 </h2>
	<%-- 사용자 리스트 1페이지 조회 --%>
	<%
		UserServiceInf service = new UserService();
	
		PageVO pageVo = new PageVO();
		pageVo.setPage(1);
		pageVo.setPageSize(10);
		
		Map<String, Object> resultMap = service.selectUserPageList(pageVo);
		
		request.setAttribute("userList", resultMap.get("userList"));
	%>
	
	<%-- <c:set var"user" value="userList의 값" 을 반복적으로 가져옴 --%>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>사용자 아이디</th>
			<th>사용자 이름</th>
			<th>생일</th>
		</tr>
		<c:forEach items="${userList }" var="user">
			<tr class="userClick">
				<%-- <tr onClick = "alertId(userId='<%=uv.getUserId()%>')"> --%>
				<td>${user.rnum }</td>
				<td>${user.userId }</td>
				<td>${user.name }</td>
				<td>${user.birth }</td>
			</tr>
		</c:forEach>
	</table>
	
	<h2> core foreach index loop </h2>
	<c:forEach begin="0" end="10" var="i" step="3">
		${i }&nbsp;&nbsp;&nbsp;
	</c:forEach>
	
	<h2> core foreach : map </h2>
	<%
		Map<String, String> strMap = new HashMap<String, String>();
		strMap.put("ranget1", "brown");
		strMap.put("ranget2", "sally");
		strMap.put("ranget3", "cony");
		strMap.put("ranget4", "james");
		
		request.setAttribute("strMap", strMap);
	%>
	<c:forEach items="${strMap }" var="map">
		${map.key } / ${map.value } <br>
	</c:forEach>
</body>
</html> 
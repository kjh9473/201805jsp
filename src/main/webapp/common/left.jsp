<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="/main.jsp">Main <span class="sr-only">(current)</span></a></li>
		<li class="active"><a href="/userAllList">사용자 리스트</a></li>
		<li class="active"><a href="/userPageList?page=1&pageSize=10">사용자 페이징 리스트</a></li>
		<!-- 사용자 리스트 클릭시 : jspuser 전체 정보를 조회하여 화면에 출력 
		
			0.요청을 처리할 서블릿 생성 : UserServlet
			1.jspuser 전체 정보를 조회 : userService.selectUserAll()
			2.사용자 정보를 화면에 출력할 jsp : userAllList.jsp		
		
		-->
	</ul>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	
	public String msg(){
		return "hello, world";
	}
	
	//factorial method 선언
	
	public int factorial(int num){
		int result = 0;
			if(num == 1){
			result = 1;
		}else{
			result = num * factorial(num-1);
		}
		return result;
	}
%>
	<%= msg() %>
	<br>
	<%-- factorial method 호출  (loop를 통해 factorial 8까지 호출) --%>
	<%
	for(int i = 8; i > 1; i--){ 
	%>
		factorial(<%=i%>) = <%=factorial(i) %><br>
	<%}%>
</body>
</html>
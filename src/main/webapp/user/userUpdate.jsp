<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="kr.or.ddit.user.service.UserService"%>
<%@page import="kr.or.ddit.user.service.UserServiceInf"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<title>회원정보</title>
<%@include file="/common/basicLib.jsp"%>

<!-- jquery ui css -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<!-- daum주소 api -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<!-- jquery ui api -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	//주소 검색 버튼 클릭이벤트가 발생 했을때 실행
$(document).ready(function () {
	
	//생일 input datepicker 적용
	$("#birth").datepicker({
		dateFormat: "yy-mm-dd",
		yearRange: "1995:2018",
		changeMonth:true,
		changeYear:true
	});
	//주소 검색 버튼 이벤트 핸들러
	$("#addrSearchBtn").click(function () {
		 new daum.Postcode({
		        oncomplete: function(data) {
		            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
		            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
		          	console.log(data);
		            //주소 : roadAddress
		            //상세주소 :  ""
		            //우편번호 : zonecode
		            
		            //주소 input value설정 : data.roadAddress
		            //우편번호 input value설정 : data.zonecode
		           $("#addr1").val(data.roadAddress);
		           $("#zipcd").val(data.zonecode);
		        }
		    }).open();
	});
});
   
</script>
</head>
<body>
<% UserVO userVo2 = (UserVO)request.getAttribute("userVo"); %>
	<%-- header --%>
	<%@ include file="/common/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<%-- left --%>
			<%@ include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form action = "/userUpdate" method = "post" class="form-horizontal" role="form" enctype="multipart/form-data">

					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
							<img alt="" src="<%=userVo2.getProfile()%>" width="200" height="200">
							<input type="file" name="profile" ><br>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userId" name="userId"
								placeholder="사용자 아이디" value = "<%=userVo2.getUserId() %>" readonly="readonly">
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">비밀번호</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="pass" name="pass"
								placeholder="패스워드" value ="<%=userVo2.getPass() %>">
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">이름</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="name" name="name"
								placeholder="사용자 이름" value="<%=userVo2.getName() %>">
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="addr1" name="addr1"
								placeholder="주소" readonly value="<%=userVo2.getAddr1()%>"> <br>
								<button id = "addrSearchBtn" type="button" class="btn btn-default" >주소검색</button>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="addr2" name="addr2"
								placeholder="상세주소" value="<%=userVo2.getAddr2()%>">
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="zipcd" name="zipcd"
								placeholder="우편번호" readonly value="<%=userVo2.getZipcd() %>">
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">생년월일</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="birth" name="birth"
							<% 
								Date birth = userVo2.getBirth();
								SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
							%>
								placeholder="생년월일" value="<%=format.format(birth)%>">
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">이메일</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="email" name="email"
								placeholder="이메일" value="<%=userVo2.getEmail() %>">
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">연락처</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="tel" name="tel"
								placeholder="연락처" value="<%=userVo2.getTel()%>">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">수정하기</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>



</body>
</html>
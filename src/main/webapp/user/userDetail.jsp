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
<%@include file="/common/basicLib.jsp"%>
<script type="text/javascript">
	$(document).ready(function() {
// 		$(".btn btn-default pull-right").on("click", function() {
			var userId = $(control-label).val();
			console.log(userId);
			$("#userId").val(userId);
			$("#frm").submit();
// 		});
	});
</script>
<title>회원정보</title>
</head>
<form id="frm" action="/userUpdate" method="get">
	<input type="hidden" id="userId" name="userId" />
</form>

<body>
	<%-- header --%>
	<%@ include file="/common/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<%-- left --%>
			<%@ include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form class="form-horizontal" role="form">

					<%
						UserVO userDetail = (UserVO) request.getAttribute("userVo");
					%>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
							<%
								if (userDetail.getProfile() != null) {
							%>
							<img src="<%=userDetail.getProfile()%>" width="200" height="200">
							<%
								} else {
							%>
							<img src="/profile/noimage.jpg" width="200" height="200">
							<%
								}
							%>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<label class="control-label" value = "<%=userDetail.getUserId()%>"><%=userDetail.getUserId()%></label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">이름</label>
						<div class="col-sm-10">
							<label class="control-label"><%=userDetail.getName()%></label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10">
							<label class="control-label"><%=userDetail.getAddr1()%></label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<label class="control-label"><%=userDetail.getAddr2()%></label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<label class="control-label"><%=userDetail.getZipcd()%></label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">생년월일</label>
						<div class="col-sm-10">
							<label class="control-label"><%=userDetail.getBirth()%></label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">이메일</label>
						<div class="col-sm-10">
							<label class="control-label"><%=userDetail.getEmail()%></label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">연락처</label>
						<div class="col-sm-10">
							<label class="control-label"><%=userDetail.getTel()%></label>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<a class="btn btn-default" href="/userUpdate?userId=<%=userDetail.getUserId()%>">수정</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>



</body>
</html>
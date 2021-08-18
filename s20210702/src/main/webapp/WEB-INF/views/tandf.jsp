<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/css_main.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<script src="https://kit.fontawesome.com/29ccb048c9.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="resources/css/mailbox.css">
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
</head>
<body>
<div class="body">
<%@ include file="/WEB-INF/viewpart/header.jsp"%>
	<div id="sc_cont_up">
		<div id="writebox">
		<%@ include file="/WEB-INF/viewpart/mailbox.jsp"%>
			<c:if test="${k >= 0 }">
			<form action="sen_mailList" method="post">
				<input type="hidden" name="mem_id" value="${mo.mem_id}">
				<div class="tnf">
				메일 전송에 성공하였습니다.
				<input type="submit" value="확인">
				</div>
			</form>
			</c:if>
			<c:if test="${k < 0 }">
			<form action="mailWrite">
				<input type="hidden" name="mem_id" value="${mo.mem_id}">
				<div class="tnf">
				메일 전송에 실패하였습니다. 상대방 이메일을 확인하세요
				<input type="submit" value="확인">
				</div>
			</form>
			</c:if>
		</div>
	</div>
<%@ include file="/WEB-INF/viewpart/footer.jsp"%>
</div>
</body>
</html>
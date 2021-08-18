<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<div id="writebox" >
		<%@ include file="/WEB-INF/viewpart/mailbox.jsp"%>
			<div>
			<form action="mailSend" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
				<p><input type="submit" value="보내기"></p>
				<input type="hidden" name="mem_id" value="${mo.mem_id }">
				<input type="hidden" name="mem_no" value="${mo.mem_no }">
				<p>받는사람&nbsp;&nbsp;&nbsp;<input type="text" id="mail_receiver" name="mail_receiver" style="width: 615px; margin: 20px;" value="${mo.mem_id }"> @ damoware.com</p>
				<p>제목&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="mail_title" name="mail_title" style="width: 615px; margin: 20px;"></p>
				<p>파일첨부&nbsp;&nbsp; 
					<input type="file" id="file" name="file1" style="margin: 20px;"></p>
					<input type="hidden" name="path" value="${pageContext.request.contextPath}/resources/img/">
				<p style="margin: 20px;">내용</p><textarea rows="20" cols="100" id="mail_content" name="mail_content"></textarea><p>
				
					
			</form>
			</div>
		</div>
	</div>
<%@ include file="/WEB-INF/viewpart/footer.jsp"%>
</div>
</body>
</html>
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
<link rel="stylesheet" href="resources/css/board.css">
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
</head>
<body>
<div class="body">
<%@ include file="/WEB-INF/viewpart/header.jsp"%>
	<div id="sc_cont_up">
		<div id="writebox"> 
			<form action="write1" method="post" class="boardwrite">
			  <input type="hidden" name="mem_no" value="${sessionScope.mem_no }">
			  <input type="hidden" name="post_no" value="${post_no }">
			  <%-- <table>  
				
				<tr><th>사번</th><td>${sessionScope.mem_no }</td></tr>
				<tr><th>제목</th><td><input type="text" name="post_title"></td></tr>
				<tr><th>내용</th><td><textarea cols="30" rows="5" name="post_content">post_no=${post_no }</textarea></td></tr>
				<tr><td colspan="2">
				   <input type="submit" value="확인">
				   </td>
				</tr>
			</table> --%>
			<p style="width: 615px; margin: 20px;">사번 : ${sessionScope.mem_no }</p>
			<p style="margin: 20px;">제목 : &nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="mail_title" name="post_title" style="width: 615px;"></p>
			<p style="margin: 20px;">내용</p><textarea rows="20" cols="100" id="mail_content" name="post_content"></textarea><p>
			<input type="submit" value="확인">
			</form>
		</div>
	</div>
<%@ include file="/WEB-INF/viewpart/footer.jsp"%>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${mail.mail_del }
<div>
	<span>제목 : ${mail.mail_title }</span><p>
	<span>보낸사람 : [${mail.mem_rank}]${mail.mem_name }(${mail.mem_id }@damoware.com)</span><p>
	<span>받는사람 : [${mo.mem_rank }]${mo.mem_name}(${mail.mail_receiver }@damoware.com)</span><p>
	<span>보낸날짜 : ${mail.mail_send_time }</span><p>
	<span>내용 : ${mail.mail_content }</span><p>
	<input type="button" value="목록" onclick="history.back(-1)">
	<form>	
		<input type="button" value="답장" onclick="location.href='mailWrite'">
	</form>
	<form action="eraseMail" method="post">
		<input type="hidden" name="mem_id" value="${member.mem_id }">
		<input type="hidden" name="mail_no" value="${mail.mail_no }">	
		<input type="submit" value="삭제">
	</form>
	<c:if test="${mail.mail_del == 1 }">
	<form action="restoreMail" method="post">
		<input type="hidden" name="mail_no" value="${mail.mail_no }">
		<input type="hidden" name="mem_id" value="${member.mem_id }">
		<input type="submit" value="복구">
	</form>
	<form action="mailDelete" method="post">
		<input type="hidden" name="mail_no" value="${mail.mail_no }">
		<input type="hidden" name="mem_id" value="${member.mem_id }">	
		<input type="submit" value="영구삭제">
	</form>	
	</c:if>
</div>
</body>
</html>
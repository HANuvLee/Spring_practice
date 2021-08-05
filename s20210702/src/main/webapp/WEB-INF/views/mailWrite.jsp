<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>메일 쓰기</h1>
${mo.mem_no }
${mo.mem_id }
${member.mem_id}
<form action="mailSend" method="post">
	<input type="hidden" name="mem_id" value="${mo.mem_id }">
	<input type="hidden" name="mem_no" value="${mo.mem_no }">
	받는사람 : <input type="text" id="mail_receiver" name="mail_receiver"> @ damoware.com<p>
	제목 : <input type="text" id="mail_title" name="mail_title"><p>
	내용 : <textarea rows="20" cols="20" id="mail_content" name="mail_content"></textarea><p>
	첨부파일
	<input type="submit" value="보내기">
</form>
</body>
</html>
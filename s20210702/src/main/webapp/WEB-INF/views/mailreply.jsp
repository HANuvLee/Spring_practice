<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>답장하기</h1>
${sender.mem_id }
${mo.mem_no }
${mo.mem_id }
${member.mem_id} / <a href="main?mem_no=${sessionScope.mem_no }">Go Main</a>
<form action="mailSend" method="post">
	<input type="hidden" name="mem_id" value="${member.mem_id }">
	<input type="hidden" name="mem_no" value="${member.mem_no }">
	받는사람 : <input type="text" id="mail_receiver" name="mail_receiver" value="${sender.mem_id }"> @ damoware.com<p>
	제목 : <input type="text" id="mail_title" name="mail_title"><p>
	내용 : <textarea rows="20" cols="20" id="mail_content" name="mail_content" placeholder="">${mail.mail_content}&#13;&#10;--------------------&#13;&#10;답장 : </textarea><p>
	첨부파일
	<input type="submit" value="보내기">
</form>
</body>
</html>
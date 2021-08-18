<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="mailbox">
	<a id="write" href="mailWrite?mem_id=${member.mem_id}">메일쓰기</a>
	<a id="write" href="mailtome?mem_id=${member.mem_id}">내게쓰기</a>
	<ul id="mailbox1">
		<li><a  href="mailList?mem_id=${member.mem_id }">전체메일함</a></li>
		<li><a  href="rec_mailList?mem_id=${member.mem_id }">받은메일함</a></li> 
		<li><a  href="sen_mailList?mem_id=${member.mem_id }">보낸메일함</a></li> 
		<li><a  href="del_mailList?mem_id=${member.mem_id }">삭제된메일함</a></li>
	</ul>
</div>
</body>
</html>
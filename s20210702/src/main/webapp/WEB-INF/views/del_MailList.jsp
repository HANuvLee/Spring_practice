<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#table {display: table; width: 100%;}
.row {display: table-row;}
.cell {display: table-cell; padding: 3px; border-bottom: 1px solid #DDD;}
.col1 { width: 10%;}
.col2 {width: 60%;}
.col3 {width: 10%;}
.col4 {width: 10%;}
ul li {list-style-type: none;}
</style>
</head>
<body>
${member.mem_id} - ${member.mem_no } - ${member.mem_status}
 <h1>삭제된 메일함</h1>
 <c:set var="num" value="${pg.total-pg.start+1}"></c:set>
<div>
	<a href="mailWrite?mem_id=${member.mem_id}">메일쓰기</a>
	<a href="">내게쓰기</a>
</div>
<div>
 		<ul>
			<li><a href="mailList?mem_id=${member.mem_id }">전체메일함</a></li>
			<li><a href="rec_mailList?mem_id=${member.mem_id }">받은메일함</a></li> 
			<li><a href="sen_mailList?mem_id=${member.mem_id }">보낸메일함</a></li> 
			<li><a href="del_mailList?mem_id=${member.mem_id }">삭제된메일함</a></li>
		</ul>
</div>
<div id="table">
 	<c:forEach var="mail" items="${listMail }">
		<div class="row">
			<span class="cell col1">[${mail.mem_rank}]${mail.mem_name}</span>
			<span class="cell col2"><a href="mailDetail?mail_no=${mail.mail_no }&mail_receiver=${mail.mail_receiver}">[${mail.chk}]${mail.mail_title}</a></span> 
			<span class="cell col3">${mail.mail_send_time }</span>
		</div>
		<c:set var="num" value="${num - 1 }"></c:set>
	</c:forEach>
 </div>
 <c:if test="${pg.startPage > pg.pageBlock }">
	<a href="del_mailList?currentPage=${pg.startPage-pg.pageBlock}&mem_id=${member.mem_id}">[이전]</a>
</c:if>
<c:forEach var="i" begin="${pg.startPage }" end="${pg.endPage }">
	<a href="del_mailList?currentPage=${i}&mem_id=${member.mem_id}">[${i}]</a>
</c:forEach>
<c:if test="${pg.endPage < pg.totalPage }">
	<a href="del_mailList?currentPage=${pg.startPage+pg.pageBlock}&mem_id=${member.mem_id}">[다음]</a>
</c:if>
</body>
</html>
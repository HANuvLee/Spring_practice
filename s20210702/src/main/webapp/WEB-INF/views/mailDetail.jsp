<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<input type="hidden" name="mem_no" value="${no.mem_no }">
<%@ include file="/WEB-INF/viewpart/header.jsp"%>
	<div id="sc_cont_up">
		<div id="writebox">
		<%@ include file="/WEB-INF/viewpart/mailbox.jsp"%>
			<div class="mailbotton1">
			<input type="button" value="목록" onclick="history.back(-1)">
				<form action="replyMail">
					<input type="hidden" name="mail_no" value="${mail.mail_no }">
					<c:if test="${mail.mem_no != member.mem_no }">
						<input type="submit" value="답장">
					</c:if>
				</form>
				<form action="eraseMail" method="post">
					<input type="hidden" name="mem_id" value="${member.mem_id }">
					<input type="hidden" name="mail_no" value="${mail.mail_no }">	
					<c:if test="${mail.mail_del == 0 }">
						<input type="submit" value="삭제">
					</c:if>
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
				<div>
				<p style="padding: 10px;"><span>제목&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${mail.mail_title }</span></p>
				<p style="padding: 10px;"><span>보낸사람 :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; [${mail.mem_rank}]${mail.mem_name }(${mail.mem_id }@damoware.com)</span></p>
				<p style="padding: 10px;"><span>받는사람 :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; [${receiverMember.mem_rank }]${receiverMember.mem_name}(${mail.mail_receiver }@damoware.com)</span></p>
				<p style="padding: 10px;"><span>보낸날짜 :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <fmt:formatDate value="${mail.mail_send_time }" pattern="yyyy-MM-dd  hh:mm" /></span></p>
				
				<p style="padding: 10px;"><c:choose>
					<c:when test="${mailFile.mail_file_no != null}">
						<a href="fileDown?mail_file_no=${mailFile.mail_file_no}">첨부파일: ${mailFile.mail_org_name}</a>
						(${mailFile.mail_file_size}byte)<br>
					</c:when>
					<c:otherwise>
						첨부파일 :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; [없음]
					</c:otherwise>
				</c:choose>
						</p>
				<p style="padding: 10px;"><span>내용 </span></p> 
				<div class="mailcontent">
				${mail.mail_content }
				</div>
				</div>
			
		</div>
	</div>
<%@ include file="/WEB-INF/viewpart/footer.jsp"%>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/mailbox.css">
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
<script type="text/javascript">
	function eraseMail(){
		var chkArray = new Array();
		$("input[id='mail_no[]']:checked").each(function() { 
		      var tmpVal = $(this).val(); 
		      chkArray.push(tmpVal);
		    });
		if( chkArray.length < 1 ){
		      alert("삭제할 메일을 선택해주시기 바랍니다.");
		      return;
		    }
		console.log(chkArray);
		$.ajax({
			url: "http://localhost:8282/s20210702/delArray",
			type: 'get',
			data: {"delArray": chkArray},
			dataType:"json",
			async:false,
			success: function(date) {
				alert(date + "개의 메일이 삭제되었습니다.")
				window.location.reload();
				
			}
		})
	}
</script>
</head>
<body>
${member.mem_id} - ${member.mem_no } - ${member.mem_status} / <a href="main?mem_no=${sessionScope.mem_no }">Go Main</a>
 <h1>받은 메일함</h1>
 <c:set var="num" value="${pg.total-pg.start+1}"></c:set>
<div>
	<a id="write" href="mailWrite?mem_id=${member.mem_id}">메일쓰기</a>
	<a id="write" href="mailtome?mem_id=${member.mem_id}">내게쓰기</a>
	<button id="write" type="button" onclick="eraseMail()">삭제</button>
</div> 
<div id="mailbox">
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
			<span class="cell col1"><input type="checkbox" id="mail_no[]" value="${mail.mail_no }">[${mail.mem_rank}]${mail.mem_name}</span>
			<span class="cell col2"><a class="readed" href="mailDetail?mail_no=${mail.mail_no }&mail_receiver=${mail.mail_receiver}">${mail.mail_title}</a></span> 
			<span class="cell col3"><fmt:formatDate value="${mail.mail_send_time }" pattern="yy-MM-dd  hh:mm" /></span>
		</div>
		<c:set var="num" value="${num - 1 }"></c:set>
	</c:forEach>
 </div>
 <div class="currentpage">
	 <c:if test="${pg.startPage > pg.pageBlock }">
		<a href="rec_mailList?currentPage=${pg.startPage-pg.pageBlock}&mem_id=${member.mem_id}">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${pg.startPage }" end="${pg.endPage }">
		<a class="currentpage1" href="rec_mailList?currentPage=${i}&mem_id=${member.mem_id}">[${i}]</a>
	</c:forEach>
	<c:if test="${pg.endPage < pg.totalPage }">
		<a href="rec_mailList?currentPage=${pg.startPage+pg.pageBlock}&mem_id=${member.mem_id}">[다음]</a>
	</c:if>
</div>
</body>
</html>
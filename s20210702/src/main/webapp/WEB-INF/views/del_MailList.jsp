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
 <h1>삭제된 메일함</h1>
 <c:set var="num" value="${pg.total-pg.start+1}"></c:set>

<div>
       <ul>
         <li><a href="mailList">전체메일함</a></li>
         <li><a href="rec_mailList">받은메일함</a></li> 
         <li><a href="sen_mailList">보낸메일함</a></li> 
         <li><a href="del_mailList">삭제된메일함</a></li>
      </ul>
</div>
<div id="table">
    <c:forEach var="mail" items="${listMail }">
      <div class="row">
         <span class="cell col1">[${mail.mem_rank}]${mail.mem_name}</span>
         <span class="cell col2">${mail.mail_title}</span> 
         <span class="cell col3">${mail.mail_send_time }</span>
      </div>
      <c:set var="num" value="${num - 1 }"></c:set>
   </c:forEach>
 </div>
 <c:if test="${pg.startPage > pg.pageBlock }">
   <a href="delMailList?currentPage=${pg.startPage-pg.pageBlock}">[이전]</a>
</c:if>
<c:forEach var="i" begin="${pg.startPage }" end="${pg.endPage }">
   <a href="delMailList?currentPage=${i}">[${i}]</a>
</c:forEach>
<c:if test="${pg.endPage < pg.totalPage }">
   <a href="delMailList?currentPage=${pg.startPage+pg.pageBlock}">[다음]</a>
</c:if>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html >
<html><head><meta httpr-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/css_main.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<script src="https://kit.fontawesome.com/29ccb048c9.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="resources/css/mailbox.css">
<link rel="stylesheet" href="resources/css/board.css">
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
</head><body>
<div class="body">
<%@ include file="/WEB-INF/viewpart/header.jsp"%>
	<div id="sc_cont_up">
		<div id="sc_cont_ul">


			<c:set var="num" value="${pg.total-pg.start+1}"></c:set>
			<%-- <%-- <table>
				<tr>
				<th><a href="writeForm1">글쓰기</th><th>${sessionScope.mem_no }</th><th><input type="hidden" name="writer_mem_no" value="$sessionScope.mem_no"><input type="hidden" name="board_no" value="1"></th>
				</tr>
				<tr><th >번호</th><th>사번</th><th>제목</th><th>작성시간</th><th>작성내용</th></tr>
				<c:forEach var="bd" items="${listBoard }">
					<tr><td>${num }</td><td>${bd.mem_no }</td>
					<td><a href="content1?board_no=1&post_no=${bd.post_no}">${bd.post_title}</a></td>
						<td>${bd.post_date }</td><td>${bd.post_content }</td></tr>
					<c:set var="num" value="${num - 1 }"></c:set>
				</c:forEach>
			</table> --%>
			<div class="mailbotton">
				<a href="writeForm1">글쓰기</a>
			</div>
			
			<div id="table">
				<div class="row">
						<span class="cell col1">번호</span>
						<span class="cell col2">제목</span> 
						<span class="cell col3">작성시간</span>
				</div>
			 	<c:forEach var="bd" items="${listBoard }">
					<div class="row">
						<span class="cell col1">${num }</span>
						<span class="cell col2"><a href="content1?board_no=1&post_no=${bd.post_no}">${bd.post_title}</a></span> 
						<span class="cell col3"><fmt:formatDate value="${bd.post_date }" pattern="yy-MM-dd  hh:mm" /></span>
					</div>
					<c:set var="num" value="${num - 1 }"></c:set>
				</c:forEach>
			 </div>
			
			<div class="currentpage">
				<c:if test="${pg.startPage > pg.pageBlock }">
					<a href="list?currentPage=${pg.startPage-pg.pageBlock}">[이전]</a>
				</c:if>
				<c:forEach var="i" begin="${pg.startPage}" end="${pg.endPage}">
					<a class="currentpage1" href="list1?currentPage=${i}">[${i}]</a>
				</c:forEach>
				<c:if test="${pg.endPage < pg.totalPage }">
					<a href="list?currentPage=${pg.startPage+pg.pageBlock}">[다음]</a>
				</c:if>
			</div>
		</div>
	</div>
<%@ include file="/WEB-INF/viewpart/footer.jsp"%>
</div>
</body>
</html>
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
<link href="css/app_main.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/scheWriteForm.css">
<script src="https://kit.fontawesome.com/29ccb048c9.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="body">
<c:if test="${sessionScope.mem_no ne null }">
<%@ include file="/WEB-INF/viewpart/header.jsp"%>

	<div id="wmcontainer3">
	<h3>${mo.mem_name}님이 상신한 결재 목록  </h3>
	
	<c:set var="num" value="${pg.total-pg.start+1}"></c:set>

<table>
	
	<tr><th >번호</th><th>사번</th><th>제목</th><th>작성시간</th><th>작성내용</th><th> 결재 상태 설정</th></tr>
	<c:forEach var="appr" items="${listAppr }">
		<tr><td>${num }</td><td>${appr.mem_no }</td>
		<td>${appr.app_doc_title}</td>
			<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${appr.app_doc_date }" /> </td><td>${appr.app_doc_content }</td><td>${appr.app_doc_status }</td></tr>
		<c:set var="num" value="${num - 1 }"></c:set>
	</c:forEach>
</table>
<div class="currentpage">
	<c:if test="${pg.startPage > pg.pageBlock }">
		<a href="app_my_list?mem_no=${mo.mem_no }&currentPage=${pg.startPage-pg.pageBlock}">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${pg.startPage}" end="${pg.endPage}">
		<a href="app_my_list?mem_no=${mo.mem_no }&currentPage=${i}">[${i}]</a>
	</c:forEach>
	<c:if test="${pg.endPage < pg.totalPage }">
		<a href="app_my_list?mem_no=${mo.mem_no }&currentPage=${pg.startPage+pg.pageBlock}">[다음]</a>
	</c:if>
</div>
<p>
<hr>
<p>
<div style="float:right; margin-top:50px;">
<h4><a href="app_my_list2?mem_no=${mo.mem_no}&currentPage=1">${mo.mem_name}님이 결재할 목록</a> </h4>
</div>

	 </div>
   <%@ include file="/WEB-INF/viewpart/footer.jsp"%>
</c:if>
<c:if test="${sessionScope.mem_no eq null }">
<%
	response.sendRedirect("loginForm");
%>
</c:if>	
</div>
</body>
</html>
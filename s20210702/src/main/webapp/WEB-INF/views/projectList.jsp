<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<%@ include file="/WEB-INF/viewpart/header.jsp"%>
	<div id="sc_cont_up">
		<div id="sc_cont_ul">
			<h2>프로젝트 게시판</h2>
			
			<a href="projectWriteForm?mem_no=${sessionScope.mem_no }">글쓰기</a>
			
			<c:set var="num" value="${pg.total-pg.start+1}"></c:set>
			
			<table>
				<tr><th>프로젝트명</th></tr>
				<c:forEach var="listProject" items="${listProject}">
					<tr onclick="location.href='projectContent?board_no=${listProject.board_no }&project_no=${listProject.project_no }&smem_no=${sessionScope.mem_no }&mem_no=${listProject.mem_no }'"><td>${listProject.project_name }</td></tr>
					<tr>
						<td>${listProject.mem_no }</td>
					</tr>
					<tr>
						<td>${listProject.project_no }</td>
					</tr>
					<tr>
						<td>${listProject.project_start }</td>
					</tr>
					<tr>
						<td>${listProject.project_end }</td>
					</tr>
					<tr>
						<td>${listProject.project_company }</td>
					</tr>
					<tr>
						<td>${listProject.project_progress }</td>
					</tr>
				</c:forEach>
			</table>
			
			
			<c:if test="${pg.startPage > pg.pageBlock }">
				<a href="list?currentPage=${pg.startPage-pg.pageBlock}">[이전]</a>
			</c:if>
			<c:forEach var="i" begin="${pg.startPage}" end="${pg.endPage}">
				<a href="list?currentPage=${i}">[${i}]</a>
			</c:forEach>
			<c:if test="${pg.endPage < pg.totalPage }">
				<a href="list?currentPage=${pg.startPage+pg.pageBlock}">[다음]</a>
			</c:if>
		</div>
	</div>
<%@ include file="/WEB-INF/viewpart/footer.jsp"%>
</div>
</body>
</html>
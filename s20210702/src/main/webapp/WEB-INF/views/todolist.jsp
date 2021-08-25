<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
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
<link rel="stylesheet" href="resources/css/mycal.css">
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
</head>
<body>
<div class="body">
<%@ include file="/WEB-INF/viewpart/header.jsp"%>
	<div id="sc_cont_up">
		<div id="sc_cont_ul_sch">

<h3>${mos.mem_name } 님의 ${year_ }년 ${month_ }월 ${day_ }일 일정입니다.</h3>

	<p>총 ${schtot }개의 일정이 있습니다.</p>


<%-- <table border="1">
<tr>
<th>스케쥴 종류</th><th>스케쥴 번호</th><th>스케쥴 이름</th><th>시작일</th><th>스케쥴 종료일</th><th>스케쥴 내용</th><th>스케쥴 삭제</th>
</tr>
<c:forEach var="sch" items="${listSchedule }">
<tr>
<td>${sch.schedule_kind }</td><td>${sch.schedule_no }</td><td>${sch.schedule_name }</td><td>${sch.schedule_start }</td><td>${sch.schedule_end }</td><td>${sch.schedule_content }</td><td><a href="delSche?schedule_no=${sch.schedule_no }&mem_no=${mos.mem_no}">스케쥴삭제신청</a></td>
</tr>
</c:forEach>
</table> --%>
			<div id="table">
				<div class="row1">
					<span class="cell col1">스케줄 이름</span>
					<span class="cell col2">스케줄 내용</span>
					<span class="cell col3">스케줄 시작일</span>
					<span class="cell col4">스케줄 종료일</span>		
					<span class="cell col5">스케줄 삭제</span>
				</div>
				<c:forEach var="sch" items="${listSchedule }">
					<div class="row">
						<span class="cell col1">${sch.schedule_name }</span>
						<span class="cell col2">${sch.schedule_content }</span>
						<span class="cell col3">${sch.schedule_start }</span>
						<span class="cell col4">${sch.schedule_end }</span>
						<span class="cell col5"><a href="delSche?schedule_no=${sch.schedule_no }&mem_no=${mos.mem_no}">스케쥴삭제신청</a></span>
					</div>
				</c:forEach>
				<a class="schwritebtn" href="insertsche?year_=${year_ }&month_=${month_}&day_=${day_}&mem_no=${mos.mem_no}">스케쥴 작성</a>
			</div>
		</div>
	</div>
<%@ include file="/WEB-INF/viewpart/footer.jsp"%>
</div>
</body>
</html>
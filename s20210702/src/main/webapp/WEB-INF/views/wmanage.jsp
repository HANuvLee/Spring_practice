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
<link rel="stylesheet" href="resources/css/wmanage.css">
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
</head>
<body>
<div class="body">
<%@ include file="/WEB-INF/viewpart/header.jsp"%>
	<div id="sc_cont_up">
		<div id="sc_cont_ul">
	<a href="wmanage2?year_=${years }&month_=${months}&day_=${todays}&mem_no=${mo.mem_no}">근태 현황 보기</a>
	<h2>${mo.mem_name }님의 <a href="wmanage?year_=${years }&mem_no=${mo.mem_no}">연차현황</a></h2>
	<table class="table1" border="1px">
		<tr>
			<td colspan="2" style="text-align: center;">${years }년</td>
		</tr>
		<tr>
			<th>총 사용 일수</th><td>${used_vacation }일</td>
		</tr>
			<tr><th>발생 휴가일</th><td>${vtotdays }일</td>
		</tr>
		<tr>
			<th>잔여 휴가일</th><td>${rest_vacation }일</td>
		</tr>
	</table>
	<p>
	<table class="table2" border="1px">
		<thead>
			<th>상태</th><th>해당연도</th><th>유형</th><th>사용일수</th><th>시작일</th><th>종료일</th><th>승인일시</th>
		</thead>
		<tbody>
		
		<c:forEach var="sch" items="${listSchedule }">
		<tr>
			<td>승인</td><td>${years}</td><td> 연차휴가</td><td>${sch.vday }일</td><td>${sch.schedule_start }</td><td>${sch.schedule_end }</td><td>승인일시</td>
		</tr>
		</c:forEach>
		
		
		
		</tbody>
	
	</table>
		</div>
	</div>
<%@ include file="/WEB-INF/viewpart/footer.jsp"%>
</div>
</body>
</html>
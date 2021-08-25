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
<link rel="stylesheet" href="resources/css/wmanage2.css">
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
</head>
<body>
<div class="body">
<%@ include file="/WEB-INF/viewpart/header.jsp"%>
	<div class="realbody_space">

	<div class="main_text_box">
	<span class="title_text1">${mo.mem_name }님의 <a  class="title_text2" href="wmanage2?year_=${years }&month_=${months}&day_=${todays}&mem_no=${mo.mem_no}">근태 현황</a></span>
	<span class="title_text3"><a class="title_text4" href="wmanage?year_=${years }&mem_no=${mo.mem_no}">연차현황 바로가기</a></span>
	</div>

	<div class="left_box">
	<h4 class="t1capt">[${years }년 ${months }월 ${todays }일  (${what_week }주차)]</h4>
	<table class="table1">
		<tr class="t1tr2f">
		<th class="t1th2">출근 시간</th><td class="t1td2"><fmt:formatDate pattern="HH시mm분ss초" value="${wm.work_in_time }"/> </td>
		</tr>
		<tr class="t1tr2">
		<th class="t1th2">근무 시간 </th><td class="t1td2">${wm3.worktime_hh }시간 ${wm3.worktime_mi }분 ${wm3.worktime_hh }초동안 근무중<p><fmt:formatDate pattern="HH:mm:ss" value="${wm3.sysdate}"/> 기준</td>
		</tr>
		<tr class="t1tr2">
		<th class="t1th2">퇴근 시간</th><td class="t1td2"><fmt:formatDate pattern="HH시mm분ss초" value="${wm.work_out_time }"/></td>
		</tr>
		<tr class="t1tr2">
		<th class="t1th2">근무 일수(weekly)</th><td class="t1td2">${wm2.work_day_cnt }일</td>
		</tr>
		<tr class="t1tr2">
		<th class="t1th2">평균 근무 시간(weekly)</th><td class="t1td2">${wm2.work_time_avg }시간</td>
		</tr>
		
	</table>
	</div>
	<div class="right_box">
	<h3 class="t2capt">[금주 출/퇴근 현황]</h3>
	<table class="table2">
		<tr class="t2tr1">
			<th class="t2td1 col21">날짜</th><th class="t2td1 col22">요일</th><th class="t2td1 col23">출근시간</th><th class="t2td1 col24">퇴근시간</th><th class="t2td1 col25">근무시간</th><th class="t2td1 col26">시간외 근무 시간</th><th class="t2td1 col27">상태</th>
		</tr>
		<tbody>
		
		<c:forEach var="wmw" items="${WMWeekList }">
		<tr class="t2tr2">
			<td class="t2td2">${wmw.years_}년${wmw.months_}월${wmw.days_}일</td>
			<c:choose>
			<c:when test="${wmw.day_nos_ ==1}"><td class="t2td2">일요일</td></c:when>
			<c:when test="${wmw.day_nos_ ==2}"><td class="t2td2">월요일</td></c:when>
			<c:when test="${wmw.day_nos_ ==3}"><td class="t2td2">화요일</td></c:when>
			<c:when test="${wmw.day_nos_ ==4}"><td class="t2td2">수요일</td></c:when>
			<c:when test="${wmw.day_nos_ ==5}"><td class="t2td2">목요일</td></c:when>
			<c:when test="${wmw.day_nos_ ==6}"><td class="t2td2">금요일</td></c:when>
			<c:when test="${wmw.day_nos_ ==7}"><td class="t2td2">토요일</td></c:when>
			</c:choose>
			
			<td class="t2td2"> <fmt:formatDate pattern="HH시mm분ss초" value="${wmw.work_in_time }"/></td>
			<td class="t2td2"><fmt:formatDate pattern="HH시mm분ss초" value="${wmw.work_out_time }"/></td>
			<td class="t2td2"><c:if test="${wmw.worktime_full eq 0 }"> - </c:if> <c:if test="${wmw.worktime_full > 0 }"><c:choose><c:when test="${wmw.worktime_hh>3 }">${wmw.worktime_hh -1}</c:when><c:when test="${wmw.worktime_hh<4 }">${wmw.worktime_hh }</c:when></c:choose>시간${wmw.worktime_mi }분${wmw.worktime_ss }초</c:if></td>
			<td class="t2td2"><c:choose><c:when test="${wmw.daily_overtime_full >0}">${wmw.daily_overtime_hh }시${wmw.daily_overtime_mi }분${wmw.daily_overtime_ss }초</c:when><c:when test="${wmw.daily_overtime_full<=0 }">-</c:when></c:choose></td>
			<td class="t2td2">
			<c:if test="${wmw.worktime_full eq 0 }">정상 근무중</c:if><c:if test="${wmw.worktime_full > 0 }"><c:choose><c:when test="${wmw.daily_overtime_full >3000}"> 초과 근무</c:when><c:when test="${wmw.daily_overtime_full >=0}"> 정시 퇴근</c:when><c:when test="${wmw.daily_overtime_full <0}"> 조퇴</c:when></c:choose></c:if>
			</td>
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
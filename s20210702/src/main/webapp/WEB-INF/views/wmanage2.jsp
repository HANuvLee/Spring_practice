<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="main?mem_no=${mo.mem_no }">Go Main</a> / <a href="wmanage?year_=${years }&mem_no=${mo.mem_no}">연차현황 보기</a>
	<h2>${mo.mem_name }님의 <a href="wmanage2?year_=${years }&month_=${months}&day_=${todays}&mem_no=${mo.mem_no}">근태 현황</a></h2>
	<h3>${years }년 ${months }월 ${todays }일  (${what_week }주차)</h3>
	<table border="1px">
		<tr>
		<th>금일 출근 시간</th><th>금일 근무 시간 </th><th>금일 퇴근 시간</th><th>금주 근무 일수</th><th>금주 평균 근무 시간</th>
		</tr>
		<tr>
		<td><fmt:formatDate pattern="HH시mm분ss초" value="${wm.work_in_time }"/> </td><td>${wm3.worktime_hh }시간 ${wm3.worktime_mi }분 ${wm3.worktime_hh }초동안 근무중<p><fmt:formatDate pattern="HH:mm:ss" value="${wm3.sysdate}"/> 기준</td><td><fmt:formatDate pattern="HH시mm분ss초" value="${wm.work_out_time }"/></td><td>${wm2.work_day_cnt }일</td><td>${wm2.work_time_avg }시간</td>
		</tr>
	</table>
	<p>
	<h3>금주 출/퇴근 현황</h3>
	<table border="1px">
		<thead>
			<th>날짜</th><th>요일</th><th>출근시간</th><th>퇴근시간</th><th>근무시간</th><th>시간외 근무 시간</th><th>상태</th>
		</thead>
		<tbody>
		
		<c:forEach var="wmw" items="${WMWeekList }">
		<tr>
			<td>${wmw.years_}년${wmw.months_}월${wmw.days_}일</td>
			<c:choose>
			<c:when test="${wmw.day_nos_ ==1}"><td>일요일</td></c:when>
			<c:when test="${wmw.day_nos_ ==2}"><td>월요일</td></c:when>
			<c:when test="${wmw.day_nos_ ==3}"><td>화요일</td></c:when>
			<c:when test="${wmw.day_nos_ ==4}"><td>수요일</td></c:when>
			<c:when test="${wmw.day_nos_ ==5}"><td>목요일</td></c:when>
			<c:when test="${wmw.day_nos_ ==6}"><td>금요일</td></c:when>
			<c:when test="${wmw.day_nos_ ==7}"><td>토요일</td></c:when>
			</c:choose>
			
			<td> <fmt:formatDate pattern="HH시mm분ss초" value="${wmw.work_in_time }"/></td><td><fmt:formatDate pattern="HH시mm분ss초" value="${wmw.work_out_time }"/></td><td><c:if test="${wmw.worktime_full eq 0 }"> - </c:if> <c:if test="${wmw.worktime_full > 0 }"><c:choose><c:when test="${wmw.worktime_hh>3 }">${wmw.worktime_hh -1}</c:when><c:when test="${wmw.worktime_hh<4 }">${wmw.worktime_hh }</c:when></c:choose>시간${wmw.worktime_mi }분${wmw.worktime_ss }초</c:if></td><td><c:choose><c:when test="${wmw.daily_overtime_full >0}">${wmw.daily_overtime_hh }시${wmw.daily_overtime_mi }분${wmw.daily_overtime_ss }초</c:when><c:when test="${wmw.daily_overtime_full<=0 }">-</c:when></c:choose></td>
			<td>
			<c:if test="${wmw.worktime_full eq 0 }">정상 근무중</c:if><c:if test="${wmw.worktime_full > 0 }"><c:choose><c:when test="${wmw.daily_overtime_full >3000}"> 초과 근무</c:when><c:when test="${wmw.daily_overtime_full >=0}"> 정시 퇴근</c:when><c:when test="${wmw.daily_overtime_full <0}"> 조퇴</c:when></c:choose></c:if>
			</td>
		</tr>
		</c:forEach>
		
		
		
		</tbody>
	
	</table>
</body>
</html>
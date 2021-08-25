<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/MyCal.css?ver=1" rel="stylesheet" type="text/css">
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
		<div id="mycal">
<div class="calaside">
<h2>${mos.mem_name }님의 ${caltoday.month_+1 }월 일정</h2>
<p>
<c:forEach var="test1" items="${callistall}">
<c:if test="${test1.todocnt != 0 }">
${test1.day_ }일 :
<c:forEach var="scheoncal" items="${test1.lishe }" varStatus="sno">
<span> ${scheoncal.schedule_name} <p> </span> 
<fmt:parseDate value='${scheoncal.schedule_start}' var='schedule_start' pattern="yyyy-MM-dd HH:mm:ss" /> 
<fmt:formatDate value="${schedule_start}" pattern="MM-dd HH:mm"/>  ~ 
<fmt:parseDate value='${scheoncal.schedule_end}' var='schedule_end' pattern="yyyy-MM-dd HH:mm:ss" /> 
<fmt:formatDate value="${schedule_end}" pattern="MM-dd HH:mm"/>
<p>
</c:forEach> 

 <br>
</c:if>

</c:forEach><p>
</div>

<table class="main_cal_table" >
	<thead>
		<tr>
			<th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>
		</tr>
	</thead>
<tbody>
	<tr>
		<c:forEach var="cal" items="${callistall }">
		
			<c:choose>
				<c:when test="${cal.day_ == caltoday.today_ and cal.month_ == caltoday.month_ and cal.year_ == caltoday.year_}">
					<td class="today">
					<a href="todolist?year_=${cal.year_ }&month_=${cal.month_ +1}&day_=${cal.day_}&mem_no=${mos.mem_no}">${cal.day_ } 오늘</a>
					<br>
					<c:forEach var="scheoncal" items="${cal.lishe }" varStatus="sno">
						<span>${sno.count }. ${scheoncal.schedule_name}  </span> <br>
					</c:forEach>
					
					</td>
					</c:when> 
				<c:when test="${cal.day_no ==1 }">
					<td class="sunday">
					<a href="todolist?year_=${cal.year_ }&month_=${cal.month_ +1}&day_=${cal.day_}&mem_no=${mos.mem_no}">${cal.day_ }</a>
					<br>
					<c:forEach var="scheoncal" items="${cal.lishe }" varStatus="sno">
						<span>${sno.count }. ${scheoncal.schedule_name}  </span> <br>
					</c:forEach>
					
					</td>
				</c:when>
				<c:when test="${cal.day_no == 7 }">
					<td class="saturday">
					<a href="todolist?year_=${cal.year_ }&month_=${cal.month_ +1}&day_=${cal.day_}&mem_no=${mos.mem_no}">${cal.day_ } </a>
					<br>
					<c:forEach var="scheoncal" items="${cal.lishe }" varStatus="sno">
						<span>${sno.count }. ${scheoncal.schedule_name}  </span> <br>
					</c:forEach>
					
					</td>
					</tr><tr>
					</c:when>
					<c:when test="${cal.todocnt != 0}">
					<td class="tododay">
					<a href="todolist?year_=${cal.year_ }&month_=${cal.month_ +1}&day_=${cal.day_}&mem_no=${mos.mem_no}">${cal.day_ }</a>
					<br>
					<c:forEach var="scheoncal" items="${cal.lishe }" varStatus="sno">
						<span>${sno.count }. ${scheoncal.schedule_name}  </span> <br>
					</c:forEach>
					
					
					</td>
					</c:when> 
					<c:otherwise>
					<td class="normalday">
					<a href="todolist?year_=${cal.year_ }&month_=${cal.month_ +1}&day_=${cal.day_}&mem_no=${mos.mem_no}">${cal.day_ }</a>
					<br>
					<c:forEach var="scheoncal" items="${cal.lishe }" varStatus="sno">
						<span>${sno.count }. ${scheoncal.schedule_name}  </span> <br>
					</c:forEach>
					
					
					</td>
					</c:otherwise>
			</c:choose>
		
		</c:forEach>
	</tr>
</tbody>
</table>
		</div>
	</div>
<%@ include file="/WEB-INF/viewpart/footer.jsp"%>
</div>
</body>
</html>
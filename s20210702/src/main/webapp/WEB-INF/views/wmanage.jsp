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
	<div class="realbody_space">

	<div class="main_text_box">
	<span class="title_text1">${mo.mem_name }님의 <a class="title_text2" href="wmanage?year_=${years }&mem_no=${mo.mem_no}">연차현황</a></span>
	<span class="title_text3"><a class="title_text4" href="wmanage2?year_=${years }&month_=${months}&day_=${todays}&mem_no=${mo.mem_no}">근태 현황 바로가기</a></span>
	</div>
	<div class="left_box">
		<table class="table1">
		<tr>
			<td class="t1td1" colspan="2" style="text-align: center;">[${years }년 연차 요약] </td>
		</tr>
		<tr class="t1tr2">
			<th  class="t1td2">총 사용 일수</th><td  class="t1td2">${used_vacation }일</td>
		</tr>
			<tr class="t1tr2"><th  class="t1td2">발생 휴가일</th><td  class="t1td2">${vtotdays }일</td>
		</tr>
		<tr class="t1tr2">
			<th  class="t1td2">잔여 휴가일</th><td  class="t1td2">${rest_vacation }일</td>
		</tr>
	</table>
	
	</div>
	<div class="right_box">
	<h4 class="t2capt">[연차 상세 내역]</h4>
	<table class="table2" border="1px">
		<thead class="t2tr1">
			<th class="t2td1 col21">상태</th><th class="t2td1 col22">해당연도</th><th class="t2td1 col23">유형</th><th class="t2td1 col24">사용일수</th><th class="t2td1 col25">시작일</th><th class="t2td1 col26">종료일</th><th class="t2td1 col27">승인일시</th>
		</thead>
		<tbody>
		
		<c:forEach var="sch" items="${listSchedule }">
		<tr class="t2tr2">
			<td class="t2td2 col21">승인</td><td class="t2td2 col22">${years}</td><td class="t2td2 col23"> 연차휴가</td><td class="t2td2 col24">${sch.vday }일</td><td class="t2td2 col25">${sch.schedule_start }</td><td class="t2td2 col26">${sch.schedule_end }</td><td class="t2td2 col27">승인일시</td>
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
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

</head>
<body>
<h2>ToDoList</h2> <a href="mycal?mem_no=${mos.mem_no }">뒤로</a> / <a href="insertsche?year_=${year_ }&month_=${month_}&day_=${day_}&mem_no=${mos.mem_no}">스케쥴 작성</a>
<h3>${mos.mem_name } 님의 ${year_ }년 ${month_ }월 ${day_ }일 일정입니다.</h3>

	총 ${schtot }개의 일정이 있습니다.


<table border="1">
<tr>
<th>스케쥴 종류</th><th>스케쥴 번호</th><th>스케쥴 이름</th><th>시작일</th><th>스케쥴 종료일</th><th>스케쥴 내용</th><th>스케쥴 삭제</th>
</tr>
<c:forEach var="sch" items="${listSchedule }">
<tr>
<td>${sch.schedule_kind }</td><td>${sch.schedule_no }</td><td>${sch.schedule_name }</td><td>${sch.schedule_start }</td><td>${sch.schedule_end }</td><td>${sch.schedule_content }</td><td><a href="delSche?schedule_no=${sch.schedule_no }&mem_no=${mos.mem_no}">스케쥴삭제신청</a></td>
</tr>
</c:forEach>
</table>


</body>
</html>
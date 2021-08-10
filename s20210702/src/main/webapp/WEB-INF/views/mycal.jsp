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
<h2>My Cal</h2>
${caltoday.month_+1 }월 일정<p>
<c:forEach var="test1" items="${callistall}">
<c:if test="${test1.todocnt != 0 }">
${test1.day_ }일 : ${test1.todocnt }개 일정 있음. <br>
</c:if>

</c:forEach><p>


<table border="1px">
	<thead>
		<tr>
			<th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>
		</tr>
	</thead>
<tbody>
	<tr>
		<c:forEach var="cal" items="${callistall }">
		
			<c:choose>
				<c:when test="${cal.day_no ==1 }">
					<td>
					<a href="todolist?year_=${cal.year_ }&month_=${cal.month_ +1}&day_=${cal.day_}&mem_no=${mos.mem_no}">${cal.day_ } 일요일</a>
					<br>
					<c:if test="${cal.todocnt != 0  }">${cal.todocnt }개 일정 있음!!</c:if>
					<c:if test="${cal.todocnt == 0  }">일정 없음!</c:if>
					</td>
				</c:when>
				<c:when test="${cal.day_no == 7 }">
					<td>
					<a href="todolist?year_=${cal.year_ }&month_=${cal.month_ +1}&day_=${cal.day_}&mem_no=${mos.mem_no}">${cal.day_ } 토요일</a>
					<br>
					<c:if test="${cal.todocnt != 0  }">${cal.todocnt }개 일정 있음!!</c:if>
					<c:if test="${cal.todocnt == 0  }">일정 없음!</c:if>
					
					</td>
					</tr><tr>
				</c:when>
					<c:otherwise>
					<td>
					<a href="todolist?year_=${cal.year_ }&month_=${cal.month_ +1}&day_=${cal.day_}&mem_no=${mos.mem_no}">${cal.day_ } 평일</a>
					<br>
					<c:if test="${cal.todocnt != 0  }">${cal.todocnt }개 일정 있음!!</c:if>
					<c:if test="${cal.todocnt == 0  }">일정 없음!</c:if>
					
					</td>
					</c:otherwise>
			</c:choose>
		
		</c:forEach>
	</tr>
</tbody>
</table>
<a href="main?mem_no=${mos.mem_no }">Go Home</a>
</body>
</html>
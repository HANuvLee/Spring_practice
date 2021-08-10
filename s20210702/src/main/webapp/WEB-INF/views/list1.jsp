<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html >
<html><head><meta httpr-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title></head><body>


<c:set var="num" value="${pg.total-pg.start+1}"></c:set>
<h2><a href="main?mem_no=${sessionScope.mem_no }">Main</a></h2>
<table>
	<tr>
	<th><a href="writeForm1">글쓰기</th><th>${sessionScope.mem_no }</th><th><input type="hidden" name="writer_mem_no" value="$sessionScope.mem_no"><input type="hidden" name="board_no" value="1"></th>
	</tr>
	<tr><th >번호</th><th>사번</th><th>제목</th><th>작성시간</th><th>작성내용</th></tr>
	<c:forEach var="bd" items="${listBoard }">
		<tr><td>${num }</td><td>${bd.mem_no }</td>
		<td><a href="content1?board_no=1&post_no=${bd.post_no}">${bd.post_title}</a></td>
			<td>${bd.post_date }</td><td>${bd.post_content }</td></tr>
		<c:set var="num" value="${num - 1 }"></c:set>
	</c:forEach>
</table>
<c:if test="${pg.startPage > pg.pageBlock }">
	<a href="list?currentPage=${pg.startPage-pg.pageBlock}">[이전]</a>
</c:if>
<c:forEach var="i" begin="${pg.startPage}" end="${pg.endPage}">
	<a href="list1?currentPage=${i}">[${i}]</a>
</c:forEach>
<c:if test="${pg.endPage < pg.totalPage }">
	<a href="list?currentPage=${pg.startPage+pg.pageBlock}">[다음]</a>
</c:if>
</body>
</html>
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
${mo.mem_id}
<c:if test="${k >= 0 }">
<form action="sen_mailList" method="post">
	<input type="hidden" name="mem_id" value="${mo.mem_id}">
	<h1>메일 전송에 성공하였습니다.</h1>
	<input type="submit" value="확인">
</form>
</c:if>
<c:if test="${k < 0 }">
<form action="mailWrite">
	<input type="hidden" name="mem_id" value="${mo.mem_id}">
	<h1>메일 전송에 실패하였습니다. 상대방 이메일을 확인하세요</h1>
	<input type="submit" value="확인">
</form>
</c:if>
</body>
</html>
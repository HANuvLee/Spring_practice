<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>일반 게시판</h2> 
<form action="write1" method="post">
  <input type="hidden" name="mem_no" value="${sessionScope.mem_no }">
  <input type="hidden" name="post_no" value="${post_no }">
  <table>  
	
	<tr><th>사번</th><td>${sessionScope.mem_no }</td></tr>
	<tr><th>제목</th><td><input type="text" name="post_title"></td></tr>
	<tr><th>내용</th><td><textarea cols="30" rows="5" name="post_content">post_no=${post_no }</textarea></td></tr>
	<tr><td colspan="2">
	   <input type="submit" value="확인">
	   </td>
	</tr>
</table>
</form>

</body>
</html>
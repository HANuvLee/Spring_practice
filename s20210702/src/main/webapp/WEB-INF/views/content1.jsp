<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title></head><body>
<h2>일반 게시판</h2> 
<table>
	<tr><th>사번</th><td>${board.mem_no }</td></tr>
	<tr><th>제목</th><td>${board.post_title }</td></tr>
	<tr><th>업로드일시</th><td>${board.post_date }</td></tr>
	<tr><th>내용</th><td>${board.post_content }</td></tr>
	<tr><td colspan="2">
	    <input type="button" value="목록" 
			onclick="location.href='list1'">
		<input type="button" value="수정" 
			onclick="location.href='updateForm?board_no=1&post_no=${board.post_no}'">
		<input type="button" value="삭제" 
			onclick="location.href='delete1?board_no=1&post_no=${board.post_no}'"></td></tr>
</table>
</body>
</html>
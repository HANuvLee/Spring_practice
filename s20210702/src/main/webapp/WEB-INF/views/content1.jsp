<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/css_main.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<script src="https://kit.fontawesome.com/29ccb048c9.js" crossorigin="anonymous"></script>
<!-- <link rel="stylesheet" href="resources/css/mailbox.css"> -->
<link rel="stylesheet" href="resources/css/board.css">
<link rel="stylesheet" href="resources/css/content1.css">
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
</head><body>

<div class="body">
<%@ include file="/WEB-INF/viewpart/header.jsp"%>
	<div id="sc_cont_up">
		<div id="sc_cont_ul">	 
			<%-- <table>
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
			</table> --%>	
			<div id="contenttable"> 
				<div class="row">		
					<span class="cell col1">제목 </span>
					<span class="cell col2"> ${board.post_title }</span>
				</div>		
				<div class="row2">
					<span class="cell col1">작성일시 </span>
					<span class="cell col2"> <fmt:formatDate value="${board.post_date }" pattern="yyyy-MM-dd  hh:mm" /></span>
				</div>
				<div class="row3">
					<span class="cell col1">작성자</span>
					<span class="cell col2">${board.mem_name}</span>
				</div>
				<div class="postcontent">
					<span class="content">${board.post_content }</span>
				</div>
			</div>
				<div class="items">
					<input type="button" class="button" value="목록" onclick="location.href='list1'">
					<input type="button" class="button" value="수정" onclick="location.href='updateForm?board_no=1&post_no=${board.post_no}'">
					<input type="button" class="button" value="삭제" onclick="location.href='delete1?board_no=1&post_no=${board.post_no}'">
				</div>
			</div>
		</div>
<%@ include file="/WEB-INF/viewpart/footer.jsp"%>
</div>
</body>
</html>
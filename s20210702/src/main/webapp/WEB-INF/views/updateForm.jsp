<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/css_main.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<script src="https://kit.fontawesome.com/29ccb048c9.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="resources/css/mailbox.css">
<link rel="stylesheet" href="resources/css/board.css">
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
</head>
<body>

<div class="body">
<%@ include file="/WEB-INF/viewpart/header.jsp"%>
	<div id="sc_cont_up">
		<div id="sc_cont_ul">
			<h2>일반 게시판</h2> 
			<form action="update1?board_no=${board_no }&post_no=${board.post_no }" method="get">
			  <input type="hidden" name="board_no" value="${board.board_no}">
			  <input type="hidden" name="post_no" value="${board.post_no}"> 
			  
			  <table>  
				
				<tr><th>사번</th><td>${board.mem_no }</td></tr>
				<tr><th>제목</th><td><input type="text" name="post_title" value="${board.post_title }"></td></tr>
				<tr><th>업로드일시</th><td>${board.post_date }</td></tr>
				<tr><th>내용</th><td><textarea cols="30" rows="5" name="post_content">${board.post_content }</textarea></td></tr>
				
				
				<tr><td colspan="2">
				   <input type="submit" value="확인">
				   </td>
				</tr>
			</table>
			</form>
		</div>
	</div>
<%@ include file="/WEB-INF/viewpart/footer.jsp"%>
</div>
</body>
</html>
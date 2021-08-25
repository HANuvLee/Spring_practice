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
<link rel="stylesheet" href="resources/css/updateform.css">
<link rel="stylesheet" href="resources/css/board.css">
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
</head>
<body>

<div class="body">
<%@ include file="/WEB-INF/viewpart/header.jsp"%>
	<div id="sc_cont_up">
		<div id="sc_cont_ul">
			<form action="update1?board_no=${board_no }&post_no=${board.post_no }" method="get">
			  <input type="hidden" name="board_no" value="${board.board_no}">
			  <input type="hidden" name="post_no" value="${board.post_no}"> 
			  <div class="table">
				  	<div class="header">
		
				  	</div>
				  	<div class="row">  
						<span class="cell col1">
							제목	
						</span>
						<span class="cell col2">
							<input type="text" name="post_title" class="post_title" placeholder="제목을 입력하세요.">
						</span>
					</div>
					<div class="row2">
						<span class="cell col1">
							내용
						</span>
						<span class="cell col2"> 
							<input type="text" class="post_content" name="post_content" placeholder="내용을 입력하세요.">
						</span>				
					</div>
			   </div>
			   <div class="items">
					<input type="submit" class="button" value="확인">
				</div>
			</form>
		</div>
	</div>
<%@ include file="/WEB-INF/viewpart/footer.jsp"%>
</div>
</body>
</html>
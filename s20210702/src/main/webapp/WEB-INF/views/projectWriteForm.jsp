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
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
</head>
<body>
	<div class="body">
		<%@ include file="/WEB-INF/viewpart/header.jsp"%>
			<div id="writebox">
				<div>
				<form action="projectWrite1" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
					<input type="hidden" name="mem_no" value="${sessionScope.mem_no }">
					<input type="hidden" name="project_no" value="${project_no }">
					<p>프로젝트명<input type="text" id="project_name" name="project_name" ></p>
					<p>시작날짜<input type="date" id="project_start" name="project_start"></p>
					<p>종료날짜<input type="date" id="project_end" name="project_end"></p>
					<p>예상비용<input type="number" id="project_excost" name="project_excost"></p>
					<p>실제비용<input type="number" id="project_realcost" name="project_realcost"></p>
					<p>회사명<input type="text" id="project_company" name="project_company"></p>
					<p>진행상황<input type="text" id="project_progress" name="project_progress"></p>
					<h5>첨부파일</h5>
					<input type="file" id="file" name="file1"> 
					<input type="hidden" name="path" value="${pageContext.request.contextPath}/resources/img/">
					<input type="submit" value="등록">
				</form>
			</div>
		</div>
	</div>
</body>
</html>
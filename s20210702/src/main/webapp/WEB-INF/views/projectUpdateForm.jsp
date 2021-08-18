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
	<div id="sc_cont_up">
		<div id="sc_cont_ul">
			<h2>프로젝트 수정</h2>
			
			<form action="projectUpdate" method="post">
				<input type="hidden" name="mem_no" value="${sessionScope.mem_no }">
				<input type="hidden" name="project_no" value="${project.project_no}">
			<table>
			
			<tr><th>프로젝트명</th><td>${project.project_name}</td></tr>
			
			<tr><th>시작날짜</th><td><input type="date" name="project_start" value="${project.project_start}"></td></tr>
			<tr><th>종료날짜</th><td><input type="date" name="project_end" value="${project.project_end}"></td></tr>
			
			<tr><th>예상비용</th><td><input type="number" name="project_excost" value="${project.project_excost }"></td></tr>
			<tr><th>실제비용</th><td><input type="number" name="project_realcost" value="${project.project_realcost}"></td></tr>
			
			<tr><th>회사명</th><td>${project.project_company}</td></tr>
			<tr><th>진행상황</th><td><input type="text" name="project_progress" value="${project.project_progress }"></td></tr>
			
			
				<tr><td colspan = "1"><input type="submit" value="수정">
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
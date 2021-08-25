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
		<div id="sc_cont_ul123">
			<form action="projectUpdate" method="post">
				<input type="hidden" name="mem_no" value="${sessionScope.mem_no }">
				<input type="hidden" name="project_no" value="${project.project_no}">
			<div class="table">
				<div class="header"></div>
					<div class="row">
						<span class="cell col1">프로젝트명</span>
						<span class="cell col2">${project.project_name}</span>
					</div>
					<div class="row2">
						<span class="cell col1">시작날짜</span>
						<span class="cell col2">
							<input type="date" name="project_start" value="${project.project_start}">
						</span>
					</div>
					<div class="row3">
						<span class="cell col1">종료날짜</span>
						<span class="cell col2">
							<input type="date" name="project_end" value="${project.project_end}">
						</span>
					</div>
					<div class="row4">
						<span class="cell col1">예상비용</span>
						<span class="cell col2">
							<input type="number" name="project_excost" value="${project.project_excost }">
						</span>
					</div>
					<div class="row5">
						<span class="cell col1">실제비용</span>
						<span class="cell col2">
							<input type="number" name="project_realcost" value="${project.project_realcost}"></td></tr>
						</span>
					</div>
					<div class="row6">
						<span class="cell col1">회사명</span>
						<span class="cell col2">${project.project_company}</span>
					</div>
					<div class="row7">
						<span class="cell col1">진행상황</span>
						<span class="cell col2">
							<input type="text" name="project_progress" value="${project.project_progress }">
						</span>
					</div>
				</div>
					<div>
						<input type="submit" value="수정">
					</div>
					</form>
				</div>
			</div>
<%@ include file="/WEB-INF/viewpart/footer.jsp"%>
</div>
</body>
</html>
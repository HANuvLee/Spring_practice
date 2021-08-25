<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/css_main.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<script src="https://kit.fontawesome.com/29ccb048c9.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="resources/css/pjwriteform.css">
<script
	src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
</head>
<body>
	<div class="body">
		<%@ include file="/WEB-INF/viewpart/header.jsp"%>
		<div id="sc_pj_cont_up">
			<div id="sc_cont_ul">
				<div class="header">
					<div class="table">
						<form  class="pjwriteform" action="projectWrite1" method="post"
							enctype="multipart/form-data" accept-charset="UTF-8">
							<input type="hidden" name="mem_no" value="${sessionScope.mem_no }">
							<input type="hidden" name="project_no" value="${project_no }">
							<div class="row">
								<span class="cell col1">프로젝트명</span>
								<span class="cell col2">
									<input type="text" id="project_name" name="project_name">
								</span>
							</div>
							<div class="row2">
								<span class="cell col1">시작날짜</span>
								<span class="cell col2">
									<input type="date" id="project_start" name="project_start">
								</span>
							</div>
							<div class="row3">
								<span class="cell col1">종료날짜</span>
								<span class="cell col2">
									<input type="date" id="project_end" name="project_end">
								</span>
							</div>
							<div class="row4">
								<span class="cell col1">예상비용</span>
								<span class="cell col2">
									<input type="number" id="project_excost" name="project_excost">
								</span>
							</div>
							<div class="row5">
								<span class="cell col1">실제비용</span>
								<span class="cell col2">
									<input type="number" id="project_realcost" name="project_realcost">
								</span>
							</div>
							<div class="row6">
								<span class="cell col1">회사명</span> 
								<span class="cell col2">
									<input type="text" id="project_company" name="project_company">
								</span>
							</div>
							<div class="row7">
								<span class="cell col1">진행상황</span>
								<span class="cell col2">
									<input type="text" id="project_progress" name="project_progress">
								</span>
							</div>
							<div class="file">
								<h5>첨부파일</h5>
								<input type="file" id="file" name="file1"> 
								<input type="hidden" class="path" name="path" value="${pageContext.request.contextPath}/resources/img/">
							</div>
							<div class="items">
								<input type="submit" class="button" value="등록">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
<%@ include file="/WEB-INF/viewpart/footer.jsp"%>
</div>
</body>
</html>
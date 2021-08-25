<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/css_main.css" rel="stylesheet">
<link href="resources/css/projectContent.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<script src="https://kit.fontawesome.com/29ccb048c9.js" crossorigin="anonymous"></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
</head>

<body>
<div class="body">
<%@ include file="/WEB-INF/viewpart/header.jsp"%>
	<div id="sc_cont_up">
		<div id="sc_cont_ul">
			<h4 class="bigtitle">프로젝트</h4> 
				<h3 class="smalltitle">${project.project_name}</h3>
				<c:choose>
					<c:when test="${pjteam.team_no == pjwrite.team_no }">
						<div id="projectContTable">
							<div class="row">
								<span class="cell col1">프로젝트 번호</span>
								<span class="cell col2">${project.project_no }</span>
								<span class="cell col3">시작날짜</span>
								<span class="cell col4">
									<fmt:parseDate value='${project.project_start}' var='project_start' pattern="yyyy-MM-dd HH:mm:ss" /> 
 									<fmt:formatDate value="${project_start}" pattern="yyyy-MM-dd"/>
								</span>
							</div>
							<div class="row2">
								<span class="cell col1">회사명</span>
								<span class="cell col2">${project.project_name }</span>
								<span class="cell col3">종료날짜</span>
								<span class="cell col4">
									<fmt:parseDate value='${project.project_end}' var='project_end' pattern="yyyy-MM-dd HH:mm:ss" /> 
 									<fmt:formatDate value="${project_end}" pattern="yyyy-MM-dd"/>
								</span>
							</div>
							<div class="row3">
								<span class="cell col1">담당자</span>
								<span class="cell col2">${pjwrite.mem_name}[${project.mem_no }]</span>
								<span class="cell col3">진행상황</span>
								<span class="cell col4">${project.project_progress }</span>
							</div>
							<div class="row4">
								<span class="cell col1">예상비용</span>
								<span class="cell col2">${project.project_excost }</span>
								<span class="cell col3">실제비용</span>
								<span class="cell col4">${project.project_realcost }</span>
							</div>
							<div class="filedown">
								<c:if test="${projectFile.mail_file_no != null}">
								<a href="projectFileDown?mail_file_no=${projectFile.mail_file_no}">첨부파일: ${projectFile.mail_org_name}</a>
								(${projectFile.mail_file_size}byte)<br>
								</c:if>
								<c:if test="${projectFile.mail_file_no == null}">
								첨부파일 :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; [없음]		
								</c:if>
							</div>
							<div class="items">
								<c:choose>
									<c:when test="${pjwrite.mem_no == sessionScope.mem_no}">
										<input type="button" class="button" value="목록" onclick="location.href='projectList'">
										<input type="button" class="button" value="수정" onclick="location.href='projectUpdateForm?project_no=${project.project_no}'">
										<input type="button" class="button" value="삭제" onclick="location.href='projectDelete?&project_no=${project.project_no}'">
									</c:when>
									<c:otherwise>
										<input type="button" class="button" value="목록" onclick="location.href='projectList'">
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						소속팀이 아니라 열람 불가합니다.
						돌아가 주세요.
					</c:otherwise>
				</c:choose>
			</div> 
		</div>
<%@ include file="/WEB-INF/viewpart/footer.jsp"%>
</div>
</body>
</html>
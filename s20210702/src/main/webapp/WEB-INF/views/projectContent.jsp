<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<h2>프로젝트 게시판</h2> 
			<table>
				<c:choose>
					<c:when test="${pjteam.team_no == pjwrite.team_no }">
						<tr><th>프로젝트 번호</th><td>${project.project_no }</td></tr>
						<tr><th>프로젝트명</th><td>${project.project_name }</td></tr>
						<tr><th>시작날짜</th><td>${project.project_start }</td></tr>
						<tr><th>종료날짜</th><td>${project.project_end }</td></tr>
						<tr><th>예상비용</th><td>${project.project_excost }</td></tr>
						<tr><th>실제비용</th><td>${project.project_realcost }</td></tr>
						<tr><th>회사명</th><td>${project.project_company }</td></tr>
						<tr><th>진행상황</th><td>${project.project_progress }</td></tr>
						<c:if test="${projectFile.mail_file_no != null}">
						<a href="projectFileDown?mail_file_no=${projectFile.mail_file_no}">첨부파일: ${projectFile.mail_org_name}</a>
						(${projectFile.mail_file_size}byte)<br>
						</c:if>
						<c:if test="${projectFile.mail_file_no == null}">
						첨부파일 :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; [없음]		
						</c:if>
					</c:when>
					<c:otherwise>
						소속팀이 아니라 열람 불가합니다.
						돌아가 주세요.
					</c:otherwise>
				</c:choose>
				<tr>
					<td colspan="2">
						<c:choose>
							<c:when test="${pjwrite.mem_no == sessionScope.mem_no}">
						    	<input type="button" value="목록" 
									onclick="location.href='projectList'">
								<input type="button" value="수정" 
									onclick="location.href='projectUpdateForm?project_no=${project.project_no}'">
								<input type="button" value="삭제" 
									onclick="location.href='projectDelete?&project_no=${project.project_no}'">
							</c:when>
							<c:otherwise>
								<input type="button" value="목록" 
									onclick="location.href='projectList'">
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</table> 
		</div>
	</div>
<%@ include file="/WEB-INF/viewpart/footer.jsp"%>
</div>
</body>
</html>
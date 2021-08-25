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
<link href="resources/css/projectList.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<script src="https://kit.fontawesome.com/29ccb048c9.js" crossorigin="anonymous"></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
</head>

<body>
<div class="body">
<%@ include file="/WEB-INF/viewpart/header.jsp"%>
<%-- <%@ include file="/WEB-INF/viewpart/aside.jsp"%>   --%>
	<div id="sc_pj_cont_up">
		<div id="sc_cont_ul">
			<c:set var="num" value="${pg.total-pg.start+1}"></c:set>
			<div id="projectTable">
				<div class="prjHead">
					<span class="cell head1 verticalLine">프로젝트번호</span>
					<span class="cell head2 verticalLine">프로젝트명</span>
					<span class="cell head3 verticalLine">시작날짜</span>
					<span class="cell head4 verticalLine">종료날짜</span>
	                <span class="cell head5 verticalLine">담당자 번호</span>
					<span class="cell head6 verticalLine">회사명</span>
					<span class="cell head7 verticalLine">진행상황</span>
				</div>
				<c:forEach var="listProject" items="${listProject}">
					<div class="projectList">
						<span class="cell col1">
							${listProject.project_no }
						</span>
						<span class="cell col2" onclick="location.href='projectContent?board_no=${listProject.board_no }&project_no=${listProject.project_no }&smem_no=${sessionScope.mem_no }&mem_no=${listProject.mem_no }'">
							${listProject.project_name}
						</span>
						<span class="cell col3">
							<fmt:parseDate value='${listProject.project_start}' var='project_start' pattern="yyyy-MM-dd HH:mm:ss" /> 
 							<fmt:formatDate value="${project_start}" pattern="yyyy-MM-dd"/> 
						</span>
						<span class="cell col4">
							<fmt:parseDate value='${listProject.project_end}' var='project_end' pattern="yyyy-MM-dd HH:mm:ss" /> 
 							<fmt:formatDate value="${project_end}" pattern="yyyy-MM-dd"/>
                  		</span>
                  		<span class="cell col5">
                    		 ${listProject.mem_no }
                  		</span>
						<span class="cell col6">
							${listProject.project_company }
						</span>
						<span class="cell col7">
							${listProject.project_progress }
						</span>
					</div>
					<c:set var="num" value="${num - 1 }"></c:set>
				</c:forEach>
				<div id="projectWriteBtn">
					<button id="projectWriteBtn" type="button" onclick="location.href='projectWriteForm?mem_no=${sessionScope.mem_no }'">글쓰기</button>
				</div>
			</div>
			<div class="currentpage">
				<c:if test="${pg.startPage > pg.pageBlock }">
					<a href="projectList?currentPage=${pg.startPage-pg.pageBlock}">[이전]</a>
				</c:if>
				<c:forEach var="i" begin="${pg.startPage}" end="${pg.endPage}">
					<a href="projectList?currentPage=${i}">${i}</a>
				</c:forEach>
				<c:if test="${pg.endPage < pg.totalPage }">
					<a href="projectList?currentPage=${pg.startPage+pg.pageBlock}">[다음]</a>
			</c:if>
			</div>
		</div>
	</div>
<%@ include file="/WEB-INF/viewpart/footer.jsp"%>
</div>
</body>
</html>
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
<link href="css/app_main.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/scheWriteForm.css">
<script src="https://kit.fontawesome.com/29ccb048c9.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="body">
<c:if test="${sessionScope.mem_no ne null }">

				<!-- 사원급 이하 직원에게 보여질 페이지 -->
								<c:if test="${auth_no > 3 }">
				<%@ include file="/WEB-INF/viewpart/header.jsp"%>
				
					<div id="wmcontainer3">
					<h3>${mo.mem_name}님이 결재할 목록  </h3>
				<p>
				<hr>
				<p>
				<h4><a href="app_my_list?mem_no=${mo.mem_no}&currentPage=1">${mo.mem_name}님이 상신한 결재 목록</a> </h4>
				
				
					 </div>
				   <%@ include file="/WEB-INF/viewpart/footer.jsp"%>
				   
				   </c:if>

				<!-- 팀장급 인원에게 보여질 페이지 -->
				<c:if test="${auth_no == 3 }">
				<%@ include file="/WEB-INF/viewpart/header.jsp"%>
				
					<div id="wmcontainer3">
					<h3>${mo.mem_name}님이 결재할 목록  </h3>
					
					<c:set var="num" value="${pg.total-pg.start+1}"></c:set>
				
				<table>
					
					<tr><th >번호</th><th>사번</th><th>제목</th><th>작성시간</th><th>작성내용</th><th> 결재 상태 설정</th></tr>
					<c:forEach var="appr2" items="${listAppr2 }">
					
						<tr><td>${appr2.app_doc_no }</td><td>${appr2.mem_no }</td>
						<td>${appr2.app_doc_title}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${appr2.app_doc_date }" /> </td><td>${appr2.app_doc_content }</td>
							<td>
							<c:if test="${appr2.memfrom1 eq null }">
							<a href="accept?mem_no=${appr2.mem_no}&from_mem_no=${mo.mem_no }&app_doc_no=${appr2.app_doc_no}">결재 승인</a> /
							<a href="no_accept?mem_no=${appr2.mem_no}&from_mem_no=${mo.mem_no }&app_doc_no=${appr2.app_doc_no}">결재 반려</a>
							</c:if>
							<c:if test="${appr2.memfrom1 == 1 }">
							[승인]
							</c:if>
							<c:if test="${appr2.memfrom1 == 2 }">
							[반려]
							</c:if>
							</td>
							
							
							</tr>
					
						<c:set var="num" value="${num - 1 }"></c:set>
					
					</c:forEach>
				</table>
				<div class="currentpage">
				<c:if test="${pg.startPage > pg.pageBlock }">
					<a href="app_my_list2?mem_no=${mo.mem_no }&currentPage=${pg.startPage-pg.pageBlock}">[이전]</a>
				</c:if>
				<c:forEach var="i" begin="${pg.startPage}" end="${pg.endPage}">
					<a href="app_my_list2?mem_no=${mo.mem_no }&currentPage=${i}">[${i}]</a>
				</c:forEach>
				<c:if test="${pg.endPage < pg.totalPage }">
					<a href="app_my_list2?mem_no=${mo.mem_no }&currentPage=${pg.startPage+pg.pageBlock}">[다음]</a>
				</c:if>
				</div>
				<p>
				<hr>
				<p>
				<div style="float:right; margin-top:50px;">
				<h4><a href="app_my_list?mem_no=${mo.mem_no}&currentPage=1">${mo.mem_name}님이 상신한 결재 목록</a> </h4>
				</div>
				
					 </div>
				   <%@ include file="/WEB-INF/viewpart/footer.jsp"%>
				   
				   </c:if>

					<!-- 부장급 인원들한태 보여질 페이지 -->
					<c:if test="${auth_no == 2 }">
					<%@ include file="/WEB-INF/viewpart/header.jsp"%>
					
						<div id="wmcontainer3">
						<h3>${mo.mem_name}님이 결재할 목록  </h3>
						
						<c:set var="num" value="${pg.total-pg.start+1}"></c:set>
					
					<table>
						
						<tr><th >번호</th><th>사번</th><th>제목</th><th>작성시간</th><th>작성내용</th><th> 결재 상태 설정</th></tr>
						<c:forEach var="appr2" items="${listAppr2 }">
						<c:if test="${appr2.memfrom1 == 1 }">
							<tr><td>${appr2.app_doc_no }</td><td>${appr2.mem_no }</td>
							<td>${appr2.app_doc_title}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${appr2.app_doc_date }" /> </td><td>${appr2.app_doc_content }</td>
								<td>
								<c:if test="${appr2.memfrom2 eq null }">
							<a href="accept?mem_no=${appr2.mem_no}&from_mem_no=${mo.mem_no }&app_doc_no=${appr2.app_doc_no}">결재 승인</a> /
							<a href="no_accept?mem_no=${appr2.mem_no}&from_mem_no=${mo.mem_no }&app_doc_no=${appr2.app_doc_no}">결재 반려</a>
							</c:if>
							<c:if test="${appr2.memfrom2 == 1 }">
							[승인]
							</c:if>
							<c:if test="${appr2.memfrom2 == 2 }">
							[반려]
							</c:if>
								</td>
								
								
								</tr>
								</c:if>
							<c:set var="num" value="${num - 1 }"></c:set>
						
						</c:forEach>
					</table>
					<div class="currentpage">
					<c:if test="${pg.startPage > pg.pageBlock }">
						<a href="app_my_list2?mem_no=${mo.mem_no }&currentPage=${pg.startPage-pg.pageBlock}">[이전]</a>
					</c:if>
					<c:forEach var="i" begin="${pg.startPage}" end="${pg.endPage}">
						<a href="app_my_list2?mem_no=${mo.mem_no }&currentPage=${i}">[${i}]</a>
					</c:forEach>
					<c:if test="${pg.endPage < pg.totalPage }">
						<a href="app_my_list2?mem_no=${mo.mem_no }&currentPage=${pg.startPage+pg.pageBlock}">[다음]</a>
					</c:if>
					</div>
					<p>
					<hr>
					<p>
					<div style="float:right; margin-top:50px;">
					<h4><a href="app_my_list?mem_no=${mo.mem_no}&currentPage=1">${mo.mem_name}님이 상신한 결재 목록</a> </h4>
					</div>
					
						 </div>
					   <%@ include file="/WEB-INF/viewpart/footer.jsp"%>
					   
					   </c:if>
					   
					   
					   <!-- 대표/관리자 급에게 보여질 패이지 -->
					   <c:if test="${auth_no == 1 }">
					<%@ include file="/WEB-INF/viewpart/header.jsp"%>
					
						<div id="wmcontainer3">
						<h3>${mo.mem_name}님이 결재할 목록  </h3>
						
						<c:set var="num" value="${pg.total-pg.start+1}"></c:set>
					
					<table>
						
						<tr><th >번호</th><th>사번</th><th>제목</th><th>작성시간</th><th>작성내용</th><th> 결재 상태 설정</th><th>최종 결재 완료 처리</th></tr>
						<c:forEach var="appr2" items="${listApprT }">
						<c:if test="${appr2.memfrom2 == 1 }">
							<tr><td>${appr2.app_doc_no }</td><td>${appr2.mem_no }</td>
							<td>${appr2.app_doc_title}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${appr2.app_doc_date }" /> </td><td>${appr2.app_doc_content }</td>
								<td>
								<c:if test="${appr2.memfrom3 eq null }">
							<a href="accept?mem_no=${appr2.mem_no}&from_mem_no=${mo.mem_no }&app_doc_no=${appr2.app_doc_no}">결재 승인</a> /
							<a href="no_accept?mem_no=${appr2.mem_no}&from_mem_no=${mo.mem_no }&app_doc_no=${appr2.app_doc_no}">결재 반려</a>
							</c:if>
							<c:if test="${appr2.memfrom3 == 1 or appr2.memfrom3 ==10 }">
							[승인]
							</c:if>
							<c:if test="${appr2.memfrom3 == 2 }">
							[반려]
							</c:if>
								</td>
								
								<td>
							<c:if test="${appr2.memfrom3 == 1 }">
							<a href="app_acc_final?mem_no=${mo.mem_no }&app_doc_no=${appr2.app_doc_no}"> 승인 확정</a>
							<%-- <form action="app_acc_final" method="post">
							<input type="hidden" name="app_doc_no" value="${appr2.app_doc_no }">
							<input type="hidden" name="app_file_no" value="${appr2.app_file_no }">
							<input type="hidden" name="app_doc_title" value="${appr2.app_doc_title }">
							<input type="hidden" name="mem_no" value="${appr2.mem_no }">
							<input type="hidden" name="sch_start_date" value="${appr2.sch_start_date }">
							<input type="hidden" name="sch_end_date" value="${appr2.sch_end_date }">
							 <input type="submit" value="승인 확정">
							 </form> --%>
							</c:if>
							
							<c:if test="${appr2.memfrom3 == 10 }">
							[처리 완료!]
							</c:if>	
								</td>
								
								</tr>
								</c:if>
							<c:set var="num" value="${num - 1 }"></c:set>
						
						</c:forEach>
					</table>
					<div class="currentpage">
					<c:if test="${pg.startPage > pg.pageBlock }">
						<a href="app_my_list2?mem_no=${mo.mem_no }&currentPage=${pg.startPage-pg.pageBlock}">[이전]</a>
					</c:if>
					<c:forEach var="i" begin="${pg.startPage}" end="${pg.endPage}">
						<a href="app_my_list2?mem_no=${mo.mem_no }&currentPage=${i}">[${i}]</a>
					</c:forEach>
					<c:if test="${pg.endPage < pg.totalPage }">
						<a href="app_my_list2?mem_no=${mo.mem_no }&currentPage=${pg.startPage+pg.pageBlock}">[다음]</a>
					</c:if>
					</div>
					<p>
					<hr>
					<p>
					<div style="float:right; margin-top:50px;">
					<h4><a href="app_my_list?mem_no=${mo.mem_no}&currentPage=1">${mo.mem_name}님이 상신한 결재 목록</a> </h4>
					</div>
					
						 </div>
					   <%@ include file="/WEB-INF/viewpart/footer.jsp"%>
					   
					   </c:if>
</c:if>











<c:if test="${sessionScope.mem_no eq null }">
<%
	response.sendRedirect("loginForm");
%>
</c:if>	
</div>
</body>
</html>
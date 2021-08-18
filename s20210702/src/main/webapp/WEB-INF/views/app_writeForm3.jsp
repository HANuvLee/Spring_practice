<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/css_main.css" rel="stylesheet">
<link href="css/app_main.css" rel="stylesheet">
<script src="https://kit.fontawesome.com/29ccb048c9.js" crossorigin="anonymous"></script>
</head>
<body>
<c:if test="${sessionScope.mem_no ne null }">
<%@ include file="/WEB-INF/viewpart/header.jsp"%>
 
	<div id="wmcontainer1">
	 <h3>writeForm3 (일반)</h3>
	 <form action="app_write3" method="post">
	 <table>
	 <tr>
	<th>결재 종류</th>
		<td>
		<select name="app_doc_kind">
		<option value="21">비용 청구</option> <option value="22">복지 서비스 신청</option> <option value="23">일반 결재 </option><option value="24">기타 결재</option>
		</select>
		</td>	 
	 </tr>
	  <tr>
	<th>상신자</th> <td> ${mo.mem_name } <input type="hidden" name="mem_no" value="${mo.mem_no }"></td>
	  </tr>
	 <tr>
	 <th>결재 문서 제목</th><td><input type="text" name="app_doc_title"></td>
	 </tr>
	 <tr>
	 <tr>
	 <th>결재 문서 내용</th><td><textarea name="app_doc_content" cols="50" rows="20"></textarea></td>
	 </tr>
	 <tr>
	 <th>결재 라인 선택 </th> <td>
	 팀장 : <select name="app_doc_memberto1"><option value="0005">이주호 과장</option><option value="0006">박병규 차장</option></select> 
	 부장 : <select name="app_doc_memberto2"><option value="0003">홍승엽 부장</option><option value="0004">강승석 부장</option></select> 
	 대표: 관리자</td>
	 </tr>
	 <tr>
	 <th><input type="submit" value="결재 상신"> <input type="reset" value="재작성"></th>
	 </tr>
	 
	 </table>
	 </form>
	 
	 </div>
   <%@ include file="/WEB-INF/viewpart/footer.jsp"%>
</c:if>
<c:if test="${sessionScope.mem_no eq null }">
<%
	response.sendRedirect("loginForm");
%>
</c:if>	


</body>
</html>
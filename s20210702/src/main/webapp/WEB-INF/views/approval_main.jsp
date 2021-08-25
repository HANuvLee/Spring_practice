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
<div class="body">
	<c:if test="${sessionScope.mem_no ne null }">
	<%@ include file="/WEB-INF/viewpart/header.jsp"%>
		
		<div id="wmcontainer2">
		 
		 <table>
		 <tr>
		 <th> <a href="app_writeForm1?mem_no=${mo.mem_no }"><img alt="yc_icon" src="img/yc_icon.png" width=" 150px"></a> 	 </th>
		 <th> <a href="app_writeForm2?mem_no=${mo.mem_no }"><img alt="cj_icon" src="img/cj_icon.jpg" width=" 150px"></a> 	 </th>
		 <th> <a href="app_writeForm3?mem_no=${mo.mem_no }"><img alt="etc_app_icon" src="img/etc_app_icon.jpg" width=" 150px"></a> 	 </th>
		 <th> <a href="app_my_list?mem_no=${mo.mem_no }&currentPage=1"><img alt="my_appr" src="img/my_appr.png" width=" 150px"></a>	 </th>
		 <th> <a href="app_my_list2?mem_no=${mo.mem_no }&currentPage=1"><img alt="my_appr2" src="img/my_appr2.png" width=" 150px"></a>	 </th>
		 
		  </tr>
		  <tr>
		  <th width="400px">연차 결재 신청</th>
		  <th width="400px">출장 신청</th>
		  <th width="400px">기타 일반 결재 신정</th>
		  <th width="400px">내가 상신한 결재 목록 보기</th>
		  <th width="400px">내가 결재할 목록 보기</th>
		  </tr>
		 
		 </table>
		 
		 </div>
	   <%@ include file="/WEB-INF/viewpart/footer.jsp"%>
	</c:if>
	<c:if test="${sessionScope.mem_no eq null }">
	<%
		response.sendRedirect("loginForm");
	%>
	</c:if>	
</div>

</body>
</html>
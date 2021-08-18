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
	 <h3>writeForm2 (출장)</h3>
	 <form action="app_write2" method="post">
	 <table>
	 <tr>
	<th>출장 종류</th>
		<td>
		<select name="app_doc_kind">
		<option value="11">관내 출장</option> <option value="12">관외 출장</option> <option value="13">해외 출장</option><option value="14">기타 출장</option>
		</select>
		</td>	 
	 </tr>
	  <tr>
	<th>신청자</th> <td> ${mo.mem_name } <input type="hidden" name="mem_no" value="${mo.mem_no }"></td>
	  </tr>
	 <tr>
	 <th>결재 문서 제목</th><td><input type="text" name="app_doc_title"></td>
	 </tr>
	 <tr>
	 <th>출장 시작 일자</th>
	 <td>
	  <select name="sch_start_yy"><option value="2021" selected="selected">2021</option><option value="2022">2022</option><option value="2023">2023</option></select>년 
	 <select name="sch_start_mm">
	 <option value="1">1</option><option value="2">2</option><option value="3">3</option>
	 <option value="4">4</option><option value="5">5</option><option value="6">6</option>
	 <option value="7">7</option><option value="8">8</option><option value="9">9</option>
	 <option value="10">10</option><option value="11">11</option><option value="12">12</option>
	 </select>월 
	 <select name="sch_start_dd">
	 <option value="1">1</option><option value="2">2</option><option value="3">3</option>
	 <option value="4">4</option><option value="5">5</option><option value="6">6</option>
	 <option value="7">7</option><option value="8">8</option><option value="9">9</option>
	 <option value="10">10</option><option value="11">11</option><option value="12">12</option>
	 <option value="13">13</option><option value="14">14</option><option value="15">15</option>
	 <option value="16">16</option><option value="17">17</option><option value="18">18</option>
	 <option value="19">19</option><option value="20">20</option><option value="21">21</option>
	 <option value="22">22</option><option value="23">23</option><option value="24">24</option>
	 <option value="25">25</option><option value="26">26</option><option value="27">27</option>
	 <option value="28">28</option><option value="29">29</option><option value="30">30</option>
	 <option value="31">31</option>
	 </select>일  
	 <select name="sch_start_hh">
	 <option value="9">09</option><option value="10">10</option>
	 <option value="11">11</option><option value="12">12</option>
	 <option value="13">13</option><option value="14">14</option>
	 <option value="15">15</option><option value="16">16</option>
	 <option value="17">17</option></select>시 
	 <select name="sch_start_mi">
	 <option value="0">00</option><option value="30">30</option>
	 </select>
	 분
	 </td>
	 </tr>
	 
	 <tr>
	 <th>출장 종료 일자</th>
	 <td>
	 <select name="sch_end_yy"><option value="2021" selected="selected">2021</option><option value="2022">2022</option><option value="2023">2023</option></select>년 
	 <select name="sch_end_mm">
	 <option value="1">1</option><option value="2">2</option><option value="3">3</option>
	 <option value="4">4</option><option value="5">5</option><option value="6">6</option>
	 <option value="7">7</option><option value="8">8</option><option value="9">9</option>
	 <option value="10">10</option><option value="11">11</option><option value="12">12</option>
	 </select>월 
	 <select name="sch_end_dd">
	 <option value="1">1</option><option value="2">2</option><option value="3">3</option>
	 <option value="4">4</option><option value="5">5</option><option value="6">6</option>
	 <option value="7">7</option><option value="8">8</option><option value="9">9</option>
	 <option value="10">10</option><option value="11">11</option><option value="12">12</option>
	 <option value="13">13</option><option value="14">14</option><option value="15">15</option>
	 <option value="16">16</option><option value="17">17</option><option value="18">18</option>
	 <option value="19">19</option><option value="20">20</option><option value="21">21</option>
	 <option value="22">22</option><option value="23">23</option><option value="24">24</option>
	 <option value="25">25</option><option value="26">26</option><option value="27">27</option>
	 <option value="28">28</option><option value="29">29</option><option value="30">30</option>
	 <option value="31">31</option>
	 </select>일 
	 <select name="sch_end_hh">
	 <option value="10">10</option>
	 <option value="11">11</option><option value="12">12</option>
	 <option value="13">13</option><option value="14">14</option>
	 <option value="15">15</option><option value="16">16</option>
	 <option value="17">17</option><option value="18">18</option>
	 </select>시 
	 <select name="sch_end_mi">
	 <option value="0">00</option><option value="30">30</option>
	 </select>
	 분
	 </td>
	 </tr>
	 <tr>
	 <th>법인 차량 사용</th> <td><select name="car_no"><option value="0">자차/대중교통 사용</option>
	 <c:forEach var="car" items="${carlist }">
	 <c:choose>
	 <c:when test="${car.car_no ==1 }"><option value="1">42마4271(제네시스)</option></c:when>
	 <c:when test="${car.car_no ==2 }"><option value="2">37마1794(그렌져)</option></c:when>
	 <c:when test="${car.car_no ==3 }"><option value="3">18고4442(아반떼)</option></select></c:when>
	 </c:choose>
	 </c:forEach> 
	 </td>
	 <!-- 차량 예약은 가능목록 list받아와서 option으로 뿌려주려고 생각 -->
	 </tr>
	 
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
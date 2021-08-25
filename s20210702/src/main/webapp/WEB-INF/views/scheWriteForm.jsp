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
<link rel="stylesheet" href="resources/css/scheWriteForm.css">
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
</head>
<body>
<div class="body">
<%@ include file="/WEB-INF/viewpart/header.jsp"%>
	<div id="sc_cont_up3">
		<div id="sc_cont_ul3">
	<h2>스케쥴 작성</h2>
	<form action="scheins" method="post">
	<table border="1">
		<tr>
		<th>스케쥴 당사자</th> <td>${mem_no }
		<input type="hidden" name = "mem_no" value="${mem_no }">
		<input type="hidden" name = "year_" value="${year_ }">
		<input type="hidden" name = "month_" value="${month_ }">
		<input type="hidden" name = "day_" value="${day_ }">
		</td>
		
		</tr>
		
		<tr>
		<th>스케쥴 시작일</th>
		<td>
		<select name="sche_yy_sta">
		<option value="2021" selected="selected">2021</option>
		<option value="2022">2022</option>
		<option value="2023">2023</option>
		<option value="2024">2024</option>
		<option value="2025">2025</option>
		</select>년

		<select name="sche_mm_sta">
		<c:if test="${month_  == 1 }"><option value="1" selected="selected">1</option></c:if>
		<c:if test="${month_  != 1 }"><option value="1">1 </option></c:if>
		<c:if test="${month_  == 2 }"><option value="2" selected="selected">2</option></c:if>
		<c:if test="${month_  != 2 }"><option value="2">2 </option></c:if>
		<c:if test="${month_  == 3 }"><option value="3" selected="selected">3</option></c:if>
		<c:if test="${month_  != 3 }"><option value="3">3 </option></c:if>
		<c:if test="${month_  == 4 }"><option value="4" selected="selected">4</option></c:if>
		<c:if test="${month_  != 4 }"><option value="4">4 </option></c:if>
		<c:if test="${month_  == 5 }"><option value="5" selected="selected">5</option></c:if>
		<c:if test="${month_  != 5 }"><option value="5">5 </option></c:if>
		<c:if test="${month_  == 6 }"><option value="6" selected="selected">6</option></c:if>
		<c:if test="${month_  != 6 }"><option value="6">6 </option></c:if>
		<c:if test="${month_  == 7 }"><option value="7" selected="selected">7</option></c:if>
		<c:if test="${month_  != 7 }"><option value="7">7 </option></c:if>
		<c:if test="${month_  == 8 }"><option value="8" selected="selected">8</option></c:if>
		<c:if test="${month_  != 8 }"><option value="7">8 </option></c:if>
		<c:if test="${month_  == 9 }"><option value="9" selected="selected">9</option></c:if>
		<c:if test="${month_  != 9 }"><option value="9">9 </option></c:if>
		<c:if test="${month_  == 10 }"><option value="10" selected="selected">10</option></c:if>
		<c:if test="${month_  != 10 }"><option value="10">10 </option></c:if>
		<c:if test="${month_  == 11 }"><option value="11" selected="selected">11</option></c:if>
		<c:if test="${month_  != 11 }"><option value="11">11 </option></c:if>
		<c:if test="${month_  == 12 }"><option value="12" selected="selected">12</option></c:if>
		<c:if test="${month_  != 12 }"><option value="12">12 </option></c:if>
		</select>월
		<select name="sche_dd_sta">
		<option value="${day_}" selected="selected">${day_ }</option>
		<option value="1">1</option><option value="2">2</option><option value="3">3</option>
		<option value="4">4</option><option value="5">5</option><option value="6">6</option>
		<option value="7">7</option><option value="8">8</option><option value="9">9</option>
		<option value="10">10</option><option value="11">11</option><option value="12">12</option>
		<option value="13">13</option><option value="14">14</option><option value="15">15</option>
		<option value="16">16</option><option value="17">17</option><option value="18" >18</option>
		<option value="19">19</option><option value="20">20</option><option value="21">21</option>
		<option value="22">22</option><option value="23">23</option><option value="24">24</option>
		<option value="25">25</option><option value="26">26</option><option value="27">27</option>
		<option value="28">28</option><option value="29">29</option><option value="3">30</option>
		<option value="31">31</option>
		</select>일
		<select name="sche_hh_sta">
		<option value="9" selected="selected">9</option>
		<option value="10">10</option>
		<option value="11">11</option>
		<option value="12">12</option>
		<option value="13">13</option>
		<option value="14">14</option>
		<option value="15">15</option>
		<option value="16">16</option>
		<option value="17">17</option>
		<option value="18">18</option>
		</select>시
		</td>
		</tr>
		
		<tr>
		<th>스케쥴 종료일</th>
		<td>
		<select name="sche_yy_end">
		<option value="2021" selected="selected">2021</option>
		<option value="2022">2022</option>
		<option value="2023">2023</option>
		<option value="2024">2024</option>
		<option value="2025">2025</option>
		</select>년
		
		<select name="sche_mm_end">
<c:if test="${month_  == 1 }"><option value="1" selected="selected">1</option></c:if>
		<c:if test="${month_  != 1 }"><option value="1">1 </option></c:if>
		<c:if test="${month_  == 2 }"><option value="2" selected="selected">2</option></c:if>
		<c:if test="${month_  != 2 }"><option value="2">2 </option></c:if>
		<c:if test="${month_  == 3 }"><option value="3" selected="selected">3</option></c:if>
		<c:if test="${month_  != 3 }"><option value="3">3 </option></c:if>
		<c:if test="${month_  == 4 }"><option value="4" selected="selected">4</option></c:if>
		<c:if test="${month_  != 4 }"><option value="4">4 </option></c:if>
		<c:if test="${month_  == 5 }"><option value="5" selected="selected">5</option></c:if>
		<c:if test="${month_  != 5 }"><option value="5">5 </option></c:if>
		<c:if test="${month_  == 6 }"><option value="6" selected="selected">6</option></c:if>
		<c:if test="${month_  != 6 }"><option value="6">6 </option></c:if>
		<c:if test="${month_  == 7 }"><option value="7" selected="selected">7</option></c:if>
		<c:if test="${month_  != 7 }"><option value="7">7 </option></c:if>
		<c:if test="${month_  == 8 }"><option value="8" selected="selected">8</option></c:if>
		<c:if test="${month_  != 8 }"><option value="7">8 </option></c:if>
		<c:if test="${month_  == 9 }"><option value="9" selected="selected">9</option></c:if>
		<c:if test="${month_  != 9 }"><option value="9">9 </option></c:if>
		<c:if test="${month_  == 10 }"><option value="10" selected="selected">10</option></c:if>
		<c:if test="${month_  != 10 }"><option value="10">10 </option></c:if>
		<c:if test="${month_  == 11 }"><option value="11" selected="selected">11</option></c:if>
		<c:if test="${month_  != 11 }"><option value="11">11 </option></c:if>
		<c:if test="${month_  == 12 }"><option value="12" selected="selected">12</option></c:if>
		<c:if test="${month_  != 12 }"><option value="12">12 </option></c:if>
		</select>월
		<select name="sche_dd_end">
		<option value="${day_ }" selected="selected">${day_ }</option>
		<option value="1">1</option><option value="2">2</option><option value="3">3</option>
		<option value="4">4</option><option value="5">5</option><option value="6">6</option>
		<option value="7">7</option><option value="8">8</option><option value="9">9</option>
		<option value="10">10</option><option value="11">11</option><option value="12">12</option>
		<option value="13">13</option><option value="14">14</option><option value="15">15</option>
		<option value="16">16</option><option value="17">17</option><option value="18">18</option>
		<option value="19">19</option><option value="20">20</option><option value="21">21</option>
		<option value="22">22</option><option value="23">23</option><option value="24">24</option>
		<option value="25">25</option><option value="26">26</option><option value="27">27</option>
		<option value="28">28</option><option value="29">29</option><option value="3">30</option>
		<option value="31">31</option>
		</select>일
		<select name="sche_hh_end">
		<option value="9">9</option>
		<option value="10">10</option>
		<option value="11">11</option>
		<option value="12">12</option>
		<option value="13">13</option>
		<option value="14">14</option>
		<option value="15">15</option>
		<option value="16">16</option>
		<option value="17">17</option>
		<option value="18" selected="selected">18</option>
		</select>시
		</td>
		</tr>
		
		<tr>
		<th>스케쥴 종류</th>
		<td>
		<select name="schedule_kind">
		<option value="1" selected="selected"> 연차 휴가 </option>
		<option value="2"> 병가 </option>
		<option value="3"> 인정 휴가 </option>
		<option value="4"> 관내 출장 </option>
		<option value="5"> 관외 출장 </option>
		<option value="6"> 해외 출장 </option>
		</select>
		</td>
		</tr>
		
		<tr>
		<th> 스케쥴 이름 </th> <td> <input type="text" name="schedule_name" required="required" style="width:900px;"> </td>
		</tr>
		
		<tr>
		<th> 스케쥴 내용 </th> <td> <textarea name="schedule_content" cols="140" rows="20"></textarea></td>
		</tr>
		
		
		
	</table>
	<div class="swfbtn">
		<input type="submit" value="작성완료"> / <input type="reset" value="다시 작성">
	</div>
	</form>
		</div>
	</div>
<%@ include file="/WEB-INF/viewpart/footer.jsp"%>
</div>
</body>
</html>
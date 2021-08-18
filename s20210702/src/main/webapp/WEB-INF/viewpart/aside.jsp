<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="bd_container">
<aside>
            <div id="as_pbox">

                <div class="pf_photo">
                    <img src="img/pfimg_sample.jpg" width="100px">
                    <p>

                </div>
                <div class="pf_info">
                    <ul class="pf_mem_name">
                        <li>${mo.mem_name}</li>
                    </ul>
                    <ul class="pf_team_mem_info">
                        <li>${mo.team_name } / ${mo.mem_rank }</li>
                        <li>금일 출근 시간 : <fmt:formatDate pattern="HH:mm:ss"  value="${wm.work_in_time}" /></li>
                    </ul>
                    <ul class="log_out_btn">
                        <li><a href="logout?mem_no=${sessionScope.mem_no }">로그아웃</a></li>
                    </ul>
                </div>


            </div>
            <div id="as_etc">
                출 근 체 크
                    <hr>
               <a href="cin_btn?mem_no=${mo.mem_no }"><img alt="출근" src="img/c_in.png" width="100px"></a> <a href="tout_btn?mem_no=${mo.mem_no }"><img alt="퇴근" src="img/t_out.png" width="100px"></a><p>
                    
                </p>

             
            </div>
            
            <div id="as_ctstatus">
				<h1>근태현황<i class="fas fa-chevron-circle-right fa-1x"></i></h1>
				<hr>
                <table>
                    <tr>
                        <th>금일 출근 시간</th> <td><fmt:formatDate pattern="HH:mm:ss"  value="${wm.work_in_time}" /></td>
                    </tr>
                    <tr>
                        <th>금일 퇴근 시간</th> <td><fmt:formatDate pattern="HH:mm:ss"  value="${wm.work_out_time}" /></td>
                    </tr>
                </table>

                <table>
                    <tr>
                        <th>금주  총  근무 시간</th> <td>${wm2.work_time_sum} 시간</td>
                    </tr>
                    <tr>
                        <th>금주  총  근무 일수</th> <td>${wm2.work_day_cnt} 일</td>
                    </tr>
                    <tr>
                        <th>금주 평균 근무 시간</th> <td>${wm2.work_time_avg} 시간</td>
                    </tr>
                    <tr>
                        <th>금주 초과 근무 시간</th> <td>${wm2.overtime} 시간</td>
                    </tr>
                </table>

                <table>
                    <tr>
                        <th>잔여 휴가:</th> <td>${rest_vacation}일</td>
                    </tr>
                    <tr>
                        <th>사용 휴가:</th> <td>${used_vacation}일</td>
                    </tr>
                </table>
            </div>

        </aside>
       </div>
</body>
</html>
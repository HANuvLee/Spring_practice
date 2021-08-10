<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
	<link href="css/css_main.css" rel="stylesheet">
    <link rel="stylesheet" href="resources/css/chat.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
    <script src="https://kit.fontawesome.com/29ccb048c9.js" crossorigin="anonymous"></script>
    
  <!--   <script>

function printClock() {
    
    var clock = document.getElementById("clock");            // 출력할 장소 선택
    var currentDate = new Date();                                     // 현재시간
    var calendar = currentDate.getFullYear() + "-" + (currentDate.getMonth()+1) + "-" + currentDate.getDate() // 현재 날짜
    var amPm = 'AM'; // 초기값 AM
    var currentHours = addZeros(currentDate.getHours(),2); 
    var currentMinute = addZeros(currentDate.getMinutes() ,2);
    var currentSeconds =  addZeros(currentDate.getSeconds(),2);
    
    if(currentHours >= 12){ // 시간이 12보다 클 때 PM으로 세팅, 12를 빼줌
    	amPm = 'PM';
    	currentHours = addZeros(currentHours - 12,2);
    }

    if(currentSeconds >= 50){// 50초 이상일 때 색을 변환해 준다.
       currentSeconds = '<span style="color:#de1951;">'+currentSeconds+'</span>'
    }
    clock.innerHTML = currentHours+":"+currentMinute+":"+currentSeconds +" <span style='font-size:35px;'>"+ amPm+"</span>"; //날짜를 출력해 줌
    
    setTimeout("printClock()",1000);         // 1초마다 printClock() 함수 호출
}

function addZeros(num, digit) { // 자릿수 맞춰주기
	  var zero = '';
	  num = num.toString();
	  if (num.length < digit) {
	    for (i = 0; i < digit - num.length; i++) {
	      zero += '0';
	    }
	  }
	  return zero + num;
}
</script> -->
<style>
body{
max-width: auto;
height: auto;
}

div{
max-width: auto;
height: auto;
}
</style>
    
    

</head>

<!-- <body onload="printClock()"> -->
<body>
<c:if test="${sessionScope.mem_no ne null }">



    <header id="hd_container">
        <div id="hd_logo"><a href="main?mem_no=${mo.mem_no }"><img src="img/logo_sample001.png" width="200px"></a></div>
        <div id="hd_dash">
            <ul>
                <li><img src="img/ct_icon.jpg">1</li>
                <li><a href="mycal?mem_no=${mo.mem_no }"><img src="img/schedu_icon.jpg"></a>3</li>
                <li><a href="list1"><img src="img/board_icon.jpg"></a>9</li>
                <li><img src="img/work_icon.jpg">1</li>
                <li><a href ="mailList?mem_id=${mo.mem_id }"><img src="img/mail_icon.jpg"></a>11</li>
                <li><img src="img/messanger_icon.jpg">20</li>
            </ul>
        </div>
    </header>

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
            <div id="as_ctbox">
           <div style="border:0;  width:230px; height:130px; line-height:70px;  color:#666; font-size:35px; text-align:center;" id="clock">
	</div>



                
                
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

        <section>
            <div id="sc_cont_up">
                <div id="sc_cont_ul">
                    <div id="sc_cal_todo">
	                    <div class="sc_cal_todo1">
						${caltoday.month_+1 }월 일정<p>
<table class="main_cal" border="1px">
	<thead>
		<tr>
			<th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>
		</tr>
	</thead>
<tbody>
	<tr>
		<c:forEach var="cal" items="${callistall }">
		
			<c:choose>
				<c:when test="${cal.day_no ==1 }">
					<td>
					<a href="todolist?year_=${cal.year_ }&month_=${cal.month_ +1}&day_=${cal.day_}&mem_no=${mo.mem_no}">${cal.day_ }</a>
					<c:if test="${cal.todocnt != 0  }">★</c:if>
					</td>
				</c:when>
				<c:when test="${cal.day_no == 7 }">
					<td>
					<a href="todolist?year_=${cal.year_ }&month_=${cal.month_ +1}&day_=${cal.day_}&mem_no=${mo.mem_no}">${cal.day_ }</a>
					<c:if test="${cal.todocnt != 0  }">★</c:if>
					</td>
					</tr><tr>
				</c:when>
					<c:otherwise>
					<td>
					<a href="todolist?year_=${cal.year_ }&month_=${cal.month_ +1}&day_=${cal.day_}&mem_no=${mo.mem_no}">${cal.day_ }</a>
					<c:if test="${cal.todocnt != 0  }">★</c:if>
					</td>
					</c:otherwise>
			</c:choose>
		
		</c:forEach>
	</tr>
</tbody>
</table>
	             		</div>       
                    	
                    	<div class="sc_cal_todo2">
                    	<h2>일정 리스트</h2>
                    	<c:forEach var="test1" items="${callistall}">
						<c:if test="${test1.todocnt != 0 }">
						${test1.day_ }일 : ${test1.todocnt }개 일정 있음. <br>
						</c:if>

						</c:forEach><p>

                    	
                    	</div>
                    </div>
                    <div id="sc_board"><a href="list1">게시판</a><p>
                    <ul>
                 <c:forEach var="board" items="${recentlistBoard1 }">
				<li><a href="content1?board_no=1&post_no=${board.post_no }">${board.post_title } /written by. ${board.mem_name  } ${board.mem_rank }</a></li>
				</c:forEach>
                    	
                    </ul>
                    
                    </div>
                    <div id="sc_order">전자결재</div>
                </div>
               <div id="sc_cont_ur">
                    <div id="sc_msger_box"  class="container">
                       <input type="hidden" id="mem_name" value="${mem_name}">
                  <input type="hidden" id="mem_id" value="${mem_id}">
                         
                         <div class="modal">
                      <div class="header format">${loginUSer}<a class="btn js-close-modal">X</a></div>
                      <div class="chatMiddle">
                           <ul>
                               <!-- 동적 생성 -->
                           </ul>
                       </div>
                      <div class="chatBottom">
                         <textarea class="textarea" placeholder="메세지를 입력해 주세요."></textarea>
                      </div>
                      <div class="chatMiddle format">
                          <ul>
                              <li>
                                  <div class="sender">
                                      <span></span>
                                  </div>
                                  <div class="message">
                                      <span class="msg_content"></span>
                                  </div>
                              </li>
                          </ul>
                      </div>
                  </div>
                    </div>
               
                   <script  src="resources/js/chat.js"></script>
                </div>
            <div id="sc_cont_down">
                <div id="sc_email"><a href="mailList?mem_id=${mo.mem_id}">전자메일</a></div>
                <div id="sc_booking">자원예약</div>
            </div>
        </section>
    </div>

    <footer>
        <P> The time on the server is ${serverTime}. </P>
        copyright asdf!

    </footer>
</c:if>
<c:if test="${sessionScope.mem_no eq null }">
<%

	response.sendRedirect("loginForm");
%>
</c:if>

</body>

</html>
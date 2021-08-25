<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

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
</script>
</head>
<body onload="printClock(); loginUser();">
<div id="hd_container">

	    <header id="hd_container">
	        <div id="hd_logo"><a href="main?mem_no=${sessionScope.mem_no }"><img id="logo1" src="img/logo_sample001.png"></a></div>
	        <div id="hd_dash">
	            <ul>
	                <li><a href="wmanage?year_=${caltoday.year_ }&mem_no=${sessionScope.mem_no }"><img src="img/ct_icon.jpg"></a></li>
	                <li><a href="mycal?mem_no=${sessionScope.mem_no }"><img src="img/schedu_icon.jpg"></a></li>
	                <li><a href="list1"><img src="img/board_icon.jpg"></a></li>
	                <li><a href="projectList?mem_no=${sessionScope.mem_no }"><img src="img/work_icon.jpg"></a></li>
	                <li><a href ="mailList?mem_id=${member.mem_id }&mem_no=${sessionScope.mem_no }"><img src="img/mail_icon.jpg"></a></li>
	                <li><a href="approval_main?mem_no=${sessionScope.mem_no }"><img src="img/approv_icon.jpg"></a></li>
	            </ul>
	        </div>
	        <div id="as_ctbox">
           		<div style="border:0;  width:230px; height:130px; line-height:70px;  color:#666; font-size:35px; text-align:center;" id="clock"></div>   
            </div>
	    </header>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="sc_cont_ur">
	<div id="sc_msger_box"  class="container">
     	<div>
         	<input type="hidden" id="mem_name" value="${mem_name}">
    		<input type="hidden" id="mem_id" value="${mem_id}">
    		<input type="hidden" id="mem_no" value="${mo.mem_no }">
        </div>
        <div class="myname">
	        <div>
	        	<a onclick="selectroom(${mem_name})" class="btn js-click-modal2">${mem_name }</a>
	        </div>
        </div>
        <div class="allUser-me">
	        <div class="loginUser"></div>
	        <div class="logoutUser"></div>
        </div>
        	<div class="modal">
         		<div class="header format">
         			<a class="btn js-close-modal">X</a>
         		</div>
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
	                	  <b class="unread_message"></b>
	                    <span class="msg_content"></span>
	                </div>
	            </li>
	        </ul>
	    </div>
	    </div>
	</div>
<script  src="resources/js/chat.js"></script>
</div>
</body>
</html>
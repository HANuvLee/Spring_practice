    //window.onload = loginUser();
    
    function chatreload(login_youname) {
    	$('.' + login_youname).remove();
    	
    }
    
    
		function loginUser() {
			
			var	mem_name = $("#mem_name").val();
			$('.reload').remove();
			
			$.ajax({
				url: "http://localhost:8282/s20210702/loginunread_count",
				type: 'get',
				data: {"mem_name": mem_name},
				dataType:"json",
				async:false,
				success: function(data) {
					var loginroomunread = data;
		
					$.ajax({
						url: "http://localhost:8282/s20210702/loginUser",
						type: 'get',
						data: {"mem_name" : mem_name},
						dataType:"json",
						async:false,
						success: function(data) {
							var mem_name = $("#mem_name").val();
							let loginUser = data;
							let loginList = loginUser.filter((element) => element !== mem_name);
							for(var i = 0; i < loginList.length; i++) {
								$('.loginUser').append(
									'<div class="reload"><a onclick="chatreload('
									+ '\''
									+ loginList[i]
									+ '\''	
									+'); selectroom('
									+ '\''
									+ loginList[i]
									+ '\''
									+ ');" class="btn js-click-modal" id="'
									+ loginList[i]
									+ '">'
									+ loginList[i]
									+'</a><span class="alrim unread'
									+ loginroomunread[i]
									+ ' '
									+ loginList[i]
									+ '">'
									+ loginroomunread[i]
									+'</span></div>'
									
								)
							}
							
							$.ajax({
								url: "http://localhost:8282/s20210702/logoutunread_count",
								type: 'get',
								data: {"mem_name": mem_name},
								dataType:"json",
								async:false,
								success: function(data) {
									var logoutroomunread = data;
								
								
									$.ajax({
										url: "http://localhost:8282/s20210702/logoutUser",
										type: 'get',
										dataType:"json",
										data: {"mem_name" : mem_name},
										async:false,
										success: function(data){
											let allList = data;
											let logoutList  = allList.filter(x=> !loginList.includes(x));
											let logoutUser = logoutList.filter((element) => element !== mem_name);
											for(var j = 0; j < logoutUser.length; j++) {
												$('.logoutUser').append(
													'<div class="reload"><a onclick="chatreload('
													+ '\''
													+ logoutUser[j]
													+ '\''	
													+ '); selectroom('
													+ '\''
													+ logoutUser[j]
													+ '\''
													+ ');" class="btn js-click-modal1">'
													+ logoutUser[j]
													+'</a><span class="alrim unread'
													+ logoutroomunread[j]
													+ ' '
													+ logoutUser[j]
													+ '">'
													+ logoutroomunread[j]
													+'</span></div>'
												)
											}
										
										}
									});
								}
							});
						}
						
					});	
				}
			});
			setTimeout("loginUser()",500);	
		};
		
	
	
	function selectroom(you_name) {
		if($('.container').hasClass('modal-open')) {
        	$('.container').addClass('modal-open'); 
        	websocket.close();
        }else {
        	$('.container').addClass('modal-open');
        } 
		var	mem_name = $("#mem_name").val();
	
		  	$.ajax({
				type: "GET", //요청 메소드 방식
				url:"http://localhost:8282/s20210702/selectroom",
				data: {"mem_name": mem_name, "you_name": you_name},
				dataType: 'json',
				success : function(data){
					var room_no = data;
					$('.format_t').remove();
					$('.header').append(
					'<input type="hidden" class="room_no format_t" value="'
					+ room_no
					+ '">'
					+ '<input type="hidden" class="you_name format_t" value="'
					+ you_name
					+ '">'
					+ '<input type="hidden" class="mem_name format_t" value="'
					+ mem_name
					+ '">'
					+ '<span class="format_t">'
					+ you_name
					+ '</span>'
					)
					selectMessage(room_no);
				}
		  });
		  		
		  	 

	};
	
	function selectMessage(room_no) {
		
		
		$('div.chatMiddle:not(.format) ul').html("");
		$.ajax({
			type: "GET", //요청 메소드 방식
			url:"http://localhost:8282/s20210702/selectmessage",
			data: {"room_no": room_no, "sen_message_id": $("#mem_id").val()},
			dataType: "json",
			async:false,
			success : function(data){

		        for(var i = 0; i < data.length; i++){
                    // 채팅 목록 동적 추가
                    CheckLR(data[i]);
                }
		        updateMessage();
		        
		        
			}
			
		});
		wsOpen();
	};
	
	function updateMessage() {
		$.ajax({
			type:"GET",
			url:"http://localhost:8282/s20210702/updatemessage",
			data: {"room_no": $(".room_no").val(), "sen_message_id": $("#mem_id").val()},
			dataType: "json",
			async:false,
			
		});
		//$('loginUser()').load(window.location.href + 'loginUser()');
	};
	
	
	
	let websocket;

	function wsOpen(){
		var wsUri = "ws://" + location.host + "/s20210702/chating/"+$(".room_no").val();
		//웹소켓 전송시 현재 방의 번호를 넘겨서 보낸다.
		websocket = new WebSocket(wsUri);
		websocket.onopen = onOpen;
		
		websocket.onmessage = onMessage;
	}
	
	function onOpen() {
		const data = {
				"room_no" : $(".room_no").val(),
				"sen_message_name" : $(".mem_name").val(),
				"sen_message_id" : $("#mem_id").val(),
				"message_content" : "ENTER-CHAT"
		}
		let jsonData = JSON.stringify(data);
		websocket.send(jsonData);
		

	}
	
	function onMessage(evt) {
        let receive = evt.data.split(",");
         
        const data = {
                "sen_message_name" : receive[0],
                "sen_message_id" : receive[1],
                "message_content" : receive[2],
                "unread_count" : receive[3]
        };
         if(data.sen_message_name != $("#mem_name").val()){
        	 
            CheckLR(data);
         }else
        	 CheckLR(data);
    }
	
	
	function sendMessage(message){
		
		const data = {
				"room_no" : $(".room_no").val(),
				"sen_message_name" : $("#mem_name").val(),
				"sen_message_id" : $("#mem_id").val(),
				"message_content" : message,
				
		};
		
		
		let jsonData = JSON.stringify(data);
        websocket.send(jsonData);
	}
	
//	function latelymessage(room_no) {
//		$.ajax({
//			type:"GET",
//			url:"http://localhost:8282/s20210702/selectmessage",
//			data: {"room_no": room_no.room_no},
//			dataType: "json",
//			async:false,
//			success:function(data) {
//				var i = data.length;
//				CheckLR(data[i]);
//			}
//			
//			
//		});
//	}
	
	$('.js-close-modal').click(function(){
		  $('.container').removeClass('modal-open');
		  $('.format_t').remove();
		  websocket.close();
		});
	
	//엔터키 이벤트
	let room_no;
	$(document).on('keydown', 'div.chatBottom textarea', function(e){
		if(e.keyCode == 13 && !e.shiftKey) {
			e.preventDefault();
			const message = $(this).val();
			let search3 = $('div.chatBottom textarea').val();
			if(search3.replace(/\s|  /gi, "").length == 0){
                return false;
                $('div.chatBottom textarea').focus();
             }
			sendMessage(message);
			clearTextarea();
		}
	});
	
	function CheckLR(data) {
        // email이 loginSession의 email과 다르면 왼쪽, 같으면 오른쪽.
        const LR = (data.sen_message_name != $("#mem_name").val()) ? "left" : "right";
         // 메세지 추가
        appendMessageTag(LR, data.sen_message_id, data.sen_message_name, data.message_content, data.unread_count);
    }
	
	function appendMessageTag(LR_className, sen_message_id, sen_message_name, message_content, unread_count) {
		
		const chatLi = createMessageTag(LR_className, sen_message_id, sen_message_name, message_content, unread_count);
		
		
		$('div.chatMiddle:not(.format) ul').append(chatLi);
		// 스크롤바 아래 고정
        $('div.chatMiddle').scrollTop($('div.chatMiddle').prop('scrollHeight'));
	}
	
	function createMessageTag(LR_className, sen_message_id, sen_message_name, message_content, unread_count) {
		
		let chatLi = $('div.chatMiddle.format ul li').clone();
		chatLi.addClass(LR_className);
		chatLi.find('.sender span').text(sen_message_name);
		if(unread_count == 1) {
			chatLi.find('.message b').text(unread_count);
		}else {
			chatLi.find('.message b').text(null);
		}
		
		chatLi.find('.message span').text(message_content);
		
		return chatLi;
	};
	
	
	function clearTextarea() {
        $('div.chatBottom textarea').val('');
        return false;
   };
	
	
	

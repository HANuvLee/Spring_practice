    window.onload = loginUser();
	
	function loginUser() {
		
			$.ajax({
				url: "http://localhost:8282/s20210702/loginUser",
				type: 'get',
				dataType:"json",
				success: function(data) {
					let loginList = data;
					for(var i = 0; i < loginList.length; i++) {
						$('.container').append(
							'<div><a onclick="selectroom('
							+ '\''
							+ loginList[i]
							+ '\''
							+ ')" class="btn js-click-modal">'
							+ loginList[i]
							+'</a></div>'
							
						)
						
					}
				}
				
			});
	};
	
	
	function selectroom(you_name) {
	
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
//		        $('.container').addClass('modal-open');
//		        $('.chatMiddle').html(data);
		        for(var i = 0; i < data.length; i++){
                    // 채팅 목록 동적 추가
                    CheckLR(data[i]);
                }
		        $('.container').addClass('modal-open'); 
				updateMessage();
				
			}
			
		});
		$('.js-close-modal').click(function(){
		  $('.container').removeClass('modal-open');
		  $('.format_t').remove();
		  websocket.close();
		});
	  	wsOpen();
	};
	
	function updateMessage() {
		$.ajax({
			type:"GET",
			url:"http://localhost:8282/s20210702/updatemessage",
			data: {"room_no": $(".room_no").val(), "sen_message_id": $("#mem_id").val()},
			dataType: "json",
			async:false
		});
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
                "message_content" : receive[2]
        };
         if(data.sen_message_name != $("#mem_name").val()){
        	 
            CheckLR(data);
         }
    }
	
	function sendMessage(message){
		
		const data = {
				"room_no" : $(".room_no").val(),
				"sen_message_name" : $("#mem_name").val(),
				"sen_message_id" : $("#mem_id").val(),
				"message_content" : message
		};
		CheckLR(data);
		
		let jsonData = JSON.stringify(data);
        
        websocket.send(jsonData);
	}
	
	
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
        appendMessageTag(LR, data.sen_message_id, data.sen_message_name, data.message_content);
    }
	
	function appendMessageTag(LR_className, sen_message_id, sen_message_name, message_content) {
		
		const chatLi = createMessageTag(LR_className, sen_message_id, sen_message_name, message_content);
		
		
		$('div.chatMiddle:not(.format) ul').append(chatLi);
		// 스크롤바 아래 고정
        $('div.chatMiddle').scrollTop($('div.chatMiddle').prop('scrollHeight'));
	}
	
	function createMessageTag(LR_className, sen_message_id, sen_message_name, message_content) {
		
		let chatLi = $('div.chatMiddle.format ul li').clone();
		chatLi.addClass(LR_className);
		chatLi.find('.sender span').text(sen_message_name);
		chatLi.find('.message span').text(message_content);
		
		return chatLi;
	};
	
	
	function clearTextarea() {
        $('div.chatBottom textarea').val('');
        return false;
   };
	
	
	

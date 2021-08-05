package com.oracle.s20210702.dao;

import java.util.List;

import com.oracle.s20210702.model.ChatMessage;
import com.oracle.s20210702.model.ChatRoom;

public interface ChatDao {

	ChatRoom 			selectChatRoom(String room_no);

	int 				insertMessage(ChatMessage chatMessage);

	List<ChatMessage> 	messageList(String room_no);

	int 				updateCount(ChatMessage message);

	ChatRoom 			searchChatRoom(ChatRoom room);

	int 				createChat(ChatRoom room);

	List<ChatRoom> 		ChatRoomList(String mem_id);

	int 				selectUnReadCount(ChatMessage message);
	
	

}

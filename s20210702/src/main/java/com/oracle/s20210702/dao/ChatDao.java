package com.oracle.s20210702.dao;

import java.util.ArrayList;
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

	String 				selectroom_no(String you_name, String mem_name);

	String 				insertChatroom(String you_name, String mem_name);

	List<String> 		allUser();

	List<String> 		myroom(String mem_name);

	int 				totalunread(String room_no, String mem_name);

	int 				updateTotalCount(ChatMessage chatMessage);

	
	
	
	
	
	
	
	

}

package com.oracle.s20210702.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210702.dao.ChatDao;
import com.oracle.s20210702.model.ChatMessage;
import com.oracle.s20210702.model.ChatRoom;

@Service
public class ChatServiceImpl implements ChatService {
	
	@Autowired
	private ChatDao cd;

	@Override
	public ChatRoom selectChatRoom(String room_no) {
		System.out.println("ChatServiceImpl selectChatRoom start...");
		ChatRoom cr = null;
		cr = cd.selectChatRoom(room_no);
		return cr;
	}

	@Override
	public int insertMessage(ChatMessage chatMessage) {
		System.out.println("ChatServiceImpl insertMessage start...");
		int result = 0;
		result = cd.insertMessage(chatMessage);
		return result;
	}

	@Override
	public List<ChatMessage> messageList(String room_no) {
		System.out.println("ChatServiceImpl messageList start...");
		List<ChatMessage> mList = null;
		mList = cd.messageList(room_no);
		return mList;
	}

	@Override
	public int updateCount(ChatMessage message) {
		System.out.println("ChatServiceImpl updateCount start...");
		int k = 0;
		k = cd.updateCount(message);
		return k;
	}

	@Override
	public ChatRoom searchChatRoom(ChatRoom room) {
		System.out.println("ChatServiceImpl searchChatRoom start...");
		ChatRoom result = null;
		result = cd.searchChatRoom(room);
		return result;
	}

	@Override
	public int createChat(ChatRoom room) {
		System.out.println("ChatServiceImpl createChat start...");
		int c = 0;
		c = cd.createChat(room);
		return c;
	}

	@Override
	public List<ChatRoom> ChatRoomList(String mem_id) {
		System.out.println("ChatServiceImpl ChatRoomList start...");
		List<ChatRoom> cList = null;
		cList = cd.ChatRoomList(mem_id);
		return cList;
	}

	@Override
	public int selectUnReadCount(ChatMessage message) {
		System.out.println("ChatServiceImpl selectUnReadCount start...");
		int uc = 0;
		uc = cd.selectUnReadCount(message);
		return uc;
	}

	@Override
	public String selectroom_no(String you_name, String mem_name) {
		System.out.println("ChatServiceImpl selectroom_no start...");
		String roomList = null;
		roomList = cd.selectroom_no(you_name, mem_name);
		if(roomList == null) {
			System.out.println("채팅방이 없습니다. 채팅방을 생성합니다.");
			roomList = cd.insertChatroom(you_name, mem_name);
		}
		System.out.println("방이 이미 있습니다.");
		return roomList;
	}

}

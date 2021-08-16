package com.oracle.s20210702.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210702.model.ChatMessage;
import com.oracle.s20210702.model.ChatRoom;

@Service
public class ChatDaoImpl implements ChatDao {
	
	@Autowired
	private SqlSession session;

	@Override
	public ChatRoom selectChatRoom(String room_no) {
		System.out.println("ChatDaoImpl selectChatRoom start...");
		return session.selectOne("hhchatroom", room_no);
	}

	@Override
	public int insertMessage(ChatMessage chatMessage) {
		System.out.println("ChatDaoImpl insertMessage start...");
		System.out.println(chatMessage);
		int message_no = 0;
		message_no = session.insert("hhchatinsert", chatMessage);
		System.out.println(message_no);
		return message_no;
	}

	@Override
	public List<ChatMessage> messageList(String room_no) {
		System.out.println("ChatDaoImpl messageList start...");
		return session.selectList("hhmessagelist", room_no);
	}

	@Override
	public int updateCount(ChatMessage message) {
		System.out.println("ChatDaoImpl update start...");
		int k = session.update("hhupdatecount", message);
		return k;
	}

	@Override
	public ChatRoom searchChatRoom(ChatRoom room) {
		System.out.println("ChatDaoImpl searchChatRoom start...");
		return session.selectOne("hhsearchchatroom", room);
	}

	@Override
	public int createChat(ChatRoom room) {
		System.out.println("ChatDaoImpl createChat start...");
		return session.insert("hhinsertroom", room);
	}

	@Override
	public List<ChatRoom> ChatRoomList(String mem_id) {
		System.out.println("ChatDaoImpl ChatRoomList start...");
		return session.selectList("hhchatroomlist", mem_id);
	}

	@Override
	public int selectUnReadCount(ChatMessage message) {
		System.out.println("ChatDaoImpl selectUnReadCount start...");
		return session.selectOne("hhselectunreadcount", message);
	}

	@Override
	public String selectroom_no(String you_name, String mem_name) {
		System.out.println("ChatDaoImpl selectroom_no start...");
		 Map<String, Object> map = new HashMap<String, Object>();  
	      map.put("you_name", you_name);
	      map.put("mem_name", mem_name);
		return session.selectOne("hhselectroom_no", map);
	}

	@Override
	public String insertChatroom(String you_name, String mem_name) {
		System.out.println("ChatDaoImpl insertChatroom start...");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("you_name", you_name);
	    map.put("mem_name", mem_name);
	    session.insert("hhinsertChatroom", map);
		return null;
	}

	@Override
	public List<String> allUser() {
		List<String> allUser = null;
		allUser = session.selectList("hhalluser");
		return allUser;
	}

	@Override
	public List<String> myroom(String mem_name) {
		List<String> myroom = null;
		myroom = session.selectList("hhmyroom", mem_name);
		return myroom;
	}

	@Override
	public int totalunread(String room_no,String mem_name) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("room_no", room_no);
	    map.put("mem_name", mem_name);
		int totalunread = session.selectOne("hhselectmyroomno",map);
		return totalunread;
	}

	@Override
	public int updateTotalCount(ChatMessage chatMessage) {
		int kk = 0;
		kk = session.update("hhupdatetotalcount", chatMessage);
		return kk;
	}

}

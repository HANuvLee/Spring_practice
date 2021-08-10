package com.oracle.s20210702.dao;

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
		return session.insert("hhchatinsert", chatMessage);
	}

	@Override
	public List<ChatMessage> messageList(String room_no) {
		System.out.println("ChatDaoImpl messageList start...");
		return session.selectList("hhmessagelist", room_no);
	}

	@Override
	public int updateCount(ChatMessage message) {
		System.out.println("ChatDaoImpl update start...");
		return session.update("hhupdatecount", message);
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

}

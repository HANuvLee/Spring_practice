package com.oracle.s20210702.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.oracle.s20210702.model.ChatMessage;
import com.oracle.s20210702.model.ChatRoom;
import com.oracle.s20210702.model.ChatSession;
import com.oracle.s20210702.model.Member_OfficeInfo;
import com.oracle.s20210702.service.ChatService;
import com.oracle.s20210702.service.MailService;

@Controller
public class ChatController {
	
	@Autowired
    private ChatService cService;
	
	@Autowired
    private ChatSession cSession;
	
	@Autowired
	private MailService ms;
	
//	@RequestMapping(value = "{room_no}.do")
//	public void messageList(@PathVariable String room_no, String mem_id, Model model, HttpServletResponse response) throws JsonIOException, IOException {
//		
//		List<ChatMessage> mList = cService.messageList(room_no);
//		response.setContentType("application/json; charset=utf-8");
//		
//		ChatMessage message = new ChatMessage();
//		message.setSen_message_id(mem_id);
//		message.setRoom_no(room_no);
//		cService.updateCount(message);
//		
//		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
//		gson.toJson(mList, response.getWriter());
//	}
//	
//	@ResponseBody
//	@RequestMapping("createChat.do")
//	public String createChat(ChatRoom room, String mem_name, String mem_id) {
//		
//		Member_OfficeInfo mo = ms.ListMember(mem_id);
//		
//		room.setMem_id(mem_id);
//		room.setMem_name(mem_name);
//		room.setYou_id(mo.getMem_id());
//		room.setYou_name(mo.getMem_name());
//		
//		ChatRoom exist = cService.searchChatRoom(room);
//		
//		if(exist == null) {
//            System.out.println("방이 없다!!");
//            int result = cService.createChat(room);
//            if(result == 1) {
//                System.out.println("방 만들었다!!");
//                return "new";
//            }else {
//                return "fail";
//            }
//        }
//        // DB에 방이 있을 때
//        else{
//            System.out.println("방이 있다!!");
//            return "exist";
//        }
//		
//	}
//	
//	@RequestMapping("chatRoomList.do")
//	public void createChat(ChatRoom room, ChatMessage message, String mem_id, HttpServletResponse response) throws JsonIOException, IOException {
//		System.out.println("mem_name->" + mem_id);
//		List<ChatRoom> cList = cService.ChatRoomList(mem_id);
//		
//		for(int i = 0; i < cList.size(); i++) {
//			message.setRoom_no(cList.get(i).getRoom_no());
//			message.setSen_message_id(mem_id);
//			int count = cService.selectUnReadCount(message);
//			cList.get(i).setUnread_count(count);
//		}
//		response.setContentType("application/json; charset=utf-8");
//		
//		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
//		gson.toJson(cList, response.getWriter());
//	}
//	@RequestMapping("chatSession.do")
//	public void chatSession(HttpServletResponse response) throws JsonIOException, IOException {
//		
//		ArrayList<String> chatSessionList = cSession.getLoginUser();
//		
//		response.setContentType("application/json; charset=utf-8");
//		
//		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
//		gson.toJson(chatSessionList, response.getWriter());
//	}
	
	@RequestMapping(value = "selectroom")
	@ResponseBody
	public void selectroom(Model model, ChatMessage message, ChatRoom room, String mem_name, String you_name, HttpServletResponse response) throws JsonIOException, IOException {
		System.out.println("ChatController selectroom start...");
		System.out.println("selectroom you_name->" + you_name);
		System.out.println("selectroom mem_name->" + mem_name);
		
		String room_no = cService.selectroom_no(you_name, mem_name);
		System.out.println("selectroom room_no->" + room_no);
//		List<ChatMessage> mList = cService.messageList(room_no);
//		System.out.println("selectroom mList -> " + mList);
		model.addAttribute("room_no", room_no);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		gson.toJson(room_no, response.getWriter());
	}
	
	@RequestMapping(value = "selectmessage")
	@ResponseBody
	public void selectmessage(HttpServletResponse response, String room_no, String sen_message_id) throws JsonIOException, IOException {
		System.out.println("ChatController selectmessage start...");
		System.out.println("selectmessage room_no -> " + room_no);
		System.out.println("selectmessage sen_message_id -> " + sen_message_id);
		List<ChatMessage> mList = cService.messageList(room_no);
		System.out.println("selectroom mList -> " + mList);
		
		
		response.setContentType("application/json; charset=utf-8");
		 
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        gson.toJson(mList,response.getWriter());
	}
	
	@RequestMapping(value = "updatemessage")
	@ResponseBody
	public void updatemessage(HttpServletResponse response, String room_no, String sen_message_id) {
		ChatMessage message = new ChatMessage();
		message.setSen_message_id(sen_message_id);
		message.setRoom_no(room_no);
		System.out.println("1111111111111111111111111111111" + message.getSen_message_id());
		System.out.println("1111111111111111111111111111111" + message.getRoom_no());
		cService.updateCount(message);
		System.out.println("1234");
		
	}
	
	@RequestMapping(value = "loginUser")
	@ResponseBody
	public void loginUser(HttpServletResponse response) throws JsonIOException, IOException {
		ArrayList<String> chatSessionList = cSession.getLoginUser();
		
		response.setContentType("application/json; charset=utf-8");
		 
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        gson.toJson(chatSessionList,response.getWriter());
	}

}

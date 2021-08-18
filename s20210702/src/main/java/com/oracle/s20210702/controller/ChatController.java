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
	
	@RequestMapping(value = "selectroom")
	@ResponseBody
	public void selectroom(Model model, ChatMessage message, ChatRoom room, String mem_name, String you_name, HttpServletResponse response) throws JsonIOException, IOException {
		System.out.println("ChatController selectroom start...");
		System.out.println("selectroom you_name->" + you_name);
		System.out.println("selectroom mem_name->" + mem_name);
		
		String room_no = cService.selectroom_no(you_name, mem_name);
		System.out.println("selectroom room_no->" + room_no);
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
	public void updatemessage(HttpServletResponse response, String room_no, String sen_message_id) throws JsonIOException, IOException {
		System.out.println("ChatController updatemessage start...");
		ChatMessage message = new ChatMessage();
		message.setSen_message_id(sen_message_id);
		message.setRoom_no(room_no);
		int k = cService.updateCount(message);
		int kk = cService.updateTotalCount(message);
		System.out.println("ChatController updatemessage k -->" + k);
		response.setContentType("application/json; charset=utf-8");
		 
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        gson.toJson(kk,response.getWriter());
		
	}
	
	@RequestMapping(value = "loginUser")
	@ResponseBody
	public void loginUser(HttpServletResponse response, String mem_name) throws JsonIOException, IOException {
		System.out.println("ChatController loginUser start...");
		ArrayList<String> chatSessionList = cSession.getLoginUser();
		
		response.setContentType("application/json; charset=utf-8");
		 
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        gson.toJson(chatSessionList,response.getWriter());
	}
	
	@RequestMapping(value = "logoutUser")
	@ResponseBody
	public void logoutUser(HttpServletResponse response, String mem_name) throws JsonIOException, IOException {
		System.out.println("ChatController logoutUser start...");
		List<String> allUser = cService.allUser();
		
		
		response.setContentType("application/json; charset=utf-8");
		 
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        gson.toJson(allUser, response.getWriter());
	}
	
	@RequestMapping(value = "loginunread_count")
	@ResponseBody
	public void loginunread_count(HttpServletResponse response, String mem_name) throws JsonIOException, IOException {
		System.out.println("ChatController loginunread_count start...");
		List<String> allUser = cService.allUser();
		ArrayList<String> chatSessionList = cSession.getLoginUser();
		List<String> myroom = new ArrayList<String>();
		List<Integer> loginroomunread = new ArrayList<Integer>();
		System.out.println("allUser -> " + allUser);
		System.out.println(myroom);
		for(int i = 0; i < chatSessionList.size(); i++) {
			if(!chatSessionList.get(i).equals(mem_name)) {
				System.out.println(chatSessionList.get(i));
				 String allUseri = cService.selectroom_no(chatSessionList.get(i),mem_name);
				System.out.println(allUseri);
				myroom.add(allUseri);
			}
		} 
		System.out.println("------------->" + myroom);
		for(int j = 0; j < myroom.size(); j++) {
			int totalunread = cService.totalunread(myroom.get(j), mem_name);
			loginroomunread.add(totalunread);
		}
		System.out.println("------->" + loginroomunread);
		response.setContentType("application/json; charset=utf-8");
		 
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        gson.toJson(loginroomunread, response.getWriter());
		
	}
	
	@RequestMapping(value = "logoutunread_count")
	@ResponseBody
	public void logoutunread_count(HttpServletResponse response, String mem_name) throws JsonIOException, IOException {
		System.out.println("ChatController logoutunread_count start...");
		List<String> allUser = cService.allUser();
		ArrayList<String> chatSessionList = cSession.getLoginUser();
		List<String> myroom = new ArrayList<String>();
		List<Integer> logoutroomunread = new ArrayList<Integer>();
		allUser.removeAll(chatSessionList);
		System.out.println("allUser -> " + allUser);
		System.out.println(myroom);
		for(int i = 0; i < allUser.size(); i++) {
				System.out.println(allUser.get(i));
				 String allUseri = cService.selectroom_no(allUser.get(i),mem_name);
				System.out.println(allUseri);
				myroom.add(allUseri);
		} 
		System.out.println("------------->" + myroom);
		for(int j = 0; j < myroom.size(); j++) {
			int totalunread = cService.totalunread(myroom.get(j),mem_name);
			logoutroomunread.add(totalunread);
		}
		System.out.println("------->" + logoutroomunread);
		response.setContentType("application/json; charset=utf-8");
		 
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        gson.toJson(logoutroomunread, response.getWriter());
		
	}

}

package com.oracle.s20210702.model;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component("cSession")
public class ChatSession {
    
    // static으로 필드변수를 설정하여 같은 ArrayList를 이용 할 수 있도록 선언합니다.
    private static ArrayList<String> member = new ArrayList<String>();
    
    // 로그인 시 ArrayList에 추가합니다.
    public void addmember(String sen_message_id) {
    	System.out.println("ChatSession addmember start..." );
        member.add(sen_message_id);
    }
    
//    // 로그아웃 시 ArrayList에서 제거합니다.
//    public void removeLoginUser(String sen_message_id) {
//        loginUser.remove(sen_message_id);
//    }
 
    // 현재 로그인 되어 있는 유저 목록을 가져옵니다.
    public static ArrayList<String> getMember() {
    	System.out.println("ChatSession getMember start..." );
        return member;
    }
 
    // 자동 setter. 사용하진 않았습니다.
    public static void setMember(ArrayList<String> member) {
    	System.out.println("ChatSession setMember start..." );
        ChatSession.member = member;
    }
}

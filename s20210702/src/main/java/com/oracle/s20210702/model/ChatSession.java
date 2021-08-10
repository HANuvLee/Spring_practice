package com.oracle.s20210702.model;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component("cSession")
public class ChatSession {
    
    // static으로 필드변수를 설정하여 같은 ArrayList를 이용 할 수 있도록 선언합니다.
    private static ArrayList<String> loginUser = new ArrayList<String>();
    
    // 로그인 시 ArrayList에 추가합니다.
    public void addLoginUser(String name) {
    	System.out.println("addmember sen_message_id ->" + name);
    	 int userChkIndex = loginUser.indexOf(name);
         System.out.println("userChkIndex : " + userChkIndex);
         if(userChkIndex >= 0 ) {
        	 System.out.println("이미 값이 존재합니다.");
         }
         else {
            
            loginUser.add(name);
         }
    	//loginUser.add(sen_message_id);
    }
    
    // 로그아웃 시 ArrayList에서 제거합니다.
    public void removeLoginUser(String name) {
    	loginUser.remove(name);
    }
 
    // 현재 로그인 되어 있는 유저 목록을 가져옵니다.
    public static ArrayList<String> getLoginUser() {
    	System.out.println("ArrayList getLoginUser->" + loginUser);
        return loginUser;
    }
 
    // 자동 setter. 사용하진 않았습니다.
    public static void setLoginUser(ArrayList<String> loginUser) {
    	System.out.println("setLoginUser ArrayList<String> LoginUser ->" + loginUser);
        ChatSession.loginUser = loginUser;
    }
}
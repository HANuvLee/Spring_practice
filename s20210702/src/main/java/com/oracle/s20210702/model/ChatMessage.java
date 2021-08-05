package com.oracle.s20210702.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChatMessage {
	private int message_no;
	private String room_no;
	private String message_content;
	private String sen_message_name;
	private String sen_message_id;
	private int unread_count;
	private int session_count;
	public ChatMessage() {
        super();
    }
	
	public ChatMessage(int message_no, String room_no, String message_content, String sen_message_name
					, String sen_message_id, int unread_count, int session_count) {
		super();
		this.message_no = message_no;
		this.room_no = room_no;
		this.message_content = message_content;
		this.sen_message_name = sen_message_name;
		this.sen_message_id = sen_message_id;
		this.unread_count = unread_count;
		this.session_count = session_count;
	}
	
	@Override
	public String toString() {
		return "ChatMessage [message_no = " + message_no + ",room_no = " + room_no + 
				",message_content = " + message_content + ",sen_message_name = " + sen_message_name + 
				",sen_message_id = " + sen_message_id + ",unread_count = " + unread_count + ",session_count = " + session_count + "]"; 
	}

}

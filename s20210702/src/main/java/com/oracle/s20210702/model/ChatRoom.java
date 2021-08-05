package com.oracle.s20210702.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatRoom {
	private String room_no;
	private String mem_id;
	private String mem_name;
	private String you_id;
	private String you_name;
	private int unread_count;
	public ChatRoom() {
        super();
    }
	public ChatRoom(String room_no, String mem_id, String mem_name,
					String you_id, String you_name, int unread_count) {
		super();
		this.room_no = room_no;
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.you_id = you_id;
		this.you_name = you_name;
		this.unread_count = unread_count;
	}
	
	@Override
	public String toString() {
		return "ChatRoom [room_no = " + room_no + ",mem_id = " + mem_id + 
				",mem_name = " + mem_name + ",you_id = " + you_id + 
				",you_name = " + you_name + ",unread_count = " + unread_count + "]";
	}

}

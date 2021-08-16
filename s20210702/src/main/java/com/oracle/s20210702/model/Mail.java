package com.oracle.s20210702.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Mail {
	private int mail_no;
	private String mem_no;
	private String mail_receiver;
	private String mail_title;
	private String mail_content;
	private Date mail_send_time;
	private String mem_name;
	private String mem_rank;
	private int mail_del;
	
	
	
	//조회용
	private String search;   private String keyword;
	private String pageNum;  
	private int start; 		 private int end;
	
	private String mem_id;
	private String chk;

	
	
	@Override
	public String toString() {
		return "Mail [mail_no = " + mail_no + ",mem_no = " + mem_no + 
				",mail_receiver = " + mail_receiver + ",mail_title = " + mail_title + 
				",mail_content = " + mail_content + ",mail_send_time = " + mail_send_time + 
				",mem_name = " + mem_name + ",mem_rank = " + mem_rank + 
				",mail_del = " + mail_del + "]";
	}
  
}


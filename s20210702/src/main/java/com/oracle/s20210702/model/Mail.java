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
  
}


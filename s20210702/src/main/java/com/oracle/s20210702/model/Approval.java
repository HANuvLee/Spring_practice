package com.oracle.s20210702.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Approval {
	
	//테이블 기본 정보
	private int app_doc_no;
	private String app_doc_kind;
	private int file_no;
	private String app_doc_title;
	private String app_doc_memberto1;
	private String app_doc_memberto2;
	private String app_doc_memberto3;
	private String app_doc_content;
	private String app_doc_status;
	private Date app_doc_date;
	private String mem_no;
	private int app_auth_no;
	private Date sch_start_date;
	private Date sch_end_date;
	
	//차량 기입용
	private int car_no;
	
	//조회용
	private String pageNum;  
	private int start; 		 private int end;
	
	//결재여부 확인용
	private String memfrom1;
	private String memfrom2;
	private String memfrom3;
	
}

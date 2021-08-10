package com.oracle.s20210702.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member_OfficeInfo {
	private String mem_no;
	private int dept_no;
	private int team_no;
	private String mem_id;
	private String mem_pw;
	private String mem_name;
	private String mem_rank;
	private Date mem_join_date;
	private Date mem_quit_date;
	private String mem_status;
	private String mem_tel;
	
	// main page용
	private String team_name;

	
}

package com.oracle.s20210702.model;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {

	//list 용
	private int board_no;
	private int post_no;
	private int mem_no;
	private Date post_date;
	private String post_title;
	private String post_content;
	
	//신상정보 표시용
	private String mem_name;
	private String mem_rank;
	private String mem_tel;
	
	// 조회용
		private String search;   private String keyword;
		private String pageNum;  
		private int start; 		 private int end;


	
}

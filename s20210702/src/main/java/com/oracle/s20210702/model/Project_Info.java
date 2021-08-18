package com.oracle.s20210702.model;

import java.util.Date;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Project_Info {
	
	private int board_no;
	private String mem_no;
	
	private String project_name;
	private int project_no;
	

	private String project_start;
	private String project_end;


	private String project_company;
	private String project_progress;
	
	private int project_excost;
	private int project_realcost;
	
	private String project_url;
	private int mail_file_no;
	
	//조회용
	private String search;
	private String keyword;
	private String pageNum;
	private int start;
	private int end;

}

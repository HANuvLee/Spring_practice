package com.oracle.s20210702.model;



import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Schedule {

	// 테이블 입출력용
	private String schedule_kind;
	private String schedule_no;
	private String schedule_name;
	private String schedule_start;
	private String schedule_end;
	private String schedule_content;
	private String mem_no;
	
	//vacaday 연산용...
	private float vday;
}

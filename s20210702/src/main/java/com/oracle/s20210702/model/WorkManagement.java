package com.oracle.s20210702.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkManagement {

	private String mem_no;
	private int work_seq_num;
	
	private Date work_date;
	private Date work_in_time;
	private Date work_out_time;
	
	//업무시간 관리용
	private int work_time_avg;
	private int work_time_sum;
	private int work_day_cnt;
	private int overtime;
	
	private Date sysdate;
	private int worktime_hh;
	private int worktime_mi;
	private int worktime_ss;
	private int worktime_full;
	
	private int days_;
	private int months_;
	private int years_;
	private int day_nos_;
	
	private int daily_overtime_hh;
	private int daily_overtime_mi;
	private int daily_overtime_ss;
	private int daily_overtime_full;
	
	
}

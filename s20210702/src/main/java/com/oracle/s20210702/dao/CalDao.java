package com.oracle.s20210702.dao;

import java.util.List;

import com.oracle.s20210702.model.CalData;
import com.oracle.s20210702.model.Schedule;

public interface CalDao {

	int 											todocnt(String targetDateString, String mem_no);

	List<Schedule> 					listSchedule(String targetDateString, String mem_no);

	int 											schIns(String schedule_kind, String schedule_name, String startDateString, String endDateString,
																	String schedule_content, String mem_no);

	int 											dccheck(String schedule_no, String mem_no);

	int 											upSche(String schedule_no, String mem_no);



	

	

	

}

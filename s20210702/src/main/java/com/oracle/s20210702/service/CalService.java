package com.oracle.s20210702.service;

import java.util.List;

import com.oracle.s20210702.model.CalData;
import com.oracle.s20210702.model.Schedule;

public interface CalService {

	CalData 					getTodayInfo();

	List<CalData> 		getCallistall(String mem_no);

	int 								todotot(String targetDateString, String mem_no);

	List<Schedule> 		listSchedule(String targetDateString, String mem_no);

	int 								scheIns(String schedule_kind, String schedule_name, String startDateString, String endDateString,
														String schedule_content, String mem_no);

	int 								checkcond(String schedule_no, String mem_no);

	int 								updsche(String schedule_no, String mem_no);

	int 								todotot2(int years, String mem_no);

	List<Schedule> 		listSchedule2(int years, String mem_no);

	



	

	

}

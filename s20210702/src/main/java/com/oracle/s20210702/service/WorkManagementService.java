package com.oracle.s20210702.service;

import java.util.List;

import com.oracle.s20210702.model.WorkManagement;

public interface WorkManagementService {

	WorkManagement 				ctview(String mem_no);
	int 												inswit(String mem_no);
	String											next_seq_num();
	int 												toutbtn(String mem_no);
	WorkManagement 				weeklyworktime(String mem_no);
	int 												ccheck(String mem_no);
	WorkManagement 				todayworktime(String mem_no);
	List<WorkManagement> 	weeklyCTCheck(String mem_no);
	
}

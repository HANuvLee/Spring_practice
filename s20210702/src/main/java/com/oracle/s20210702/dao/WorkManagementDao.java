package com.oracle.s20210702.dao;

import org.springframework.stereotype.Repository;

import com.oracle.s20210702.model.WorkManagement;

@Repository
public interface WorkManagementDao {

	WorkManagement 				ctview(String mem_no);

	int 												inswit(String mem_no);
	int												next_seq_num();

	int 												toutbtn(String mem_no);

	WorkManagement 				weeklyworktime(String mem_no);

	int 												ccheck(String mem_no);

}

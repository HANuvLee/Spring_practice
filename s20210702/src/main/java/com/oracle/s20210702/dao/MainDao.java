package com.oracle.s20210702.dao;

import com.oracle.s20210702.model.Member_OfficeInfo;

public interface MainDao {

	Member_OfficeInfo 				pfview(String mem_no);

	float 												vacacheck(String mem_no);

	String 													rankcheck(String mem_no);

}

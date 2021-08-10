package com.oracle.s20210702.service;

import com.oracle.s20210702.model.Member_OfficeInfo;

public interface MainService {

	Member_OfficeInfo 					pfview(String mem_no);

	float 													vacacheck(String mem_no);

	float 														rankcheck(String mem_no);

	

}

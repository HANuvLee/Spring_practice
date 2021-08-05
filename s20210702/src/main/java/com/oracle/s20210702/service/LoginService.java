package com.oracle.s20210702.service;

import java.util.List;

import com.oracle.s20210702.model.Member_OfficeInfo;

public interface LoginService {

	int 						login(Member_OfficeInfo mo);
	Member_OfficeInfo 			member(String mem_id);
	

	
	
	

}

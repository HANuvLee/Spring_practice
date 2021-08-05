package com.oracle.s20210702.dao;

import java.util.List;

import com.oracle.s20210702.model.Member_OfficeInfo;

public interface LoginDao {

	int     loginId_chk(String mem_id);

	int 	loginPw_chk(String mem_pw);

	Member_OfficeInfo member(String mem_id);

	
	

	
	
	

}

package com.oracle.s20210702.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210702.dao.LoginDao;
import com.oracle.s20210702.model.Member_OfficeInfo;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao ld;

	@Override
	public int login(Member_OfficeInfo mo){
        int result = 0;
		if(ld.loginId_chk(mo.getMem_id()) == 0) {
         	System.out.println("등록된 아이디가 없습니다.");
        }else {
        	if(ld.loginPw_chk(mo.getMem_pw()) == 0) {
        		System.out.println("비밀번호가 틀립니다.");
        	}else {
        		System.out.println("로그인에 성공하였습니다.");
        		result = 1;
        	}
        }
		return result;	
	}

	@Override
	public Member_OfficeInfo member(String mem_id) {
		Member_OfficeInfo member = null;
		member = ld.member(mem_id);
		return member;
	}

	
	

}

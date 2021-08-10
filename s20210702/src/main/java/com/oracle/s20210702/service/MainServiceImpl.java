package com.oracle.s20210702.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210702.dao.MainDao;
import com.oracle.s20210702.model.Member_OfficeInfo;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	private MainDao md;
	
	//메인화면 프로필박스 프로필 조회
	@Override
	public Member_OfficeInfo pfview(String mem_no) {
		System.out.println("Main Serv IMPL pfview start");
		Member_OfficeInfo mo = null;
		System.out.println("Main_Serv_impl__mem_no = "+mem_no);
		mo = md.pfview(mem_no);
		return mo;
	}

	//메인화면 휴가 체크 관련
	@Override
	public float vacacheck(String mem_no) {
		float vcresult = md.vacacheck(mem_no);
		return vcresult;
	}

	//메인 화면 직위 체크 관련
	@Override
	public float rankcheck(String mem_no) {
		float vtotstatus = 0;
		String mem_rank = md.rankcheck(mem_no);
		System.out.println("mem_rank ==>" + mem_rank );
		if (mem_rank.equals("회장")) {vtotstatus = 7;}
		else if(mem_rank.equals("사장")) {vtotstatus=6;}
		else if(mem_rank.equals("부장")) {vtotstatus=5;}
		else if(mem_rank.equals("과장")) {vtotstatus=4;}
		else if(mem_rank.equals("차장")) {vtotstatus=3;}
		else if(mem_rank.equals("대리")) {vtotstatus=2;}
		else if(mem_rank.equals("사원")) {vtotstatus=1;}
		
		System.out.println("MSI vtotStatus =>"+vtotstatus);
		
		return vtotstatus;
	}

	
	
}

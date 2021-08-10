package com.oracle.s20210702.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210702.model.Member_OfficeInfo;

@Repository
public class MainDaoImpl implements MainDao {

	@Autowired
	private SqlSession session;
	
	//main화면 profile box 내 profile조회
	@Override
	public Member_OfficeInfo pfview(String mem_no) {
		System.out.println("main_dao_impl_pfview_start");
		Member_OfficeInfo mo = new Member_OfficeInfo();
		
		try {
			mo = session.selectOne("ssMainPfView",mem_no);
		} catch (Exception e) {
			System.out.println("main_dao_impl_pf_view_exception ->"+ e.getMessage());
		}
		return mo;
	}

	//메인화면 휴가 관련 조회
	@Override
	public float vacacheck(String mem_no) {
		System.out.println("MDI _vacacheck!");
		float vcresult=0;
		try {
			vcresult = session.selectOne("ssVacaCheck",mem_no);
			System.out.println("vcresult = " + vcresult);
			
		} catch (Exception e) {
			System.out.println("MDI VACACHECK EXCEPTION -> "+ e.getMessage());
		}
		
		return vcresult;
	}

	//main 직위 체크 관련//
	@Override
	public String rankcheck(String mem_no) {
		System.out.println("MDI_RANKCHECK");
		String mem_rank = "";
		try {
			mem_rank = session.selectOne("ssRankCheck",mem_no);
			System.out.println("MDI mem_rank ==>" + mem_rank);
		} catch (Exception e) {
			System.out.println("MDI RANKCHECK EXCEPTION -> "+ e.getMessage());
		}
		
		return mem_rank;
	}

	
	
	
	
	
}

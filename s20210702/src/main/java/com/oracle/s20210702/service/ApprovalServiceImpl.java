package com.oracle.s20210702.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210702.dao.ApprovalDao;
import com.oracle.s20210702.model.Approval;
import com.oracle.s20210702.model.Board;
import com.oracle.s20210702.model.Car;

@Service
public class ApprovalServiceImpl implements ApprovalService {

	@Autowired
	private ApprovalDao apd;
	
	//결재 목록/상신목록 리스팅
	@Override
	public int total1(String mem_no) {
		System.out.println("APPRServiceImpl Start total..." );
		int totCnt1 = apd.total1(mem_no);
		System.out.println("APPRServiceImpl total totCnt->"+totCnt1 );
		return totCnt1;
		
	}

	@Override
	public List<Approval> listAppr1(Approval apr) {
		List<Approval> apprList1 = null;
		System.out.println("ApprServiceImpl list Start..." );
		apprList1 = apd.listAppr1(apr);
		System.out.println("ApprServiceImpl list1 apprList.size()->" +apprList1.size());
		return apprList1;
	}

	@Override
	public int total2(String mem_no) {
		System.out.println("APPRServiceImpl Start total2..." );
		int totCnt2 = apd.total2(mem_no);
		System.out.println("APPRServiceImpl total totCnt->"+totCnt2 );
		return totCnt2;
	}

	@Override
	public List<Approval> listAppr2(Approval apr) {
		List<Approval> apprList2 = null;
		System.out.println("ApprServiceImpl list2 Start..." );
		apprList2 = apd.listAppr2(apr);
		System.out.println("ApprServiceImpl list2 apprList.size()->" +apprList2.size());
		return apprList2;
	}

	//결재상신1
	@Override
	public int apinsert1(Approval apr) {
		int apresult = 0;
		System.out.println("appr Service Impl Insert1 Start");
		apresult = apd.apinsert1(apr);
		System.out.println("appr_service_impl_insert1_result = "+apresult);
		return apresult;
		
	}

	@Override
	public int apinsert11(int max_adno) {
		int apresult11 = 0;
		System.out.println("appr Service Impl Insert1 Start");
		apresult11 = apd.apinsert11(max_adno);
		System.out.println("appr_service_impl_insert1_result = "+apresult11);
		return apresult11;
	}

	@Override
	public int maxadno() {
		int maxadno=0;
		System.out.println("appr Service Impl Insert1 Start");
		maxadno = apd.adnomax();
		System.out.println("appr_service_impl_insert1_result = "+maxadno);
		
		return maxadno;
	}

	//결재상신2 중 이용가능 차량 체크
	@Override
	public List<Car> carcheck(Approval apr) {
		System.out.println("apprSI CARCHECK STA");
		List<Car> carlist1 = apd.carcheck1(apr);
		return carlist1;
	}

	//결재상신2 글쓰기
	@Override
	public int apinsert2(Approval apr) {
		System.out.println("appr Service Impl Insert2 Start");
		int apresult2=0;
		apresult2 = apd.apinsert2(apr);
		System.out.println("appr_service_impl_insert2_result = "+apresult2);
		return apresult2;
	}

	//결재상신2 차량 등록
	@Override
	public int carinsert2(Approval apr) {
		int carresult2=0;
		carresult2 = apd.carinsert2(apr);
		System.out.println("appr_service_impl_carinsert2_result = "+carresult2);
		return carresult2;
	}
	
	
	//결재상신3 일반등록
	@Override
	public int apinsert3(Approval apr) {
		System.out.println("appr Service Impl Insert3 Start");
		int apresult3=0;
		apresult3 = apd.apinsert3(apr);
		System.out.println("appr_service_impl_insert3_result = "+apresult3);
		return apresult3;
	}

	//결재승인중 mt1인지 2인지 체크
	@Override
	public int checkmt1(String mem_no1,String mem_no2, int doc_no) {
		System.out.println("service impl!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("test mem_no1-->"+mem_no1);
		System.out.println("test mem_no2-->"+mem_no2);
		System.out.println("test doc_no  -- >"+doc_no);
		
		int cmtresult1 = apd.checkmt1(mem_no1,mem_no2,doc_no);
		return cmtresult1;
	}

}

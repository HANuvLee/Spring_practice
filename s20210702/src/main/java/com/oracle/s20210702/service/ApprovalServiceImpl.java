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

	//결재 해야할 목록 리스팅2
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

	//auth no 확인
	@Override
	public int getauthno(String mem_no1) {
		System.out.println("apprsi getauthno start");
		int auth_nos=0;
		auth_nos = apd.getauthnos(mem_no1);
		return auth_nos;
	}
	
	//app_check update (memberto2,3,1)
	@Override
	public int up_apck2(Approval apr) {
		System.out.println("appsi up_apck Start!!!!!");
		System.out.println("apr data check!! auth_no==>"+apr.getApp_auth_no());
		System.out.println("apr data check!! doc_no==>"+apr.getApp_doc_no());
		int up_apcks = 0;
		
		if(apr.getApp_auth_no() == 1) {
			up_apcks = 10 + apd.up_apcks1(apr);
		}
		if(apr.getApp_auth_no() == 2) {
			up_apcks = 20 + apd.up_apcks2(apr);
		}
		if(apr.getApp_auth_no() == 3) {
			up_apcks = 30 + apd.up_apcks3(apr);
		}
		
		
		return up_apcks;
	}

	///대표용 결재목록 리스트
	@Override
	public List<Approval> listApprT(Approval apr) {
		List<Approval> apprListT = null;
		System.out.println("ApprServiceImpl listT Start..." );
		apprListT = apd.listApprT(apr);
		System.out.println("ApprServiceImpl listT apprList.size()->" +apprListT.size());
		return apprListT;
	}

	@Override
	public int totalT(String mem_no) {
		System.out.println("APPRServiceImpl Start totalT..." );
		int totCntT = apd.totalT(mem_no);
		System.out.println("APPRServiceImpl total totCnt->"+totCntT );
		return totCntT;
	}

	@Override
	public int up_apck2N(Approval apr) {
		System.out.println("appsi up_apck Start!!!!!");
		System.out.println("apr data check!! auth_no==>"+apr.getApp_auth_no());
		System.out.println("apr data check!! doc_no==>"+apr.getApp_doc_no());
		int up_apckNs = 0;
		
		if(apr.getApp_auth_no() == 1) {
			up_apckNs = 10 + apd.up_apcksN1(apr);
		}
		if(apr.getApp_auth_no() == 2) {
			up_apckNs = 20 + apd.up_apcksN2(apr);
		}
		if(apr.getApp_auth_no() == 3) {
			up_apckNs = 30 + apd.up_apcksN3(apr);
		}
		
		
		return up_apckNs;
	}

	@Override
	public Approval showAppData(int app_doc_no) {
		Approval showADATA = new Approval();
		showADATA = apd.showAppData(app_doc_no);
		
		return showADATA;
	}

	//app_doc_status 변경
	@Override
	public int up_app_status(int app_doc_no) {
		int upsta = apd.upstatus(app_doc_no);
		return upsta;
	}

	//승인난 스케쥴을 스케쥴테이블에 밀어넣기
	@Override
	public int inshefrap(Approval app1) {
		int inshefrap = apd.inshefrap(app1);
		return inshefrap;
	}

	//memfrom3 을 10으로 변경
	@Override
	public int upmf310(int app_doc_no) {
		int up_mf310 = apd.upmf310(app_doc_no);
		return up_mf310;
	}

	//메인화면 카 available cnt
	@Override
	public int caravailcnt() {
		int carcnt = apd.caracnt();
		return carcnt;
	}

	

}

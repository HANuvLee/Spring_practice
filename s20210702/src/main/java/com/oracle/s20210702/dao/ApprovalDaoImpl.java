package com.oracle.s20210702.dao;

import java.util.List;

import javax.print.Doc;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210702.model.Approval;
import com.oracle.s20210702.model.Board;
import com.oracle.s20210702.model.Car;

@Repository
public class ApprovalDaoImpl implements ApprovalDao {
	
	@Autowired
	private SqlSession session;

	@Override
	public int total1(String mem_no) {
		int tot1 = 0;
		System.out.println("APPRDaoImpl Start total1..." );
		try {

			 tot1 = session.selectOne("ssApprtotal1",mem_no);
			System.out.println("APPRDaoImpl Start total..." );
		} catch (Exception e) {
			System.out.println("APPRDaoImpl total Exception->"+e.getMessage());
		}
		
		return tot1;
	}

	@Override
	public List<Approval> listAppr1(Approval apr) {
		List<Approval> apprList1 = null;
		System.out.println("ApprDaoImpl listAppr Start ..." );
		
		try {
			// Naming Rule 
			apprList1 = session.selectList("ssApprList1", apr);
		} catch (Exception e) {
			System.out.println("APPRDaoImpl apprList Exception->"+e.getMessage());
		}
		return apprList1;
		
	}

	@Override
	public int total2(String mem_no) {
		int tot2 = 0;
		System.out.println("APPRDaoImpl Start total2..." );
		try {

			 tot2 = session.selectOne("ssApprtotal2",mem_no);
			System.out.println("APPRDaoImpl Start total2..." );
		} catch (Exception e) {
			System.out.println("APPRDaoImpl total2 Exception->"+e.getMessage());
		}
		
		return tot2;
	}

	@Override
	public List<Approval> listAppr2(Approval apr) {
		List<Approval> apprList2 = null;
		System.out.println("ApprDaoImpl listAppr2 Start ..." );
		
		try {
			// Naming Rule 
			apprList2 = session.selectList("ssApprList2", apr);
		} catch (Exception e) {
			System.out.println("APPRDaoImpl apprList2 Exception->"+e.getMessage());
		}
		return apprList2;
	}

	@Override
	public int apinsert1(Approval apr) {
		int apresult = 0;
		System.out.println("appr Dao IMPL insert1 start");
		System.out.println("test//getApp_doc_memberto1-->" + apr.getApp_doc_memberto1());
		System.out.println("test//getApp_doc_memberto2-->" + apr.getApp_doc_memberto2());
		System.out.println("type of getApp_doc_memberto2--> "+(apr.getApp_doc_memberto2()).getClass().getName());
		try {
			apresult = session.insert("ssapprinsert1",apr);
			System.out.println("appr_dao_impl_insert1_result = "+apresult);
		} catch (Exception e) {
				System.out.println("apresult Dao IMPL Exception ->" + e.getMessage());
		}
		return apresult;
		
		
	}

	@Override
	public int apinsert11(int max_adno) {
		int apresult11 = 0;
		System.out.println("appr Dao IMPL insert11 start");
		try {
			apresult11 = session.insert("ssapprinsert11",max_adno);
			System.out.println("appr_dao_impl_insert11_result = "+apresult11);
		} catch (Exception e) {
				System.out.println("apresult Dao IMPL Exception ->" + e.getMessage());
		}
		return apresult11;
	}

	@Override
	public int adnomax() {
		int max_adno=0;
		System.out.println("appr Dao IMPL max_adno start");
		try {
			max_adno = session.selectOne("ssadnomax");
			System.out.println("appr_dao_impl_max_adno = "+max_adno);
		} catch (Exception e) {
				System.out.println("apresult Dao IMPL Exception ->" + e.getMessage());
		}
		return max_adno;
		
		
	}

	//결재2 차 사용 가능 여부 검색
	@Override
	public List<Car> carcheck1(Approval apr) {
		List<Car> carlist1 = null;
		System.out.println("appr di carcheck start");
		try {
			carlist1 = session.selectList("sscarcheck",apr);
		} catch (Exception e) {
			System.out.println("appr Dao IMPL carcheck Exception ->" + e.getMessage());
		}
		
		
		return carlist1;
	}

	//결재상신2 메인
	@Override
	public int apinsert2(Approval apr) {
		int apresult2 = 0;
		System.out.println("appr Dao IMPL insert2 start");
		System.out.println("test//getApp_doc_memberto1-->" + apr.getApp_doc_memberto1());
		System.out.println("test//getApp_doc_memberto2-->" + apr.getApp_doc_memberto2());
//		System.out.println("type of getApp_doc_kind--> "+(apr.getApp_doc_kind()).getClass().getName());
		System.out.println("test//getAPP_doc_kind --> " + apr.getApp_doc_kind());
		try {
			apresult2 = session.insert("ssapprinsert2",apr);
			System.out.println("appr_dao_impl_insert2_result = "+apresult2);
		} catch (Exception e) {
				System.out.println("apresult2 Dao IMPL Exception ->" + e.getMessage());
		}
		return apresult2;
	}

	//결재상신2 차등록
	@Override
	public int carinsert2(Approval apr) {
		int carresult2 = 0;
		System.out.println("appr Dao IMPL carinsert2 start");
		try {
			carresult2=session.update("sscarinsert2",apr);
		} catch (Exception e) {
			System.out.println("carresult2 Dao IMPL Exception ->" + e.getMessage());
		}
		
		
		return carresult2;
	}

	@Override
	public int apinsert3(Approval apr) {
		int apresult3 = 0;
		System.out.println("appr Dao IMPL insert3 start");
		System.out.println("test//getApp_doc_memberto1-->" + apr.getApp_doc_memberto1());
		System.out.println("test//getApp_doc_memberto2-->" + apr.getApp_doc_memberto2());
//		System.out.println("type of getApp_doc_kind--> "+(apr.getApp_doc_kind()).getClass().getName());
		System.out.println("test//getAPP_doc_kind --> " + apr.getApp_doc_kind());
		try {
			apresult3 = session.insert("ssapprinsert3",apr);
			System.out.println("appr_dao_impl_insert3_result = "+apresult3);
		} catch (Exception e) {
				System.out.println("apresult3 Dao IMPL Exception ->" + e.getMessage());
		}
		return apresult3;
	}

	//mt1 check!
	@Override
	public int checkmt1(String mem_no1,String mem_no2, int doc_no) {
		Approval apr = null;
		apr.setApp_doc_no(doc_no);
		apr.setApp_doc_memberto1(mem_no1);
		apr.setMem_no(mem_no2);
		
		System.out.println("doc_no -->" + apr.getApp_doc_no());
		System.out.println("memberto1 -->" + apr.getApp_doc_no());
		System.out.println("mem_no -->" + apr.getMem_no());
		
		int checktest1=0;
		try {
		
		
		checktest1=session.selectOne("sscheckmt1",apr);
		System.out.println("checktest1 ==> "+ checktest1);		
			
		} catch (Exception e) {
			System.out.println("mtcheck1 Dao IMPL Exception ->" + e.getMessage());
		}
		
		return checktest1;
	}
	
	
	
	
}

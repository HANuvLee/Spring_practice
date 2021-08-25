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
	
	
	//authno 확인
	@Override
	public int getauthnos(String mem_no1) {
		System.out.println("apprdi getAuthno start");
		int auth_nod = 0;
		
		try {
			auth_nod = session.selectOne("ssgetAuthno",mem_no1);
			System.out.println("test//auth_nod ==>" + auth_nod);
			
		} catch (Exception e) {
			System.out.println("getauthnod app Dao IMPL Exception ->" + e.getMessage());
		}
		
		return auth_nod;
	}

	//app_check 테이블 업데이트!
	@Override
	public int up_apcks1(Approval apr) {
		//관리자급 // app_check update액션
		
		int up_apckd1 = 0;
	
		try {
			up_apckd1 = session.update("ssupApck1",apr);
		} catch (Exception e) {
			System.out.println("up_APCKD1 app Dao IMPL Exception ->" + e.getMessage());
		}
		
		
		return up_apckd1;
	}

	@Override
	public int up_apcks2(Approval apr) {
	//부장급 // app_check update액션
		
		int up_apckd2 = 0;
	
		try {
			up_apckd2 = session.update("ssupApck2",apr);
		} catch (Exception e) {
			System.out.println("up_APCKD2 app Dao IMPL Exception ->" + e.getMessage());
		}
		
		
		return up_apckd2;
		
		
	}

	@Override
	public int up_apcks3(Approval apr) {
	// 팀장급 // app_check update액션
		
		int up_apckd3 = 0;
	
		try {
			up_apckd3 = session.update("ssupApck3",apr);
		} catch (Exception e) {
			System.out.println("up_APCKD3 app Dao IMPL Exception ->" + e.getMessage());
		}
		
		
		return up_apckd3;
	}

	//대표 전용 리스트
	@Override
	public List<Approval> listApprT(Approval apr) {
		List<Approval> apprListT = null;
		System.out.println("ApprDaoImpl listApprT Start ..." );
		
		try {
			// Naming Rule 
			apprListT = session.selectList("ssApprListT", apr);
		} catch (Exception e) {
			System.out.println("APPRDaoImpl apprList2 Exception->"+e.getMessage());
		}
		return apprListT;
	}

	@Override
	public int totalT(String mem_no) {
		int totT = 0;
		System.out.println("APPRDaoImpl Start totalT..." );
		try {

			 totT = session.selectOne("ssApprtotalT",mem_no);
			System.out.println("APPRDaoImpl Start totalT..." );
		} catch (Exception e) {
			System.out.println("APPRDaoImpl totalT Exception->"+e.getMessage());
		}
		
		return totT;
	}

	@Override
	public int up_apcksN1(Approval apr) {
		// 대표급 // app_check update액션
		
		int up_apckdN1 = 0;
	
		try {
			up_apckdN1 = session.update("ssupApckN1",apr);
		} catch (Exception e) {
			System.out.println("up_APCKDN1 app Dao IMPL Exception ->" + e.getMessage());
		}
		
		
		return up_apckdN1;
	}

	@Override
	public int up_apcksN2(Approval apr) {
		// 부장급 // app_check update액션
		
		int up_apckdN2 = 0;
	
		try {
			up_apckdN2 = session.update("ssupApckN2",apr);
		} catch (Exception e) {
			System.out.println("up_APCKDN2 app Dao IMPL Exception ->" + e.getMessage());
		}
		
		
		return up_apckdN2;
	}

	@Override
	public int up_apcksN3(Approval apr) {
		// 팀장급 // app_check update액션
		
				int up_apckdN3 = 0;
			
				try {
					up_apckdN3 = session.update("ssupApckN3",apr);
				} catch (Exception e) {
					System.out.println("up_APCKDN3 app Dao IMPL Exception ->" + e.getMessage());
				}
				
				
				return up_apckdN3;
	}

	
	//결제 최종승인후 기본정보 읽어오기
	@Override
	public Approval showAppData(int app_doc_no) {
		Approval showADATA = new Approval();
		
		try {
			showADATA = session.selectOne("ssShowAdata",app_doc_no);
		} catch (Exception e) {
			System.out.println("최종승인 완료 후 기본정보 읽어오기 ! 오류 -->"+ e.getMessage());
		}
		
		
		return showADATA;
	}

	//status 변경
	@Override
	public int upstatus(int app_doc_no) {
		int upstat  = 0;
		
		try {
			upstat = session.update("ssupstat",app_doc_no);
		} catch (Exception e) {
			System.out.println("최종승인-> 스테이터스변경 오류 -->"+ e.getMessage());
		}
		
		return upstat;
	}

	@Override
	public int inshefrap(Approval app1) {
		int inshfrap = 0;
		
		try {
			inshfrap = session.insert("ssinshefrap",app1);
		} catch (Exception e) {
			System.out.println("최종승인->스케쥴 테이블에 밀어넣기 에러?-->"+e.getMessage());
		}
		return 0;
	}

	// memfrom3을 10으로 변경
	@Override
	public int upmf310(int app_doc_no) {
		int up_mf310 = 0;
		
		try {
			up_mf310 = session.update("ssmf310",app_doc_no);
		} catch (Exception e) {
			System.out.println("최종승인->memfrom3을 10으로 에러?-->"+e.getMessage());
		}
		return up_mf310;
	}

	//메인화면 car cnt
	@Override
	public int caracnt() {
		int caravailcnt = session.selectOne("sscarcnt");
		return caravailcnt;
	}

	
	
	
	
	
}

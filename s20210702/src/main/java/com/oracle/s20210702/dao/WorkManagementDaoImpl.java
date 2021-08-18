package com.oracle.s20210702.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210702.model.CalData;
import com.oracle.s20210702.model.WorkManagement;

@Repository
public class WorkManagementDaoImpl implements WorkManagementDao {

	@Autowired
	private SqlSession session;

	
	//출퇴근 시간 조회
	@Override
	public WorkManagement ctview(String mem_no) {
		System.out.println("WM_Dao ctview Start");
		WorkManagement wm = new WorkManagement();
		
		try {
			
			System.out.println("WM_DAO_IMPL_mem_no_before" + mem_no);
			wm = session.selectOne("ssWMCtview",mem_no);
			System.out.println("WM_DAO_IMPL_mem_no after" + mem_no);
//			System.out.println("wm memno -->"+wm.getMem_no() );
//			System.out.println("wm wd -->"+wm.getWork_date() );
//			System.out.println("wm wit -->"+wm.getWork_in_time() );
//			System.out.println("wm wot -->"+wm.getWork_out_time() );
		} catch (Exception e) {
			System.out.println("WMDaoImpl ct_view exception -> "+e.getMessage());
		}
		return wm;
	}

	
	//work_seq_num nextval 계산
		@Override
		public int next_seq_num() {
			System.out.println("WMDAO nextseqnum start");
			int max_seq_num = 0;
			int next_seq_num1=0;
			try {
				max_seq_num = session.selectOne("ssMaxSeqWork");
				next_seq_num1 = max_seq_num+1;
				
				System.out.println("max_seq_num ==>"+max_seq_num);
				System.out.println("next_seq_num ==>"+next_seq_num1);
				
				
			} catch (Exception e) {
				System.out.println("wmdao nex_seq exception -> "+e.getMessage());
			}
			
			
			return next_seq_num1;
		}
	
	//출근 시간 입력
	@Override
	public int inswit(String mem_no) {
		System.out.println("WM_Dao inswit Start");
		int inswitresult = 0;
		
		try {
			System.out.println("WMDAO_INSWIT_MEMNO= "+mem_no);
			
			inswitresult = session.insert("ssWMInswit",mem_no);
			System.out.println("wmdao_inswitresult" +inswitresult);
		} catch (Exception e) {
			System.out.println("wmdaoimpl inswit exception ->"+e.getMessage());
		}
		
		
		return inswitresult;
	}

	//퇴근시간 update
	@Override
	public int toutbtn(String mem_no) {
		int toutresult = 0;
		try {
			toutresult = session.update("ssWMToutUpdate",mem_no);
			System.out.println("wmdao_toutresult==>"+toutresult);
		} catch (Exception e) {
			System.out.println("wmdaoimpl toutbtn Exception --> "+e.getMessage());
		}
		
		return toutresult;
	}

	//주당 근무시간 관련
	@Override
	public WorkManagement weeklyworktime(String mem_no) {
		System.out.println("wmdi_weeklywtime start");
		WorkManagement wm2 = new WorkManagement();
		try {
			wm2 = session.selectOne("ssWeeklyWtime", mem_no);
			System.out.println("wm2.getWorkDayCnt =>" +wm2.getWork_day_cnt());
			System.out.println("wm2.getWorkTimeAvg =>" +wm2.getWork_time_avg());
			System.out.println("wm2.getWorkTimeSUM =>" +wm2.getWork_time_sum());
			System.out.println("wm2.getOvertime =>" +wm2.getOvertime());
		} catch (Exception e) {
			System.out.println("WMDI weekly Exception -> "+ e.getMessage());
		}
		return wm2;
	}


	@Override
	public int ccheck(String mem_no) {
		System.out.println("WMDI_CCHECK START");
		int cresult = 0;
		try {
			cresult = session.selectOne("ssCCheckToday",mem_no);
			System.out.println("WMDI Cresult = " + cresult);
		} catch (Exception e) {
			System.out.println("WMDI Exception ->"+e.getMessage());
		}
		
		return cresult;
	}

	// 금일 근무시간(sysdate 대비)
	@Override
	public WorkManagement todayworktime(String mem_no) {
		WorkManagement wm3 = new WorkManagement();
		try {
			wm3 = session.selectOne("ssTodayWt",mem_no);
		} catch (Exception e) {
			System.out.println("wmdi Exception ==>" + e.getMessage());
		}
		
		return wm3;
	}

	// 금주 출퇴 시간 체크
	@Override
	public WorkManagement wctcheck(String targetDateString, String mem_no) {
		CalData cal5 = new CalData();
		cal5.setTargetDateString(targetDateString);
		cal5.setMem_no(mem_no);
		System.out.println("test targetDateString -->"+targetDateString);
		
		WorkManagement wm5 = new WorkManagement();
		try {
			wm5=session.selectOne("ssWctCheck",cal5);
		} catch (Exception e) {
			System.out.println("WMDI wctcheck  EXCEPTION ==>" + e.getMessage());
		}
		
		return wm5;
	}



	
	
	
	
	
	
}

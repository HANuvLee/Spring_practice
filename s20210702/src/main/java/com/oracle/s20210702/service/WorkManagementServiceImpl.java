package com.oracle.s20210702.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210702.dao.WorkManagementDao;
import com.oracle.s20210702.model.CalData;
import com.oracle.s20210702.model.WorkManagement;

@Service
public class WorkManagementServiceImpl implements WorkManagementService {

	@Autowired
	private WorkManagementDao wmd;
	
	
	//출퇴근 시간 조회
	@Override
	public WorkManagement ctview(String mem_no) {
		System.out.println("WorkManag impl ctviw start");
		WorkManagement wm = null;
		System.out.println("WM_Serv_impl__mem_no = "+mem_no);
//		int imem_no = Integer.parseInt(mem_no);
//		System.out.println("WM_Serv_impl__imem_no = "+imem_no);
		wm = wmd.ctview(mem_no);
		return wm;
	}


	
	//출근 시간 입력
	@Override
	public int inswit(String mem_no) {
		System.out.println("WorkManag impl ctviw start");
		int inswitresult = 0;
		System.out.println("WM_Serv_impl__mem_no = "+mem_no);
//		int imem_no = Integer.parseInt(mem_no);
//		System.out.println("WM_Serv_impl__imem_no = "+imem_no);
		
		
		inswitresult = wmd.inswit(mem_no);
		
		return inswitresult;
	}


	//next_seq_num 로딩
	@Override
	public String next_seq_num() {
		System.out.println("WorkManag impl next_seq_num start");
		int next_seq_numi=0;
		next_seq_numi = wmd.next_seq_num();
		String next_seq_num = Integer.toString(next_seq_numi);
		return next_seq_num;
	}


	//퇴근 시간 업데이트
	@Override
	public int toutbtn(String mem_no) {
		System.out.println("wmsimpl toutbtn start");
		int toutresult =0;
		
		System.out.println("WM_Serv_impl__mem_no = "+mem_no);
		int imem_no = Integer.parseInt(mem_no);
		System.out.println("WM_Serv_impl__imem_no = "+imem_no);
		
		toutresult = wmd.toutbtn(mem_no);
				System.out.println("toutresult ==>"+toutresult);
				
		return toutresult;
	}


	//금주 근무시간 관련
	@Override
	public WorkManagement weeklyworktime(String mem_no) {
		System.out.println("wmsi_weeklywtime start");
		WorkManagement wm2 = wmd.weeklyworktime(mem_no);
//		
//		System.out.println("WMSI_wm2_test->"+wm2.getOvertime());
//		System.out.println("WMSI_wm2_test->"+wm2.getWork_day_cnt());
//		System.out.println("WMSI_wm2_test->"+wm2.getWork_time_avg());
//		System.out.println("WMSI_wm2_test->"+wm2.getWork_time_sum());
		
		return wm2;
	}



	@Override
	public int ccheck(String mem_no) {
		System.out.println("WMS_IMPL_CCHECK START");
		int cresult = wmd.ccheck(mem_no);
		System.out.println("WMSI_cresult = "+ cresult);
		return cresult;
	}


	//금일 업무시간 계산용 (sysdate비교)
	@Override
	public WorkManagement todayworktime(String mem_no) {
		WorkManagement wm3 = null;
				
		wm3 = wmd.todayworktime(mem_no);
		return wm3;
	}


	//금주 출퇴 체크용!
	@Override
	public List<WorkManagement> weeklyCTCheck(String mem_no) {
		List<WorkManagement> wmwlist = new ArrayList<WorkManagement>(); 
		Calendar cal_today = Calendar.getInstance();
		int todays = cal_today.get(Calendar.DAY_OF_MONTH);
		int months= cal_today.get(Calendar.MONTH) +1;
		int years = cal_today.get(Calendar.YEAR);
		int today_no=cal_today.get(Calendar.DAY_OF_WEEK);
		
		
		for (int i=1; i<=7; i++) {
			WorkManagement wm4 = new WorkManagement();
			cal_today.set((Calendar.DAY_OF_MONTH),todays-today_no+i);
			int day_ = cal_today.get(Calendar.DAY_OF_MONTH);
			months = cal_today.get(Calendar.MONTH)+1;
			years = cal_today.get(Calendar.YEAR);
			int day_nos=cal_today.get(Calendar.DAY_OF_WEEK);
			
			String targetDateString = String.format("%04d", (years)) + String.format("%02d", (months))+String.format("%02d", (day_));
			
			System.out.println("WMSI WCTCHECK BEFORE");
			wm4 = wmd.wctcheck(targetDateString, mem_no);
			System.out.println("WMSI WCTCHECK AFTER");

			

			if (wm4 != null) {			wmwlist.add(wm4); }
		}
				
		return wmwlist;
	}


	
	
}

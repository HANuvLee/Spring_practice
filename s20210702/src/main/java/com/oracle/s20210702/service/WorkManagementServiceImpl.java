package com.oracle.s20210702.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210702.dao.WorkManagementDao;
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

	
	
}

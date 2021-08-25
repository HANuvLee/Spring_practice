package com.oracle.s20210702.service;

import java.util.List;

import com.oracle.s20210702.model.Approval;
import com.oracle.s20210702.model.Car;

public interface ApprovalService {

	int 										total1(String mem_no);

	List<Approval> 				listAppr1(Approval apr);

	int 										total2(String mem_no);

	List<Approval> 				listAppr2(Approval apr);

	int 										apinsert1(Approval apr);

	int 										maxadno();
	
	int 										apinsert11(int max_adno);

	List<Car> 							carcheck(Approval apr);

	int 										apinsert2(Approval apr);

	int 										carinsert2(Approval apr);

	int			 							apinsert3(Approval apr);

	int 										getauthno(String mem_no1);

	int 										up_apck2(Approval apr);

	List<Approval> 				listApprT(Approval apr);

	int 										totalT(String mem_no);

	int 										up_apck2N(Approval apr);

	Approval 							showAppData(int app_doc_no);

	int 										up_app_status(int app_doc_no);

	int 										inshefrap(Approval app1);

	int 										upmf310(int app_doc_no);

	int 										caravailcnt();

	

	

	

	

}

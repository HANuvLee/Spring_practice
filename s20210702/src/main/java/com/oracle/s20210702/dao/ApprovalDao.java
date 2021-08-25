package com.oracle.s20210702.dao;

import java.util.List;

import com.oracle.s20210702.model.Approval;
import com.oracle.s20210702.model.Car;

public interface ApprovalDao {

	int 											total1(String mem_no);

	List<Approval> 					listAppr1(Approval apr);

	int 											total2(String mem_no);

	List<Approval> 					listAppr2(Approval apr);

	int 											apinsert1(Approval apr);

	int 											apinsert11(int max_adno);

	int 											adnomax();

	List<Car> 								carcheck1(Approval apr);

	int 											apinsert2(Approval apr);

	int 											carinsert2(Approval apr);

	int 											apinsert3(Approval apr);

	int 											getauthnos(String mem_no1);

	int 											up_apcks1(Approval apr);
	int 											up_apcks2(Approval apr);
	int 											up_apcks3(Approval apr);

	List<Approval> 					listApprT(Approval apr);

	int 											totalT(String mem_no);

	int 											up_apcksN1(Approval apr);

	int 											up_apcksN2(Approval apr);

	int 											up_apcksN3(Approval apr);

	Approval 								showAppData(int app_doc_no);

	int 											upstatus(int app_doc_no);

	int 											inshefrap(Approval app1);

	int 											upmf310(int app_doc_no);

	int 											caracnt();


}

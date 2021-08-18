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

	int 											checkmt1(String mem_no1,String mem_no2, int doc_no);

}

package com.oracle.s20210702.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
	//기본 테이블 대응
	private int car_no;
	private Date car_start;
	private Date car_end;
	private String car_license;
	private String car_model;
	private String mem_no;
	
	
	
	
	
}

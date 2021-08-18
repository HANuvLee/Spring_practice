package com.oracle.s20210702.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CalData {
	
	//적용 대상
	private String mem_no;
	
	//기본정보(오늘날짜)
	private int year_;
	private int month_;
	private int today_;
	
	//달력 위치용
	// 몇번쨰주
	private int week_no;
	//무슨 요일? (일요일 = 1 토요일 =7)
	private int day_no;
	//몇일?
	private int day_;
	
	//그달의 첫날 / 마지막 날 저장용
	private int firstDay_no;					
	private int lastDay_no;
	
	//week_no_cnt
	private int week_no_cnt;
	
	//first_day_dayno
	private int first_day_dayno;
	
	//date형식 변환용
	private String targetDateString;
	
	//todo있을때 없을때 구분
	private int todocnt;
	
	// todolist on calendar 용
	private List<Schedule> lishe;
}

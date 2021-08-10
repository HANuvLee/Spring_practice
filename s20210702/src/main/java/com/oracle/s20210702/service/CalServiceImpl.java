package com.oracle.s20210702.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210702.dao.CalDao;
import com.oracle.s20210702.model.CalData;
import com.oracle.s20210702.model.Schedule;

@Service
public class CalServiceImpl implements CalService {

	@Autowired
	private CalDao cd;

	//today info
	@Override
	public CalData getTodayInfo() {
		CalData cdt = new CalData();
		
		Calendar cal_today = Calendar.getInstance();
		cdt.setYear_(cal_today.get(Calendar.YEAR));
		cdt.setMonth_(cal_today.get(Calendar.MONTH));
		cdt.setToday_(cal_today.get(Calendar.DAY_OF_MONTH));
		cdt.setFirstDay_no(1);
		
		int months = cdt.getMonth_()+1;
		int years = cdt.getYear_();		
		
		if ((months == 1)  || (months == 3) || (months==5)|| (months==7)|| (months==8)|| (months==10)|| (months==12)) {
			cdt.setLastDay_no(31);
		} else if((months==4)|| (months==6)|| (months==9)|| (months==11)) {
			cdt.setLastDay_no(30);
		}
		else if (((years %400 ==0) ||((years%100 != 0)&&(years%4==0))) && (months==2)) {
			cdt.setLastDay_no(29);
		} else if ((((years %100 == 0)&& (years%400 != 0))||(years%4 != 0))&&(months==2)) {
			cdt.setLastDay_no(28);
		}
		
		Calendar cal2 = Calendar.getInstance();
		cal2.set(Calendar.DAY_OF_MONTH,cdt.getLastDay_no());
		cdt.setWeek_no_cnt (cal2.get(Calendar.WEEK_OF_MONTH));
		cal2.set(Calendar.DAY_OF_MONTH,1);
		cdt.setFirst_day_dayno(cal2.get(Calendar.DAY_OF_WEEK));
	
		
		
		
		System.out.println("Cal Service Test Start!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("Today info : " + cdt.getYear_() + " / " + months + " / " + cdt.getToday_() );
		System.out.println("this month last day :" + cdt.getLastDay_no());
		System.out.println("this month weekNocnt : "+ cdt.getWeek_no_cnt());
		System.out.println("this month firstday dayno :" + cdt.getFirst_day_dayno());
		
		
		return cdt;
	}

	//CAL LIST
	@Override
	public List<CalData> getCallistall(String mem_no) {
		
		
		Calendar cal_today = Calendar.getInstance();
		
		int months= cal_today.get(Calendar.MONTH) +1;
		int years = cal_today.get(Calendar.YEAR);
		int lastdayno = 0;
		
		if ((months == 1)  || (months == 3) || (months==5)|| (months==7)|| (months==8)|| (months==10)|| (months==12)) {
			lastdayno = 31;
		} else if((months==4)|| (months==6)|| (months==9)|| (months==11)) {
			lastdayno = 30;
		}
		else if (((years %400 ==0) ||((years%100 != 0)&&(years%4==0))) && (months==2)) {
			lastdayno = 29;
		} else if ((((years %100 == 0)&& (years%400 != 0))||(years%4 != 0))&&(months==2)) {
			lastdayno = 28;
		}
		
		cal_today.set(Calendar.DAY_OF_MONTH,1);
		System.out.println("test=>"+lastdayno);
		
		
				
		List<CalData> callist = new ArrayList<CalData>();
			CalData cdt = null;
			
		for (int i=1 ; i<=lastdayno; i++) {
			cdt = new CalData();
			cal_today.set(Calendar.DAY_OF_MONTH, i);
			
			cdt.setYear_(cal_today.get(Calendar.YEAR));
			cdt.setMonth_(cal_today.get(Calendar.MONTH));
			cdt.setDay_(cal_today.get(Calendar.DAY_OF_MONTH));
			cdt.setWeek_no(cal_today.get(Calendar.WEEK_OF_MONTH));
			cdt.setDay_no(cal_today.get(Calendar.DAY_OF_WEEK));
			String targetDateString = String.format("%04d", (cdt.getYear_())) + String.format("%02d", (cdt.getMonth_()+1))+String.format("%02d", (cdt.getDay_()));
			System.out.println("targetDateString _ listschcnt(for in)-->" + targetDateString );
			
			int todocnt = cd.todocnt(targetDateString,mem_no);
			cdt.setTodocnt(todocnt);
			
			
			callist.add(cdt);
		}
		return callist;
	}

	
	
	//todocnt
	@Override
	public int todotot(String targetDateString, String mem_no) {
		
		System.out.println("CSI TODOCNT start");

		
		int todocnt = cd.todocnt(targetDateString,mem_no);
		System.out.println("CSI_CHECK_DATA_________________");
		System.out.println("targetDateString ==> " + targetDateString);
		System.out.println("mem_no ==> " + mem_no);
		System.out.println("todocnt ==> " + todocnt);
		return todocnt;
	}

	
	//list schedule
	@Override
	public List<Schedule> listSchedule(String targetDateString, String mem_no) {
		List<Schedule> listSchedule = null;
		System.out.println("CSI list Start!");
		listSchedule = cd.listSchedule(targetDateString,mem_no);
		System.out.println("CSI listSchedule.size()==>"+listSchedule.size());
		
		return listSchedule;
	}

	//schedule insert!!
	@Override
	public int scheIns(String schedule_kind, String schedule_name, String startDateString, String endDateString,
			String schedule_content, String mem_no) {
		System.out.println("CSI SchIns Start!");
		int sch_ins_res = cd.schIns(schedule_kind,schedule_name, startDateString,endDateString,schedule_content, mem_no);
		System.out.println("CSI sch ins result ==>"+sch_ins_res);
		return sch_ins_res;
	}

	//삭제가능여부 체크
	@Override
	public int checkcond(String schedule_no, String mem_no) {
		System.out.println("CSI check condi start");
		System.out.println("test csi_ schedule_no ==>"+schedule_no);
		System.out.println("test csi_ mem_no ==>"+mem_no);
		
		int dcresult = cd.dccheck(schedule_no,mem_no);
		return dcresult;
	}

	
	//삭제 대기중으로 변경 (추후 수정 필요.)
	@Override
	public int updsche(String schedule_no, String mem_no) {
		
		int upresult = cd.upSche(schedule_no,mem_no);
		System.out.println("test_csi_upresult ==> "+upresult);
		
		return upresult;
	}

	
	




}

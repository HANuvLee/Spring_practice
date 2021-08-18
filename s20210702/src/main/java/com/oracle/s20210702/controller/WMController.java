package com.oracle.s20210702.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.s20210702.model.Member_OfficeInfo;
import com.oracle.s20210702.model.Schedule;
import com.oracle.s20210702.model.WorkManagement;
import com.oracle.s20210702.service.CalService;
import com.oracle.s20210702.service.MainService;
import com.oracle.s20210702.service.WorkManagementService;

@Controller
public class WMController {

	@Autowired
	WorkManagementService wms;
	
	@Autowired
	MainService ms;
	
	@Autowired
	CalService cs;
	
	@RequestMapping(value = "wmanage")
	private String wmanage(String mem_no, HttpServletRequest request, Model model) {
		
		// 개인정보 조회
		Member_OfficeInfo mo = ms.pfview(mem_no);
		model.addAttribute("mo",mo);
		
		
		// 날짜 받아오기
		Calendar cal = Calendar.getInstance();
		int years= cal.get(Calendar.YEAR);
		int months = (cal.get(Calendar.MONTH))+1;
		int todays = cal.get(Calendar.DAY_OF_MONTH);
		int today_dayno = cal.get(Calendar.DAY_OF_WEEK);
		
		model.addAttribute("years",years);
		model.addAttribute("months",months);
		model.addAttribute("todays",todays);
		model.addAttribute("today_dayno",today_dayno);
		
		System.out.println("check todays ==>"+todays);
		System.out.println("check today_dayno ==>"+today_dayno);
		
		//휴가 계산처리
		float used_vcresult = ms.vacacheck(mem_no);
		System.out.println("Main_CTRL_used_vaca_check_result = "+used_vcresult);
		model.addAttribute("used_vacation",used_vcresult);
				
		// 1: 사원(15) // 2. 대리(16) // 3. ...... // 7. 회장(21)//
		float vtotstatus = ms.rankcheck(mem_no);
		System.out.println("mainCTRL_RANK_CHECK =>"+vtotstatus);
		float vtotdays = 0;
		if (vtotstatus == 7) {vtotdays = 21;}
		else if(vtotstatus == 6) {vtotdays = 20;}
		else if(vtotstatus == 5) {vtotdays = 19;}
		else if(vtotstatus == 4) {vtotdays = 18;}
		else if(vtotstatus == 3) {vtotdays = 17;}
		else if(vtotstatus == 2) {vtotdays = 16;}
		else if(vtotstatus == 1) {vtotdays = 15;}
				
		System.out.println("vtotdays ==>"+vtotdays);
		float rest_vacation = vtotdays - used_vcresult;
		System.out.println("restVacation ==>"+rest_vacation);
		model.addAttribute("rest_vacation", rest_vacation);
		model.addAttribute("vtotdays", vtotdays);
		
		//vaca list
		Member_OfficeInfo mos = ms.pfview(mem_no);
		model.addAttribute("mos",mos);
		
		
		System.out.println("CalCTRL TODOCNT start");
//		int annualtodocnt = cs.todotot2(years,mem_no);
//		System.out.println("annualtodocnt -->"+annualtodocnt);
//		model.addAttribute("schtot",annualtodocnt);
		
		System.out.println("List<Schedule> listSchedule = cs.listSchedule(cal); before start");
		List<Schedule> listSchedule = cs.listSchedule2(years,mem_no);
		System.out.println("CCTRL listSchedule.size() -->"+listSchedule.size());
		model.addAttribute("listSchedule",listSchedule);
		
		
		
		
		
		
		return "wmanage";
	}
	
	@RequestMapping(value = "wmanage2")
	private String wmanage2(String mem_no, HttpServletRequest request, Model model) {
		
				// 개인정보 조회
				Member_OfficeInfo mo = ms.pfview(mem_no);
				model.addAttribute("mo",mo);
				
				// 날짜 받아오기
				Calendar cal = Calendar.getInstance();
				int years= cal.get(Calendar.YEAR);
				int months = (cal.get(Calendar.MONTH))+1;
				int todays = cal.get(Calendar.DAY_OF_MONTH);
				int today_dayno = cal.get(Calendar.DAY_OF_WEEK);
				int what_week = cal.get(Calendar.WEEK_OF_MONTH);
				
				model.addAttribute("years",years);
				model.addAttribute("months",months);
				model.addAttribute("todays",todays);
				model.addAttribute("today_dayno",today_dayno);
				model.addAttribute("what_week",what_week);
				
				//출퇴근 시간 조회
				WorkManagement wm = wms.ctview(mem_no);
				System.out.println("ctrl_wm.getWork_in_time ==>"+wm.getWork_in_time());
				model.addAttribute("wm",wm);
//				model.addAttribute("mem_no",wm.getMem_no());
				
				//금주 근무 시간 관련
				System.out.println("main ctrl weekly start");
				WorkManagement wm2 = wms.weeklyworktime(mem_no);
				model.addAttribute("wm2", wm2);
				System.out.println("main_ctrl_wm2_test->"+wm2.getOvertime());
				System.out.println("main_ctrl_wm2_test->"+wm2.getWork_day_cnt());
				System.out.println("main_ctrl_wm2_test->"+wm2.getWork_time_avg());
				System.out.println("main_ctrl_wm2_test->"+wm2.getWork_time_sum());
				
				//금일 근무 시간 계산(sysdate와 비교)
				WorkManagement wm3 = wms.todayworktime(mem_no);
				model.addAttribute("wm3",wm3);
				System.out.println("Test SYSDATE_ ==>"+wm3.getSysdate());
				
				//금주 출퇴근 시간 체크
				List<WorkManagement> WMWeekList = wms.weeklyCTCheck(mem_no);
				model.addAttribute("WMWeekList",WMWeekList);
				
				
		
		return "wmanage2";
	}
	
}

package com.oracle.s20210702.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.oracle.s20210702.model.CalData;
import com.oracle.s20210702.model.Member_OfficeInfo;
import com.oracle.s20210702.model.Schedule;
import com.oracle.s20210702.service.CalService;
import com.oracle.s20210702.service.MainService;

@Controller
public class CalController {
	
	@Autowired
	private CalService cs;
	
	@Autowired
	private  MainService ms;
	
	
	
	
	@RequestMapping(value = "mycal")
	public String calmain (HttpServletRequest request, String mem_no, Model model) {
		
		
		//간단 개인 정보 조회용.
				Member_OfficeInfo mos = ms.pfview(mem_no);
				model.addAttribute("mos",mos);
				
				
		//today info
				CalData caltoday = cs.getTodayInfo();
				model.addAttribute("caltoday",caltoday);
				

		// 날짜 나열
				List<CalData> callistall = cs.getCallistall(mem_no);

				model.addAttribute("callistall",callistall);
				
				System.out.println("day day ==>" +String.format("%02d", caltoday.getToday_()) );
				
			// 날짜별 스케쥴 여부 및 갯수 검색	
//				List<CalData> schcntlist = cs.schcntlist(mem_no);
//				model.addAttribute("schcntlist",schcntlist);
//				System.out.println("schcntlist.size() -->"+schcntlist.size());
			
				
		
		return "mycal";
	}

	
	
	@GetMapping (value = "todolist")
	public String todolist(CalData cal , String mem_no,  HttpServletRequest request ,Model model) {
		
		//특정 일자 일정 목록 조회
		String targetDateString = String.format("%04d", (cal.getYear_())) + String.format("%02d", (cal.getMonth_()))+String.format("%02d", (cal.getDay_()));
		System.out.println("Cal_CTRL _ TODOLIST _ TARGETDATESTRING CHECK-->"+ targetDateString);
		System.out.println("Cal_CTRL _ TODOLIST _ Mem_no CHECK-->"+ mem_no);
		model.addAttribute("year_",cal.getYear_());
		model.addAttribute("month_",cal.getMonth_());
		model.addAttribute("day_",cal.getDay_());
		model.addAttribute("targetDateString",targetDateString);
		
		//간단 개인 정보 조회용.
		Member_OfficeInfo mos = ms.pfview(mem_no);
		model.addAttribute("mos",mos);
		
		System.out.println("CalCTRL TODOCNT start");
		int monthtodocnt = cs.todotot(targetDateString,mem_no);
		System.out.println("monthtodocnt -->"+monthtodocnt);
		model.addAttribute("schtot",monthtodocnt);
		
		System.out.println("List<Schedule> listSchedule = cs.listSchedule(cal); before start");
		List<Schedule> listSchedule = cs.listSchedule(targetDateString,mem_no);
		System.out.println("CCTRL listSchedule.size() -->"+listSchedule.size());
		model.addAttribute("listSchedule",listSchedule);
		
		
		return "todolist";
	}
	
	@GetMapping(value = "insertsche")
	private String insertSche(CalData cal, Model model , HttpServletRequest request, String mem_no) {
		System.out.println("cal ctrl insert schedule write form start");
		
		model.addAttribute("year_",cal.getYear_());
		model.addAttribute("month_",cal.getMonth_());
		model.addAttribute("day_",cal.getDay_());
		model.addAttribute("mem_no",cal.getMem_no());
				
		return "scheWriteForm";
	}
	
	@PostMapping(value = "scheins")
	private String scheins(CalData cal ,Model model, HttpServletRequest request) throws Exception {
		System.out.println("cal ctrl insert schedule insert start");
		
		int year_ = Integer.parseInt(request.getParameter("year_")) ;
		int month_ = Integer.parseInt(request.getParameter("month_")) ;
		int day_ = Integer.parseInt(request.getParameter("day_")) ;
		String mem_no = request.getParameter("mem_no");
		
		model.addAttribute("year_",year_);
		model.addAttribute("month_",month_);
		model.addAttribute("day_",day_);
		model.addAttribute("mem_no",mem_no);
		String targetDateString = String.format("%04d", (year_)) + String.format("%02d", (month_))+String.format("%02d", (day_));
		
		int yy_start = Integer.parseInt(request.getParameter("sche_yy_sta"));
		int mm_start = Integer.parseInt(request.getParameter("sche_mm_sta"));
		int dd_start = Integer.parseInt(request.getParameter("sche_dd_sta"));
		int hh_start = Integer.parseInt(request.getParameter("sche_hh_sta"));
		String startDateString = String.format("%04d", (yy_start)) + String.format("%02d", (mm_start))+String.format("%02d", (dd_start))+String.format("%02d", (hh_start));

		int yy_end = Integer.parseInt(request.getParameter("sche_yy_end"));
		int mm_end = Integer.parseInt(request.getParameter("sche_mm_end"));
		int dd_end = Integer.parseInt(request.getParameter("sche_dd_end"));
		int hh_end = Integer.parseInt(request.getParameter("sche_hh_end"));
		String endDateString = String.format("%04d", (yy_end)) + String.format("%02d", (mm_end))+String.format("%02d", (dd_end))+String.format("%02d", (hh_end));

		String schedule_kind = request.getParameter("schedule_kind");
		String schedule_name = request.getParameter("schedule_name");
		String schedule_content = request.getParameter("schedule_content");
		
		System.out.println("==========================================================");
		System.out.println("test_ TargetDateString ==>" + targetDateString);
		System.out.println("test_ StartDateString ==>" + startDateString);
		System.out.println("test_ EndDateString ==>" + endDateString);
		System.out.println("test_ schedule_kind ==>" + schedule_kind);
		System.out.println("test_ schedule_name ==>" + schedule_name);
		System.out.println("test_ schedule_content ==>" + schedule_content);
		
		System.out.println("==========================================================");
		
		
		System.out.println("CalCTRL schIns start");
		int insResult = cs.scheIns(schedule_kind,schedule_name,startDateString,endDateString,schedule_content,mem_no);
		
		System.out.println("test_ insResult ==>"+insResult);
		
		return "scheins";
	}
	
	@GetMapping(value = "delSche")
	private String delSche(String schedule_no, String mem_no, HttpServletRequest request, Model model) {
		System.out.println("CAL_CTRL delSche Start");
		System.out.println("test_ schedule_no ==> "+ schedule_no);
		System.out.println("test_ mem_no ==> "+ mem_no);
		
		int check_del_condition = cs.checkcond(schedule_no,mem_no);
		System.out.println("Test_ check_del_condition ==> "+check_del_condition);
		model.addAttribute("cdc",check_del_condition);
		model.addAttribute("mem_no",mem_no);
		
		
		if(check_del_condition != 0) {
			int update_sch_status = cs.updsche(schedule_no,mem_no);
			System.out.println("test Update_sch_status ==> "+update_sch_status);
			}
		
		return "delSche";
	}
}

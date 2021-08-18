package com.oracle.s20210702.controller;


import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.s20210702.model.Board;
import com.oracle.s20210702.model.CalData;
import com.oracle.s20210702.model.ChatSession;
import com.oracle.s20210702.model.Mail;
import com.oracle.s20210702.model.Member_OfficeInfo;
import com.oracle.s20210702.model.WorkManagement;
import com.oracle.s20210702.service.BoardService;
import com.oracle.s20210702.service.CalService;
import com.oracle.s20210702.service.LoginService;
import com.oracle.s20210702.service.MailService;
import com.oracle.s20210702.service.MainService;
import com.oracle.s20210702.service.Paging;
import com.oracle.s20210702.service.WorkManagementService;

@Controller
public class MainController {

	@Autowired
	private MainService ms;
	
	@Autowired
	private BoardService bs;
	
	@Autowired
	private LoginService ls;
	
	@Autowired
	private WorkManagementService wms;
	
	@Autowired
	private CalService cs;
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private ChatSession cSession;
	
	
	
	
// HttpSession session;
	
	@RequestMapping(value = "main") 
	public String main(HttpServletRequest request, Board board, String mem_no, Model model) {
		System.out.println("MAINCONTROLLER Start ..." );
		
		// 로그인 멤버 프로필 조회
		Member_OfficeInfo mo = ms.pfview(mem_no);
		
		model.addAttribute("mo",mo);
		
		
		Member_OfficeInfo member = ls.member(mo.getMem_id());
		model.addAttribute("member",member);
		model.addAttribute("mem_id", member.getMem_id());
		model.addAttribute("mem_no", member.getMem_no());
		model.addAttribute("mem_name",member.getMem_name());
		
//		System.out.println("MO =>"+mo);
//		System.out.println("MainCTRL mem_no -> "+mem_no);
		
		
		
		//금주 근무 시간 관련
		System.out.println("main ctrl weekly start");
		WorkManagement wm2 = wms.weeklyworktime(mem_no);
		model.addAttribute("wm2", wm2);
//		System.out.println("main_ctrl_wm2_test->"+wm2.getOvertime());
//		System.out.println("main_ctrl_wm2_test->"+wm2.getWork_day_cnt());
//		System.out.println("main_ctrl_wm2_test->"+wm2.getWork_time_avg());
//		System.out.println("main_ctrl_wm2_test->"+wm2.getWork_time_sum());
		
		// 게시판 최근글 main에 listing 관련
		List<Board>recentlistBoard1=bs.recentlistBoard1();
		model.addAttribute("recentlistBoard1", recentlistBoard1);
//		System.out.println("test-->"+recentlistBoard1.get(0).getPost_title());
//		System.out.println("test-->"+recentlistBoard1.get(1).getPost_title());
//		System.out.println("test-->"+recentlistBoard1.get(2).getPost_title());
//		System.out.println("test-->"+recentlistBoard1.get(3).getPost_title());
//		System.out.println("test-->"+recentlistBoard1.get(4).getPost_title());
		
		
		// 휴가 관련 
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
		
		
		//calendar 객체 테스트!!
		Calendar cal = Calendar.getInstance();
		int years= cal.get(Calendar.YEAR);
		int months = (cal.get(Calendar.MONTH))+1;
		int todays = cal.get(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH,1);
		int first_day = cal.get(Calendar.DAY_OF_WEEK);
		
		cal.set(Calendar.MONTH , Calendar.OCTOBER);
		cal.set(Calendar.DAY_OF_MONTH,31);
		int what_week = cal.get(Calendar.WEEK_OF_MONTH);
		
		
//		System.out.println("Calendar --> Year --> "+years);
//		System.out.println("Calendar --> Month --> "+months);
//		System.out.println("Calendar --> Today --> "+todays);
//		System.out.println("Calendar --> FirstDay --> "+first_day);
//		System.out.println("Calendar --> whatweek --> "+what_week);

		//스케쥴 관련
		
		//today info
		CalData caltoday = cs.getTodayInfo();
		model.addAttribute("caltoday",caltoday);
		

		// 날짜 나열
		List<CalData> callistall = cs.getCallistall(mem_no);

		model.addAttribute("callistall",callistall);
		
		System.out.println("day day ==>" +String.format("%02d", caltoday.getToday_()) );
		
		
		// 받은 메일 출력!
		Mail mail = new Mail();
		String currentPage = "1";
		
		Member_OfficeInfo mor = mailService.ListMember(member.getMem_id());
		model.addAttribute("mor",mor);
		int rec_total = mailService.rec_total(mor);
		Paging pg = new Paging(rec_total, currentPage);
		mail.setStart(pg.getStart());
		mail.setEnd(pg.getEnd());
		mail.setMem_no(mo.getMem_no());
		mail.setMem_id(mo.getMem_id());
		List<Mail> rec_listMail = mailService.rec_ListMail(mail);
		model.addAttribute("total", rec_total);
		model.addAttribute("listMail",rec_listMail);
		model.addAttribute("pg",pg);
		
		
		//채팅관련
		cSession.addLoginUser(member.getMem_name());
	      ArrayList<String> chatSessionList = cSession.getLoginUser();
	      model.addAttribute("loginUser", chatSessionList);
		
		
		return "main";
}
	
		//출근 버튼 액션
		@GetMapping(value = "cin_btn")
		private String cinbtn(String mem_no, HttpServletRequest request, Model model) {
			System.out.println("main CTRL cin ing..");
			
			// 금일 출근 여부 확인
			Member_OfficeInfo mo = ms.pfview(mem_no);
			Member_OfficeInfo member = ls.member(mo.getMem_id());
			System.out.println("choolgeun check !! today" + member.getMem_name() );
			int cresult = wms.ccheck(member.getMem_no());
			System.out.println("loginCTRL Cresult = " +cresult);
			model.addAttribute("cresult",cresult);
			
			if (cresult ==0) {
			//출근버튼 시간 기입 (출근 여부 없을경우)
						String next_seq_num = wms.next_seq_num();
						System.out.println("next_seq_num = "+next_seq_num);
						
						model.addAttribute("next_seq_num",next_seq_num);
						
						
						
						int inswitresult = wms.inswit(member.getMem_no());
						System.out.println("inswitresult --> "+ inswitresult);
						
						
						
						
			} else {
				System.out.println(member.getMem_name()+"은 이미 출근 처리 되어있음.");
					
			}
			
			//출퇴근 시간 조회
			WorkManagement wm = wms.ctview(mem_no);
			System.out.println("ctrl_wm.getWork_in_time ==>"+wm.getWork_in_time());
			model.addAttribute("wm",wm);
			model.addAttribute("mem_no",wm.getMem_no());
			
			
			
			
			
			return "forward:main";
		}
	
	
	
	
		//퇴근 버튼 액션
		@GetMapping(value = "tout_btn")
		private String toutbtn (String mem_no, HttpServletRequest request) {
		System.out.println("main ctrl tout ing...");
		System.out.println("tout mem_no = "+mem_no);
		int toutresult = wms.toutbtn(mem_no);
			
		System.out.println("ToutResult ==>"+ toutresult);
		
		return "redirect:loginForm";
		}

		
		//log out & 퇴근
		@RequestMapping(value = "logout")
		public String logout(HttpSession session, String mem_no) {
			
			Member_OfficeInfo member = mailService.ListMember1(mem_no);
			cSession.removeLoginUser(member.getMem_name());
			
			session.invalidate();
			
			

			
			
			
			return  "redirect:loginForm";
		}
		
	
}

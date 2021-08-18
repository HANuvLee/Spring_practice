package com.oracle.s20210702.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.s20210702.model.Approval;
import com.oracle.s20210702.model.Board;
import com.oracle.s20210702.model.Car;
import com.oracle.s20210702.model.Member_OfficeInfo;
import com.oracle.s20210702.service.ApprovalService;
import com.oracle.s20210702.service.MainService;
import com.oracle.s20210702.service.Paging;

@Controller
public class ApprovalController {
	
	@Autowired
	ApprovalService aps;
	
	@Autowired
	MainService ms;
	
	@RequestMapping(value = "approval_main")
	private String appmain(String mem_no, HttpServletRequest request, Model model) {
		System.out.println("app main start!");
		
		// 개인정보 조회
				Member_OfficeInfo mo = ms.pfview(mem_no);
				model.addAttribute("mo",mo);
		
		
		return "approval_main";
	}
	
	@RequestMapping(value = "app_writeForm1")
	private String appwrf1(String mem_no, HttpServletRequest request, Model model) {
		System.out.println("app main start!");
		
		// 개인정보 조회
				Member_OfficeInfo mo = ms.pfview(mem_no);
				model.addAttribute("mo",mo);
		
		
		return "app_writeForm1";
	}
	
	@RequestMapping(value = "app_writeForm2")
	private String appwrf2(Approval apr, HttpServletRequest request, Model model) {
		System.out.println("app main start!");
		
		// 개인정보 조회
				Member_OfficeInfo mo = ms.pfview(apr.getMem_no());
				model.addAttribute("mo",mo);
				
				//사용 가능 차량 리스트 조회
				List<Car> carlist = aps.carcheck(apr);
				 model.addAttribute("carlist",carlist);
				 
				 System.out.println("test//carlist size-->"+carlist.size());
		
		
		return "app_writeForm2";
		}
		
		@RequestMapping(value = "app_writeForm3")
		private String appwrf3(String mem_no, HttpServletRequest request, Model model) {
			System.out.println("app main start!");
			
			// 개인정보 조회
					Member_OfficeInfo mo = ms.pfview(mem_no);
					model.addAttribute("mo",mo);
			
			
			return "app_writeForm3";
		}
		
		@RequestMapping(value = "app_my_list")
		private String appmylist(Approval apr, String currentPage , HttpServletRequest request, Model model) {
			System.out.println("app mylist start!");
			
			// 개인정보 조회
					Member_OfficeInfo mo = ms.pfview(apr.getMem_no());
					model.addAttribute("mo",mo);
					
					int total1 = aps.total1(apr.getMem_no());  
					
					System.out.println("APCTRL total=>" + total1);
					System.out.println("currentPage=>" + currentPage);
					//                     14     NULL(0,1....)
					Paging pg = new Paging(total1, currentPage);
					apr.setStart(pg.getStart());   // 시작시 1
					apr.setEnd(pg.getEnd());       // 시작시 10 
					List<Approval> listAppr = aps.listAppr1(apr);
					System.out.println("pg.getStart()=>" + pg.getStart());
					System.out.println("pg.getEnd()=>" + pg.getEnd());
					System.out.println("APPR Controller list listBoard.size()=>" + listAppr.size());
					model.addAttribute("total1", total1);
					model.addAttribute("listAppr",listAppr);
					System.out.println("listAppr=>" + listAppr);
					model.addAttribute("pg",pg);
			
			
			return "app_my_list";
		}
		
		@RequestMapping(value = "app_my_list2")
		private String appmylist2(Approval apr, String currentPage , HttpServletRequest request, Model model) {
			System.out.println("app mylist start!");
			
			// 개인정보 조회
					Member_OfficeInfo mo = ms.pfview(apr.getMem_no());
					model.addAttribute("mo",mo);
					
					int total2 = aps.total2(apr.getMem_no());  
					
					System.out.println("APCTRL total=>" + total2);
					System.out.println("currentPage=>" + currentPage);
					//                     14     NULL(0,1....)
					Paging pg = new Paging(total2, currentPage);
					apr.setStart(pg.getStart());   // 시작시 1
					apr.setEnd(pg.getEnd());       // 시작시 10 
					List<Approval> listAppr2 = aps.listAppr2(apr);
					System.out.println("pg.getStart()=>" + pg.getStart());
					System.out.println("pg.getEnd()=>" + pg.getEnd());
					System.out.println("APPR Controller list2 listAppr2.size()=>" + listAppr2.size());
					model.addAttribute("total1", total2);
					model.addAttribute("listAppr2",listAppr2);
					System.out.println("listAppr2=>" + listAppr2);
					model.addAttribute("pg",pg);
			
			
			return "app_my_list2";
		}
		
		// 게시물 작성 (write action)
				@PostMapping(value = "app_write1")
				public String appwrite1(Approval apr, HttpServletRequest request , Model model) throws ParseException {
					System.out.println("ApprController Write1 Start");
					
					// 개인정보 조회
					Member_OfficeInfo mo = ms.pfview(apr.getMem_no());
					model.addAttribute("mo",mo);
					
					int yy_start = Integer.parseInt(request.getParameter("sch_start_yy"));
					int mm_start = Integer.parseInt(request.getParameter("sch_start_mm"));
					int dd_start = Integer.parseInt(request.getParameter("sch_start_dd"));
					int hh_start = Integer.parseInt(request.getParameter("sch_start_hh"));
					String startDateString = String.format("%04d", (yy_start)) + String.format("%02d", (mm_start))+String.format("%02d", (dd_start))+String.format("%02d", (hh_start));
					SimpleDateFormat startDate = new SimpleDateFormat("yyyyMMddHH");
					Date  sch_start_date = startDate.parse(startDateString);
					apr.setSch_start_date(sch_start_date);
					
					int yy_end = Integer.parseInt(request.getParameter("sch_end_yy"));
					int mm_end = Integer.parseInt(request.getParameter("sch_end_mm"));
					int dd_end = Integer.parseInt(request.getParameter("sch_end_dd"));
					int hh_end = Integer.parseInt(request.getParameter("sch_end_hh"));
					String endDateString = String.format("%04d", (yy_end)) + String.format("%02d", (mm_end))+String.format("%02d", (dd_end))+String.format("%02d", (hh_end));
					SimpleDateFormat endDate = new SimpleDateFormat("yyyyMMddHH");
					Date  sch_end_date = endDate.parse(endDateString);
					apr.setSch_end_date(sch_end_date);
					System.out.println("test/getSch_start_date-->"+apr.getSch_start_date());
					System.out.println("test/getSch_end_date-->"+apr.getSch_end_date());
					
					 
					int insresult = aps.apinsert1(apr);
					if (insresult ==1) {
					int max_adno = aps.maxadno();
					int result2 = aps.apinsert11(max_adno);
					return "redirect:approval_main?mem_no="+mo.getMem_no();}
					else {
						
						return "forward:app_writeForm1"; 
					}
				}
				
				
				@PostMapping(value = "app_write2")
				public String appwrite2(Approval apr, HttpServletRequest request , Model model) throws ParseException {
					System.out.println("ApprController Write2 Start");
					
					// 개인정보 조회
					Member_OfficeInfo mo = ms.pfview(apr.getMem_no());
					model.addAttribute("mo",mo);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
					
					int yy_start = Integer.parseInt(request.getParameter("sch_start_yy"));
					int mm_start = Integer.parseInt(request.getParameter("sch_start_mm"));
					int dd_start = Integer.parseInt(request.getParameter("sch_start_dd"));
					int hh_start = Integer.parseInt(request.getParameter("sch_start_hh"));
					String startDateString = String.format("%04d", (yy_start)) + String.format("%02d", (mm_start))+String.format("%02d", (dd_start))+String.format("%02d", (hh_start));
					SimpleDateFormat startDate = new SimpleDateFormat("yyyyMMddHH");
					Date  sch_start_date = startDate.parse(startDateString);
					apr.setSch_start_date(sch_start_date);
					
					int yy_end = Integer.parseInt(request.getParameter("sch_end_yy"));
					int mm_end = Integer.parseInt(request.getParameter("sch_end_mm"));
					int dd_end = Integer.parseInt(request.getParameter("sch_end_dd"));
					int hh_end = Integer.parseInt(request.getParameter("sch_end_hh"));
					String endDateString = String.format("%04d", (yy_end)) + String.format("%02d", (mm_end))+String.format("%02d", (dd_end))+String.format("%02d", (hh_end));
					SimpleDateFormat endDate = new SimpleDateFormat("yyyyMMddHH");
					Date  sch_end_date = endDate.parse(endDateString);
					apr.setSch_end_date(sch_end_date);
					System.out.println("test/getSch_start_date-->"+apr.getSch_start_date());
					System.out.println("test/getSch_end_date-->"+apr.getSch_end_date());
					
					
					
					 
					int insresult = aps.apinsert2(apr);
					if (insresult ==1) {
					int max_adno = aps.maxadno();
					int result22 = aps.apinsert11(max_adno);
					System.out.println("test//result22 => "+result22);
						if(apr.getCar_no() != 0) {
						int carinsert = aps.carinsert2(apr);
						System.out.println("test carinsert ==>"+carinsert);
						}
						
						return "redirect:approval_main?mem_no="+mo.getMem_no();}
					
					else {
						
						return "forward:app_writeForm2"; 
					}
				}
				
				
				@PostMapping(value = "app_write3")
				public String appwrite3(Approval apr, HttpServletRequest request , Model model) throws ParseException {
					System.out.println("ApprController Write3 Start");
					
					// 개인정보 조회
					Member_OfficeInfo mo = ms.pfview(apr.getMem_no());
					model.addAttribute("mo",mo);
					
//					int yy_start = Integer.parseInt(request.getParameter("sch_start_yy"));
//					int mm_start = Integer.parseInt(request.getParameter("sch_start_mm"));
//					int dd_start = Integer.parseInt(request.getParameter("sch_start_dd"));
//					int hh_start = Integer.parseInt(request.getParameter("sch_start_hh"));
//					String startDateString = String.format("%04d", (yy_start)) + String.format("%02d", (mm_start))+String.format("%02d", (dd_start))+String.format("%02d", (hh_start));
//					SimpleDateFormat startDate = new SimpleDateFormat("yyyyMMddHH");
//					Date  sch_start_date = startDate.parse(startDateString);
//					apr.setSch_start_date(sch_start_date);
//					
//					int yy_end = Integer.parseInt(request.getParameter("sch_end_yy"));
//					int mm_end = Integer.parseInt(request.getParameter("sch_end_mm"));
//					int dd_end = Integer.parseInt(request.getParameter("sch_end_dd"));
//					int hh_end = Integer.parseInt(request.getParameter("sch_end_hh"));
//					String endDateString = String.format("%04d", (yy_end)) + String.format("%02d", (mm_end))+String.format("%02d", (dd_end))+String.format("%02d", (hh_end));
//					SimpleDateFormat endDate = new SimpleDateFormat("yyyyMMddHH");
//					Date  sch_end_date = endDate.parse(endDateString);
//					apr.setSch_end_date(sch_end_date);
//					System.out.println("test/getSch_start_date-->"+apr.getSch_start_date());
//					System.out.println("test/getSch_end_date-->"+apr.getSch_end_date());
					
					 
					int insresult = aps.apinsert3(apr);
					if (insresult ==1) {
					int max_adno = aps.maxadno();
					int result2 = aps.apinsert11(max_adno);
					return "redirect:approval_main?mem_no="+mo.getMem_no();}
					else {
						
						return "forward:app_writeForm3"; 
					}
				}

				@RequestMapping(value = "accept")
				private String appaccept(String from_mem_no,Approval apr, Model model, HttpServletRequest request) {
					
					// 개인정보 조회
					Member_OfficeInfo mo = ms.pfview(from_mem_no);
					model.addAttribute("mo",mo);
					
					//변수확인(추후삭제))
					System.out.println("APPCTRL accept start");
					System.out.println("app doc no ==> "+ apr.getApp_doc_no());
					System.out.println("mem_no(to) ==>"+apr.getMem_no());
					System.out.println("mem_no(from) ==>"+from_mem_no);
					
					int doc_no = apr.getApp_doc_no();
					String mem_no1 = from_mem_no; 
					String mem_no2 = apr.getMem_no();
					System.out.println("test doc__no / =>" +doc_no);
					System.out.println("test mem_no1 / =>" +mem_no1);
					System.out.println("test mem_no2 / =>" +mem_no2);
					
					//memberto1 인지 2인지 확인  (from)
					int checkmt1 = aps.checkmt1(mem_no1,mem_no2,doc_no);
					System.out.println("checkmt1-->"+checkmt1);
					
					return "redirect:app_my_list2?mem_no="+mo.getMem_no();
				}
}

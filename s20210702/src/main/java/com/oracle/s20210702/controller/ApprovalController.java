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
	private ApprovalService aps;
	
	@Autowired
	private MainService ms;
	
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
					
					//auth_no조회
					int auth_no = aps.getauthno(apr.getMem_no());
					System.out.println("check// auth_no ==>"+ auth_no);
					model.addAttribute("auth_no",auth_no);
					
					//대표 제외 total
					int total2 = aps.total2(apr.getMem_no());  
					//대표 전용 total
					int totalT = aps.totalT(apr.getMem_no());
					
					System.out.println("APCTRL total=>" + total2);
					System.out.println("currentPage=>" + currentPage);
					//                     14     NULL(0,1....)
					Paging pg = new Paging(total2, currentPage);
					Paging pgT = new Paging(totalT, currentPage);
					apr.setStart(pg.getStart());   // 시작시 1
					apr.setEnd(pg.getEnd());       // 시작시 10 
					
					
					//대표 제외 리스트
					List<Approval> listAppr2 = aps.listAppr2(apr);
					//대표전용 리스트
					List<Approval> listApprT = aps.listApprT(apr);
					System.out.println("pg.getStart()=>" + pg.getStart());
					System.out.println("pg.getEnd()=>" + pg.getEnd());
					System.out.println("APPR Controller list2 listAppr2.size()=>" + listAppr2.size());
					model.addAttribute("total1", total2);
					model.addAttribute("totalT", totalT);
					model.addAttribute("listAppr2",listAppr2);
					model.addAttribute("listApprT",listApprT);
					System.out.println("listAppr2=>" + listAppr2);
					model.addAttribute("pg",pg);
					model.addAttribute("pgT",pgT);
			
			
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
					String mem_no1 = from_mem_no;  // from 이 결재자  //mem_no2가 상신올린사람.
					String mem_no2 = apr.getMem_no();
					System.out.println("test doc__no / =>" +doc_no);
					System.out.println("test mem_no1 / =>" +mem_no1);
					System.out.println("test mem_no2 / =>" +mem_no2);
					
					//결재 권한 체크!!
					int auth_no = aps.getauthno(mem_no1);
					System.out.println("check// auth_no ==>"+ auth_no);
					model.addAttribute("auth_no",auth_no);
					
					if (auth_no == 1) { 	apr.setApp_doc_memberto3(mem_no1); 
					System.out.println("check// app_doc_memberto3 ==>"+apr.getApp_doc_memberto3());}
					if (auth_no == 2) { 	apr.setApp_doc_memberto2(mem_no1); 
					System.out.println("check// app_doc_memberto2 ==>"+apr.getApp_doc_memberto2());}
					if (auth_no == 3) { 	apr.setApp_doc_memberto1(mem_no1); 
					System.out.println("check// app_doc_memberto1 ==>"+apr.getApp_doc_memberto1());}
					
						apr.setApp_auth_no(auth_no);
						apr.setMem_no(mem_no2);
						
						System.out.println("check// mem_no ==>" + apr.getMem_no());
						System.out.println("check// app_doc_no ==>" + apr.getApp_doc_no());
						System.out.println("check// app_auth_no ==>" + apr.getApp_auth_no());
						
						int res_up_apck2 = aps.up_apck2(apr);
						System.out.println("check// res_up_apck2 -->"+ res_up_apck2);
						model.addAttribute("apck_result",res_up_apck2);
					
					
					
					return "redirect:app_my_list2?currentPage=1&mem_no="+mo.getMem_no();
				}
				
				@RequestMapping(value = "no_accept")
				private String appnoaccept(String from_mem_no,Approval apr, Model model, HttpServletRequest request) {
					
					// 개인정보 조회
					Member_OfficeInfo mo = ms.pfview(from_mem_no);
					model.addAttribute("mo",mo);
					
					//변수확인(추후삭제))
					System.out.println("APPCTRL accept start");
					System.out.println("app doc no ==> "+ apr.getApp_doc_no());
					System.out.println("mem_no(to) ==>"+apr.getMem_no());
					System.out.println("mem_no(from) ==>"+from_mem_no);
					
					int doc_no = apr.getApp_doc_no();
					String mem_no1 = from_mem_no;  // from 이 결재자  //mem_no2가 상신올린사람.
					String mem_no2 = apr.getMem_no();
					System.out.println("test doc__no / =>" +doc_no);
					System.out.println("test mem_no1 / =>" +mem_no1);
					System.out.println("test mem_no2 / =>" +mem_no2);
					
					//결재 권한 체크!!
					int auth_no = aps.getauthno(mem_no1);
					System.out.println("check// auth_no ==>"+ auth_no);
					model.addAttribute("auth_no",auth_no);
					
					if (auth_no == 1) { 	apr.setApp_doc_memberto3(mem_no1); 
					System.out.println("check// app_doc_memberto3 ==>"+apr.getApp_doc_memberto3());}
					if (auth_no == 2) { 	apr.setApp_doc_memberto2(mem_no1); 
					System.out.println("check// app_doc_memberto2 ==>"+apr.getApp_doc_memberto2());}
					if (auth_no == 3) { 	apr.setApp_doc_memberto1(mem_no1); 
					System.out.println("check// app_doc_memberto1 ==>"+apr.getApp_doc_memberto1());}
					
						apr.setApp_auth_no(auth_no);
						apr.setMem_no(mem_no2);
						
						System.out.println("check// mem_no ==>" + apr.getMem_no());
						System.out.println("check// app_doc_no ==>" + apr.getApp_doc_no());
						System.out.println("check// app_auth_no ==>" + apr.getApp_auth_no());
						
						int res_up_apck2N = aps.up_apck2N(apr);
						System.out.println("check// res_up_apck2N -->"+ res_up_apck2N);
						model.addAttribute("apck_result",res_up_apck2N);
					
					
					
					return "redirect:app_my_list2?currentPage=1&mem_no="+mo.getMem_no();
				}
				
				// 대표/관리팀 전용 // 다른 테이블과 연동!!
				@RequestMapping(value = "app_acc_final")
				String app_acc_final(String mem_no, int app_doc_no, HttpServletRequest request, Model model) {
					
					// 개인정보 조회(접속자)
					Member_OfficeInfo mo = ms.pfview(mem_no);
					model.addAttribute("mo",mo);	
					
					System.out.println("test app_doc_no ==>" + app_doc_no);
					Approval app1 = new Approval();
					app1 = aps.showAppData(app_doc_no);
					System.out.println("test value check // app1.getMem_no =>"+app1.getMem_no());
					System.out.println("test value check // app1.getApp_doc_kind =>"+app1.getMem_no());
					
					//app_doc_status 변경
					int up_app_status  = aps.up_app_status(app_doc_no); 
					
					// 연차관련 스케쥴 등록!
					int inshefrap =  aps.inshefrap(app1);
					System.out.println("test// inshefrap ==>"+inshefrap);
					
					//memfrom3 10으로 변경
					int up_mf310 = aps.upmf310(app_doc_no);
					
					return "redirect:app_my_list2?currentPage=1&mem_no=0001";
				}
}

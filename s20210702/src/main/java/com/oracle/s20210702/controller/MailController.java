package com.oracle.s20210702.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.oracle.s20210702.model.Mail;
import com.oracle.s20210702.model.MailFile;
import com.oracle.s20210702.model.Member_OfficeInfo;
import com.oracle.s20210702.service.LoginService;
import com.oracle.s20210702.service.MailService;
import com.oracle.s20210702.service.Paging;

@Controller
public class MailController {
	@Autowired
	private MailService ms;
	@Autowired
	private LoginService ls;
	
	
	@RequestMapping(value = "mailList", method = {RequestMethod.GET, RequestMethod.POST})
	public String mailList(Mail mail, String currentPage, Model model, String mem_id, HttpServletRequest request) {
		System.out.println("MailController mailList Start list...");
		System.out.println("mail_ctrl mem_id -->" + mem_id);
		Member_OfficeInfo mo = ms.ListMember(mem_id);
		model.addAttribute("mo",mo);
		System.out.println("mail CTRL mo.getMem_id" + mo.getMem_id());
		int total = ms.total(mo);
		System.out.println("MailController total=>" + total);
		if (currentPage ==null) {currentPage = "1"  ; }
		System.out.println("currentPage=>" + currentPage);
		Paging pg = new Paging(total, currentPage);
		mail.setStart(pg.getStart());
		mail.setEnd(pg.getEnd());
		mail.setMem_no(mo.getMem_no());
		mail.setMem_id(mo.getMem_id());
		List<Mail> listMail = ms.ListMail(mail);
		System.out.println("MailController list listMail.size()=>" + listMail.size());
		model.addAttribute("total", total);
		model.addAttribute("listMail",listMail);
		model.addAttribute("pg",pg);
		return "mailList";
	}
	
	@RequestMapping(value = "del_mailList", method = {RequestMethod.GET, RequestMethod.POST})
	public String del_mailList(Mail mail, String currentPage, Model model, String mem_id, HttpServletRequest request) {
		System.out.println("MailController del_mailList Start list...");
		Member_OfficeInfo mo = ms.ListMember(mem_id);
		model.addAttribute("mo",mo);
		int del_total = ms.del_total(mo);
		Paging pg = new Paging(del_total, currentPage);
		mail.setStart(pg.getStart());
		mail.setEnd(pg.getEnd());
		mail.setMem_no(mo.getMem_no());
		mail.setMem_id(mo.getMem_id());
		List<Mail> del_listMail = ms.del_ListMail(mail);
		model.addAttribute("total", del_total);
		model.addAttribute("listMail",del_listMail);
		model.addAttribute("pg",pg);
		return "del_mailList";
	}
	
	@RequestMapping(value = "sen_mailList", method = {RequestMethod.GET, RequestMethod.POST})
	public String sen_mailList(Mail mail, String currentPage, Model model, String mem_id, HttpServletRequest request) {
		System.out.println("MailController sen_mailList Start list...");
		System.out.println(mem_id);
		Member_OfficeInfo mo = ms.ListMember(mem_id);
		model.addAttribute("mo",mo);
		int sen_total = ms.sen_total(mo.getMem_no());
		Paging pg = new Paging(sen_total, currentPage);
		mail.setStart(pg.getStart());
		mail.setEnd(pg.getEnd());
		mail.setMem_no(mo.getMem_no());
		List<Mail> sen_listMail = ms.sen_ListMail(mail);
		model.addAttribute("total", sen_total);
		model.addAttribute("listMail",sen_listMail);
		model.addAttribute("pg",pg);
		return "sen_mailList";
	}
	
	@GetMapping(value = "rec_mailList")
	public String rec_mailList(Mail mail, String currentPage, Model model, String mem_id, String mem_no, HttpServletRequest request) {
		System.out.println("MailController rec_mailList Start list...");
		System.out.println(mem_id);
		Member_OfficeInfo mo = ms.ListMember(mem_id);
		model.addAttribute("mo",mo);
		int rec_total = ms.rec_total(mo);
		Paging pg = new Paging(rec_total, currentPage);
		mail.setStart(pg.getStart());
		mail.setEnd(pg.getEnd());
		mail.setMem_no(mo.getMem_no());
		mail.setMem_id(mo.getMem_id());
		List<Mail> rec_listMail = ms.rec_ListMail(mail);
		model.addAttribute("total", rec_total);
		model.addAttribute("listMail",rec_listMail);
		model.addAttribute("pg",pg);
		return "rec_mailList";
	}
	
	@GetMapping(value = "mailWrite")
	public String mailWrite(Model model, String mem_id,HttpServletRequest request) {
		System.out.println("MailController mailWrite start.." );
		System.out.println("mem_id" + mem_id);
		Member_OfficeInfo mo = ms.ListMember(mem_id);
		model.addAttribute("mo", mo);
		return "mailWrite";
	}
	
	@PostMapping(value = "mailSend")
	public String mailSend(Mail mail, MailFile mailFile, Model model, MultipartFile file1, HttpServletRequest request) throws IOException {
		System.out.println("MailController Start MailSend...");
		Member_OfficeInfo member = ms.ListMember1(mail.getMem_no());
		
		//첨부파일 insert문
		String uploadPath = request.getSession().getServletContext().getRealPath("/upload/");
		String savedName = uploadFile(file1.getOriginalFilename(), file1.getBytes(), uploadPath);
		
		mailFile.setMail_org_name(file1.getOriginalFilename());
		mailFile.setMail_save_name(savedName);
		mailFile.setMail_size(file1.getSize());		
		
		mail.setMem_id(member.getMem_id());
		int result = ms.insert(mail);
		int resultFile = ms.insertFile(mailFile);
		//if(result > 0) return "redirect:sen_mailList";
		
		HttpSession session = request.getSession();
		session.setAttribute("member", member);
		System.out.println(member.getMem_id());
		//model.addAttribute("mem_id", member.getMem_id());
	
		return "forward:sen_mailList";
	}
	
	private String uploadFile(String originalname, byte[] fileData, String uploadPath) throws IOException {
		 UUID uid = UUID.randomUUID();
		 File fileDirectory = new File(uploadPath);
		 if(!fileDirectory.exists()) {
			 fileDirectory.mkdirs();
		 }
		 String savedName = uid.toString() + "_" + originalname;
		 File target = new File(uploadPath, savedName);
		 FileCopyUtils.copy(fileData, target);
		return savedName;
	}

	@GetMapping(value = "mailDetail")
	public String mailDetail(HttpServletRequest request, int mail_no, Model model) {
		System.out.println("MailController Start mailDetail....");
		System.out.println(mail_no);
		Mail mail = ms.detail(mail_no);
		Member_OfficeInfo mo = ms.receiverMember(mail);
		System.out.println("MailController mo rank->" + mo.getMem_rank());
		System.out.println("MailController mo name->" + mo.getMem_name());
		model.addAttribute("mail", mail);
		model.addAttribute("mo", mo);
		
		return "mailDetail";
	}
	
	@PostMapping(value = "eraseMail")
	public String eraseMail(HttpServletRequest request, int mail_no, Model model) {
		//HttpSession session = request.getSession();
		//String mem_id = (String) session.getAttribute("mem_id");
		System.out.println("MailController eraseMail Start...");
		System.out.println("MailController eraseMail mail_no->" + mail_no);
		int k = ms.eraseMail(mail_no);
		
		return "forward:del_mailList";
	}
	
	@PostMapping(value = "restoreMail")
	public String restoreMail(int mail_no, Model model) {
		System.out.println("MailController restoreMail start");
		System.out.println("MailController restoreMail mail_no->" + mail_no);
		int k = ms.restoreMail(mail_no);
		return "forward:mailList";
	}
	
	@PostMapping(value = "mailDelete")
	public String mailDelete(int mail_no, Model model) {
		int k = ms.mailDelete(mail_no);
		return "forward:del_mailList";
	}
}

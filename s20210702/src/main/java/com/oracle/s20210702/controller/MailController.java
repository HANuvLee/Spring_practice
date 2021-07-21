package com.oracle.s20210702.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.oracle.s20210702.model.Mail;
import com.oracle.s20210702.service.MailService;
import com.oracle.s20210702.service.Paging;

@Controller
public class MailController {
	
	@Autowired
	private MailService ms;
	
	@GetMapping(value = "mailList")
	public String mailList(Mail mail, String currentPage, Model model) {
		System.out.println("MailController Start list...");
		int total = ms.total();
		System.out.println("MailController total ->" + total);
		Paging pg = new Paging(total, currentPage);
		System.out.println("MailController pg ->" + pg);
		mail.setStart(pg.getStart());
		mail.setEnd(pg.getEnd());
		List<Mail> listMail = ms.ListMail(mail);
		System.out.println("MailController listMail ->" + listMail);
		model.addAttribute("total", total);
		model.addAttribute("listMail", listMail);
		model.addAttribute("pg", pg);
		
		return "mailList";
	}
	
	@GetMapping(value = "del_mailList")
	public String del_mailList(Mail mail, String currentPage, Model model) {
		System.out.println("MailController del_mailList Start list...");
		int del_total = ms.del_total();
		System.out.println("MailController del_mailList total ->" + del_total);
		Paging pg = new Paging(del_total, currentPage);
		System.out.println("MailController del_mailList pg ->" + pg);
		mail.setStart(pg.getStart());
		mail.setEnd(pg.getEnd());
		
		List<Mail> del_listMail = ms.del_ListMail(mail);
		System.out.println("MailController del_mailList listMail ->" + del_listMail);
		model.addAttribute("total", del_total);
		model.addAttribute("listMail", del_listMail);
		model.addAttribute("pg", pg);
		
		return "del_MailList";
	}
	
	@GetMapping(value = "sen_mailList")
	public String sen_mailList(Mail mail, String currentPage, Model model) {
		System.out.println("MailController sen_mailList Start list...");
		int sen_total = ms.sen_total();
		System.out.println("MailController sen_mailList total ->" + sen_total);
		Paging pg = new Paging(sen_total, currentPage);
		System.out.println("MailController sen_mailList pg ->" + pg);
		mail.setStart(pg.getStart());
		mail.setEnd(pg.getEnd());
	
		List<Mail> sen_listMail = ms.sen_ListMail(mail);
		System.out.println("MailController sen_mailList listMail ->" + sen_listMail);
		model.addAttribute("total", sen_total);
		model.addAttribute("listMail", sen_listMail);
		model.addAttribute("pg", pg);
		
		return "sen_MailList";
	}
	
	@GetMapping(value = "rec_mailList")
	public String rec_mailList(Mail mail, String currentPage, Model model) {
		System.out.println("MailController rec_mailList Start list...");
		int rec_total = ms.rec_total();
		System.out.println("MailController rec_mailList total ->" + rec_total);
		Paging pg = new Paging(rec_total, currentPage);
		System.out.println("MailController rec_mailList pg ->" + pg);
		mail.setStart(pg.getStart());
		mail.setEnd(pg.getEnd());
	
		List<Mail> rec_listMail = ms.rec_ListMail(mail);
		System.out.println("MailController rec_mailList listMail ->" + rec_listMail);
		model.addAttribute("total", rec_total);
		model.addAttribute("listMail", rec_listMail);
		model.addAttribute("pg", pg);
		
		return "rec_MailList";
	}
}

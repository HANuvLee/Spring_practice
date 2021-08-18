package com.oracle.s20210702.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.oracle.s20210702.model.ChatMessage;
import com.oracle.s20210702.model.ChatRoom;
import com.oracle.s20210702.model.ChatSession;
import com.oracle.s20210702.model.Mail;
import com.oracle.s20210702.model.Mail_File;
import com.oracle.s20210702.model.Member_OfficeInfo;
import com.oracle.s20210702.service.ChatService;
import com.oracle.s20210702.service.LoginService;
import com.oracle.s20210702.service.MailFileService;
import com.oracle.s20210702.service.MailService;
import com.oracle.s20210702.service.Paging;

@Controller
public class MailController {
	private static final Logger logger = LoggerFactory.getLogger(MailController.class);
	
	@Autowired
	private MailService ms;
	@Autowired
	private LoginService ls;
	@Autowired
	private MailFileService fs;
	@Autowired
    private ChatService cService;	
	@Autowired
    private ChatSession cSession;
	
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
	public String mailSend(Mail mail, Mail_File mailFile, Model model, HttpServletRequest request, MultipartFile file1) throws IOException {
		System.out.println("MailController Start MailSend...");
		System.out.println("mail.getMem_no -> " + mail.getMem_no());
		Member_OfficeInfo mo = ms.ListMember1(mail.getMem_no());
		
//		==================================첨부파일 insert문==========================================
		String uploadPath = ("C:\\Spring\\SpringSrc3914\\s20210702\\upload");
		System.out.println(uploadPath);
		String savedName = uploadFile(file1.getOriginalFilename(), file1.getBytes(), uploadPath);
		
		mailFile.setMail_org_name(file1.getOriginalFilename());
		mailFile.setMail_save_name(savedName);
		mailFile.setMail_file_size(file1.getSize());
		
		List<String> allMem_id = ms.allMem_id();
		System.out.println(allMem_id);
		int k = allMem_id.indexOf(mail.getMail_receiver());
		System.out.println(k);
		HttpSession session = request.getSession();
		session.setAttribute("member", mo);
		if(k >= 0) {
			mail.setMem_id(mo.getMem_id());
			int result = ms.insert(mail, mailFile);
			model.addAttribute("k", k);
			model.addAttribute("mo", mo);
			return "tandf";
		}else {
				
			System.out.println(mo.getMem_id());
			model.addAttribute("mo", mo);
			model.addAttribute("k", k);
			return "tandf";
		}
	}
	
//	=================================mailSend uploadFile 호출================================================
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
		HttpSession session = request.getSession();
		String mem_no = (String) session.getAttribute("mem_no");
		Member_OfficeInfo mo = ms.ListMember1(mem_no);
		System.out.println(mo.getMem_no());
		Mail_File mailFile = fs.fileList(mail_no);
		
		Member_OfficeInfo receiverMember = ms.receiverMember(mail);
		System.out.println("MailController mo rank->" + receiverMember.getMem_rank());
		System.out.println("MailController mo name->" + receiverMember.getMem_name());
		System.out.println("MailController mail mem_no ->" + mail.getMem_no());
		model.addAttribute("mailFile", mailFile);
		model.addAttribute("mail", mail);
		model.addAttribute("receiverMember", receiverMember);
		model.addAttribute("mo", mo);
		
		return "mailDetail";
	}
// =====================================파일 다운로드=======================================
	@RequestMapping(value = "fileDown", method = {RequestMethod.GET, RequestMethod.POST})
	public void fileDown(HttpServletResponse response, @RequestParam Map<String, Object> param, ModelMap model) throws IOException {
		try {
			fs.one(param, model);
			Map<String, Object> mailFile = (Map<String, Object>) model.get("mailFile");	
			String fileName = new String(mailFile.get("MAIL_SAVE_NAME").toString().getBytes("euc-kr"),"iso-8859-1");
			System.out.println(fileName);
			File file = new File("C:\\Spring\\SpringSrc3914\\s20210702\\upload\\"+mailFile.get("MAIL_SAVE_NAME"));
			System.out.println(file);
			String mimeType= URLConnection.guessContentTypeFromName(fileName);
			System.out.println(mimeType);
			if(mimeType==null) {
				mimeType = "application/octet-stream";
			}
			response.setContentType(mimeType);
			response.setHeader("Content-Disposition", "attachment; fileName=\""+fileName+"\"");
			response.setContentLength((int)file.length());

			InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
			FileCopyUtils.copy(inputStream, response.getOutputStream());

		} catch (Exception e) {
			logger.error( e.toString(), e );
		}
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
	
//	->수정
	@RequestMapping(value = "replyMail")
	public String replymail(int mail_no, Model model) {
		System.out.println("MailController reply start...");
		System.out.println(mail_no);
		Mail mail = ms.replymail(mail_no);
		System.out.println("replymail mem_no -> " + mail.getMem_no());
		Member_OfficeInfo mo = ms.ListMember1(mail.getMem_no());
		model.addAttribute("sender", mo);
		model.addAttribute("mail", mail);
		
		return "mailreply";
	}
	
	@GetMapping(value = "mailtome")
	public String mailtome(Model model, String mem_id, HttpServletRequest request) {
		System.out.println("MailController mailtome start.." );
		System.out.println("mem_id" + mem_id);
		Member_OfficeInfo mo = ms.ListMember(mem_id);
		model.addAttribute("mo", mo);
		return "mailtome";
	}
	
	@RequestMapping(value = "delArray")
	@ResponseBody
	public int delArry(@RequestParam(value="delArray[]") List<Integer> delArray, Mail mail) {
		System.out.println("MailController tandf start...");
		System.out.println(delArray);
		int y = delArray.size();
		for(int i = 0; i < delArray.size(); i++) {
			int k = ms.eraseMail(delArray.get(i));
		}
		return y;
	}
	
	@RequestMapping(value = "allrestoreMail")
	@ResponseBody
	public int allrestoreMail(@RequestParam(value="delArray[]") List<Integer> delArray, Mail mail) {
		System.out.println("MailController tandf start...");
		System.out.println(delArray);
		int y = delArray.size();
		for(int i = 0; i < delArray.size(); i++) {
			int k = ms.restoreMail(delArray.get(i));
		}
		return y;
	}
	
	@RequestMapping(value = "alldelMail")
	@ResponseBody
	public int alldelMail(@RequestParam(value="delArray[]") List<Integer> delArray, Mail mail) {
		System.out.println("MailController tandf start...");
		System.out.println(delArray);
		int y = delArray.size();
		for(int i = 0; i < delArray.size(); i++) {
			int k = ms.mailDelete(delArray.get(i));
		}
		return y;
	}
}

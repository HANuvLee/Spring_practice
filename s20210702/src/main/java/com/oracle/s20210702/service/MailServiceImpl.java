package com.oracle.s20210702.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.oracle.s20210702.dao.MailDao;
import com.oracle.s20210702.model.Mail;
import com.oracle.s20210702.model.MailFile;
import com.oracle.s20210702.model.Member_OfficeInfo;


@Service
public class MailServiceImpl implements MailService {
	
	@Autowired
	private MailDao md;

	@Override
	public int total(Member_OfficeInfo mo) {
		System.out.println("MailServiceImpl Start total..." );
		System.out.println("MailServiceImpl mem_id->" + mo.getMem_id());
		System.out.println("MailServiceImpl mem_no->" + mo.getMem_no());
		int totCnt = md.total(mo);
		System.out.println("MailServiceImpl total totCnt->"+totCnt );
		return totCnt;
	}
	
	@Override
	public int del_total(Member_OfficeInfo mo) {
		System.out.println("MailServiceImpl Start total..." );
		int del_totCnt = md.del_total(mo);
		System.out.println("MailServiceImpl del_total totCnt->"+del_totCnt );
		return del_totCnt;
	}

	@Override
	public List<Mail> ListMail(Mail mail) {
		System.out.println("MailServiceImpl listMail Start ..." );
		List<Mail> mailList = null;
		mailList = md.listMail(mail);
		return mailList;
	}
	
	@Override
	public List<Mail> del_ListMail(Mail mail) {
		System.out.println("MailServiceImpl del_listMail Start ..." );
		List<Mail> del_mailList = null;
		del_mailList = md.del_listMail(mail);
		return del_mailList;
	}

	@Override
	public int sen_total(String mem_no) {
		System.out.println("MailServiceImpl Start total..." );
		int sen_totCnt = md.sen_total(mem_no);
		System.out.println("MailServiceImpl sen_total totCnt->"+sen_totCnt );
		return sen_totCnt;
	}

	@Override
	public List<Mail> sen_ListMail(Mail mail) {
		System.out.println("MailServiceImpl sen_listMail Start ..." );
		List<Mail> sen_mailList = null;
		sen_mailList = md.sen_listMail(mail);
		return sen_mailList;
	}

	@Override
	public int rec_total(Member_OfficeInfo mo) {
		System.out.println("MailServiceImpl Start total..." );
		int rec_totCnt = md.rec_total(mo);
		System.out.println("MailServiceImpl rec_total totCnt->"+rec_totCnt );
		return rec_totCnt;
	}

	@Override
	public List<Mail> rec_ListMail(Mail mail) {
		System.out.println("MailServiceImpl rec_listMail Start ..." );
		List<Mail> rec_mailList = null;
		rec_mailList = md.rec_listMail(mail);
		return rec_mailList;
	}
	
	@Override
	public int insert(Mail mail) {
		System.out.println("MailServiceImpl insert start...");
		System.out.println("MailServiceImpl mem_no->" + mail.getMem_no());
		System.out.println("MailServiceImpl content->" + mail.getMail_content());
		int result = 0;
		result = md.insert(mail);
		
		return result;
	}

	@Override
	public Member_OfficeInfo ListMember(String mem_id) {
		System.out.println("MailServiceImpl member_id -> " + mem_id);
		Member_OfficeInfo mo = null;
		mo = md.listMember(mem_id);
		return mo;
	}
	
	@Override
	public Member_OfficeInfo ListMember1(String mem_no) {
		System.out.println("MailServiceImpl ListMember1 member_no -> " + mem_no);
		Member_OfficeInfo mo = null;
		mo = md.listMember1(mem_no);
		return mo;
	}

	@Override
	public Mail detail(int mail_no) {
		System.out.println("MailServiceImpl detail start...");
		Mail mail = null;
		mail = md.detail(mail_no);
		
		return mail;
	}

	@Override
	public Member_OfficeInfo receiverMember(Mail mail) {
		Member_OfficeInfo mo = null;
		mo = md.receiverMember(mail);
		return mo;
	}

	@Override
	public int eraseMail(int mail_no) {
		System.out.println("MailServiceImpl eraseMail start...");
		int k = 0;
		k = md.eraseMail(mail_no);
		return k;
	}

	@Override
	public int restoreMail(int mail_no) {
		int k = 0;
		k = md.restoreMail(mail_no);
		return k;
	}

	@Override
	public int mailDelete(int mail_no) {
		int k = 0;
		k = md.mailDelete(mail_no);
		return k;
	}

	@Override
	public int insertFile(MailFile mailFile) {
		int result = 0;
		result = md.insert(mailFile);
		
		return result;
	}

	
}

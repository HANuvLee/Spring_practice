package com.oracle.s20210702.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210702.dao.MailDao;
import com.oracle.s20210702.model.Mail;


@Service
public class MailServiceImpl implements MailService {
	
	@Autowired
	private MailDao md;

	@Override
	public int total() {
		int totCnt = md.total();
		return totCnt;
	}
	
	@Override
	public int del_total() {
		int del_totCnt = md.del_total();
		return del_totCnt;
	}
	
	@Override
	public int sen_total() {
		int sen_totCnt = md.sen_total();
		return sen_totCnt;
	}
	
	@Override
	public int rec_total() {
		int rec_totCnt = md.rec_total();
		return rec_totCnt;
	}

	@Override
	public List<Mail> ListMail(Mail mail) {
		List<Mail> mailList = null;
		mailList = md.listMail(mail);
		return mailList;
	}

	@Override
	public List<Mail> del_ListMail(Mail mail) {
		List<Mail> del_mailList = null;
		del_mailList = md.del_listMail(mail);
		return del_mailList;
	}


	@Override
	public List<Mail> sen_ListMail(Mail mail) {
		List<Mail> sen_mailList = null;
		sen_mailList = md.sen_listMail(mail);
		return sen_mailList;
	}



	@Override
	public List<Mail> rec_ListMail(Mail mail) {
		List<Mail> rec_mailList = null;
		rec_mailList = md.rec_listMail(mail);
		return rec_mailList;
	}

	





}

package com.oracle.s20210702.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210702.model.Mail;

@Repository
public class MailDaoImpl implements MailDao {
	
	@Autowired
	private SqlSession session;

	@Override
	public int total() {
		int tot = 0;
		try {
			tot = session.selectOne("hhMailtotal");
		} catch (Exception e) {
			System.out.println("MailDaoImpl total Exception->"+e.getMessage());
		}
		return tot;
	}
	
	@Override
	public int del_total() {
		int del_tot = 0;
		try {
			del_tot = session.selectOne("hhDelMailtotal");
		} catch (Exception e) {
			System.out.println("MailDaoImpl del_total Exception->"+e.getMessage());
		}
		return del_tot;
	}
	
	@Override
	public int sen_total() {
		int sen_tot = 0;
		try {
			sen_tot = session.selectOne("hhSenMailtotal");
		} catch (Exception e) {
			System.out.println("MailDaoImpl sen_total Exception->"+e.getMessage());
		}
		return sen_tot;
	}
	
	@Override
	public int rec_total() {
		int rec_tot = 0;
		try {
			rec_tot = session.selectOne("hhRecMailtotal");
		} catch (Exception e) {
			System.out.println("MailDaoImpl rec_total Exception->"+e.getMessage());
		}
		return rec_tot;
	}

	@Override
	public List<Mail> listMail(Mail mail) {
		List<Mail> mailList = null;
		System.out.println("MailDaoImpl listMail Start ..." );
		try {
			// Naming Rule 
			mailList = session.selectList("hhMailListAll", mail);
		} catch (Exception e) {
			System.out.println("MailDaoImpl listMail Exception->"+e.getMessage());
		}
		return mailList;
	}

	@Override
	public List<Mail> del_listMail(Mail mail) {
		List<Mail> del_mailList = null;
		System.out.println("MailDaoImpl del_listMail Start ..." );
		try {
			// Naming Rule 
			del_mailList = session.selectList("hhDelMailListAll", mail);
		} catch (Exception e) {
			System.out.println("MailDaoImpl del_listMail Exception->"+e.getMessage());
		}
		return del_mailList;
	}

	@Override
	public List<Mail> sen_listMail(Mail mail) {
		List<Mail> sen_mailList = null;
		System.out.println("MailDaoImpl sen_listMail Start ..." );
		try {
			// Naming Rule 
			sen_mailList = session.selectList("hhSenMailListAll", mail);
		} catch (Exception e) {
			System.out.println("MailDaoImpl sen_listMail Exception->"+e.getMessage());
		}
		return sen_mailList;
	}


	@Override
	public List<Mail> rec_listMail(Mail mail) {
		List<Mail> rec_mailList = null;
		System.out.println("MailDaoImpl rec_listMail Start ..." );
		try {
			// Naming Rule 
			rec_mailList = session.selectList("hhRecMailListAll", mail);
		} catch (Exception e) {
			System.out.println("MailDaoImpl rec_listMail Exception->"+e.getMessage());
		}
		return rec_mailList;
	}

	

	
	

}

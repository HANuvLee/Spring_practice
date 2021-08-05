package com.oracle.s20210702.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210702.model.Mail;
import com.oracle.s20210702.model.Member_OfficeInfo;

@Repository
public class MailDaoImpl implements MailDao {
	
	@Autowired
	private SqlSession session;

	@Override
	public int total(Member_OfficeInfo mo) {
		System.out.println("MailDaoImpl mem_id" + mo.getMem_id());
		System.out.println("MailDaoImpl mem_no" + mo.getMem_no());
		int tot = 0;
		try {
			tot = session.selectOne("hhMailtotal", mo);
		} catch (Exception e) {
			System.out.println("MailDaoImpl total Exception->"+e.getMessage());
		}
		return tot;
	}
	
	@Override
	public int del_total(Member_OfficeInfo mo) {
		int del_tot = 0;
		try {
			del_tot = session.selectOne("hhDelMailtotal", mo);
		} catch (Exception e) {
			System.out.println("MailDaoImpl del_total Exception->"+e.getMessage());
		}
		return del_tot;
	}

	@Override
	public List<Mail> listMail(Mail mail) {
		List<Mail> mailList = null;
		System.out.println("MailaDaoImpl listMail Start ..." );
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
	public int sen_total(String mem_no) {
		int sen_tot = 0;
		try {
			sen_tot = session.selectOne("hhSenMailtotal", mem_no);
		} catch (Exception e) {
			System.out.println("MailDaoImpl sen_total Exception->"+e.getMessage());
		}
		return sen_tot;
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
	public int rec_total(Member_OfficeInfo mo) {
		int rec_tot = 0;
		rec_tot = session.selectOne("hhRecMailtotal", mo);
		return rec_tot;
	}

	@Override
	public List<Mail> rec_listMail(Mail mail) {
		List<Mail> rec_mailList = null;
		rec_mailList = session.selectList("hhRecMailListAll", mail);
		
		return rec_mailList;
	}

	@Override
	public int insert(Mail mail) {
		System.out.println("MailDaoImpl insert Start ...");		
		int result = 0;
		try {
			result = session.insert("hhInsert", mail);
		} catch (Exception e) {
			System.out.println("MailDaoImpl insert Exception->" + e.getMessage());
		}
		
		
		return result;
	}

	@Override
	public Member_OfficeInfo listMember(String mem_id) {
		System.out.println("MailDaoImpl mem_id->" + mem_id);
		Member_OfficeInfo mo = null;
		try {
			mo = session.selectOne("hhMember", mem_id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mo;
	}
	
	@Override
	public Member_OfficeInfo listMember1(String mem_no) {
		System.out.println("MailDaoImpl mem_id->" + mem_no);
		Member_OfficeInfo mo = null;
		try {
			mo = session.selectOne("hhMember1", mem_no);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mo;
	}

	@Override
	public Mail detail(int mail_no) {
		System.out.println("MailDaoImpl detail start...");
		Mail mail = new Mail();
		mail = session.selectOne("hhmaildetail", mail_no);
		
		return mail;
	}

	@Override
	public Member_OfficeInfo receiverMember(Mail mail) {
		Member_OfficeInfo mo = null;
		mo = session.selectOne("hhreceiverMember", mail);
		return mo;
	}

	@Override
	public int eraseMail(int mail_no) {
		System.out.println("MailDaoImpl eraseMail start...");
		int k = 0;
		k = session.update("hheraseMail", mail_no);
		return k;
	}

	@Override
	public int restoreMail(int mail_no) {
		int k = 0;
		k = session.update("hhrestoreMail", mail_no);
		return k;
	}
	
	@Override
	public int mailDelete(int mail_no) {
		int k = 0;
		k = session.update("hhmailDelete", mail_no);
		return k;
	}

	
	
	

}

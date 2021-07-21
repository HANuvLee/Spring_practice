package com.oracle.s20210702.dao;

import java.util.List;

import com.oracle.s20210702.model.Mail;

public interface MailDao {

	int 		total();
	int 		del_total();
	int         sen_total();
	int         rec_total();
	List<Mail> 	listMail(Mail mail);
	List<Mail>  del_listMail(Mail mail);
	List<Mail>  sen_listMail(Mail mail);
	List<Mail> rec_listMail(Mail mail);
	
	

}

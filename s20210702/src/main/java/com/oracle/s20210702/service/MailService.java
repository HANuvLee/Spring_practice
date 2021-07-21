package com.oracle.s20210702.service;

import java.util.List;

import com.oracle.s20210702.model.Mail;

public interface MailService {
	
	int 			total();
	int             del_total();
	int             sen_total();
	int             rec_total();
	List<Mail> 		ListMail(Mail mail);
	List<Mail>		del_ListMail(Mail mail);
	List<Mail>      sen_ListMail(Mail mail);
	List<Mail>      rec_ListMail(Mail mail);
	
	

	

}

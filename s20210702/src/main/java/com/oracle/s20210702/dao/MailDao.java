package com.oracle.s20210702.dao;

import java.util.List;

import com.oracle.s20210702.model.Mail;
import com.oracle.s20210702.model.Mail_File;
import com.oracle.s20210702.model.Member_OfficeInfo;

public interface MailDao {

	int 				total(Member_OfficeInfo mo);
	List<Mail> 			listMail(Mail mail);

	int 				del_total(Member_OfficeInfo mo);
	List<Mail> 			del_listMail(Mail mail);

	int 				sen_total(String mem_no);
	List<Mail> 			sen_listMail(Mail mail);

	int 				rec_total(Member_OfficeInfo mo);
	List<Mail> 			rec_listMail(Mail mail);
	

	int 				insert(Mail mail, Mail_File mailFile);
	Member_OfficeInfo 	listMember(String mem_id);
	Member_OfficeInfo 	listMember1(String mem_no);
	
	Mail 				detail(int mail_no);
	Member_OfficeInfo 	receiverMember(Mail mail);
	int 				eraseMail(int mail_no);
	int 				restoreMail(int mail_no);
	int 				mailDelete(int mail_no);
	
//	->수정
	Mail 				replymail(int mail_no);
	List<String> 		allMem_id();
	
	
	
	
	
	
}

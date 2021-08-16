package com.oracle.s20210702.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.oracle.s20210702.model.Mail;
import com.oracle.s20210702.model.Mail_File;
import com.oracle.s20210702.model.Member_OfficeInfo;

public interface MailService {
	
	int 				total(Member_OfficeInfo mo);
	List<Mail> 			ListMail(Mail mail);
	
	int 				del_total(Member_OfficeInfo mo);
	List<Mail> 			del_ListMail(Mail mail);

	int 				sen_total(String mem_no);
	List<Mail> 			sen_ListMail(Mail mail);

	int 				rec_total(Member_OfficeInfo mo);
	List<Mail> 			rec_ListMail(Mail mail);
	
	
	Member_OfficeInfo 	ListMember(String mem_id);
	Member_OfficeInfo 	ListMember1(String mem_no);
	
	int 				insert(Mail mail, Mail_File mailFile);
	
	Mail 				detail(int mail_no);
	Member_OfficeInfo 	receiverMember(Mail mail);
	int 				eraseMail(int mail_no);
	int 				restoreMail(int mail_no);
	int					mailDelete(int mail_no);
//	->수정
	Mail 				replymail(int mail_no);
	List<String> 		allMem_id();
	
	
	
	
	
	

}

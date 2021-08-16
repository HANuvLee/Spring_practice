package com.oracle.s20210702.dao;

import java.util.Map;

import javax.mail.Session;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210702.model.Mail_File;

@Repository("MailFileDao")
public class MailFileDaoImpl implements MailFileDao {
	
	@Autowired
	private SqlSession Session;
	
	@Override
	public Mail_File fileList(int mail_no) {
		System.out.println("MailFileDaoImpl fileList start");
		Mail_File mailFile = new Mail_File();
		mailFile = Session.selectOne("hhfileList", mail_no);
		
		return mailFile;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> one( Map<String, Object> param ){
		System.out.println("MailFileDaoImpl one");
		return (Map<String, Object>)Session.selectOne( "hhmailFileone", param );
	}

	
}

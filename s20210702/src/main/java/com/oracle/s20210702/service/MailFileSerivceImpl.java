package com.oracle.s20210702.service;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.oracle.s20210702.dao.MailFileDao;
import com.oracle.s20210702.model.Mail_File;

@Service("MailFileService")
public class MailFileSerivceImpl implements MailFileService {

	@Autowired
	private MailFileDao fd;
	
	@Override
	public Mail_File fileList(int mail_no) {
		System.out.println("MailFileSerivceImpl fileList start");
		Mail_File mailFile = null;
		mailFile = fd.fileList(mail_no);
		
		return mailFile;
	}

	@Override
	public boolean one(Map<String, Object> param, ModelMap model) throws Exception {
		System.out.println("MailFileSerivceImpl one");
		Map<String, Object> svcMap = new HashMap<>();
		svcMap.put("mail_file_no", param.get("mail_file_no"));
		model.put("mailFile", fd.one(svcMap));
		return true;
	}

	@Override
	public Mail_File projectFile(Map<String, Object> map) {
		System.out.println("MailFileSerivceImpl projectFile Start...");
		Mail_File projectFile = null;
		projectFile = fd.projectFile(map);
		return projectFile;
	}


}

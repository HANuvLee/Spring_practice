package com.oracle.s20210702.service;

import java.util.Map;

import org.springframework.ui.ModelMap;
import com.oracle.s20210702.model.Mail_File;

public interface MailFileService {
//	==================메일 파일 리스트 select============================
	Mail_File               fileList(int mail_no);

	public boolean one(Map<String, Object> param, ModelMap model) throws Exception;

}

package com.oracle.s20210702.dao;

import java.util.HashMap;
import java.util.Map;

import com.oracle.s20210702.model.Mail_File;

public interface MailFileDao {
// ==========================메일 파일 select==========================
	Mail_File                  fileList(int mail_no);

	//---*저장
    public Map<String, Object> one( Map<String, Object> param );
// ==========================게시판 파일 select==========================

	Mail_File                  projectFile(Map<String, Object> map);

}

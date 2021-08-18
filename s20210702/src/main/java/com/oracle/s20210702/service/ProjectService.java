package com.oracle.s20210702.service;

import java.util.List;
import java.util.Map;

import org.springframework.ui.ModelMap;

import com.oracle.s20210702.model.Mail_File;
import com.oracle.s20210702.model.Member_OfficeInfo;
import com.oracle.s20210702.model.Project_Info;

public interface ProjectService {

	int 					total();

	List<Project_Info> 		listProject(Project_Info project);

	int 					next_pno();

	int 					pjinsert(Project_Info project, Mail_File mailFile);

	Project_Info            detail(int project_no);

	int                     pjupdate(Project_Info project);

	int projectDelete		(int project_no);

	Member_OfficeInfo       pjwrite(String mem_no);

	Member_OfficeInfo       pjteam(String smem_no);
// ==========================프로젝트 첨부파일 다운로드============================
	public boolean 		    one(Map<String, Object> param, ModelMap model) throws Exception;
	
	
	
	
	


}

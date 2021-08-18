package com.oracle.s20210702.dao;

import java.util.List;
import java.util.Map;

import com.oracle.s20210702.model.Mail_File;
import com.oracle.s20210702.model.Member_OfficeInfo;
import com.oracle.s20210702.model.Project_Info;

public interface ProjectDAO {

	int 						total();

	List<Project_Info> 			listProject(Project_Info project);

	int 						next_pno();

	int							pjinsert(Project_Info project, Mail_File mailFile);

	Project_Info				detail(int project_no);

	int      					update(Project_Info project);

	int 						projectDelete(int project_no);

	Member_OfficeInfo           pjwrite(String mem_no);

	Member_OfficeInfo           pjteam(String smem_no);
//	=====================프로젝트 첨부파이 저장=========================
	public Map<String, Object>   one(Map<String, Object> param);
	
	



}

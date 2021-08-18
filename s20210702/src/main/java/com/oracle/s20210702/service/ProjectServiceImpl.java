package com.oracle.s20210702.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.oracle.s20210702.dao.ProjectDAO;
import com.oracle.s20210702.model.Mail_File;
import com.oracle.s20210702.model.Member_OfficeInfo;
import com.oracle.s20210702.model.Project_Info;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDAO pd;
	
	@Override
	public int total() {
		System.out.println("ProjectServiceImpl total start..");
		int totCnt = pd.total();
		System.out.println("ProjectServiceImpl total totCnt ->" +totCnt);
		
		
		return totCnt;
	}

	@Override
	public List<Project_Info> listProject(Project_Info project) {
		
		System.out.println("ProjectServiceImpl listProject start..");
		List<Project_Info> projectList = null;
		
		projectList = pd.listProject(project);
		return projectList;
	}
	
	//프로젝트 등록
	@Override
	public int next_pno() {
		int next_pno = 0;
		next_pno = pd.next_pno();
		return next_pno;
	}

	@Override
	public int pjinsert(Project_Info project, Mail_File mailFile) {
		int pjinsert = 0;
		mailFile.setProject_no(project.getProject_no());
		System.out.println("project Service Impl mailFile getProject_no->" + mailFile.getProject_no());
		System.out.println("project Service Impl pjinsert Start");
		pjinsert = pd.pjinsert(project, mailFile);
		System.out.println("project_service_impl_pjinsert_result = "+pjinsert);
		return pjinsert;
	}

	@Override
	public Project_Info detail(int project_no) {
		System.out.println("ProjectServiceImpl  Project_Info detail start");
		
		Project_Info project = null;
		project = pd.detail(project_no);
		
		return project;
	}

	@Override
	public int pjupdate(Project_Info project) {
		int result = 0;
		result = pd.update(project);
		return result;
	}

	@Override
	public int projectDelete(int project_no) {
		System.out.println("ProjectServiceImpl projectDelete start");
		int pjdelresult = 0;
		pjdelresult = pd.projectDelete(project_no);
		
		return pjdelresult;
	}

	@Override
	public Member_OfficeInfo pjwrite(String mem_no) {
		Member_OfficeInfo pjwrite = null;
		pjwrite = pd.pjwrite(mem_no);
		return pjwrite;
	}

	@Override
	public Member_OfficeInfo pjteam(String smem_no) {
		Member_OfficeInfo pjteam = null;
		pjteam = pd.pjteam(smem_no);
		return pjteam;
	}

	@Override
	public boolean one(Map<String, Object> param, ModelMap model) throws Exception {
		System.out.println("ProjectServiceImpl one");
		Map<String, Object> svcMap = new HashMap<>();
		svcMap.put("mail_file_no", param.get("mail_file_no"));
		model.put("projectFile", pd.one(svcMap));
		return true;
	}



}

package com.oracle.s20210702.dao;

import java.util.List;
import java.util.Map;

import javax.mail.Session;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210702.model.Mail_File;
import com.oracle.s20210702.model.Member_OfficeInfo;
import com.oracle.s20210702.model.Project_Info;

@Repository

public class ProjectDAOImpl implements ProjectDAO {
	
	@Autowired SqlSession session;

	@Override
	public int total() {
		int tot = 0;
		System.out.println("ProjectDAOImpl start total..");
		tot = session.selectOne("bqProjectTotal");
		return tot;
	}

	@Override
	public List<Project_Info> listProject(Project_Info project) {
		System.out.println("ProjectDAOImpl listProject start..");
		List<Project_Info> ProjectList = null;
		ProjectList = session.selectList("bqProjectList", project);
		return ProjectList;
	}

	@Override
	public int next_pno() {
		int next_pno =0;
		int max_pno = 0;
		System.out.println("projectDAO impl next_pno start");
		try {
			max_pno = session.selectOne("bqMaxPno");
			next_pno = max_pno+1;
			
			System.out.println("result check =========== ");
			System.out.println("max_pno = "+max_pno);
			System.out.println("next_pno = "+next_pno);
		} 	catch (Exception e) {
			System.out.println("projcetDAO_impl_exception -> "+e.getMessage());
		}
		
		return next_pno;
	}

	@Override
	public int pjinsert(Project_Info project, Mail_File mailFile) {
		int pjinsert = 0;
		int pjinsert2 = 0;
		System.out.println("project Dao IMPL pjinsert start");
		try {
			pjinsert = session.insert("bqpjinsert", project); 
			System.out.println("what the fucking");
			if(pjinsert > 0) {
				if(mailFile == null) {
					return pjinsert;
				}
			}
			System.out.println("ProjectDAOImpl setOrgName->" + mailFile.getMail_org_name());
			System.out.println("ProjectDAOImpl setSavedName->" + mailFile.getMail_save_name());
			System.out.println("ProjectDAOImpl size->" + mailFile.getMail_file_size());
			System.out.println("ProjectDAOImpl setProject_no ->" + mailFile.getProject_no());
			pjinsert2 = session.insert("hhInsertFile", mailFile);
		} catch (Exception e) {
				System.out.println("ProjectDAOImpl Exception ->" + e.getMessage());
		}
		return pjinsert2;
	}

	@Override
	public Project_Info detail(int project_no) {
		System.out.println("ProjectDAOImpl Project_Info detail start");
		Project_Info project = new Project_Info();
		try {
			project = session.selectOne("bqpjdetail", project_no);
		} catch (Exception e) {
			System.out.println("ProjectDAOImpl Project_Info detail Exception->"+ e.getMessage());
		}
		return project;
	}

	@Override
	public int update(Project_Info project) {
		int result = 0;
		try {
			result = session.update("bqpjupdate", project);
		} catch (Exception e) {
			System.out.println("ProjectDAOImpl update exception-> " + e.getMessage());
		}
		return result;
	}

	@Override
	public int projectDelete(int project_no) {
		System.out.println("ProjectDAOImpl delete start");
		int pjdelresult =0;
		try {
			pjdelresult = session.delete("bqdelete" , project_no);
			
			
		} catch (Exception e) {
			System.out.println("ProjectDAOImpl projectDelete->"+ e.getMessage());
		}
		return pjdelresult;
	}

	@Override
	public Member_OfficeInfo pjwrite(String mem_no) {
	 Member_OfficeInfo pjwrite = new Member_OfficeInfo();
	 try {
		pjwrite = session.selectOne("bqpjwrite", mem_no);
	} catch (Exception e) {
		System.out.println("ProjectDAOImpl pjwrite exception ->" + e.getMessage());
	}
		return pjwrite;
	}

	@Override
	public Member_OfficeInfo pjteam(String smem_no) {
		Member_OfficeInfo pjteam = new Member_OfficeInfo();
		try {
			pjteam = session.selectOne("bqpjteam", smem_no);
		} catch (Exception e) {
			System.out.println("ProjectDAOImpl pjteam exception ->" + e.getMessage());
		}
		return pjteam;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> one(Map<String, Object> param) {
		System.out.println("ProjectDAOImpl one Start");
		return (Map<String, Object>)session.selectOne("hhprojectFileone", param);
	}

	
}
	
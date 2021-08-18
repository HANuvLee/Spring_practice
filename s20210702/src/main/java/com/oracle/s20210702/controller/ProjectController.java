package com.oracle.s20210702.controller;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.oracle.s20210702.dao.Paging;
import com.oracle.s20210702.model.Mail_File;
import com.oracle.s20210702.model.Member_OfficeInfo;
import com.oracle.s20210702.model.Project_Info;
import com.oracle.s20210702.service.MailFileService;
import com.oracle.s20210702.service.ProjectService;


@Controller
public class ProjectController {
	private static final Logger logger = LoggerFactory.getLogger(MailController.class);
	
	@Autowired
	private ProjectService ps;
	
	@Autowired
	private MailFileService fs;
//프로젝트 목록 조회
	@RequestMapping(value = "projectList")
	public String projectlist(Project_Info project, String currentPage, Model model) {
		System.out.println("projectcontroller list start..");
		int total = ps.total();
		
		Paging pg = new Paging(total, currentPage);
		
		project.setStart(pg.getStart());
		project.setEnd(pg.getEnd());
		
		List<Project_Info> listProject = ps.listProject(project);
		
		model.addAttribute("total", total);
		model.addAttribute("listProject", listProject);
		model.addAttribute("pg", pg);
		
		
		return "projectList";
		
	}
	
	
	
		
//프로젝트 등록 Form
	@RequestMapping(value = "projectWriteForm")
	public String projectWriteForm(String mem_no, Model model) {
		System.out.println("projectController projectWriteForm start");
		int next_pno = ps.next_pno();
		System.out.println("projectController next_pno"+next_pno);
		model.addAttribute("project_no", next_pno);
		return "projectWriteForm";
	}

//프로젝트 등록 Action
	@PostMapping(value = "projectWrite1")
	public String projectWrite(Project_Info project, Mail_File mailFile, String mem_no, Model model, HttpServletRequest request, MultipartFile file1) throws IOException {
		System.out.println("projectController projectWrite start");

		//		==================================첨부파일 insert문==========================================
		String uploadPath = ("C:\\Spring\\SpringSrc3914\\s20210702\\upload");
		System.out.println(uploadPath);
		String savedName = uploadFile(file1.getOriginalFilename(), file1.getBytes(), uploadPath);
		System.out.println(savedName);
		
		mailFile.setMail_org_name(file1.getOriginalFilename());
		mailFile.setMail_save_name(savedName);
		mailFile.setMail_file_size(file1.getSize());
		
		System.out.println(project.getBoard_no());
		System.out.println(project.getProject_no());
		System.out.println(project.getMem_no());
		System.out.println(project.getProject_name());
		System.out.println(project.getProject_excost());
		System.out.println(project.getProject_realcost());
		System.out.println(project.getProject_start());
		System.out.println(project.getProject_end());
		System.out.println(project.getProject_company());
		System.out.println(project.getProject_progress());
		System.out.println(project.getProject_url());
		System.out.println(project.getMail_file_no());
		
		int pjinsert = ps.pjinsert(project, mailFile);
//		if (pjinsert >0)
		System.out.println("projectController pjinsert -->"+pjinsert);
		

		
		return "redirect:projectList?mem_no="+mem_no;
		
	}
	
//	=================================mailSend uploadFile 호출================================================
	private String uploadFile(String originalname, byte[] fileData, String uploadPath) throws IOException {
		 UUID uid = UUID.randomUUID();
		 File fileDirectory = new File(uploadPath);
		 if(!fileDirectory.exists()) {
			 fileDirectory.mkdirs();
		 }
		 String savedName = uid.toString() + "_" + originalname;
		 File target = new File(uploadPath, savedName);
		 FileCopyUtils.copy(fileData, target);
		return savedName;
	}
	
//프로젝트 상세내용
	
	@RequestMapping(value ="projectContent")
	public String projectContent(String smem_no, String mem_no, int board_no, int project_no, Model model) {
		System.out.println("projectController projectContent start");
		Project_Info project = ps.detail(project_no);
		Member_OfficeInfo pjwrite = ps.pjwrite(mem_no);
		Member_OfficeInfo pjteam = ps.pjteam(smem_no);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("board_no", board_no);
		map.put("project_no", project_no);
		Mail_File projectFile =  fs.projectFile(map);
		
		model.addAttribute("projectFile", projectFile);
		model.addAttribute("pjteam", pjteam);
		model.addAttribute("pjwrite", pjwrite);
		model.addAttribute("project", project);
		
		return "projectContent";
	}
	
	// =====================================파일 다운로드=======================================
		@RequestMapping(value = "projectFileDown", method = {RequestMethod.GET, RequestMethod.POST})
		public void projectFileDown(HttpServletResponse response, @RequestParam Map<String, Object> param, ModelMap model) throws IOException {
			try {
				ps.one(param, model);
				Map<String, Object> projectFile = (Map<String, Object>) model.get("projectFile");	
				String fileName = new String(projectFile.get("MAIL_SAVE_NAME").toString().getBytes("euc-kr"),"iso-8859-1");
				System.out.println(fileName);
				File file = new File("C:\\Spring\\SpringSrc3914\\s20210702\\upload\\"+projectFile.get("MAIL_SAVE_NAME"));
				System.out.println(file);
				String mimeType= URLConnection.guessContentTypeFromName(fileName);
				System.out.println(mimeType);
				if(mimeType==null) {
					mimeType = "application/octet-stream";
				}
				response.setContentType(mimeType);
				response.setHeader("Content-Disposition", "attachment; fileName=\""+fileName+"\"");
				response.setContentLength((int)file.length());

				InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
				FileCopyUtils.copy(inputStream, response.getOutputStream());

			} catch (Exception e) {
				logger.error( e.toString(), e );
			}
		}
		
	
//프로젝트 수정
	@RequestMapping(value ="projectUpdateForm")
	public String projectUpdateForm(int project_no, Model model) {
		System.out.println("projectController projectUpdateForm start");
		System.out.println("projcet_no -->" +project_no);
		Project_Info project = ps.detail(project_no);
		
		model.addAttribute("project", project);
		
		return  "projectUpdateForm";
		
		
	}
	
	@PostMapping(value ="projectUpdate")
	public String projectUpdate(Project_Info project, Model model) {
		System.out.println("projectController projectUpdate start");
		int result = ps.pjupdate(project);
				
		return "forward:projectList";
	}


//프로젝트 삭제 
	
	@RequestMapping(value ="projectDelete")
	public String projectDelete(int project_no, Model model) {
		System.out.println("projectController Delete start");
		int pjdelresult = ps.projectDelete(project_no);
		return "redirect:projectList";
	}
}


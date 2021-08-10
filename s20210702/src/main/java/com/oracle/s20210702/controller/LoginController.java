package com.oracle.s20210702.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.oracle.s20210702.model.ChatSession;
import com.oracle.s20210702.model.MemVO1;
import com.oracle.s20210702.model.Member_OfficeInfo;
import com.oracle.s20210702.service.LoginService;
import com.oracle.s20210702.service.WorkManagementService;

@Controller
public class LoginController {
	
	@Autowired
	private ChatSession cSession;
	
	@Autowired
	private LoginService ls;
	
	@Autowired
	private WorkManagementService wms;
	
	@GetMapping(value = "loginForm") 
	public String loginFrom() {
	return "loginForm";
	}
	
	
	@PostMapping(value = "login")
	public String login(Member_OfficeInfo mo, Model model, HttpServletRequest request){
		System.out.println("LoginController login Start...");
		int result = ls.login(mo);
		System.out.println("member_id ->" + mo.getMem_id());
		System.out.println("LoginController result->" + result);
		Member_OfficeInfo member = ls.member(mo.getMem_id());
		model.addAttribute("mem_no", member.getMem_no());
		if(result == 0) 
			return "redirect:loginForm";
		
		else {
		model.addAttribute("mem_id", member.getMem_id());
		model.addAttribute("mem_no", member.getMem_no());
		
		

		System.out.println("22222->" + member.getMem_id());
		System.out.println("22222->" + member.getMem_no());
		
		HttpSession session = request.getSession();
		session.setAttribute("mem_no", member.getMem_no());
		session.setAttribute("member", member);

	
		return "forward:main?mem_no="+member.getMem_no();
		}
	}

}

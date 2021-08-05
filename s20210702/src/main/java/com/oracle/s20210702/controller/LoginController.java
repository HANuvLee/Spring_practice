package com.oracle.s20210702.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.oracle.s20210702.model.ChatSession;
import com.oracle.s20210702.model.Member_OfficeInfo;
import com.oracle.s20210702.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private ChatSession cSession;
	
	@Autowired
	private LoginService ls;
	
	@GetMapping(value = "loginForm") 
	public String loginFrom() {
	return "loginForm";
	}
	
	
	@PostMapping(value = "login")
	public String login(Member_OfficeInfo mo, Model model, HttpServletRequest request){
		System.out.println("LoginController login Start...");
		System.out.println("LoginController Login mo.mem_id->" + mo.getMem_id());
		int result = ls.login(mo);
		System.out.println("member_id ->" + mo.getMem_id());
		System.out.println("LoginController result->" + result);
		Member_OfficeInfo member = ls.member(mo.getMem_id());
		if(result == 0) 
			return "forward:loginForm";
		
		else {
		
		
		

		System.out.println("login member.getMem_id() ->" + member.getMem_id());
		System.out.println("login member.getMem_no() ->" + member.getMem_no());
		System.out.println("login member ->" + member);
		HttpSession session = request.getSession();
		session.setAttribute("member", member);
		//model.addAttribute("member", member);
		session.setAttribute("mem_id", mo.getMem_id());
		
		//cSession.addmember(member.getMem_id());
		//session.setAttribute("mem_no", member.getMem_no());

		return "forward:mailList";
		}
	}

}

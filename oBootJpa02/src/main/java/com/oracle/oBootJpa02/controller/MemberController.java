package com.oracle.oBootJpa02.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.oracle.oBootJpa02.domain.Member;
import com.oracle.oBootJpa02.service.MemberService;

@Controller
//빈으로 설정해 놓았기 때문에 사용가능한것
public class MemberController {
   private final MemberService memberService;
   
   //빈으로 설정해 놓았기 때문에 사용가능한것(springConfigd에서)
   @Autowired
   public MemberController(MemberService memberService) {
	   System.out.println("@autowired MemberController start");
      this.memberService = memberService;
   }
   
   @GetMapping(value="/members/new")
   public String createForm() {
      System.out.println("MemberController JPA /members/new start...");
      
      return "members/createMemberForm";
   }
   
   @PostMapping(value="/members/save")
   public String create(Member member) {
      System.out.println("MemberController JPA create start..");
      System.out.println("Member.getTeamname()->" + member.getTeamname());
      System.out.println("Member.getName()->" + member.getName());
      memberService.join(member);
      
      return "redirect:/";
   }
   
   @GetMapping(value = "/members")
   public String listMember(Model model) {
	   List<Member> memberList = memberService.getListAllMember();
	   System.out.println("memberList.get(0).getName()->" + memberList.get(0).getName());
	   System.out.println("memberList.get(0).getTeam().getName()->" + memberList.get(0).getTeam().getName());
	   
	   model.addAttribute("members", memberList);
	   
	   return "members/memberList";
   }
   
   @GetMapping(value = "/memberModifyForm")
   public String memberModify(Long id, Model model) {
	   System.out.println("MemberController memberModify id -> " + id);
	   Optional<Member> memeber = memberService.findByMember(id);
	   
	   Member member2 = new Member();
	   member2.setId(memeber.get().getId());
	   member2.setName(memeber.get().getName());
	   member2.setTeam(memeber.get().getTeam());
	   
	   System.out.println("memeber.get().getId() -> " + memeber.get().getId());
	   System.out.println("memeber.get().getName() -> " + memeber.get().getName());
	   System.out.println("memeber.get().getTeam().getName() ->" + memeber.get().getTeam().getName());
	   model.addAttribute("member", member2);
	   
	   return "members/memberModify";
   }
   
   @GetMapping(value = "/members/memberUpdate")
   public String memberUpdate(Member member, Model model) {
	   System.out.println("MemberController memberUpdate id ->" + member.getId());
	   System.out.println("MemberController memberUpdate member.getName -> " + member.getName());
	   System.out.println("MemberController memberUpdate member.getTeamname ->" + member.getTeamname());
	   memberService.memberUpdate(member);
	   return "redirect:/members";
   }
   
   @PostMapping(value = "/members/search")
   public String search(Member member, Model model) {
	   System.out.println("/members/search member.getName()->"+ member.getName());
	   List<Member> memberList = memberService.getListSearchMember(member.getName());
	   System.out.println("/members/search memberList.size()->" + memberList.size());
	   model.addAttribute("members", memberList);
	   
	   return "members/memberList";
   }

}
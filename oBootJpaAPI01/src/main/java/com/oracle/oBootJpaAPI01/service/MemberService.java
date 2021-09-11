package com.oracle.oBootJpaAPI01.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.oracle.oBootJpaAPI01.domain.Member;
import com.oracle.oBootJpaAPI01.repository.MemberRepository;

@Service
@Transactional
public class MemberService {
	private final MemberRepository memberRepository;
	
	public MemberService(MemberRepository memberRepository) {
		System.out.println(" MemberService MemberRepository memberRepository start...");
		this.memberRepository = memberRepository;
	}
	
	//전체회원 조회
	public List<Member> getListAllMember(){
		List<Member> listMember = memberRepository.findAll();
		System.out.println("Memberservice getListAllMember listMember.seiz()->" + listMember.size());
		
		return listMember;
	}
}

package com.oracle.oBootJpaAPI01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.oBootJpaAPI01.domain.Member;
import com.oracle.oBootJpaAPI01.repository.MemberRepository;

@SpringBootTest
class OBootJpaApi01ApplicationTests {
	@Autowired
	MemberRepository memberRepository;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testMember() {
		Member member = new Member();
		member.setName("memberTestA");
		Long savedId = memberRepository.save(member);
		Member findMember = memberRepository.findByMember(savedId);
		System.out.println("@SpringBootTest savedId" + savedId );
		System.out.println("@SpringBootTest findMember.getId()->" + findMember.getId());
		Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
		Assertions.assertThat(findMember.getId()).isEqualTo(999);
		
	}

}

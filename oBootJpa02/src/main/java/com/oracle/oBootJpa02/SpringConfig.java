package com.oracle.oBootJpa02;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.oracle.oBootJpa02.repository.JpaMemberRepository;
import com.oracle.oBootJpa02.repository.MemberRepository;
import com.oracle.oBootJpa02.service.MemberService;

@Configuration
public class SpringConfig {
	private final DataSource       dataSource;
	private final EntityManager    em;   //JPA사용을 위해 선언

    public SpringConfig(
 		    DataSource       dataSource,
   		    EntityManager    em) 
    {
    	System.out.println("SpringConfig Start...");
		this.dataSource = dataSource;
		this.em = em;
	}
    @Bean
    public MemberService memberService() {
    	System.out.println("MemberService memberService start()...");
		return  new MemberService(memberRepository());
	}

    @Bean
    public MemberRepository memberRepository() {
    	System.out.println("MemberRepository memberRepository() Start...");
        return new JpaMemberRepository(em);
    }	
}

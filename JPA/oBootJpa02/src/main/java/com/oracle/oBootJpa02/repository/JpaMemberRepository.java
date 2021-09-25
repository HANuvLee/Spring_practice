package com.oracle.oBootJpa02.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import com.oracle.oBootJpa02.domain.Member;
import com.oracle.oBootJpa02.domain.Team;

public class JpaMemberRepository implements MemberRepository {
    private final EntityManager em;
    
    public JpaMemberRepository(EntityManager em) {
    	System.out.println("JpaMemberRepository Start...");
    	this.em = em;			//jpa연결시 엔티티메니저를 사용해야함
    }
    
	@Override
	public Member save(Member member) {
		System.out.println("JpaMemberRepository Member save() Start...");
		 //팀 저장
		Team team = new Team();
		
		team.setName(member.getTeamname());
		em.persist(team);
		
		//회원 저장
		 member.setTeam(team); //단방향 연관관계 설정, 참조 저장
		 em.persist(member);	  //엔티티 매니저 사용	
		 return member;
	}

	@Override
	public List<Member> findAll() {
		System.out.println("JpaMemberRepository Member findAll() Start...");
													//테이블이 아닌 멤버클래스에서 가져옴, 테이블 착각 x
		List<Member> memberList = em.createQuery("select m from Member m", Member.class)
								 .getResultList();
							
		return memberList;
	}
	
	//엔티티 매니저의 find메소드 em.find(Member.class, id); => select * from Member where id =id;
	// Optional 객체를 사용하면 예상치 못한 NullPointerException 예외를 제공되는 메소드로 간단히 회피.
	// 즉, 복잡한 조건문 없이도 널(null) 값으로 인해 발생하는 예외를 처리
	@Override
	public Optional<Member> findByMember(Long id) {
		System.out.println("JpaMemberRepository Member findByMember() Start...");
		Member member = em.find(Member.class, id);
		return Optional.ofNullable(member);
	}

	@Override
	public int updateByMember(Member member) {
		System.out.println("JpaMemberRepository Member updateByMember() Start...");
		int result = 0;
		Member member3 = em.find(Member.class, member.getId());
		//member3.ifPresent(object);
		if(member3 != null) {
			//팀 저장
			Team team = em.find(Team.class, member.getTeamid());
			if(team != null) {
				team.setName(member.getTeamname());
				em.persist(team);
			}
			//회원저장
			member3.setTeam(team); //단방향 연관관계 설정, 참조 저장
			member3.setName(member.getName()); //단방향 연관관계 설정, 참조 저장
//			member3.setTeam(member.getTeam());
			em.persist(member3);
			System.out.println("JpaMemberRepository upadateByMember member.getName()->" + member.getName());
			result = 1;
		}
		else {
			result = 0;
			System.out.println("JpaMemberRepository updateByMember No Exist...");
		}
		
		return result;
	}

	@Override
	public List<Member> findByNames(String name) {
		String pname = name + '%';
		System.out.println("JpaMemberRepository findByNames name ->" + name);
												//name 은 member 클래스에 있는것을 사용 착각x
		List<Member> memberList = em.createQuery("select m from Member m where name Like :name", Member.class)
								.setParameter("name", pname)
								.getResultList();
		System.out.println("JpaMemberRepository memberList.size()->" + memberList.size());
		
		return memberList;
	}

}

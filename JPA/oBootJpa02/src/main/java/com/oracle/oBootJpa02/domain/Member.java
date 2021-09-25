package com.oracle.oBootJpa02.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

//Entity는 테이블 객체가 아닌 자바의 클래스 엔티티를 말한다!! 착각x , 엔티티는 밑에 테이블 어노테이션을 만들어주기 위한 세팅과정(전초기지)!!
@Entity
@SequenceGenerator(name = "member_seq_gen",					//객체에서 쓰는 제네레이터 이름
				   sequenceName = "member_seq_generator",	//매핑할 DB 시퀀스 이름, DB에서 쓰는 시퀀스 이름
				   initialValue =  1,
				   allocationSize = 1
				  )
@Table(name = "member1")
public class Member {
	// 프라이머리 키  
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_gen")
	private Long   id;
	@Column(name = "username")
	private String name;
	
	//team테이블과 연결( FK지정 team id로 선언 ), (오라클에 team_id필드가 저절로 생성)
	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team team;
	
	//Update시 -> team에 저장할 teamname 임시저장 (임시버퍼), TBL(테이블)에는 존재 안 함
	//html에서 name = teamname 이용 때문에
	@Transient       
	private String teamname;
	@Transient
	@Column(name = "team_id")
	private Long teamid;
	
	
	public Long getTeamid() {
		return teamid;
	}

	public void setTeamid(Long teamid) {
		this.teamid = teamid;
	}

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

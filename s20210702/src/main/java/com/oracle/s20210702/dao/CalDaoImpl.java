package com.oracle.s20210702.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210702.model.CalData;
import com.oracle.s20210702.model.Schedule;

@Repository
public class CalDaoImpl implements CalDao {

	@Autowired
	private SqlSession session;

	@Override
	public int todocnt(String targetDateString, String mem_no) {
		System.out.println("CDI todocnt Start");
		CalData cal = new CalData();
		System.out.println("CalData cal = new CalData(); end~~");
		cal.setTargetDateString(targetDateString);
		System.out.println("cal.setTargetDateString(targetDateString); end..");
		
		cal.setMem_no(mem_no);
		System.out.println("cal.setMem_no(mem_no); end..");
		
		System.out.println("cal.getTargetDateString -->"+ cal.getTargetDateString());
		System.out.println("cal.getMem_no -->"+ cal.getMem_no());
		
			
		int todocnt = session.selectOne("ssTodoCnt",cal);
		return todocnt;
	}

	//listSche
	@Override
	public List<Schedule> listSchedule(String targetDateString, String mem_no) {
		List<Schedule> listSchedule = null;
		CalData cal = new CalData();
		cal.setTargetDateString(targetDateString);
		System.out.println("cal.setTargetDateString(targetDateString); end..");
		
		cal.setMem_no(mem_no);
		System.out.println("cal.setMem_no(mem_no); end..");
		
		
		System.out.println("CDI List start");
		try {
			listSchedule = session.selectList("ssScheduleList",cal);			
		} catch (Exception e) {
			System.out.println("CDI EXCEPTION --> "+e.getMessage());
		}
		return listSchedule;
	}

	
	//schedule insert real
	@Override
	public int schIns(String schedule_kind, String schedule_name, String startDateString, String endDateString,
			String schedule_content, String mem_no) {
		int insresult = 0;
		Schedule sch = new Schedule();
		sch.setMem_no(mem_no);
		sch.setSchedule_content(schedule_content);
		sch.setSchedule_end(endDateString);
		sch.setSchedule_start(startDateString);
		sch.setSchedule_name(schedule_name);
		sch.setSchedule_kind(schedule_kind);
		
		
		try {
			insresult = session.insert("ssScheIns",sch);
		} catch (Exception e) {
			System.out.println("CalDI SCHINS EXCEPTION --> "+e.getMessage());
		}
		
		return insresult;
	}

	
	//삭제 가능 여부 체크 // 가능 = 1 / 불가능 = 0
	@Override
	public int dccheck(String schedule_no, String mem_no) {
		Schedule sch = new Schedule();
		sch.setSchedule_no(schedule_no);
		sch.setMem_no(mem_no);
		
		System.out.println("CDI dccheck Start!!!");
		
		
		int dcresult = session.selectOne("ssdccheck",sch);
		System.out.println("CALDI dcresult= >"+dcresult);
		
		return dcresult;
	}

	//삭제 대기중으로 변경 // 추후 변경 필요
	@Override
	public int upSche(String schedule_no, String mem_no) {
		Schedule sch = new Schedule();
		sch.setMem_no(mem_no);
		sch.setSchedule_no(schedule_no);
		
		int upresult = session.update("ssupSche",sch);
		
		
		
		
		return upresult;
	}

	

	
	
	
	
	
}

package com.oracle.s20210702.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210702.model.Member_OfficeInfo;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private SqlSession session;

	@Override
	public int loginId_chk(String mem_id) {
		int result = 0;
		try {
			// result > 0  존재 User
			result = session.selectOne("hhid_chk", mem_id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int loginPw_chk(String mem_pw) {
		int result = 0;
		try {
			// result > 0  존재 User
			result = session.selectOne("hhpw_chk", mem_pw);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public Member_OfficeInfo member(String mem_id) {
		Member_OfficeInfo member = null;
		member = session.selectOne("hhmember", mem_id);
		return member;
	}

	

}

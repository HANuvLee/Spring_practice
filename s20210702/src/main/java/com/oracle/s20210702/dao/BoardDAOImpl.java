package com.oracle.s20210702.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.s20210702.model.Board;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired
	private SqlSession session;

	// 게시물 리스트 조회용 (게시물 갯수 카운팅 board_no = 1)
	@Override
	public int total1() {
		int tot1 = 0;
		System.out.println("BoardDaoImpl Start total1..." );
		try {
			  // session -> Mapper ID total 호출 
			 tot1 = session.selectOne("ssBoardtotal1");
			System.out.println("boardDaoImpl Start total..." );
		} catch (Exception e) {
			System.out.println("boardDaoImpl total Exception->"+e.getMessage());
		}
		
		return tot1;
	}

	// 게시물 리스트 조회용 (게시물 리스팅 board_no = 1)
	@Override
	public List<Board> listBoard1(Board bd) {
		List<Board> boardList1 = null;
		System.out.println("BoardDaoImpl listBoard Start ..." );
		
		try {
			// Naming Rule 
			boardList1 = session.selectList("ssBoardList1", bd);
		} catch (Exception e) {
			System.out.println("EmpDaoImpl listEmp Exception->"+e.getMessage());
		}
		return boardList1;
	}

	
	// 게시물 상세 조회용
	@Override
	public Board content(int board_no, int post_no) {
		System.out.println("BoardDaoImpl content sta");
		Board board = new Board();
		try { // map으로 수정하는게 좋긴할탠데 추후 수정할 계획
			if (board_no ==1) {
			board = session.selectOne("ssBoardCont1",post_no);
			} else { // board_no== 1 이외에 다 이쪽으로 일단 설정 //추후 맵으로 수정
			board= session.selectOne("ssBoardCont2",post_no);
			}
			
			System.out.println("board_no = " +board_no);
			System.out.println("post_no = " +post_no);
			System.out.println("board.getMem_no = " + board.getMem_no() );
			System.out.println("board.getPost_title() = " + board.getPost_title() );
			
		} catch (Exception e) {
			System.out.println("boardDaoImpl content exception -> "+ e.getMessage());
		}
		return board;
	}

	
	// 게시물 수정 action
	@Override
	public int update1(Board board) {
		System.out.println("boarddaoimpl update start");
		int upresult1 = 0;
		System.out.println("board_no = "+ board.getBoard_no());
		System.out.println("post_no = "+ board.getPost_no());
		System.out.println("post_title = "+ board.getPost_title());
		System.out.println("post_content = "+ board.getPost_content());
		
		
		try {
			upresult1  = session.update("ssboardUpdate1",board);
			
			
		} catch (Exception e) {
			System.out.println("boarddaoimpl update exception -> "+e.getMessage());
		}
		return upresult1;
	}

	
	//게시물 삭제
	@Override
	public int delete1(int post_no) {
		System.out.println("BoardDAOIMPL delete1 start");
		int delresult =0;
		try {
			delresult = session.delete("ssdelete1",post_no);
			System.out.println("boardDAO delete1 delresult = " + delresult);
		} catch (Exception e) {
			System.out.println("boardDao exception =>"+ e.getMessage());
		}
		return delresult;
	}

	//게시물 작성
	@Override
	public int next_pno1() {
		int next_pno1 =0;
		int max_pno1 = 0;
		System.out.println("board dao impl next_pno1 start");
		try {
			max_pno1 = session.selectOne("ssMaxPno1");
			next_pno1 = max_pno1+1;
			
			System.out.println("result check =========== ");
			System.out.println("max_pno1 = "+max_pno1);
			System.out.println("next_pno1 = "+next_pno1);
		} catch (Exception e) {
			System.out.println("board_dao_impl_exception -> "+e.getMessage());
		}
		
		return next_pno1;
	}
	
	
	@Override
	public int insert1(Board board) {
		int insresult = 0;
		System.out.println("Board Dao IMPL insert1 start");
		try {
			insresult = session.insert("ssinsert1",board);
			System.out.println("board_dao_impl_insert1_result = "+insresult);
		} catch (Exception e) {
				System.out.println("Board Dao IMPL Exception ->" + e.getMessage());
		}
		return insresult;
	}

	@Override
	public List<Board> recentlistBoard1() {
		List<Board> recentboardList1 = null;
		System.out.println("BoardDaoImpl listBoard Start ..." );
		
		try {
			// Naming Rule 
			recentboardList1 = session.selectList("ssBoardRecList1");
		} catch (Exception e) {
			System.out.println("EmpDaoImpl listEmp Exception->"+e.getMessage());
		}
		return recentboardList1;
	}




	
	
	
}

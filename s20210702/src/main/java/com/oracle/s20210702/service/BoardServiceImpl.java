package com.oracle.s20210702.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.s20210702.dao.BoardDAO;
import com.oracle.s20210702.model.Board;




	@Service
	public class BoardServiceImpl implements BoardService {

		@Autowired
		private BoardDAO bd;

		// 게시물 목록 조회 (게시물 갯수 / board_no=1)
		@Override
		public int total1() {
			System.out.println("BoardServiceImpl Start total..." );
			int totCnt = bd.total1();
			System.out.println("BoardServiceImpl total totCnt->"+totCnt );
			return totCnt;
		}

		// 게시물 목록 조회 (게시물 리스팅/board_no = 1)
		@Override
		public List<Board> listBoard1(Board board) {
			List<Board> boardList1 = null;
			System.out.println("BoardServiceImpl list Start..." );
			boardList1 = bd.listBoard1(board);
			System.out.println("BoardServiceImpl listBoard1 boardList.size()->" +boardList1.size());
			return boardList1;
		}

		
		
		//게시물 상세 내용 조회
		@Override
		public Board content(int board_no, int post_no) {
			System.out.println("BoardServiceImpl content.");
			Board board = null;
			board = bd.content(board_no, post_no);
			return board;
		}

		
		
		// 게시물 수정 (1)
		@Override
		public int update1(Board board) {
			System.out.println("BoardServiceImpl update Sta");
			int upresult1 = 0;
			upresult1 = bd.update1(board);
			return upresult1;
		}

		//게시물 삭제
		@Override
		public int delete1(int post_no) {
			System.out.println("boardServiceImpl Delete1 start");
			int delresult=0;
			delresult = bd.delete1(post_no);
			return delresult;
		}

		// 게시물 작성(다음 post_no 얻기 1)
		@Override
		public int nextpno1() {
			int next_pno1 = 0;
			next_pno1 = bd.next_pno1(); 
			return next_pno1;
		}

		
		// 게시물 작성
		@Override
		public int insert1(Board board) {
			int insresult = 0;
			System.out.println("Board Service Impl Insert1 Start");
			insresult = bd.insert1(board);
			System.out.println("board_service_impl_insert1_result = "+insresult);
			return insresult;
		}

		
		//main용 최근 글 리스트 보여주기
		@Override
		public List<Board> recentlistBoard1() {
			List<Board> recentboardList1 = null;
			System.out.println("BoardServiceImpl recentboardlist Start..." );
			recentboardList1 = bd.recentlistBoard1();
			System.out.println("BoardServiceImpl recentlistBoard1 boardList.size()->" +recentboardList1.size());
			return recentboardList1;
		}


		
		
		
		
		
}
	


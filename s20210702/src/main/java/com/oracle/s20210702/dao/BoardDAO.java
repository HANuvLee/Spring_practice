package com.oracle.s20210702.dao;

import java.util.List;

import com.oracle.s20210702.model.Board;





public interface BoardDAO {
	
	List<Board>		 		listBoard1(Board board);
	int 				total1();
	Board 		content(int board_no, int post_no);
	int 				update1(Board board);
	int 				delete1(int post_no);
	int 				insert1(Board board);
	int 				next_pno1();
	List<Board> 				recentlistBoard1();
	
	// 게시글 작성
	

	// 게시물 목록 조회
	
}


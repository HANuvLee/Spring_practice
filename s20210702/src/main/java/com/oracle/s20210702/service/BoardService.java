package com.oracle.s20210702.service;

import java.util.List;

import com.oracle.s20210702.model.Board;



public interface BoardService {
	

	
	List<Board> 					listBoard1(Board board);
	int 			total1();
	Board 	content(int board_no, int post_no);
	int 			update1(Board board);
	int	 		delete1(int post_no);
	int 			insert1(Board board);
	int 			nextpno1();
	List<Board> 					recentlistBoard1();
}

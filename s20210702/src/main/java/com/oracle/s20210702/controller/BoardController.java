package com.oracle.s20210702.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.oracle.s20210702.model.Board;
import com.oracle.s20210702.service.BoardService;
import com.oracle.s20210702.service.Paging;

	
	@Controller
	public class BoardController {

		private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
		
		@Autowired
		private BoardService bd;
		
		@RequestMapping("/list1")	
		// 게시판 목록 조회
		public String list(Board board, String currentPage, Model model) {
			System.out.println("BoardController Start list..." );
			int total1 = bd.total1();   // Board Count -> 19
			System.out.println("BoardController total=>" + total1);
			System.out.println("currentPage=>" + currentPage);
			//                     14     NULL(0,1....)
			Paging pg = new Paging(total1, currentPage);
			board.setStart(pg.getStart());   // 시작시 1
			board.setEnd(pg.getEnd());       // 시작시 10 
			List<Board> listBoard = bd.listBoard1(board);
			System.out.println("pg.getStart()=>" + pg.getStart());
			System.out.println("pg.getEnd()=>" + pg.getEnd());
			System.out.println("Board Controller list listBoard.size()=>" + listBoard.size());
			model.addAttribute("total1", total1);
			model.addAttribute("listBoard",listBoard);
			System.out.println("listBoard=>" + listBoard);
			model.addAttribute("pg",pg);

			return "list1";
		}
			
		//게시물 상세조회
		@GetMapping(value = "content1")
		public String detail(HttpServletRequest request, int board_no , int post_no, Model model) {
			System.out.println("BoardController Start content..." );
			Board board = bd.content(board_no, post_no);
			model.addAttribute("board",board);
			
			return "content1";
		}

		// 게시물 작성
		
			
		
		//게시물 수정 (form)
		@GetMapping(value = "updateForm")
		public String updateForm(int board_no, int post_no, Model model) {
			System.out.println("boardController updateForm start");
			System.out.println("board_no = "+board_no);
			System.out.println("post_no = "+post_no);
			Board board = bd.content(board_no, post_no);
			model.addAttribute("board",board);
//			model.addAttribute("board_no",board_no);
//			model.addAttribute("post_no",post_no);
			
			
			return "updateForm";
		}
		
		//게시물 수정 (action)		
		@GetMapping(value = "update1")
		public String update1(Board board,  Model model) {
			System.out.println("boardcontroller update Start");
			System.out.println("boardcontroller update board info board_no ="+board.getBoard_no());
			System.out.println("boardcontroller update board info post_no ="+board.getPost_no());
			System.out.println("boardcontroller update board info post_title ="+board.getPost_title());
			System.out.println("boardcontroller update board info post_title ="+board.getPost_content());
			
			System.out.println("boardcontroller update bd.update1(board) start");
			int upresult1 = bd.update1(board);
			System.out.println("boardcontroller update bd.update1(board) complete");
			System.out.println("bd.update1(board) result = "+upresult1);
			model.addAttribute("upresult1",upresult1);
			
			return "forward:list1";
		}
		
		// 게시물 삭제 (확인)
		@RequestMapping(value = "delete1")
		public String delete1(int post_no, Model model) {
			System.out.println("Board Controller Delete Start");
			int delresult = bd.delete1(post_no);
			return "redirect:list1";
		}
		
		//게시물 작성 (writeForm )
		@RequestMapping(value = "writeForm1")
		public String writeForm1(Model model) {
			System.out.println("boardController writeform1 start");
			int pno_next = bd.nextpno1();
			model.addAttribute("post_no", pno_next);
			return "writeForm1";
		}
		
		// 게시물 작성 (write action)
		@PostMapping(value = "write1")
		public String write1(Board board, Model model) {
			System.out.println("BoardController Write1 Start");
			int insresult = bd.insert1(board);
			if (insresult >0) return "redirect:list1";
			else {
				//model. addAttribute("msg","입력실패");
				return "forward:writeForm1"; 
			}
		}
		
}


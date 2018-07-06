package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		// 1. SPRING CONTAINER EXEC!!
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		BoardService boardService = (BoardService)container.getBean("boardService");
		
		// 등록 가능 여부 테스트 
		
		BoardVO vo = new BoardVO();
		vo.setTitle("임시제목");
		vo.setWriter("홍길동");
		vo.setContent("임시 내용............");
		boardService.insertBoard(vo);
		System.out.println("insert complete!!");
		
		// 글 목록 검색 기능 테스트
		
		BoardVO getBoard = boardService.getBoard(vo);
		System.out.println(getBoard.toString());
		System.out.println("getBoard complete!!");
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("--> " + board.toString());
		}
		container.close();
	}
}
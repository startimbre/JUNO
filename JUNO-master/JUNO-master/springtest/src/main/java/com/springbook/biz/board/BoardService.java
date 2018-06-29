package com.springbook.biz.board;

import java.util.List;

public interface BoardService {

	// CRUD기능의 메소드 구현
	// 글 등록
	void insertBoard(BoardVO vo);

	void updateBoard(BoardVO vo);

	void deleteBoard(BoardVO vo);

	BoardVO getBoard(BoardVO vo);

	List<BoardVO> getBoardList(BoardVO vo);

}
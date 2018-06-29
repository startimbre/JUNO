package com.springbook.biz.board.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAOMybatis extends SqlSessionDaoSupport{
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
		
	public void insertBoard(BoardVO vo) {
		System.out.println("insertBoard processing...");
		getSqlSession().insert("BoardDAO.insertBoard", vo);
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("updateBoard processing...");
		getSqlSession().update("BoardDAO.updateBoard", vo);
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("deleteBoard processing...");
		getSqlSession().delete("BoardDAO.deleteBoard", vo);
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("getBoard processing...");
		return (BoardVO) getSqlSession().selectOne("BoardDAO.getBoard", vo);
	}
	
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("getBoardList processing...");
		return getSqlSession().selectList("BoardDAO.getBoardList", vo);
	}
}
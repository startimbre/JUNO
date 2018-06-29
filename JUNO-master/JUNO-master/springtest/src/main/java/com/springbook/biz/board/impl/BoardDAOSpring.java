//package com.springbook.biz.board.impl;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//
//import com.springbook.biz.board.BoardVO;
//
////DAO(Data Access Object)
//@Repository
//public class BoardDAOSpring {
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//	// SQL query
//	private final String BOARD_INSERT = "insert into board(seq, title, writer, content)"
//			+ "values((select nvl(max(seq), 0)+1 from board),?,?,?)";
//	private final String BOARD_UPDATE = "update board set title=?," + "content=? where seq=?";
//	private final String BOARD_DELETE = "delete board where seq=?";
//	private final String BOARD_GET = "select * from board where seq=?";
//	private final String BOARD_LIST_T = "select * from board where title like '%'||?||'%' order by seq desc";
//	private final String BOARD_LIST_C = "select * from board where content like '%'||?||'%' order by seq desc";
//	// CRUD기능의 메소드 구현
//	// 글 등록
//
//	// public void insertBoard(BoardVO vo) {
//	// System.out.println("==> JDBC is InsertBoard() method process");
//	// try {
//	// conn = JDBCUtil.getConnection();
//	// stmt = conn.prepareStatement(BOARD_INSERT);
//	// stmt.setString(1, vo.getTitle());
//	// stmt.setString(2, vo.getWriter());
//	// stmt.setString(3, vo.getContent());
//	// stmt.executeUpdate();
//	// } catch (Exception e) {
//	// e.printStackTrace();
//	// } finally {
//	// JDBCUtil.close();
//	// }
//	// }
//	public void insertBoard(BoardVO vo) {
//		System.out.println("===> Spring JDBC로 insertBoard() 기능 처리");
//		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
//	}
//
//	public void updateBoard(BoardVO vo) {
//		System.out.println("===> Spring JDBC로 updateBoard() 기능 처리");
//		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
//	}
//
//	public void deleteBoard(BoardVO vo) {
//		System.out.println("===> spring JDBC로 deleteBoard기능 처리");
//		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
//	}
//
//	public BoardVO getBoard(BoardVO vo) {
//		System.out.println("===> spring JDBC로 getBoard기능 처리");
//		Object[] args = { vo.getSeq() };
//		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
//	}
//
//	public List<BoardVO> getBoardList(BoardVO vo) {
//		System.out.println("==> spring JDBC getBoardList() method exec");
//		Object[] args = { vo.getSearchKeyword() };
//		if (vo.getSearchCondition().equals("TITLE")) {
//			return jdbcTemplate.query(BOARD_LIST_T, args, new BoardRowMapper());
//		} else if (vo.getSearchCondition().equals("CONTENT")) {
//			return jdbcTemplate.query(BOARD_LIST_C, args, new BoardRowMapper());
//		}
//		return null;
//	}
//}
//
//class BoardRowMapper implements RowMapper<BoardVO> {
//	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
//		BoardVO board = new BoardVO();
//		board.setSeq(rs.getInt("SEQ"));
//		board.setTitle(rs.getString("TITLE"));
//		board.setWriter(rs.getString("WRITER"));
//		board.setContent(rs.getString("CONTENT"));
//		board.setRegDate(rs.getDate("REGDATE"));
//		board.setCnt(rs.getInt("CNT"));
//		return board;
//	}
//}

import java.sql.SQLException;
import java.util.List;

import com.juno.springweb.board.BoardDAOMybatis;
import com.juno.springweb.board.BoardVO;

public class BoardServiceClient {
	public static void main(String[] args) throws SQLException{
		BoardDAOMybatis boardDAO = new BoardDAOMybatis();
		
		BoardVO vo = new BoardVO();
		vo.setTitle("myBatis 제목");
		vo.setWriter("홍길동");
		vo.setContent("myBatis 내용입니다...");
		boardDAO.insertBoard(vo);
		
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("GDGDGDGDGD");
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		for(BoardVO board : boardList) {
			System.out.println("---->" + board.toString());
		}
	}
}

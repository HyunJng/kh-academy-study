package board.impl;

import java.util.List;

import board.BoardService;
import board.BoardVO;

// 고객별 web application을 개발할 경우를 고려
// View.Controller에서 BoardServiceImpl의 메소드를 사용함
// BoardService bservice = new BoardServiceImpl();
// bservice.insertBoard(vo);
// 따로 써주는 이유는 DB가 바뀌면 DB 코드도 달라지기 때문에 분리한 것임. Spring배울 때 제대로 사용
public class BoardServiceImpl implements BoardService {
	private BoardDAO boardDAO = new BoardDAO();

	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);

	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		
		return boardDAO.getBoardList(vo);
	}

}

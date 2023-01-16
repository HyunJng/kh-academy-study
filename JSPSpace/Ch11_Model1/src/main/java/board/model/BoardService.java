package board.model;

import java.util.List;

public interface BoardService {
	
	// 게시글 등록 abstract method 선언
	void insertBoard(BoardVO vo);
	
	// 게시글 수정 abstract method 선언
	void updateBoard(BoardVO vo);
	
	// 게시글 삭제 abstract method 선언
	void deleteBoard(BoardVO vo);
	
	// 게시글 상세조회 abstract method 선언
	BoardVO getBoard(BoardVO vo);
	
	// 게시글 목록조회 abstract method 선언
	List<BoardVO> getBoardList(BoardVO vo);

}

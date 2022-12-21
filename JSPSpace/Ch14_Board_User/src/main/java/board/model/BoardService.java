package board.model;

import java.util.List;

public interface BoardService {
	
	// 1. 게시글 등록 abstract method 선언
	void insertBoard(BoardVO vo);
	
	// 2. 게시글 수정 abstract method 선언
	void updateBoard(BoardVO vo);
	
	// 3. 게시글 삭제 abstract method 선언
	void deleteBoard(BoardVO vo);
	
	// 4. 게시글 상세 조회 abstract method 선언
	BoardVO getBoard(BoardVO vo);
	
	// 5. 게시글 목록 조회 abstract method 선언
	List<BoardVO> getBoardList(BoardVO vo);
	
}

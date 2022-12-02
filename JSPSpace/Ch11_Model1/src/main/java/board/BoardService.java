package board;

import java.util.List;

public interface BoardService {
	//게시글 등록 abstract method
	void insertBoard(BoardVO vo);
	//게시글 수정 abstract method
	void updateBoard(BoardVO vo);
	//게시글 삭제 abstract method
	void deleteBoard(BoardVO vo);
	//게시글 상세조회 abstract method
	BoardVO getBoard(BoardVO vo);
	//게시글 목록조회 abstract method
	List<BoardVO> getBoardList(BoardVO vo);
}

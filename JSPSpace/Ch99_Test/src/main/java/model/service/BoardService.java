package model.service;

public class BoardService {
	
	public int updateBoard(Board board) {
		Connection conn = getConnection();
		int result = new BoardDao().updateBoard(conn, board);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result;
	}

}

package model.service;

public class BoardDAO {
	public int updateBoard(Connection conn, Board board) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE BOARD SET BTITLE=?, BWRITER=?, BCONTENT=? WHERE BID=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getbTitle());
			pstmt.setString(2, board.getbWriter());
			pstmt.setString(3, board.getbContent());
			pstmt.setInt(4, board.getbId());
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
}

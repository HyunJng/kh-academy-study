package com.spring.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;

// DAO (Data Access Object)
@Repository("boardDAO")
public class BoardDAOSpring {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// SQL 명령어들
	// 범용 insert statement
	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) "
				+ "values((select nvl(max(seq), 0) + 1 from board), ?, ?, ?)";
	private final String BOARD_UPDATE = "update board set title=?, content=? " 
			+ "where seq = ?";
	private final String BOARD_DELETE = "delete from board where seq = ?";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	
	// CRUD 기능의 메소드 구현
	public void insertBoard(BoardVO vo) {
		System.out.println("---> jdbcTemplate로 insertBoard() 기능 처리");

		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("---> jdbcTemplate로 updateBoard() 기능 처리");
		
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("---> jdbcTemplate로 deleteBoard() 기능 처리");
		
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("---> jdbcTemplate로 getBoard() 기능 처리");
		BoardVO board = null;
		
//		Object[] args = null;
//		args[0] = vo.getSeq();
		Object[] args = {vo.getSeq()};
		
		// return 결과값 : board
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("---> jdbcTemplate로 getBoardList() 기능 처리");
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		// 여러개를 동시에 가져올 때 사용
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	}
}

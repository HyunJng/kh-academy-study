package com.spring.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;
//import com.spring.biz.common.LogAdvice;
import com.spring.biz.board.SearchCriteria;


@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO;
//	private LogAdvice log;
	
//	public BoardServiceImpl() {
//		log = new LogAdvice();
//	}

	public void insertBoard(BoardVO vo) {
//		log.printLog();
		boardDAO.insertBoard(vo);
	}

	public void updateBoard(BoardVO vo) {
//		log.printLog();
		boardDAO.updateBoard(vo);
	}

	public void deleteBoard(BoardVO vo) {
//		log.printLog();
		boardDAO.deleteBoard(vo);
	}

	public BoardVO getBoard(BoardVO vo) {
//		log.printLog();
		return boardDAO.getBoard(vo);
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
//		log.printLog();
		return boardDAO.getBoardList(vo);
	}

	@Override
	public int getTotalPages(SearchCriteria cri) {
		return boardDAO.getTotalPages(cri);
	}

	@Override
	public List<BoardVO> getBoardListWithPaging(SearchCriteria cri) {
		return boardDAO.getBoardListWithPaging(cri);
	}

	@Override
	public List<BoardVO> getBoardListWithDynamicPaging(SearchCriteria cri) {
		return boardDAO.getBoardListWithDynamicPaging(cri);
	}

}

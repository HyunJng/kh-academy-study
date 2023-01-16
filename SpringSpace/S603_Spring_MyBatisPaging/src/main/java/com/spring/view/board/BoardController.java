package com.spring.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;
import com.spring.biz.board.PageDTO;
import com.spring.biz.board.SearchCriteria;


@Controller
@SessionAttributes("board")
public class BoardController {
	@Autowired
	private BoardService boardService;

	
	// 글 등록
	@RequestMapping(value="insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException {

		System.out.println("글 등록 처리");
//		logger.debug("[LOG] 글 등록 처리");

		// 파일 업로드 처리
		MultipartFile uploadFile = vo.getUploadFile();
		if (!uploadFile.isEmpty()) {
			String filename = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C:/" + filename));
		}
		
		boardService.insertBoard(vo);
		
		return "getBoardList.do";
	}

	// 글 수정
	@RequestMapping(value="updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, 
			@ModelAttribute("cri") SearchCriteria cri) {

		System.out.println("글 수정 처리");
//		logger.debug("[LOG] 글 수정 처리");

		boardService.updateBoard(vo);

//		System.out.println("query : " + cri.makeQuery());
		return "redirect:getBoardList.do" + cri.makeQuery();
	}

	// 글 삭제
	@RequestMapping(value="deleteBoard.do")
	public String deleteBoard(@ModelAttribute("board") BoardVO vo, 
			@ModelAttribute("cri") SearchCriteria cri) {

		System.out.println("글 삭제 처리");
//		logger.debug("[LOG] 글 삭제  처리");
		boardService.deleteBoard(vo);
		
		return "redirect:getBoardList.do" + cri.makeQuery();
	}
	
	// 검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}

	// 글 상세 조회
	@RequestMapping(value="/getBoard.do")
	public String getBoard(BoardVO vo, @ModelAttribute("cri") SearchCriteria cri, Model model) {

		System.out.println("글 상세 조회 처리");
//		logger.debug("[LOG] 글 상세 조회 처리");
		
		// NULL Check
		if (cri.getSearchCondition() == null) {
			cri.setSearchCondition("TITLE");
		}
		if (cri.getSearchKeyword() == null) {
			cri.setSearchKeyword("");
		}
	
		// 검색 결과를 세션에 저장하고 목록 화면으로 이동한다.
		model.addAttribute("board", boardService.getBoard(vo));
		
		return "getBoard.jsp";
	}

	// 글 목록 검색
	@RequestMapping(value="getBoardList.do")
//	public String getBoardList(@RequestParam(value="searchCondition", 
//			defaultValue="TITLE", required=false) String condition,
//			@RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword,
//			BoardVO vo, BoardDAO boardDAO, Model model) {
	public String getBoardList(SearchCriteria cri, Model model) {
		
//		System.out.println("pageNum : " + cri.getPageNum());
//		System.out.println("amount : " + cri.getAmount());
//		logger.debug("[LOG] 글 목록 검색");
		
		// NULL Check
		if (cri.getSearchCondition() == null) {
			cri.setSearchCondition("TITLE");
		}
		if (cri.getSearchKeyword() == null) {
			cri.setSearchKeyword("");
		}
		
		// Model 정보 저장
		PageDTO pageMaker = new PageDTO(cri, boardService.getTotalPages(cri));
//		System.out.println("TotalPage : " + pageMaker.getTotalPage());
//		System.out.println("StartPage : " + pageMaker.getStartPage());
//		System.out.println("EndPage : " + pageMaker.getEndPage());
		
		model.addAttribute("pageMaker", pageMaker);	// Model 정보 저장
		model.addAttribute("boardList", boardService.getBoardListWithDynamicPaging(cri));	// Model 정보 저장
//		model.addAttribute("boardList", boardService.getBoardList(vo));	// Model 정보 저장
		return "getBoardList.jsp";
	}

}

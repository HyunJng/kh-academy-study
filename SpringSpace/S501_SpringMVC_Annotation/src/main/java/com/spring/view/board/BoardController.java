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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;


@Controller
// @SessionAttributes("board") : board를 session 객체에 등록하여 사용하겠다는 의미
// session에 저장해야 수정하지 않은 것도 불러와짐??. 
//@SessionAttributes("board")
public class BoardController {
	// ApplicationContext.xml에서 선언된 
	@Autowired
	private BoardService boardService;

	@RequestMapping(value="/dataTransform.do")
	// JSON으로 보낼 때 사용
	@ResponseBody
	public List<BoardVO> dataTransform(BoardVO vo) {
		
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
//		BoardListVO boardListVO = new BoardListVO();
//		boardListVO.setBoardList(boardList);
		
		return boardList;
	}
	
	// 글 등록
	@RequestMapping(value="insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) throws IOException {

		System.out.println("글 등록 처리");

		// 파일 업로드 처리
		MultipartFile uploadFile = vo.getUploadFile();

		if (!uploadFile.isEmpty()) {
			String filename = uploadFile.getOriginalFilename();
			System.out.println("업로드 파일 이름: "+filename);
			uploadFile.transferTo(new File("D:/temp/" + filename));
		}
		
		boardService.insertBoard(vo);
		
		return "getBoardList.do";
	}

	// 글 수정
	// @ModelAttribute("board") BoardVO vo => JSP에서 사용할 기본 객체 이름이 baordVO인데 board로 바꿈.
	// - 기능 중 하나 더: 만약  @SessionAttributes("board")가 선언되어 있으면, board객체를 session객체에서 읽어옴
	@RequestMapping(value="updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) {

		System.out.println("글 수정 처리");

		System.out.println("번호 : " + vo.getSeq());
		System.out.println("제목 : " + vo.getTitle());
		System.out.println("작성자 : " + vo.getWriter());
		System.out.println("내용 : " + vo.getContent());
		System.out.println("등록일 : " + vo.getRegDate());
		System.out.println("조회수 : " + vo.getCnt());
		boardService.updateBoard(vo);
		
		return "getBoardList.do";
	}

	// 글 삭제
	@RequestMapping(value="deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {

		System.out.println("글 삭제 처리");
		boardService.deleteBoard(vo);
		
		return "getBoardList.do";
	}
	
	// 검색 조건 목록 설정
	// @ModelAttribute가 JSP에서 사용할 객체를 생성하는 것이 목적으로도 사용 가능하다.
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}

	// 글 상세 조회
	@RequestMapping(value="/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {

		System.out.println("글 상세 조회 처리");
	
		// 1, vo 객체를 spring의 Model에 저장.
		// 2. @SessionAttributes("board")에 등록된 board이름으로 model에도 같은 이름이 있다면 
		// 	  session 내장 객체에도 검색 결과를  저장하고 목록 화면으로 이동한다.
		// System.out.println("boardVO실험: " + vo.getSeq());
		model.addAttribute("board", boardService.getBoard(vo));
		
		return "getBoard.jsp";
	}

	// 글 목록 검색
	// @RequestParam
	// => String searchCondition = request.getParameter("searchCondition");
	// required: 꼭 필요한 것은 아니다. Null이 올 수 있다.
	// BoardVO에 searchCondition, searchKeyword 멤버변수를 없애고 이렇게 써도 된다. 있으면 VO에 넣어서 써도 무방. 
	@RequestMapping(value="getBoardList.do")
	public String getBoardList(@RequestParam(value="searchCondition", 
			defaultValue="TITLE", required=false) String condition,
			@RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword,
			BoardVO vo, BoardDAO boardDAO, Model model) {
//	public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {
		
		
		System.out.println("검색 조건 : " + condition);
		System.out.println("검색 단어 : " + vo.getSearchKeyword());
		
		// NULL Check
		if (vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if (vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		
		// Model 정보 저장
		model.addAttribute("boardList", boardService.getBoardList(vo));	// Model 정보 저장
		return "getBoardList.jsp";
	}

}

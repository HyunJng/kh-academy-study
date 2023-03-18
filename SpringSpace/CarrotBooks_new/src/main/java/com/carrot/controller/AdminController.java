package com.carrot.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.carrot.domain.AdvertVO;
import com.carrot.domain.AttachImageVO;
import com.carrot.domain.BCateVO;
import com.carrot.domain.BookVO;
import com.carrot.domain.Criteria;
import com.carrot.domain.MemberInfoVO;
import com.carrot.domain.MemberVO;
import com.carrot.domain.OrderCancleVO;
import com.carrot.domain.OrderPageVO;
import com.carrot.domain.OrderVO;
import com.carrot.domain.ReplyPageVO;
import com.carrot.domain.ReplyVO;
import com.carrot.repository.OrderRepository;
import com.carrot.service.AdminService;
import com.carrot.service.AdvertService;
import com.carrot.service.BookService;
import com.carrot.service.ImageService;
import com.carrot.service.MemberService;
import com.carrot.service.OrderService;
import com.carrot.service.ReplyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	private AdminService adminService;
	private BookService bookService;
	private ImageService imageService;
	private AdvertService advertService;
	@Autowired private MemberService memberService;
	@Autowired private OrderService orderService;
	@Autowired private ReplyService replyService;
	
	@Autowired
	public AdminController(AdminService adminService, BookService bookService, ImageService imageService, AdvertService advertService) {
		this.adminService = adminService;
		this.bookService = bookService;
		this.imageService = imageService;
		this.advertService = advertService;
	}
	
	// 관리자 메인페이지 이동
	@GetMapping("/main")
	public String adminMainGet() {
		logger.info("관리자 페이지 진입");
		return "/admin/main";
	}
	
	/* 상품 등록 관련 */
	// 등록 상품 검색 페이지 이동
	@GetMapping("/addGoods")
	public String addGoodsGet() {
		logger.info("상품 등록 페이지 진입");
		return "/admin/addGoods";
	}
	
	// 등록 상품 세부사항 지정 페이지 이동
	@GetMapping("/addGoods/form")
	public String addGoodsFormGet(BookVO book, Model model) {
		logger.info("상품 등록 폼 페이지 진입");
		ObjectMapper objm = new ObjectMapper();
		List<BCateVO> list = bookService.getCateList();
		
		try {
			model.addAttribute("book", book); // get으로 온 것이 book에 담기게
			model.addAttribute("cateList", objm.writeValueAsString(list));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			model.addAttribute("cateList", "error");
		}

		return "/admin/addGoods_form";
	}
	
	// 상품 등록
	@PostMapping("/addGoods/form") 
	public String addGoodsFormPost(BookVO book, RedirectAttributes reAttr) throws IOException {
		logger.info("addGoodsFormPost 진입");

		try {
			adminService.saveBook(book);
			reAttr.addFlashAttribute("result", book.getTitle());
		} catch (Exception e) {
			reAttr.addFlashAttribute("result", "");
		}
		return "redirect:/admin/addGoods";
	}

	
	/* 상품 관리 관련 */
	// 상품 관리 페이지 이동
	@GetMapping("/manageGoods")
	public String manageGoodsGet(Model model, Criteria cri) {
		logger.info("상품 관리 페이지 진입");
		
		model.addAttribute("bookList", bookService.getBookList(cri));
		model.addAttribute("pageMaker", bookService.getBookPageMaker(cri));
		
		return "/admin/manageGoods";
	}
	
	// 상품 수정 페이지 이동
	@GetMapping("/manageGoods/{bookId}")
	public String manageGoodsDetailGet(Model model, @PathVariable("bookId")String bookId) {
		logger.info("상품 관리 - 수정페이지 진입");
		BookVO book = new BookVO();
		ObjectMapper objm = new ObjectMapper();
		
		book.setBookId(bookId);
		model.addAttribute("book", bookService.findBookById(book));
		try {
			model.addAttribute("cateList", objm.writeValueAsString(bookService.getCateList()));
		} catch(Exception e) {
			model.addAttribute("cateList", "");
		}
		return "/admin/manageGoods_detail";
	}
	
	// 상품 수정
	@PostMapping("/manageGoods/update")
	public String manageGoodsUpdatePost(RedirectAttributes rattr, BookVO book) {
		logger.info("manageGoodsUpdatePost 진입");

		try {
			adminService.updateBook(book);
			rattr.addFlashAttribute("update", book.getTitle());
		} catch (Exception e) {
			rattr.addFlashAttribute("update", "error");
		}
		
		return "redirect:/admin/manageGoods";
	}
	
	// 상품 삭제
	@GetMapping("/manageGoods/delete/{bookId}")
	public String manageGoodsDeleteGet(RedirectAttributes rattr, @PathVariable("bookId")String bookId) {
		logger.info("manageGoodsDeleteGet 진입");
		BookVO bookInfo= new BookVO();
		bookInfo.setBookId(bookId);
		
		BookVO target = bookService.findBookById(bookInfo);
		if(target.getBookStock() > 0) {
			rattr.addFlashAttribute("delete", "error");
		} else {
			adminService.deleteBook(target);
			rattr.addFlashAttribute("delete", target.getTitle());
		}
		return "redirect:/admin/manageGoods";
	}
	
	/* 회원 관리 관련 */
	// 회원 관리 페이지 이동
	@GetMapping("/manageMember")
	public String manageMemberGet(Model model,  Criteria cri) {
		logger.info("manageMember 페이지 진입");
		model.addAttribute("memberList", adminService.getMemberList(cri));
		model.addAttribute("pageMaker", adminService.getMemberPageMaker(cri));
		return "/admin/manageMember";
	}
	
	// BAN 회원으로 수정
	@GetMapping("/manageMember/ban/{memberNum}")
	public String manageMemberBanGet(@PathVariable("memberNum")String memberId) {
		logger.info("manageMemberBanGet 진입");
		
		MemberVO memberInfo = new MemberVO();
		memberInfo.setMemberId(Integer.valueOf(memberId));
		MemberVO target = memberService.findMemberbyId(memberInfo);
		adminService.changeMemberBan(target);
		
		return "redirect:/admin/manageMember";
	}
	
	// 회원 상세정보
	@GetMapping("/manageMember/{memberId}")
	public @ResponseBody MemberInfoVO manageMemberDetailGet(@PathVariable("memberId")int memberId, Criteria cri) {
		logger.info("manageMemberDetailGet 진입");
		MemberInfoVO result = new MemberInfoVO();
		cri.setAmount(4);
		// 회원 정보
		MemberVO memberInfo = new MemberVO();
		memberInfo.setMemberId(memberId);
		result.setMember(memberService.findMemberbyId(memberInfo));
		
		// 회원 댓글 리스트
		cri.setKeyword(memberId + "");
		result.setReply(replyService.getReplyListByMemberId(cri));
		
		return result;
	}
	
	// 회원 상세 정보 댓글
	@GetMapping("/manageMember/reply")
	public @ResponseBody ReplyPageVO manageMemberDetailReplyGet(Criteria cri) {
		logger.info("manageMemberDetailReplyGet 진입");
		cri.setAmount(4);
		return replyService.getReplyListByMemberId(cri);
	}
	
	// 회원 상세 정보 댓글 삭제
	@GetMapping("/manageMember/reply/delete")
	public @ResponseBody ReplyPageVO manageMemberDetailReplyDeleteGet(Criteria cri, int replyId) {
		logger.info("manageMemberDetailReplyDeleteGet 진입");
		cri.setAmount(4);
	
		ReplyVO vo = new ReplyVO();
		vo.setReplyId(replyId);
		vo.setBookId(cri.getBookId());
		
		replyService.deleteReply(vo);
		return replyService.getReplyListByMemberId(cri);
	}
	
	// 회원 강퇴
	@PostMapping("/manageMember/delete")
	public String manageMemberDeletePost(int pageNum, int memberId, RedirectAttributes ratr) {
		
		memberService.deleteMember(memberId);
		
		ratr.addAttribute("pageNum", pageNum);
		return "redirect:/admin/manageMember";
	}
	
	/* 광고 관리 관련 */
	// 광고 관리 페이지로 이동
	@GetMapping("/manageAdvert")
	public String manageAdvertGet(Model model,  Criteria cri) {
		logger.info("manageAdvert 페이지 진입");
		List<AdvertVO> list = advertService.getAdvertList(cri);
		
		model.addAttribute("advertList", list);
		model.addAttribute("pageMaker", advertService.getAdvertPageMaker(cri));
		
		return "/admin/manageAdvert";
	}
	
	// 광고 등록 페이지로 이동
	@GetMapping("/manageAdvert/add")
	public String manageAdvertAddGet() {
		logger.info("manageAdvertAdd 페이지 진입");
		return "/admin/addAdvert";
	}
	
	// 광고 등록
	@PostMapping("/manageAdvert/add")
	public String manageAdvertAddPost(AdvertVO advert, RedirectAttributes rattr) {
		logger.info("manageAdvertAddPost 실행");
		logger.info(advert.toString());
		
		try {
			adminService.saveAdvert(advert);
			rattr.addFlashAttribute("save", advert.getAdvertName());
		}catch(Exception e) {
			rattr.addFlashAttribute("save", "error");
		}
		
		return "redirect:/admin/manageAdvert";
	}
	
	// 광고 이미지 등록
	@PostMapping(path = "/uploadAdvertImage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<AttachImageVO>> uploadAdvertImagePost(MultipartFile[] uploadFile) {
		logger.info("uploadImagePost 실행");
		List<AttachImageVO> list = null;
		
		try {
			// 이미지 파일인지 체크
			if(!imageService.checkImageFile(uploadFile)) {
				return new ResponseEntity<List<AttachImageVO>>(list, HttpStatus.BAD_REQUEST);
			}
			// 파일 저장
			list = imageService.uploadImage("c:\\upload\\advert", uploadFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<List<AttachImageVO>>(list, HttpStatus.OK);
	}
	
	// 등록 광고 이미지 보이기
	@GetMapping(path = "/getAttachList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<AttachImageVO>> getAttachList(int refId){
		logger.info("getAttachList 진입 " + refId);
		
		return new ResponseEntity<List<AttachImageVO>>(imageService.getImageList(refId), HttpStatus.OK);
	}
	
	// 연관 책 등록 팝화면 이동 
	@GetMapping("/bookPop")
	public String bookPopGet(Criteria cri, Model model) throws Exception {
		logger.info("bookPopGet 진입");
		
		cri.setAmount(5);
		List<BookVO> list = bookService.getBookList(cri);
		
		if(!list.isEmpty()) {
			model.addAttribute("list", list);
		} else {
			model.addAttribute("listCheck", "empty");
		}
		
		model.addAttribute("pageMaker", bookService.getBookPageMaker(cri));
		return "/admin/bookPop";
	}
	
	/* 주문 페이지 */
	// 주문 관리 페이지 이동
	@GetMapping("/orderList")
	public String orderListGet(Criteria cri, Model model) {
		logger.info("orderList페이지 진입");
		
		// 회원 이메일 -> 아이디 찾기
		if(cri.getKeyword() != null && cri.getKeyword() != "") {
			int id = memberService.findMemberIdbyEmail(cri.getKeyword());
			cri.setKeyword(String.valueOf(id));
		}
		
		List<OrderVO> list = adminService.getOrderList(cri); 
	
		if(!list.isEmpty()) {
			model.addAttribute("orderList", list);
			model.addAttribute("pageMaker", adminService.getOrderPageMaker(cri));
		} else {
			model.addAttribute("orderListCheck", "empty");
		}
		
		return "/admin/manageOrder";
	}
	
	/* 주문 삭제 */
	// 주문 삭제
	@PostMapping("/orderCancle")
	public String orderCanclePost(OrderCancleVO vo) {
		logger.info("orderCanclePost 진입");
		
		orderService.orderCancle(vo);
		return "redirect:/admin/orderList?keyword=" + vo.getKeyword() + "&amount=" + vo.getAmount() + "&pageNum=" + vo.getPageNum();
	}
	
	// 주문 상세정보
	@GetMapping("/orderDetail/{orderId}")
	public @ResponseBody OrderPageVO getOrderDetailGet(@PathVariable("orderId") String orderId) {
		OrderPageVO result = new OrderPageVO();
		result.setOrderInfo(orderService.getOrderInfobyOrderId(orderId));
		result.setOrders(orderService.getOrderItemListbyOrderId(orderId));
		
		result.setTotalPrice();
		return result;
	}
}

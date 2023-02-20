package com.carrot.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
import com.carrot.domain.BookVO;
import com.carrot.domain.Criteria;
import com.carrot.domain.MemberVO;
import com.carrot.repository.BookRepository;
import com.carrot.repository.MemberRepository;
import com.carrot.service.AdminService;
import com.carrot.service.BookService;
import com.carrot.service.FileService;
import com.carrot.service.MemberService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	private AdminService adminService;
	private BookService bookService;
	private FileService fileService;
	
	@Autowired
	public AdminController(AdminService adminService, BookService bookService, FileService fileService) {
		this.adminService = adminService;
		this.bookService = bookService;
		this.fileService = fileService;
	}
	
	@GetMapping("/main")
	public String adminMainGet() {
		logger.info("관리자 페이지 진입");
		return "/admin/main";
	}
	
	/* 상품 등록 관련 */
	@GetMapping("/addGoods")
	public String addGoodsGet() {
		logger.info("상품 등록 페이지 진입");
		return "/admin/addGoods";
	}
	
	@GetMapping("/addGoods/form")
	public String addGoodsFormGet(BookVO book, Model model) {
		logger.info("상품 등록 폼 페이지 진입");
		
		System.out.println(book);
		model.addAttribute("book", book);
		return "/admin/addGoods_form";
	}
	
	@PostMapping("/addGoods/form") 
	public String addGoodsFormPost(BookVO book, RedirectAttributes reAttr) throws IOException {
		logger.info("addGoodsFormPost 진입");

		try {
			adminService.saveBook(book);
			reAttr.addFlashAttribute("result", book.getTitle());
		} catch (Exception e) {
			reAttr.addFlashAttribute("result", "error");
		}
		return "redirect:/admin/addGoods";
	}
	
	/* 상품 관리 관련 */
	@GetMapping("/manageGoods")
	public String manageGoodsGet(Model model, Criteria cri) {
		logger.info("상품 관리 페이지 진입");
		
		model.addAttribute("bookList", bookService.getBookList(cri));
		model.addAttribute("pageMaker", bookService.getBookPageMaker(cri));
		
		return "/admin/manageGoods";
	}
	
	@GetMapping("/manageGoods/{bookId}")
	public String manageGoodsDetailGet(Model model, @PathVariable("bookId")String bookId) {
		logger.info("상품 관리 - 수정페이지 진입");
		BookVO book = new BookVO();
		book.setBookId(bookId);
		
		model.addAttribute("book", bookService.findBookById(book));
		
		return "/admin/manageGoods_detail";
	}
	
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
	@GetMapping("/manageMember")
	public String manageMemberGet(Model model,  Criteria cri) {
		logger.info("manageMember 페이지 진입");
		model.addAttribute("memberList", adminService.getMemberList(cri));
		model.addAttribute("pageMaker", adminService.getMemberPageMaker(cri));
		return "/admin/manageMember";
	}
	
	@GetMapping("/manageMember/{memberNum}")
	public String manageMemberBanGet(@PathVariable("memberNum")String memberNum) {
		logger.info("manageMemberBanGet 진입");
		
		MemberVO memberInfo = new MemberVO();
		memberInfo.setMemberNum(Integer.valueOf(memberNum));
		MemberVO target = adminService.findMemberbyNum(memberInfo);
		adminService.changeMemberBan(target);
		
		return "redirect:/admin/manageMember";
	}
	
	/* 광고 관리 관련 */
	@GetMapping("/manageAdvert")
	public String manageAdvertGet() {
		logger.info("manageAdvert 페이지 진입");
		return "/admin/manageAdvert";
	}
	
	@GetMapping("/manageAdvert/add")
	public String manageAdvertAddGet() {
		logger.info("manageAdvertAdd 페이지 진입");
		return "/admin/addAdvert";
	}
	
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
	
	@PostMapping(path = "/uploadAdvertImage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<AttachImageVO>> uploadAdvertImagePost(MultipartFile[] uploadFile) {
		logger.info("uploadImagePost 실행");
		List<AttachImageVO> list = null;
		
		try {
			// 이미지 파일인지 체크
			if(!fileService.checkImageFile(uploadFile)) {
				return new ResponseEntity<List<AttachImageVO>>(list, HttpStatus.BAD_REQUEST);
			}
			// 파일 저장
			list = fileService.uploadImage("c:\\upload\\advert", uploadFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<List<AttachImageVO>>(list, HttpStatus.OK);
	}
}

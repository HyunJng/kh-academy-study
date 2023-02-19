package com.carrot.controller;


import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.carrot.domain.Criteria;
import com.carrot.service.BookService;

@Controller
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	private BookService bookService;
	
	public MainController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/main")
	public String mainpageGet(Model model, Criteria cri) {
		logger.info("메인 페이지 진입");
		
		cri.setAmount(8);
		model.addAttribute("newestList", bookService.getBookList(cri));
		
		return "main";
	}
	
	// test
	@GetMapping("/display")
	public ResponseEntity<byte[]> getImage(String fileName){
		logger.info("getImage()...." + fileName);
		
		File file = new File("c:\\upload\\" + fileName);
		ResponseEntity<byte[]> result= null;
		
		try {
			
			HttpHeaders header = new HttpHeaders();
			header.add("Content-type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@PostMapping("/deleteFile")
	public ResponseEntity<String> deleteFile(String fileName){
		logger.info("deleteFile...." + fileName);
		
		File file = null;
		
		try {
			logger.info(URLDecoder.decode(fileName, "UTF-8"));
			file = new File("c:\\upload\\" + URLDecoder.decode(fileName, "UTF-8"));
			file.delete();
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("fail", HttpStatus.NOT_IMPLEMENTED);
		}
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
}

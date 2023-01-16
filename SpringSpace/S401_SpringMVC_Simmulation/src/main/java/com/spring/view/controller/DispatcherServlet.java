package com.spring.view.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
    private HandlerMapping handlerMapping;
    private ViewResolver viewResolver;
    
    public DispatcherServlet() {
    }
    // Servlet이 servlet container에 올라갈때 최초 한번은 실행되는 method
    @Override
    public void init() throws ServletException {
    	handlerMapping = new HandlerMapping();
    	viewResolver = new ViewResolver();
    	
    	viewResolver.setPrefix("./");
    	viewResolver.setSuffix(".jsp");
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}
	// get/post가 불러오면 실행됨
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 1. 클라이언트의 요청 path 정보를 추출
		// DispatcherServelt의 uri가 "/*.do"로 명명해둠. web.xml
		String uri = request.getRequestURI();
		System.out.println("process RequestURI= " + uri);
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("process uri.subString= " + path);
		
		// 2. HandlerMapping을 통해 path에 해당하는 Controller 인스턴스 가져오기
		Controller ctrl = handlerMapping.getController(path);
		
		// 3. path를 통해 가져온 Controller을 실행
		// handleRequest안에는 다음으로 이동해야하는 view이름을 return하게 만들어놨음
		String viewName = ctrl.handleRequest(request, response);
		
		// 4. ViewResolver을 통해 viewName에 해당하는 파일을 확정
		String view = null;
		if(!viewName.contains(".do")) { // return으로 .do를 포함하고 있거나 jsp파일명만 
			// path가 getBorad라면 view는 ./getBoard.jsp가 됨
			view = viewResolver.getView(viewName);
		}else {
			view = viewName;
		}

		// 5. 검색된 화면으로 이동한다.
		response.sendRedirect(view);
		
		/*
		//2. 클라이언트의 요청 path에 따라 적절히 분기 처리 수행
		if(path.equals("/login.do")) {
			System.out.println("로그인 처리");
		} else if(path.equals("/logout.do")) {
			System.out.println("로그아웃 처리");
		} else if(path.equals("/insertBoard.do")) {
			System.out.println("글 등록 처리");
		} else if(path.equals("/updateBoard.do")) {
			System.out.println("글 수정 처리");
		} else if(path.equals("/deleteBoard.do")) {
			System.out.println("글 삭제 처리");
		} else if(path.equals("/getBoard.do")) {
			System.out.println("글 상세 조회 처리");
		} else if(path.equals("/getBoardList.do")) {
			System.out.println("글 목록 검색 처리");
		}
		*/
	}
}

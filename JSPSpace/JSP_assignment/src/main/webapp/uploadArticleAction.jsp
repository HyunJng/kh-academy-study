<%@page import="article.articleDAO"%>
<%@page import="article.articleVO"%>
<%@page import="java.io.PrintWriter"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.File" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 게시판 웹 사이트</title>
</head>
<body>
	<%
	 	String id = null;
		String goods = null;

	 	String goods_info = null;
	 	String fileName = null;
		int cost = 0;
		int count = 0;
	
		String directory = application.getRealPath("/upload/");
		int maxSize = 1024 * 1024 * 100;
		String encoding ="UTF-8";
	
		MultipartRequest multipartRequest 
		= new MultipartRequest(request, directory, maxSize, encoding,
			new DefaultFileRenamePolicy());
		
		id = multipartRequest.getParameter("id");
		fileName = (String)multipartRequest.getFilesystemName("fileName");
		goods_info = multipartRequest.getParameter("goods_info");
		goods= multipartRequest.getParameter("goods");
		cost = Integer.parseInt( multipartRequest.getParameter("cost"));
		count = Integer.parseInt( multipartRequest.getParameter("count"));
		
		System.out.println(goods_info);
		System.out.println(goods);
			
			
				// 정상적으로 입력이 되었다면 글쓰기 로직을 수행한다
				articleVO vo = new articleVO();
				vo.setId(id);
				vo.setGoods(goods);
				vo.setGoods_img(fileName);
				vo.setGoods_info(goods_info);
				vo.setCost(cost);
				vo.setCount(count);
				articleDAO dao = new articleDAO();
				dao.insertGoods(vo);
				response.sendRedirect("myPage.jsp");
		
	
	%>
</body>
</html>
 
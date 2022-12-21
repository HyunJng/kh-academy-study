package USER.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import USER.UserDAO;
import USER.UserVO;
import article.articleDAO;
import article.articleVO;
import deal.dealDAO;
import deal.dealVO;
import deal.joinDAO;
import deal.joinVO;

/**
 * Servlet implementation class getUserInfoServlet
 */
@WebServlet("/getUserInfo.do")
public class getUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getUserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String role = request.getParameter("WRole");
		String id = null;
		if(session.getAttribute("user") == null) {
		id = request.getParameter("id");
		}else {
		UserVO Nuser = (UserVO) session.getAttribute("user");
		id = Nuser.getId();
		}
		UserVO vo = new UserVO();
		UserDAO dao = new UserDAO();
		joinVO Jvo = new joinVO();
		joinDAO Jdao = new joinDAO();
		vo.setId(id);
		UserVO user = dao.getUserInfo(vo);
		if(user.getRole().equals("구매자")) {
		Jvo.setCustomer(user.getId());
		System.out.println(Jvo.getId());
		int pageSize = 2;
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);

		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		System.out.println(pageNum);
		System.out.println(startRow);
		System.out.println();
		int count = 0;

		count = Jdao.getJoinCount(Jvo);
		
		List<joinVO> list = null;
		System.out.println(count);
		if (count > 0) {
			list = Jdao.getJoinList(Jvo, startRow, endRow);
		}
		if(count > 0){
			// 총 페이지의 수
			int pageCount = count / pageSize + (count%pageSize == 0 ? 0 : 1);
			// 한 페이지에 보여줄 페이지 블럭(링크) 수
			int pageBlock = 10;
			// 한 페이지에 보여줄 시작 및 끝 번호(예 : 1, 2, 3 ~ 10 / 11, 12, 13 ~ 20)
			int startPage = ((currentPage-1)/pageBlock)*pageBlock+1;
			int endPage = startPage + pageBlock - 1;
			
			// 마지막 페이지가 총 페이지 수 보다 크면 endPage를 pageCount로 할당
			if(endPage > pageCount){
				endPage = pageCount;
			}
		
			
		// 3. 검색 결과를 session에 저장하고 getBoardList.jsp로 이동
		
	
		session.setAttribute("MboardList", list);
		
		session.setAttribute("MpageCount", pageCount);
		session.setAttribute("MpageBlock", pageBlock);
		session.setAttribute("MstartPage", startPage);
		session.setAttribute("MendPage", endPage);
		session.setAttribute("McurrentPage", currentPage);
		session.setAttribute("user", user);
		response.sendRedirect("myPage.jsp");
		}else {
			session.setAttribute("count", count);
			session.setAttribute("user", user);
			response.sendRedirect("myPage.jsp");
		}
		
		}else {
			
			articleVO avo = new articleVO();
			dealDAO adao = new dealDAO();
			vo.setId(id);
			
			avo.setId(user.getId());
			System.out.println();
			System.out.println(user.getId() + "dao");
			int sum = adao.getSum(user);
			int pageSize = 2;
			String pageNum = request.getParameter("pageNum");
			if (pageNum == null) {
				pageNum = "1";
			}
			int currentPage = Integer.parseInt(pageNum);

			int startRow = (currentPage - 1) * pageSize + 1;
			int endRow = currentPage * pageSize;
			System.out.println(pageNum);
			System.out.println(startRow);
			System.out.println();
			int count = 0;

			count = adao.getDealSellerCount(avo);
			
			List<articleVO> list = null;
			System.out.println(count);
			if (count > 0) {
				list = adao.getsellerDealList(avo, startRow, endRow);
			}
			if(count > 0){
				// 총 페이지의 수
				int pageCount = count / pageSize + (count%pageSize == 0 ? 0 : 1);
				// 한 페이지에 보여줄 페이지 블럭(링크) 수
				int pageBlock = 10;
				// 한 페이지에 보여줄 시작 및 끝 번호(예 : 1, 2, 3 ~ 10 / 11, 12, 13 ~ 20)
				int startPage = ((currentPage-1)/pageBlock)*pageBlock+1;
				int endPage = startPage + pageBlock - 1;
				
				// 마지막 페이지가 총 페이지 수 보다 크면 endPage를 pageCount로 할당
				if(endPage > pageCount){
					endPage = pageCount;
				}
			
				
			// 3. 검색 결과를 session에 저장하고 getBoardList.jsp로 이동
			
		
			session.setAttribute("SboardList", list);
			session.setAttribute("sum", sum);
			session.setAttribute("SpageCount", pageCount);
			session.setAttribute("SpageBlock", pageBlock);
			session.setAttribute("SstartPage", startPage);
			session.setAttribute("SendPage", endPage);
			session.setAttribute("ScurrentPage", currentPage);
			session.setAttribute("user", user);
			response.sendRedirect("myPage.jsp");
			}else {
				session.setAttribute("count", count);
				session.setAttribute("user", user);
				response.sendRedirect("myPage.jsp");
			}
		}
		}
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

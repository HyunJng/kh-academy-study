package article.Servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import article.articleDAO;
import article.articleVO;

/**
 * Servlet implementation class getGoodsListController
 */
@WebServlet("/getGoodsList.do")
public class getGoodsListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getGoodsListController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		session.removeAttribute("count");
		articleVO vo = new articleVO();
		articleDAO ADAO = new articleDAO();

		// 검색조건 parameter check 해야 함
		String searchCondition = request.getParameter("searchCondition");
		String searchKeyword = request.getParameter("searchkeyword");

		vo.setGetSearchCondition(searchCondition);
		vo.setGetSearchKeyword(searchKeyword);
		System.out.println();
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

		count = ADAO.getCount(vo);
		
		List<articleVO> list = null;
		System.out.print(count);
		if (count > 0) {
			list = ADAO.getGoodsPaging(vo, startRow, endRow);
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
		
	
		session.setAttribute("boardList", list);
		
		session.setAttribute("pageCount", pageCount);
		session.setAttribute("pageCount", pageBlock);
		session.setAttribute("pageCount", startPage);
		session.setAttribute("endPage", endPage);
		session.setAttribute("currentPage", currentPage);
		response.sendRedirect("index.jsp");
		}else {
			session.setAttribute("count", count);
			session.setAttribute("boardList", list);
			response.sendRedirect("index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

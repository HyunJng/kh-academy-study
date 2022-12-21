package article.Servlet;

import java.io.IOException;
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
 * Servlet implementation class getBoardServlet
 */
@WebServlet("/getBoard.do")
public class getBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		articleVO vo = new articleVO();
		articleDAO ADAO = new articleDAO();
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		vo.setSeq(seq);
		System.out.println(vo.getSeq());
		articleVO result =  ADAO.getBoard(vo);
	
		HttpSession session = request.getSession();
		session.setAttribute("goods", result);
		response.sendRedirect("goods.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

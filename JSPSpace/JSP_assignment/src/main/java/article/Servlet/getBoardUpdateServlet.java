package article.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import article.articleDAO;
import article.articleVO;

/**
 * Servlet implementation class getBoardUpdateServlet
 */
@WebServlet("/getBoardUpdate.do")
public class getBoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getBoardUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		articleVO vo = new articleVO();
		articleDAO ADAO = new articleDAO();
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		vo.setSeq(seq);
		System.out.println(vo.getSeq());
		articleVO result =  ADAO.getBoard(vo);
		System.out.println(seq);
		System.out.println(vo.getGoods());
		HttpSession session = request.getSession();
		session.setAttribute("goods", result);
		response.sendRedirect("goodsupdate.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

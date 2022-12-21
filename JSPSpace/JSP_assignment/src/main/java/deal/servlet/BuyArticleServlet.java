package deal.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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

/**
 * Servlet implementation class BuyArticleServlet
 */
@WebServlet("/BuyArticle.do")
public class BuyArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDAO UDAO = new UserDAO();
		articleDAO ADAO = new articleDAO();
		response.setCharacterEncoding("utf-8");
		int seq = Integer.parseInt(request.getParameter("seq"));
		int count = Integer.parseInt(request.getParameter("count"));
		String id =request.getParameter("id");
		System.out.println(count + "Servlet");
		UserVO user = new UserVO();
		articleVO article = new articleVO();
		user.setId(id);
		article.setSeq(seq);
		UserVO uservo = UDAO.getUserInfo(user);
		articleVO articlevo = ADAO.getBoard(article);
		dealVO deal = new dealVO();
		int cost = (articlevo.getCost() * count);
		deal.setSeller(articlevo.getId());
		
		deal.setCustomer(uservo.getId());
		deal.setC_adr(uservo.getAdr());
		deal.setGoods_seq(article.getSeq());
		deal.setCount(count);
		deal.setCost(cost);
		
		System.out.println(deal.getSeller());
		System.out.println(deal.getCustomer());
		dealDAO DAO = new dealDAO();
		DAO.insertDeal(deal, articlevo);
		
		
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('회원가입이 완료되었습니다')");
		script.println(" history.back();");
		script.println("</script>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

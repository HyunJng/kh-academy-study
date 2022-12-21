package article.Servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import article.articleDAO;
import article.articleVO;

/**
 * Servlet implementation class updateArticleServlet
 */
@WebServlet("/updateArticle.do")
public class updateArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		
		ServletContext application = request.getServletContext();
		
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
				vo.setSeq(Integer.parseInt(multipartRequest.getParameter("seq")));
				articleDAO dao = new articleDAO();
				dao.updateGoods(vo);
				response.sendRedirect("getUserInfo.do");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

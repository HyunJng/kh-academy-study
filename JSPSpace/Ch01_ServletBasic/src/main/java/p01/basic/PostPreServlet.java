package p01.basic;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PostPre")
public class PostPreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PostPreServlet() {
        super();
    }
    // 1. 최초 1번 실행 - init method가 실행되기 전에 실행
    @PostConstruct
    private void preinitMethod() {
    	System.out.println("preinitMethod method");
    }
	
    // 2. 최초 1번 실행 - init method
    public void init(ServletConfig config) throws ServletException {
		System.out.println("init method");
	}
    
    // 4. application이 종료될 때 1번 실행
	public void destroy() {
		System.out.println("destroy method");
	}
	
	// 5. web container에 이쓴 servlet이 최종 삭제되기 직전에 한번 실행
	@PreDestroy
	private void clean() {
		System.out.println("clean method");
	}
	// 3. web container에 있는 servlet을 반복 실행
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet method");
	}
	// 3. web container에 있는 servlet을 반복 실행
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

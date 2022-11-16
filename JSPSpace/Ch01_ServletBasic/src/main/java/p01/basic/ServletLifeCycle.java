package p01.basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LifeCycle")
public class ServletLifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletLifeCycle() {
		super();
	}

	// doGet 또는 doPost메소드를 실행하기 전에 수행되는 메소드
	// => ServletLifeCycle servlet이 new로 인스턴스가 메모리(web container)에 생성될 때 1번만 실행(초기화 작업할 때 사용)
	// web container : tomcat server가 메모리에서 자동으로 인스턴스를 만들어 관리하는 영역
	@Override
	public void init() throws ServletException {
		System.out.println("init method 실행");
	}
	
	// web browser에서 요청이 오면 service메소드가 먼저 실행하고, 
	// method가 GET이면, doGet()메소드를 실행, method가 POST이면 doPost()메소드 실행
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		super.service(req, resp);
//	}
	// ServletLifeCycle servlet이 메모리(web container)에서 제거될 때 1만 실행
	@Override
	public void destroy() {
		System.out.println("destroy method 실행");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do get method 실행");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do post method 실행");
	}

}

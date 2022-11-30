package p06.filter.basic;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// MyFilter : utf-8로 설정하는 filter
//@WebFilter("/MyFilter")
public class MyFilter implements Filter {

    public MyFilter() {
        
    }

    // Filter가 생성될 때 1번만 실행
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("MyFilter 초기화");
	}

	// Filter가 삭제될 때 1번만 실행
	public void destroy() {
		// TODO Auto-generated method stub
	}

	// ServletRequest : HttpServletRequest의 parent class
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("jsp 파일에 request를 보내기 전에 MyFilter에서 수행하는 코딩내용 ");
		request.setCharacterEncoding("utf-8");
		
		// pass the request along the filter chain
		// jsp의 servlet의 doGet이나 doPost로 보내는 명령어
		// doFilter메소드 명령어는 jsp가 실행이 완료될 때 까지 waiting함
		chain.doFilter(request, response);
		
		System.out.println("jsp로 부터 받은 response객체를 사용하여 MyFilter에서 코딩하는 내용");
		// response.setContentType("text/html; charset=utf-8");
	}

}

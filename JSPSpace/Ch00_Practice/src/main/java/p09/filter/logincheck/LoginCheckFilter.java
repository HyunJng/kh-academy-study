package p09.filter.logincheck;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter{
	/**1.
	 * - 세션에 로그인 정보가 있다면 로그인이 된 상태 -> boardList페이지로 가야함
	 * - 없다면 로그인이 안 된 상태이므로 -> loginForm으로 돌아가야함
	 * 2. form에 로그인 정보 입력
	 * - login페이지를 지나야 세션에 로그인 정보 탑재
	 * - 다시 1번 검사
	 */
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest)request;
		HttpSession session = httpReq.getSession(false);
		Member member = null;
		
		if(session != null)
			member = (Member)session.getAttribute("MEMBER");
		else if(member != null) {
			chain.doFilter(httpReq, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("loginForm.jsp");
			dispatcher.forward(httpReq, response);
		}
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
	}

}

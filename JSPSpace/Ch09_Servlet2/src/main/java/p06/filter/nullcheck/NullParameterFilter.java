package p06.filter.nullcheck;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullParameterFilter implements Filter{
	private String[] parameterNames = null;

	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String names = filterConfig.getInitParameter("parameterNames");
		StringTokenizer st = new StringTokenizer(names, ",");
		parameterNames = new String[st.countTokens()];
		
		for(int i = 0; st.hasMoreElements(); i++) {
			parameterNames[i] = st.nextToken();
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//jsp나 servlet으로 request객체 보내기 전에 수행하고자하는 기능에 대한 코딩
		NullParameterRequestWrapper requestWrapper = new NullParameterRequestWrapper((HttpServletRequest)request);
		requestWrapper.checkNull(parameterNames);
		
		// pass request, response 
		chain.doFilter(requestWrapper, response);
	}
	
	@Override
	public void destroy() {
	}
}

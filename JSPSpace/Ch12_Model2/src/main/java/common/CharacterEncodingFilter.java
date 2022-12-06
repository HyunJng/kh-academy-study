package common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

// @WebFilter("/CharacterEncodingFilter")
public class CharacterEncodingFilter implements Filter {
	private String encoding;

    public CharacterEncodingFilter() {
        
    }

	public void init(FilterConfig fConfig) throws ServletException {
		
		encoding = fConfig.getInitParameter("encoding");
		if (encoding == null) {
			encoding = "utf-8";
		}
	}

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
	}

}

package p06.filter.nullcheck;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class NullParameterRequestWrapper extends HttpServletRequestWrapper{
	private Map<String, String[]> parameterMap = null;
	
	public NullParameterRequestWrapper(HttpServletRequest request) {
		super(request);
		parameterMap = new HashMap<String, String[]>(request.getParameterMap());
	}
	
	public void checkNull(String[] parameterNames) {
		for(int i = 0 ; i<parameterNames.length; i++) {
			if(!parameterMap.containsKey(parameterNames[i])){
				 String[] values = new String[]{""}; // checkbox같이 여러개 올 수 있어서 배열로 둠.
				 parameterMap.put(parameterNames[i], values);
			}
		}
	}
	@Override// get모두 request메소드 오버라이드
	public String getParameter(String name) {
		String[] values = getParameterValues(name);
		if(values != null && values.length > 0)
			return values[0];
		return null;
	}
	
	@Override
	public String[] getParameterValues(String name) {
		return (String[])parameterMap.get(name);
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		return parameterMap;
	}
	@Override
	public Enumeration<String> getParameterNames() {
		return Collections.enumeration(parameterMap.keySet());
	}
}

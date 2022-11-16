package p02.html_form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test1")
public class GetParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetParam() {
        super();
    }
//   tomcat serer8.0 version이상에서는 method가 'GET"방식인 경우에 기본 charset이 "utf-8"임
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. request 객체에서 web browser에서 전송한 데이터 읽기
		// 1.1. sport key에 대한 value를 읽기
		String[] str = request.getParameterValues("sport"); // key에 맞는 parameter 읽어옴
		// 1.2. gender key에 대한 value 읽기
		String[] str2 = request.getParameterValues("gender");
		
		// 2. DB 테이블 엑세스 또는 다른 비지니스 로직 코딩
		
		
		// 3. response 객체에 setting
		// 3.1. response header에 setting
		response.setContentType("text/html;");
		response.setCharacterEncoding("utf-8");
		// 3.2. response에 web browser에 보낼 html 내용 코딩
		PrintWriter out = response.getWriter();
		out.println("<html><head><title></title></head>");
		out.println("<body>");
		out.println("<h3>좋아하는 운동: </h3>");
		for(int i= 0 ;i<str.length; i++) {
			out.print(str[i] + " ");
		}
		out.println("<h3>성별</h3>");
		out.print(str2[0]);
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

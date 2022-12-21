package user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import user.model.UserVO;
import user.model.impl.UserDAO;

@WebServlet("/checkPW.do")
public class CheckPWController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckPWController() {
        super();	
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자 입력 정보 추출
		String pwd = request.getParameter("pwd1");
		
		String[] pwUp = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		boolean pwUpCh = false;
		String[] pwLo = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		boolean pwLoCh = false;
		String[] pwSc = {"!","@","#","$","%","^","&","*","(",")","_","-","+","=","[","]","{","}","~","?",":",";","`","|","\\"};
		boolean pwScCh = false;
		
		for (int u=0;u<pwUp.length;u++) {
			if(pwd.contains(pwUp[u])){
				pwUpCh = true;
				break;
			}
		}
		for (int u=0;u<pwLo.length;u++) {
			if(pwd.contains(pwLo[u])){
				pwLoCh = true;
				break;
			}
		}
		for (int u=0;u<pwSc.length;u++) {
			if(pwd.contains(pwSc[u])){
				pwScCh = true;
				break;
			}
		}
		
		JSONObject idJson = new JSONObject();
		
		if(pwUpCh && pwLoCh && pwScCh) {
			idJson.put("Ch", "true");
		}
		response.setContentType("application/json");
		
//		System.out.println(idJson);
		PrintWriter out = response.getWriter();
		out.print(idJson);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.guhaejwo.view.sponsor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/jq")
public class kakaoPayController {
	
//	@Autowired
//	VueDAO vdao;
	
	@RequestMapping("/jq.cls")
	public ModelAndView main(ModelAndView mv, HttpSession s, RedirectView rv) {
		mv.setViewName("jq/test");
		return mv;
	}
	
	@RequestMapping("/pay.cls")
	public ModelAndView serve(ModelAndView mv, HttpSession s, RedirectView rv) {
		mv.setViewName("jq/serve");
		return mv;
	}
	
	@RequestMapping("/kakaopay.cls")
	@ResponseBody
	public String kakaoPay() {
		try {
			URL url = new URL("https://kapi.kakao.com/v1/payment/ready");
			// 요청1(클라이언트) 요청2(카카오페이 서버)를 연결을 시킴
			HttpURLConnection urlconn = (HttpURLConnection) url.openConnection();
			urlconn.setRequestMethod("POST");
			// 카카오페이에서 인증 받은 요청인지 확인
			// adminkey : c77bcb2f82c082e338b062133fbeeca9
			urlconn.setRequestProperty("Authorization", "KakaoAK c77bcb2f82c082e338b062133fbeeca9");
			urlconn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			// setDoOutput : 연결을 통해서 서버에 전달할 것이 있는지 확인
			urlconn.setDoOutput(true);
			
			// 필수 request 파라미터 (테스트용)
			String reqParam = "cid=TC0ONETIME&partner_order_id=partner_order_id&"
					+ "partner_user_id=partner_user_id&item_name=초코파이&quantity=1&"
					+ "total_amount=2200&vat_amount=200&tax_free_amount=0&"
					+ "approval_url=https://localhost:8090/cls/jq/pay.cls&"
					+ "fail_url=https://localhost:8090/fail&"
					+ "cancel_url=https://localhost:8090/cancel";
			
			OutputStream output = urlconn.getOutputStream();
			// 데이터를 전송함
			DataOutputStream doutput = new DataOutputStream(output);
			// byte 단위로 데이터 변환
			doutput.writeBytes(reqParam);
			doutput.flush();
			doutput.close();
			// 실제 통신하는 부분, 통신 이후 결과코드를 받아옴
			int result = urlconn.getResponseCode();
			
			// 그저 데이터 받는애
			InputStream input;
			// 200 : 정상 통신
			if(result == 200) {
				input = urlconn.getInputStream();
			}else {
				input = urlconn.getErrorStream();
			}
			
			// 받은 데이터 읽는애
			InputStreamReader inputR = new InputStreamReader(input);
			// byte 타입을 다시 문자열로 변환, BufferedReader를 사용하면 변환 과정에서 알아서 형번환이 되기 때문에 사용
			BufferedReader strCasting = new BufferedReader(inputR);
			
			return strCasting.readLine();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"result\":\"NO\"}";
	}
	
}

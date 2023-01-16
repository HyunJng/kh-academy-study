package com.spring.restcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


// @RestController
// 1. Controller의 자식 - jsp파일 path 리턴 
// 2. clinet에서 json 데이터를 server에서 받거나, json을 client에게 보낼 때 사용
// 3. HttpMessageConverter의 도움을 받는다.
@RestController
//  class위에 ReqeuestMapping하는 의미
// 1. .root path가 /sample이라는 의미
@RequestMapping("/sample")
public class SampleController {

	// response header에 text/html형식으로 보냄
	@RequestMapping("/hello") // 실제 path: /sample/hello
	String sayHello() {
		return "hello, World";
	}
	// Spring 버전이 4.3.11 이상일 때 사용 가능
	// - produces: response heaeder에 "text/plain; charset=UTF-8"설정하라는 의미
	// => web browser에 데이터를 보낼 때 문자열 형태로 전송하라는 의미
	// 		참고) text/html: web 브라우저에 보낼 때 html형태로 보내라는 의미
	@GetMapping(value="/getText", produces="text/plain; charset=UTF-8")
	public String getText() {
		return "안녕하세요";
	}
	
	@RequestMapping("/sendVO")
	public SampleVO getSample() {
		// 자바 객체로 넘겨도 HttpMessageConverter에 의해 웹에는 json으로 형태로 전송 
		return new SampleVO(112, "star", "load");
	}
	
	@GetMapping(value="/getSample")
	public SampleVO getSample2() {
		return new SampleVO(113, "rocket", "raccoon");
	}
	
	@GetMapping(value="/getList")
	public List<SampleVO> getList() {
		List<SampleVO> list = new ArrayList();
		for (int i=0; i<=10; i++) {
			list.add(new SampleVO(i, i + "First", i + " Last"));
		}
		return list;
	}
	
	@GetMapping(value="/getMap")
	public Map<String, SampleVO> getMap() {
		Map<String, SampleVO> map = new HashMap<>();
		map.put("First", new SampleVO(111, "Groot", "Junior"));
		return map;
	}
	
	// ResponseEntity
	// 1) Rest 방식으로 호출하는 경우 데이터 자체를 전송하는 방식으로 처리되기 떄문에 요청한 쪽에서는 정상/비정상 데이터를 구분할 수 있는 확실한 방법을 제공해야한다
	// 2) data와 함께 HTTP header의 상태 메시지등을 같이 전달하는 용도로 사용
	// 3) params: query string으로 height, weight를 사용하라는 의미
	//		=> check(Double height, Double weight) 메서드에서 height value값이 parameter의 height로 넘어가고 weight값이 weight으로 넘어감
	//		=> 예) /check?height=180&weight=75
	@GetMapping(value="/check", params={"height", "weight"})
	public ResponseEntity<SampleVO> check(Double height, Double weight) {
		
		SampleVO vo = new SampleVO(0, "" + height, "" + weight);
		ResponseEntity<SampleVO> result = null;
		
		if (height < 150) {
			// BAD_GATEWAY : response status code가 502라는 의미
			// status도 넘기고 body도 넘겨진다.
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		} else {
			// OK : 200
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		
		return result;
	}
	
	// { } : GetMapping의 path에서 {cat}의 내용을 가져오라는 의미
	// => path가 /product/야옹이/230인 경우, getPath method의 parameter cat의 값이 "야옹이"가 되고 
	// 		pid의 값은 230이 된다.
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") int pid) {
		return new String[] {"category: " + cat, "productId: " + pid};
	}
	
	// @RequestBody는 전달된 요청의 내용(body)을 이용해서 해당 파라미터의 타입으로 변환을 요구합니다.
	// 내부적으로 HttpMessageConverter 타입의 객체들을 이용해서 다양한 포맷의 입력 데이터를 변환할 수 있습니다.
	@PostMapping("/ticket")
	// RequestBody: 웹 브라우저가 request 객체의 body에 json데이터를 서버로 넘겨주면 자바 인스턴스로 변환하라는 의미
	public Ticket convert(@RequestBody Ticket ticket) {
		System.out.println("convert.....ticket: " + ticket);
		return ticket;
	}
	
}
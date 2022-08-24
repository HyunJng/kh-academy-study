package p09.regular_expression;

import java.util.regex.Pattern;

// 정규표현식(regular Expression)
// 	1. mini programming language (문법 : 이해하고 외워야함)
//	2. 대상 : 문자열(String)
//	3. 사용 목적 : 특정 문자열 검색, 추출, 삭제 등 문자열 연산과 관련하여 다양한 방식으로 사용
//	4. 현재 예제 : 해당되는 pattern이 맞는지 검색
//		ex. 100페이지 문서에서 전화번호에 해당하는 모든 것을 추출하시오.
//		ex. 100페이지 문서에서 이메일 주소만 모두 추출하시오.

// (02|010)-\\d{3,4}-\\d{4} 설명
// 1. (02|010) : 02 or 010
// 2. - : 무조건 '-'가 나온다.
// 3. /d : digit. 숫자(0~9) 
//		** MS windows에서는 \d를 \\d로 표현해야한다.
// 4. {3, 4} : 연속해서 3개 또는 4개까지 가능하다.

// \\w+@\\w+\\.\\w+(\\.\\w+)? 설명
// 1. \w : 영어 알파벳 소문자/대문자, 숫자 가능. 
// 2. + : 1개 이상
// 3. ? : 없거나 있을 수도 있다.
public class PatternEx {
	public static void main(String[] args) {
		String regExp = "(02|010)-\\d{3,4}-\\d{4}";
		String data = "010-123-5678";
		boolean result = Pattern.matches(regExp, data);
		
		if(result)
			System.out.println("정규식이 일치합니다.");
		else
			System.out.println("정규식이 일치하지 않습니다.");
		
		regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		data = "angel@naver.co.kr";
		result = Pattern.matches(regExp, data);
		
		if(result)
			System.out.println("정규식이 일치합니다.");
		else
			System.out.println("정규식이 일치하지 않습니다.");
				
	}
}

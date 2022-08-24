package p06.string_methods;

import java.io.UnsupportedEncodingException;

// Java는 내부적으로 모든 문자를 unicode(2 bytes)로 변환해서 관리하고 있음.

// 문자열 encoding 및 decoding
// 0. encoding : 암호화, decoding : 해독.
// 1. encoding in Java: 특정 문자 set코드로 변환 (ex. UTF-8, EUC-kr, UTF-16)
//		-> bytes 배열로 변환
// 		-> (unicode '가' -> UTF-8 ) : (2 byte -> 3 bytes)
//		-> java에서 encoding하는 방법 : 
//			* str.getBytes() : IDE에서 지정된 기본 encoding 방식 (eclipse에서 utf-8로 설정) 
//			* str.getBytes("EUC-KR") : EUC-KR 문자 set으로 인코딩.
// 2. decoding in Java: 특정 문자 set코드를 원래 문자로 원복.
// 		- java에서 decoding하는 방법(다시 Unicode로 변환)
//			* new String(str) : UTF-8로 인코딩 되어 있는 것을 unicode로 디코딩
//			* new String(str, "EUC-KR") : EUC-KR로 되어있는 것을 unicode로 디코딩
// 3. 한글 길이 : UTF-8(3 bytes), EUC-KR(2 bytes)
// 4. 가장 보편적인 인코딩 방식은 UTF-8.
//	 - WEB programing에서도 defacto standard로 인정
// 5. 프로그래밍에서 encoding/decoding 나온 원래 이유
//	- 통신망을 통해 데이터를 주고 받을 때 사용
//	- 파일을 저장(encoding)하고 읽을 때(decoding)을 사용
public class StringGetBytesEx {

	public static void main(String[] args) {
		String str = "안녕하세요";
		
		
		byte[] b1 = str.getBytes();	// UTF-8
		System.out.println("b1 length : "+ b1.length);
		String s1 = new String(b1);
		System.out.println(s1);
		
		try {
			byte[] b2 = str.getBytes("EUC-KR");
			System.out.println("b2 length : "+ b2.length);
			String s2 = new String(b2, "EUC-KR");
//			String s2 = new String(b2, "UTF-8");	// 꼭 encoding/decoding 문자 set이 동일해야함.
			System.out.println(s2);

			byte[] b3 = str.getBytes("UTF-8");
			System.out.println("b3 length : "+ b3.length);
			String s3 = new String(b3, "UTF-8");
			System.out.println(s3);
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("자바에서 지원하지않는 문자 encoding 방식 Exception 발생.");
		}
		
	}
}

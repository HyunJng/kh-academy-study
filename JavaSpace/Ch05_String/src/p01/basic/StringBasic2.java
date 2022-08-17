package p01.basic;

// String 문자데이터의 길이 구하기
//1. 한글과 영어 1 문자를 length에서 1개로 인식
//	- 한글, 영어 글자는 unicode로 구성되어 있음

public class StringBasic2 {
	public static void main(String[] args) {
		String message = "Welcom to Java";
		String message2 = "하이 자바";
		
		System.out.println(message + "의 길이는 " + message.length());
		System.out.println(message2 + "의 길이는 " + message2.length());
		
		
	}
}

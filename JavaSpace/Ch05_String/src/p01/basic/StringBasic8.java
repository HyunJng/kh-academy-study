package p01.basic;

import java.util.StringTokenizer;

// 전체 문자열에서 일부 문자열 가져오기 : substring(starIndx, endIndx)
//1. startIdx = 문자열 가져오기에 포함됨.
//2. endIdx = 문자열 가져오기에 미포함.
//3. endIdx 값이 없이 startIdx만 있으면 startIdx부터 문자열 끝까지 가져옴
public class StringBasic8 {
	public static void main(String[] args) {
		String message = "Welcome to Java";
		
		System.out.println(message.substring(0, 5));
		System.out.println(message.substring(0, 7));
		System.out.println(message.substring(0, 11));
		
		System.out.println(message.substring(2, 5));
		System.out.println(message.substring(2, 7));
		System.out.println(message.substring(2, 11));
		
		System.out.println(message.substring(0));
		System.out.println(message.substring(2));
		
		System.out.println();
		
	}
}

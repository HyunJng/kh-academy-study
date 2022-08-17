package p01.basic;

import java.util.Scanner;

// 문자열을 콘솔에서 읽기
// next : space로 구분된 문자열(String)을 읽어올 때 사용
// nextLine : 1줄 전체를 문자열로 읽어올 때 사용
public class StringBasic5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("space로 구분된 3개의 단어를 입력하세요.");
		String s1 = sc.next();
		String s2 = sc.next();
		String s3 = sc.next();
		
		System.out.println("s1 = " + s1);
		System.out.println("s2 = " + s2);
		System.out.println("s3 = " + s3);
		
		sc.nextLine();	// 더미
		System.out.println("문장 하나를 입력하고 enter을 누르시오.");
		String str = sc.nextLine();	// enter key문자는 제외됨.
		
		System.out.println(str);
		
		System.out.println("str대문자: " + str.toUpperCase());
		System.out.println("str소문자: " + str.toLowerCase());
		
	}
}

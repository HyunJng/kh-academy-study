package q01.quiz03;

import java.util.Scanner;

public class Quiz04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] country = new String[3];
		
		// 입력
		System.out.println("나라이름 3개를 적으시오(첫글자는 대문자)");
		for(int i = 0; i<country.length; i++) {
			country[i] = sc.next();
		}
		
		//내림차순 정렬
		for(int i = 0 ;i<country.length; i++) {
			for(int j = 0; j<country.length - (i + 1); j++) {
				if(country[j].compareTo(country[j + 1]) < 0) {
					String temp = country[j];
					country[j] = country[j+1];
					country[j+1] = temp;
				}
			}
		}
		//출력
		for(int i = 0; i<country.length; i++) {
			System.out.print(country[i] + " ");
		}
	}
}

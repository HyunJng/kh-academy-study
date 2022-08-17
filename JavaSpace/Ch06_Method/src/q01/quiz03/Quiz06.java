package q01.quiz03;

import java.util.Scanner;

public class Quiz06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String password = sc.next();
		
		if(checkPassword(password))
			System.out.println(password + "는 유효합니다.");
		else
			System.out.println(password + "는 유효하지않습니다.");
	}
	
	
	// password 유효성 확인 메소드
	public static boolean checkPassword(String password) {
		// 1. 길이 검사
		if(password.length()<10)
			return false;
		
		int numberCnt = 0;	// 숫자 개수
		
		for(int i = 0; i<password.length(); i++) {
			char temp = password.charAt(i);
			// 2. 영문자와 숫자만 있는지 확인
			if(Character.isDigit(temp)) {
				numberCnt++;
				continue;
			}
			else if(Character.isAlphabetic(temp)) {
				continue;
			}
			else
				return false;
		}
		
		// 3. 최소 3개의 숫자를 갖는지 확인
		if(numberCnt < 3) 
			return false;
		
		return true;
		
	}
}

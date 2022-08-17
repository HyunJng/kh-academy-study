package p02.switch_basic;

public class SwitchBasic4 {
	public static void main(String[] args) {

		char grade = 'D';

		switch (grade) {
		case 'A':
		case 'E':
		case 'B':
			System.out.println("우수 회원 입니다.");
			break;
		case 'C':
		case 'D':
			System.out.println("일반회원입니다.");
		}
		
		// switch를 if 문으로 변형
		if(grade == 'A' || grade == 'B' || grade == 'E')
			System.out.println("우수 회원입니다.");
		else if(grade == 'C' || grade == 'D')
			System.out.println("일반 회원입니다.");
	}
}

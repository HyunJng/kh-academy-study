package p02.switch_basic;

public class SwitchBasic5 {
	public static void main(String[] args) {
		int originScore = 79;
		int convertedScore;
		
		//originScore의 10의 자리 숫자 추출
		convertedScore = originScore / 10;
		
		switch ( convertedScore) {
		case 10:
		case 9:
			System.out.println("A 등급입니다.");
			break;
		case 8:
			System.out.println("B 등급입니다.");
			break;
		case 7:
			System.out.println("C 등급입니다.");
			break;
		case 6:
			System.out.println("D 등급입니다.");
			break;
		default:
			System.out.println("F 등급입니다.");
			break;

		}
	}
}

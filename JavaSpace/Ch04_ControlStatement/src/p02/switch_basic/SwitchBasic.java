package p02.switch_basic;

// switch문은 if ~ else if ~ else와 동일
// - 가능하면 switch문을 많이 사용하는 것을 권장
public class SwitchBasic {
	public static void main(String[] args) {
		// diceNumber : 1 ~ 6
		int diceNumber = (int) (Math.random() * 6) + 1;

		System.out.println("diceNumber = " + diceNumber);

		switch (diceNumber) {
		case 1: // if(diceNumber == 1)
			System.out.println("주사위 1이 나왔습니다.");
			break;
		case 2:
			System.out.println("주사위 2" + "이 나왔습니다.");
			break;
		case 3:
			System.out.println("주사위 3이 나왔습니다.");
			break;
		case 4:
			System.out.println("주사위 4이 나왔습니다.");
			break;
		case 5:
			System.out.println("주사위 5이 나왔습니다.");
			break;
		default:
			System.out.println("주사위 6이 나왔습니다.");
			break;
		}

	}
}

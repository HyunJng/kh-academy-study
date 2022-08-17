package p02.switch_basic;

public class SwitchBasic2 {
	public static void main(String[] args) {
		// diceNumber : 1 ~ 6
		int diceNumber = (int) (Math.random() * 6) + 1;

		System.out.println("diceNumber = " + diceNumber);

		
		switch (diceNumber) {
		case 1: // if(diceNumber == 1)
			System.out.println("주사위 1이 나왔습니다.");
		case 2:
			System.out.println("주사위 2" + "이 나왔습니다.");
		case 3:
			System.out.println("주사위 3이 나왔습니다.");
		case 4:
			System.out.println("주사위 4이 나왔습니다.");
		case 5:
			System.out.println("주사위 5이 나왔습니다.");
		default:
			System.out.println("주사위 6이 나왔습니다.");
		}

	}
}

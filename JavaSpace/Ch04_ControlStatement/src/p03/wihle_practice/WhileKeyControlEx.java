package p03.wihle_practice;

import java.io.IOException;

public class WhileKeyControlEx {

	public static void main(String[] args) throws IOException {
		boolean run = true;
		int speed = 0;
		int keyCode = 0;

		// System.in.read() : 키보드에서 한 문자씩 읽어옴.
		while (run) {
			// enter key (CR, LF)가 아닌 경우에 메뉴를 출력
			if (keyCode != 13 && keyCode != 10) {
				System.out.println("-------------------------");
				System.out.println("1. 증속 | 2. 감속 | 3. 중지");
				System.out.println("-------------------------");
				System.out.print("선택: ");
			}
			keyCode = System.in.read();
			System.out.println("keyCode = " + keyCode);
			
			if(keyCode == 49) {	// '1' 의 ASCII
				speed++;
				System.out.println("현재 속도 : " + speed);
			}else if(keyCode == 50) {
				speed--;
				System.out.println("현재 속도 : "+ speed);
			}else if(keyCode == 51) {
				run = false;
			}
		}
	}
}

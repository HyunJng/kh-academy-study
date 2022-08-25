package p12.random_class;

import java.util.Random;

// Math.random() => 0 ~ 0.9999 사이의 값을 return
// Random class 가 별도로 존재,
// 
public class RandomEx {
	public static void main(String[] args) {
		int[] selectNumber = new int[6];
		Random random = new Random();

		System.out.print("선택번호 : ");
		for (int i = 0; i < 6; i++) {
			selectNumber[i] = random.nextInt(45) + 1;
			System.out.print(selectNumber[i] + " ");
		}
		System.out.println();
		int[] winNumber = new int[6];
		random = new Random();

		System.out.print("당첨번호 : ");
		for (int i = 0; i < 6; i++) {
			winNumber[i] = random.nextInt(45) + 1;
			System.out.print(winNumber[i] + " ");
		}

		System.out.println();

	}
}

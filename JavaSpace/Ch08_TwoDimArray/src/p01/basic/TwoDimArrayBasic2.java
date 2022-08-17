package p01.basic;

public class TwoDimArrayBasic2 {

	public static void main(String[] args) {

		int[][] numbers = new int[4][3];

		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {
				numbers[i][j] = i * numbers.length + j;
			}
		}

		// 행의 길이
		System.out.println("행의 길이 : " + numbers.length);

		// 열의 길이
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(i + "열의 길이: " + numbers[i].length);
		}
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {
				System.out.print(numbers[i][j] + " ");
			}
			System.out.println();
		}
	}

}

package p01.practice;

import java.util.Scanner;

public class PassTwoDimArray {
	public static void main(String[] args) {

		int[][] numbers = getArray(2, 3);

		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {
				System.out.print(numbers[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("2차원 배열의 원소 전체 합 : " + sum(numbers));
	}

	public static int[][] getArray(int row, int column) {
		int[][] numbers = new int[row][column];

		Scanner sc = new Scanner(System.in);
		System.out.println(row + "행 " + column + "열 데이터에 대하여 행 단위로 정수를 입력하시오");

		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {
				numbers[i][j] = sc.nextInt();
			}
		}

		return numbers;
	}
	
	public static int[][] getArray() {
		int[][] numbers = new int[2][3];

		Scanner sc = new Scanner(System.in);
		System.out.println("2행 3열 데이터에 대하여 행 단위로 정수를 입력하시오");

		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {
				numbers[i][j] = sc.nextInt();
			}
		}

		return numbers;
	}
	
	public static int sum(int[][] num) {
		int total = 0;

		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[i].length; j++) {
				total += num[i][j];
			}
		}
		return total;

	}
}

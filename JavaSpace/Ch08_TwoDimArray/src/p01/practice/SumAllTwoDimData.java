package p01.practice;

public class SumAllTwoDimData {
	public static void main(String[] args) {
		int[][] numbers= {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9},
				{10, 11, 12}
		};
		int sum = 0;
		
		// 배열 원소 전체 합
		for(int i= 0 ;i<numbers.length; i++) {
			for(int j = 0; j<numbers[i].length; j++) {
				sum += numbers[i][j];
			}
		}
		
		System.out.println("이차원 배열 전체 원소의 합: " + sum);
		
		// 각 행이 합
		for(int i= 0 ;i<numbers.length; i++) {
			int colSum = 0;
			for(int j = 0; j<numbers[i].length; j++) {
				colSum += numbers[i][j];
			}
			System.out.println(i + "행의 합: " + colSum);
		}
		
		System.out.println();
		// 각 열의 합
		int len = numbers[0].length;
		for(int column = 0; column < len; column++) {
			int rowSum = 0;
			for(int row = 0; row<numbers.length; row++) {
				rowSum += numbers[row][column];
			}
			System.out.println(column + "열의 합: " + rowSum);
		}
	}
}

package p01.practice;

import java.util.Scanner;

public class GetTwoDimArrayData {
	public static void main(String[] args) {
		int numbers[][] = new int[2][3];
		
		Scanner sc =new Scanner(System.in);
		System.out.println("2행 3열 데이터에 대하여 행 단위로 정수를 입력하시오");
		
		for(int i = 0 ;i<numbers.length; i++) {
			for(int j = 0; j<numbers[i].length; j++) {
				numbers[i][j] = sc.nextInt();
			}
		}
		for(int i = 0 ;i<numbers.length; i++) {
			for(int j = 0; j<numbers[i].length; j++) {
				System.out.print(numbers[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}
}

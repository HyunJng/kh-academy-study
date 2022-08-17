package p01.basic;

import java.util.Scanner;

public class ArrayBasic3 {
	public static void main(String[] args) {
		double myList[];
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("배열의 전체 크기를 입력하시오: ");
		int arrLength = sc.nextInt();
		
		myList = new double[arrLength];
		
		for(int i= 0; i<myList.length; i++) {
			System.out.println((i+1) +"번째의 원소를 입력하세요.");
			myList[i] = sc.nextDouble();
		}
	}
}

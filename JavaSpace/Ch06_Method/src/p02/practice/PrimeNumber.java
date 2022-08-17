package p02.practice;

import java.util.Scanner;

// prime number : 소수 
public class PrimeNumber {
	
	public static void main(String[] args) {
		System.out.println("<<가장 작은 소수부터 20개의 소수>>\n");
		printPrimeNumbers(20);
	}

	public static void printPrimeNumbers(int numberOfPrime) {
		int count = 0;		// 개수
		int number = 2;		// 검사 숫자

		while (count < numberOfPrime) {
			if (isPrimenum(number)) {
				count++;
				System.out.println(count + "번째 소수 : " + number);
			}
			number++;
		}
	}

	public static boolean isPrimenum(int n) {

		// 특정 숫자가 소수인지 판별
		for (int divisor = 2; divisor < n / 2; divisor++) {
			if (n % divisor == 0)
				return false;
		}
		return true;
	}
}


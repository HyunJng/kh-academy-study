package p01.basic;

import java.util.Scanner;

public class ArrayBasic8 {
	public static void main(String[] args) {
		String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		Scanner sc = new Scanner(System.in);

		System.out.println("달력 숫자를 입력하시오(1~12): ");
		int month = sc.nextInt();
		System.out.println("이번달은 " + months[month - 1] + "입니다.");
	}
}

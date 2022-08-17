package p02.practice;

import java.util.Scanner;

public class OrderTwoCities {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("첫번째 도시를 입력하시오.>>");
		String city1 = sc.nextLine();
		System.out.print("두번째 도시를 입력하시오.>>");
		String city2 = sc.nextLine();

		if (city1.compareTo(city2) < 0)
			System.out.println("2개 city의 오름차순 순서는 " + city1 + ", " + city2);
		else
			System.out.println("2개 city의 오름차순 순서는 " + city2 + ", " + city1);
	}
}

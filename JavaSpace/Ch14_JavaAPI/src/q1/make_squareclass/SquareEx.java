package q1.make_squareclass;

import java.util.Scanner;

public class SquareEx {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("side(double), color(String), filled(boolean)를 순서대로 입력하시오.");
		double side = sc.nextDouble();
		String color = sc.next();
		boolean filled = sc.nextBoolean();

		Square square = new Square(side, color, filled);
		
		System.out.println(square);
		
	}
}

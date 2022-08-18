package Q5.q01;

import java.util.Scanner;

public class TestTriangle {
	public static void main(String[] args) {
		
		Triangle t1 = inputTriangle();
		Triangle t2 = new Triangle();
		
		t1.toString();
		System.out.println("t1의 넓이 : "+ t1.getArea());
		System.out.println("t1의 둘레 : "+ t1.getPerimeter());
		
		t2.toString();
		System.out.println("t1의 넓이 : "+ t2.getArea());
		System.out.println("t1의 둘레 : "+ t2.getPerimeter());
	}
	
	public static Triangle inputTriangle() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("삼각형의 변이 길이 3개를 입력하시오.");
		double[] side = new double[3];
		for (int i = 0; i < 3; i++)
			side[i] = scanner.nextDouble();
		
		return new Triangle(side[0], side[1], side[2]);
	}
}

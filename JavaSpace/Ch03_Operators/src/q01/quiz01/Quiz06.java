package q01.quiz01;

import java.util.Scanner;

public class Quiz06 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		double num1 = input.nextDouble();
		double num2 = input.nextDouble();
		
		boolean flag1 = (num1 >= 0) && (num1 <= 1);
		boolean flag2 = (num2 >= 0) && (num2 <= 1);
		
		if(flag1 && flag2) {
			System.out.println("두 수 모두 0과 1 사이에 있습니다.");
		}
		else
			System.out.println("두 수 모두 0과 1 사이에 있지 않습니다.");
		
	}
}

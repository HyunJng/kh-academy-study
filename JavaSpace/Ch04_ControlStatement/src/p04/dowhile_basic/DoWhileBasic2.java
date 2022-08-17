package p04.dowhile_basic;

import java.util.Scanner;

public class DoWhileBasic2 {
	public static void main(String[] args) {
		int sum = 0;
		int input_num;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("덧셈할 숫자를 입력하시오(종료: 0입력) >> ");
			input_num = sc.nextInt();
			sum += input_num;
		}while (input_num != 0);
		
		System.out.println("sum = " + sum);
		
		//while문으로 한다면
		sum = 0;
		System.out.print("덧셈할 숫자를 입력하시오(종료: 0입력) >> ");
		input_num = sc.nextInt();
		
		while(input_num != 0) {
			input_num = sc.nextInt();
			sum += input_num;
			input_num = sc.nextInt();
		}
		System.out.println("sum = " + sum);
	}
}

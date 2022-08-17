package q01.quiz02;

import java.util.Scanner;

public class Quiz03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1, n2, n3;
		
		System.out.print("정수 3개를 입력하시오>>");
		n1 = sc.nextInt();
		n2 = sc.nextInt();
		n3 = sc.nextInt();

		
		if (n1 < n2 && n1 < n3) {
			if (n2 < n3)
				System.out.println(n1 + " " + n2 + " " + n3);
			else
				System.out.println(n1 + " " + n3 + " " + n2);
		}
		if (n2 < n1 && n2 < n3) {
			if (n1 < n3)
				System.out.println(n2 + " " + n1 + " " + n3);
			else
				System.out.println(n2 + " " + n3 + " " + n1);
		}
		
		if (n3 < n2 && n3 < n1) {
			if (n1 < n2)
				System.out.println(n3 + " " + n1 + " " + n2);
			else
				System.out.println(n3 + " " + n2 + " " + n1);
		}
	}
	

}

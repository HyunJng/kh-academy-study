package q06.hashset;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TestHashSet {
	public static void main(String[] args) {
		int number1 = (int)(Math.random() * 10);
		int number2 = (int)(Math.random() * 10);
		int answer = number1 + number2;
		
		Scanner sc = new Scanner(System.in);
		// Create an set
		Set<Integer> set = new HashSet<Integer>();
		// 1. Scanner를 통해 두 숫자의 합계의 추측값을 입력 받을 것
		// 2. while문을 수행하면서 만약 합계가 맞으면 정답이라고 출력할 것
		//    - 정답이 아니면, 정답이 아니라고 출력하면서 다시 입력하라고 메세지를 출력할 것
		//    - 정답이 아닌 경우는 answers에 입력할 것 
		//      (단, answers에 이미 이전에 입력했으면 이미 입력했다는 메세지를 출력할 것
		while(true) {
			System.out.print("랜덤한 두 숫자의 합 : ");
			int you = sc.nextInt();
			if(you == answer) {
				System.out.println("정답입니다.");
				break;
			}
			if(!set.add(you)) {
				System.out.println("이전에 입력한 값입니다.");
				continue;
			}
		}
		
	}
}

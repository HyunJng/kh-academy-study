package q01.quiz02;

import java.util.Scanner;

public class Quiz02 {
	public static void main(String[] args) {
		double height, weight;			//키, 몸무게
		double bmi;						//BMI수치
		Scanner sc = new Scanner(System.in);
		
		
		//입력
		System.out.print("체중(kg)과 키(m)를 순서대로 입력하시오 >> ");
		weight = sc.nextDouble();
		height = sc.nextDouble();
		
		// BMI계산
		bmi = weight / (height * height);
		
		// BMI값 출력
		System.out.println("당신의 bmi는 " + bmi +"입니다.");
		if(bmi<18.5) {
			System.out.println("저체중입니다.");
		}else if(bmi < 25) {
			System.out.println("정상 체중입니다.");
		}else if(bmi < 30) {
			System.out.println("과체중입니다.");
		}else {
			System.out.println("비만입니다.");
		}
		
	}
}

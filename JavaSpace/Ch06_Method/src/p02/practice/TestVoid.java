package p02.practice;

// void type 메소드
// - 보통 정보 출력용으로 사용
public class TestVoid {
	public static void main(String[] args) {
		printGrade(78.5);
		printGrade(59.5);
		printGrade(100);
	}
	public static void printGrade(double score) {
		System.out.print(score + "의 등급 : ");
		if(score > 90) 
			System.out.println("A등급");
		else if(score > 80)
			System.out.println("B등급");
		else if(score > 70)
			System.out.println("C등급");
		else if(score > 60)
			System.out.println("D등급");
		else
			System.out.println("F등급");
	}
}

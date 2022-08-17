package p03.realnumer_problem;

public class RealNumberWrognUseEx {
	public static void main(String[] args) {
		float f1 = 0.1f;
		double d1 = 0.1;

		System.out.println("f1 = " + f1);
		System.out.println("d1 = " + d1);

		int apple = 1;
		float pieceUnit = 0.1f;
		int number = 7;

		double result = apple - number * pieceUnit;

		System.out.println("사과 1개에서 0.7조각을 빼면 " 
								+ result + "조각이 남습니다.");
	}
}

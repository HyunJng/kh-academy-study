package p03.realnumer_problem;

public class RealNumberCorrectUseEx {
	public static void main(String[] args) {
		int apple = 1;

		int totalPieces = apple * 10;
		int number = 7;
		int temp = totalPieces - number;

		double result = temp / 10.0;

		System.out.println("사과 1개에서 0.7조각을 뺴면, " + result + "조각이 남는다.");
	}
}

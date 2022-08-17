package p01.basic;

public class ArrayBasic6 {
	public static void main(String[] args) {
		int[] scores = { 95, 71, 84, 93, 87 };
		int sum = 0;

		for (int k : scores)
			sum += k;

		double average = (double)sum / scores.length;
		System.out.println("score의 합 : " + sum);
		System.out.println("score의 평균 : " + average);
	}
}

package q01.quiz01;

public class Quiz07_02 {
	public static void main(String[] args) {
		int x = 10;
		int y = 20;
		int z = (++ x) + (y--);
		System.out.println(z); // y--는 계산 한 후에 -1 되는 거라서 z = 11 + 20
	}
}

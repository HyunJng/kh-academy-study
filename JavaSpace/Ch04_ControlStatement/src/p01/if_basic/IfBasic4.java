package p01.if_basic;

// if ~ else if ~ else
public class IfBasic4 {
	public static void main(String[] args) {
		int score = 95;
		char rank;

		if (score >= 90) {
			rank = 'A';
		} else if (score >= 80) {
			rank = 'B';
		} else if (score >= 70) {
			rank = 'C';
		} else if (score >= 60) {
			rank = 'D';
		} else
			rank = 'F';

		System.out.println(rank + " 등급입니다.");
	}
}

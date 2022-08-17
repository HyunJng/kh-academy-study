package p01.if_basic;

// 가급적 중첩 if문은 사용하지 않는 것이 바람직하다.
// - 만약 중첩 if문을 사용해야한다면 depth를 가능하면 낮게 해야한다.
// - if아래 명령어가 하나면 { } 안 써도 되지만 비추천.
public class IfBasic3 {
	public static void main(String[] args) {
		int i = 10;
		int j = 5;
		int k = 7;

		if (i > k) {
			if (j > k) {
				System.out.println("i와 j는 k보다 크다.");
			} else {
				System.out.println("i > k > j");
			}
		} else
			System.out.println("i는 k보다 작거나 같다.");
	}
}

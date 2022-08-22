package p02.runtime_exception;

//ArrayIndexOutOfBoundsException
// - array에서 접근할 수 없는 인덱스로 array를 사용하면 발생
// - RuntimeException은 개발자 본인 능력에 의해서 판단하여 try-catch 절을 만들어야한다.
public class ArrayIndexOutOfBoundsExceptionEx {
	public static void main(String[] args) {
		int[] a = {1, 2, 3};
		try {
			System.out.println(a[0]);
			System.out.println(a[1]);
			System.out.println(a[2]);
			System.out.println(a[3]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열에서 접근할 수 없는 index를 사용했습니다.");
		}
	}
}

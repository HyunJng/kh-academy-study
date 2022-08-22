package p02.runtime_exception;

// NumberFormetException
// - String 문자열을 정수값 등의 숫자로 변화할 수 없을 경우에 발생.
//	 ex) Integer.parseInt("a100");
public class NumberFormetExceptionEx {
	public static void main(String[] args) {
		String data1 = "100";
		String data2 = "a100";
		
		try {
			int val1 = Integer.parseInt(data1);
			int val2 = Integer.parseInt(data2);
			int result = val1 + val2;
			System.out.println(data1 + " + "+ data2 + " = " + result);
		} catch (NumberFormatException e) {
			System.out.println("문자열을 숫자열로 변환할 수 없습니다.");
		}
	}
}

package p02.runtime_exception;

// NullPointerException
// - null 객체에 .를 사용할 경우에 발생
public class NullPointerExceptionEx {
	public static void main(String[] args) {
		String data = null;
		
		//println method에서 argument가 String type의 null이면 null로 출력
		try {
			System.out.println(data);
			System.out.println(data.toString());
		} catch (NullPointerException e) {
			System.out.println("Null Pointer Exception error 발생");
		}
	}
}

package p02.datatypes_basic;

// 정수 타입 리터럴 : 기본은 4B임
// long타입 리터럴로 만들고 싶으면 정수 끝에 L을 붙여줘야한다.
//  - 4B 였던 것을 8B로 메모리에 만든다.
public class LongEx {
	public static void main(String args[]) {
		long var1 = 10;
		long var2 = 10L;
		//long var3 = 1000000000000;
		long var3 = 1000000000000L;
		
		System.out.println("var1 = " + var1);
		System.out.println("var2 = " + var2);
		System.out.println("var3 = " + var3);
	}
}

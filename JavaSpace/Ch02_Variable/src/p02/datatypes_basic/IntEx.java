package p02.datatypes_basic;

// int 리터럴
// 1. 10진수, 8진수, 16진수 사용 가능
// 2. 16진수 - 하드웨어와 연계된 프로그램, 통신 포그램에서 많이 사용함

public class IntEx {
	public static void main(String args[]) {
		int var1 = 10;
		int var2 = 012;	// 8진수: 첫 번째에 0을 넣으면 8진수
		int var3 = 0xA;	// 16진수: 0x를 넣으면 16진수
		
		System.out.println("var1 = " + var1);
		System.out.println("var2 = " + var2);
		System.out.println("var3 = " + var3);
	}
}

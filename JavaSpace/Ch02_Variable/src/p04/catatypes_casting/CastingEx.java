package p04.catatypes_casting;

public class CastingEx {
	public static void main(String[] args) {
		char ch = 'A';
		int number = 88;
		double d = 100.94;
		long l = (long) d;	// double 에서 long으로 casting하면 소수점이하 버림
		int i = (int) l;	// 
		
		System.out.println("ch = " + ch);

		ch = (char) number; // int type인 number을 char type으로 casting
		System.out.println("ch = " + ch);

		System.out.println("l = " + l);
		System.out.println("i = " + i);
	}
}

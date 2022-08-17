package p02.datatypes_basic;

// 실수값 리터럴의 기본 type은 double임
// 즉 실수 리터럴은 기본 8B
// 실수 리터럴을 float타입에 넣을 경우에는 리터럴 값 끝에 f를 붙여야함
public class FloatDoubleEx {
	public static void main(String[] args) {
		double var1 = 3.14;
		// float var2 = 3.14;
		float var3 = 3.14f;
		double var4 = 0.1234567890123456789;
		float var5 = 0.1234567890123456789f;

		System.out.println("var1 = " + var1);
		System.out.println("var3 = " + var3);
		System.out.println("var4 = " + var4);
		System.out.println("var5 = " + var5);

		double var6 = 3e6;
		float var7 = 3e6f;
		double var8 = 2e-3;

		System.out.println("var6 = " + var6);
		System.out.println("var7 = " + var7);
		System.out.println("var8 = " + var8);
	}
}

package p05.practice_overloading;

// method overloading 정의
// 1. method이름이 동일하더라도 method signature이 다른 경우 JVM이 다른 method로 인식
// 2. C language에서는 method overloading이 허용 안됨.
public class TestMethodOverloading {
	public static void main(String[] args) {
		System.out.println("3, 4의 최대값 : " + max(3, 4));
		System.out.println("3.9, 1.2의 최대값: " + max(3.9, 1.2));
		System.out.println("3.9, 1.2, 5.1의 최대값: " + max(3.9, 1.2, 5.1));
	}
	
	public static int max(int num1, int num2) {
		if(num1 > num2)
			return num1;
		else return num2;
	}
	
	public static double max(double num1, double num2) {
		if(num1 > num2)
			return num1;
		else return num2;
	}
	
	public static double max(double num1, double num2, double num3) {
		if(num1 > num2)
			num2 = num1;
		if(num2 > num3)
			num3 = num2;
		return num3;
	}
}

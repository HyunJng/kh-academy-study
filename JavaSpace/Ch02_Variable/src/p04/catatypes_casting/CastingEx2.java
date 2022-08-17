package p04.catatypes_casting;

// casting 의 문제점
// - 큰 데이터 타입의 값이 작은 데이타 타입으로 변환되면서 데이터 유실됨.

public class CastingEx2 {
	public static void main(String[] args) {
		byte byteValue = 0;
		int intValue = 257;
		double doubleValue = 323.142;

		// 257(10) = 1 0000 0001(2) 이기 때문에 MSB잘려서 1 나옴(데이터 유실)
		byteValue = (byte) intValue;
		System.out.println("byteValue = " + byteValue); // byteValue = 1

		// double 의 mantissa 부분 유실
		intValue = (int) doubleValue;
		System.out.println("intValue = " + intValue);
		
	}
}

package p04.catatypes_casting;

// 강제 형변환 할 때 사용하는 팁
// - casting가능한지 Min_VALUE와 MAX_VALUE를 확인할 것.
public class ByteTypeMinMaxCheckEx {
	public static void main(String[] args) {
		int num = 125;
		
		System.out.println("byte 최소값 : " + Byte.MIN_VALUE);
		System.out.println("byte 최대값 : " + Byte.MAX_VALUE);

		if((num <Byte.MIN_VALUE) || (num > Byte.MAX_VALUE)) {
			System.out.println("byte 타입으로 변환할 수 없습니다.");
		} else {
			byte bNum = (byte) num;
			System.out.println("bNUm = " + bNum);
		}
	}
}

package p06.string_methods;

import java.io.IOException;
// System.in.read(byte[])
// 1. 키보드에서 byte단위로 byte[] 배열을 만들어 문자들을 읽음
//	 - 영어는 1 byte, 한글은 3 bytes
// 2. return 값 : 읽어들인 총 byte 갯수.(enter key도 포함,\n\r, 2 bytes 추가)
public class KeyboardToStringEx {
	public static void main(String[] args) throws IOException {
		byte[] bytes = new byte[100];

		System.out.println("입력: ");
		int readByteNo = System.in.read(bytes);

		System.out.println("readByteNO: " + readByteNo);
		
		String str = new String(bytes, 0, readByteNo - 2);
		System.out.println(str);
	}
}

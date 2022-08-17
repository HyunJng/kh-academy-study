package p01.basic;

// 배열 복사
public class ArrayBasic9 {
	public static void main(String[] args) {
		int sourceArray[] = { 2, 3, 1, 5, 10 };
		int copyArray1[] = new int[sourceArray.length];
		int copyArray2[] = new int[sourceArray.length];
		
		// 복사 방법 1: for문을 사용하여 단순 벅사
		for (int i = 0; i < sourceArray.length; i++)
			copyArray1[i] = sourceArray[i];
		
		// 복사 방법 2: System.arraycopy method 이용
		System.arraycopy(sourceArray, 0, copyArray2, 0, sourceArray.length);	//0번부터 베끼겠다.
		
		
		for(int k : copyArray1)
			System.out.print(k + " ");
		System.out.println();
		for(int k : copyArray2)
			System.out.print(k+ " ");
	}
}

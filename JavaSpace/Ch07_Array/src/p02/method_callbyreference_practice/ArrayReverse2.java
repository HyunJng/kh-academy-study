package p02.method_callbyreference_practice;

public class ArrayReverse2 {
	public static void main(String[] args) {
		int[] list = {1, 2, 3, 4, 5};
		
		// reverse 전
		System.out.print("reverse 전 : ");
		for(int k : list) {
			System.out.print(k + " ");
		}
		
		System.out.println();
		reverse(list);
		
		//reverse 후
		System.out.print("reverse 후 : ");
		for(int k : list) {
			System.out.print(k + " ");
		}
	}
	// return type : array
	public static void reverse(int[] list) {
		int[] result = new int[list.length];
		
		for(int i =list.length; i > 0; i--) {
			result[i - 1] = list[list.length - i];
		}
		
//		list = result; //이려면 formal parameter의 주소만 바뀌는거라서 소용이 없음
		for(int i = 0; i < list.length; i++) {
			list[i] = result[i];
		}		
	}
}

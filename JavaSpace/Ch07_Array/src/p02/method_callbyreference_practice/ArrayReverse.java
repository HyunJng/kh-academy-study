package p02.method_callbyreference_practice;

public class ArrayReverse {
	public static void main(String[] args) {
		int[] list = {1, 2, 3, 4, 5};
		
		// reverse 전
		System.out.print("reverse 전 : ");
		for(int k : list) {
			System.out.print(k + " ");
		}
		
		System.out.println();
		
		//reverse 후
		System.out.print("reverse 후 : ");
		list = reverse(list);	// list가 reverse함수의 result에 저장되어있던 주소로 변경.
		for(int k : list) {
			System.out.print(k + " ");
		}
	}
	// return type : array
	public static int[] reverse(int[] list) {
		int[] result = new int[list.length];
		
		for(int i =list.length; i > 0; i--) {
			result[i - 1] = list[list.length - i];
		}
		return result;
	}
}

package p01.basic;

// JAVA, DB(SQL)
// HTML, CSS, JavaScript
// SPRING FRAME WORK. KIM
public class ArrayBasic {
	public static void main(String[] args) {
		// 배열 선언 방법 1
		int[] arr = { 10, 20, 30, 40 };
		int idx = 0;
		for (int i : arr) {
			System.out.println("arr[" + idx + "]번째 원소 : " + i);
			idx++;
		}
		System.out.println("전체 배열의 원소 개수: " + arr.length);
	
		int[] arr1 = { 50, 60, 70, 80 };
		idx = 0;
		for (int i : arr1){
			System.out.println("arr[" + idx + "]번째 원소 : " + i);
			idx++;
		}
		System.out.println("전체 배열의 원소 개수: " + arr1.length);
		// 배열 선언 방법 2 : 타입변경
		double[] arr2 = { 1.2, 2, 3, 4 };
		idx = 0;
		for (double i : arr2){
			System.out.println("arr[" + idx + "]번째 원소 : " + i);
			idx++;
		}
		System.out.println("전체 배열의 원소 개수: " + arr2.length);
		
		// 배열 선언 방법 3
		int[] arr3;
		arr3 = new int[] {5, 6, 7, 8, 9};
		idx = 0;
		for (int i : arr3){
			System.out.println("arr[" + idx + "]번째 원소 : " + i);
			idx++;
		}
		System.out.println("전체 배열의 원소 개수: " + arr3.length);
		
		// 배열 선언 방법 4 
		int[] arr4;
		arr4 = new int[4];
		for(int i = 0; i<arr4.length; i++)
			arr4[i] = (i+1)* 10;
		System.out.println("arr4 전체 배열원소 개수: " + arr4.length);
	}
}

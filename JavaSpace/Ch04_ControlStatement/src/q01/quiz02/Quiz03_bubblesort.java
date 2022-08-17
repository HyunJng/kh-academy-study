package q01.quiz02;

import java.util.Random;

// Method를 이용한 bubble정렬로 변경
public class Quiz03_bubblesort {
	public static void main(String[] args) {

		Random rd = new Random();
		int arr[] = new int[5];
		for (int i = 0; i < arr.length; i++) {
//			arr[i] = (int) (Math.random() * 100);
			arr[i] = rd.nextInt(100);
		}
		System.out.print("정렬하기 전: ");
		printArr(arr);
		System.out.print("오름차순 정렬한 후: ");
		printArr(ascSort(arr));
		System.out.print("내림차순 정렬한 후: ");
		printArr(dscSort(arr));
	}

	public static int[] ascSort(int[] num) {
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num.length - (i + 1); j++) {
				if (num[j] > num[j + 1]) {
					int temp = num[j];
					num[j] = num[j + 1];
					num[j + 1] = temp;
				}
			}
		}
		return num;
	}	

	public static int[] dscSort(int[] num) {
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num.length - (i + 1); j++) {
				if (num[j] < num[j + 1]) {
					int temp = num[j];
					num[j] = num[j + 1];
					num[j + 1] = temp;
				}
			}
		}
		return num;
	}
	
	public static void printArr(int[] arr) {
		for (int k : arr)
			System.out.print(k + " ");
		System.out.println();
	}
}

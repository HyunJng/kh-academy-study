package p01.basic;

public class ArrayBasic2 {
	public static void main(String[] args) {
		int[] arr = new int[6];
		double[] arr2 = new double[4];
		
		for (int i = 0; i < arr.length; i++)
			arr[i] = (i + 1) * 10;
		
		for (int i = 0; i < arr2.length; i++) 
			arr2[i] = (i + 1);
		
		for (int i = 0; i < arr.length; i++)
			System.out.println("arr[" + i + "] : " + arr[i]);

		for (int i = 0; i < arr2.length; i++)
			System.out.println("arr2[" + i + "] : " + arr2[i]);
		
		for(int k : arr)
			System.out.println("arr의 값: " + k);
		
	}
}
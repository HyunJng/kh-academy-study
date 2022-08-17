package p04.practice_callbyvalue;

public class TestCallByValue {
	public static void main(String[] args) {
		
		int n1 = 10;
		int n2 = 4;
		
		System.out.println("main method -swap전 n1= " + n1 + ", n2= " + n2);
		swap(n1, n2);
		System.out.println("main method -swap후 n1= " + n1 + ", n2= " + n2);
		
	}
	public static void swap(int n1, int n2) {
		
		System.out.println("swap method -swap전 n1= " + n1 + ", n2= " + n2);
		
		int temp = n1;
		n1 = n2;
		n2 = temp;
		
		System.out.println("swap method -swap전 n1= " + n1 + ", n2= " + n2);
	}
}

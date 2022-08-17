package p01.basic;

public class ArrayBasic4 {
	public static void main(String[] args) {
		double[] myList = new double[10];
		
		for(int i = 0 ;i<myList.length; i++)
			myList[i] = Math.random() * 100;
		
		for(double k : myList)
			System.out.println(k);
	}
}

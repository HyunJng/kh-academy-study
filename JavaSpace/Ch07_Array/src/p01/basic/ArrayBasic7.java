package p01.basic;


public class ArrayBasic7 {
	public static void main(String[] args) {
		double[] myList = new double[10];
		
		for(int i = 0 ;i<myList.length; i++)
			myList[i] = Math.random() * 100;
		
//		for(double k : myList)
//			System.out.println(k);
		
		double max = myList[0];
		for(double k : myList) {
			if(max < k)
				max = k;
		}
		
		System.out.println("max : " + max);
	}
}

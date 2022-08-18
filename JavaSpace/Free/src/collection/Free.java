package collection;

public class Free {
	public static void main(String[] args) {
		
		int x = 5;
		int y = 5;
		int z;
//		z = y++ - 5;
//		System.out.println(z+" "+y);
		z = (x++) - (++x);//6 - 6 7
		System.out.println(x);
//		System.out.println(y);
		System.out.println(z);
//		5 - 6 = -1
	}
}

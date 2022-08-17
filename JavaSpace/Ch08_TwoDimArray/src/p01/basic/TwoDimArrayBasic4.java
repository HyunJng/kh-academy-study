package p01.basic;

public class TwoDimArrayBasic4 {

	public static void main(String[] args) {

		int[][] num;
		
		num = new int[4][];
		
		num[0] = new int[1];
		num[1] = new int[2];
		num[2] = new int[3];
		num[3] = new int[4];
		
		for(int i = 0 ;i<num.length; i++) {
			for(int j = 0;j<num[i].length; j++) {
				num[i][j] = i * num[i].length + j;
				System.out.print(num[i][j] + " ");
			}
			System.out.println();
		}
	}

}

package q4.ch11_no08;

import java.util.StringTokenizer;

public class SplitEx {
	public static void main(String[] args) {
		String str = "아이디,이름,패스워드";
		
		String[] arr = str.split(",");
		for(int i = 0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println();
		
		StringTokenizer arr2 = new StringTokenizer(str, ",");
		
		while(arr2.hasMoreTokens()) {
			System.out.println(arr2.nextToken());
		}
	}
	
}

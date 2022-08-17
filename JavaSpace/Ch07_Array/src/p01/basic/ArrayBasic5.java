package p01.basic;


// String 과 char[] 는 data type이 다르다.
// C language는 String 없음.
public class ArrayBasic5 {
	public static void main(String[] args) {
		 String city = "Dallas";
		 char city2[] = {'D', 'a', 'l', 'l', 'a', 's'};
		 
		 for(int i = 0; i<city.length(); i++)
			 System.out.println(city.charAt(i));
		 
		 System.out.println();
		 
		 for(char c: city2)
			 System.out.println(c);
	}
}

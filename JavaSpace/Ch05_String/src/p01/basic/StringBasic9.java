package p01.basic;

//문자열에서 찾고자 하는 문자열 또는 문자열의 시작 index 가져오기
//1. indexOf(char 또는 String, startIdx)
//	- startIdx부터 시작하여 찾고자하는 문자열이나 문자가 있으면 그 문자의 시작idx를 가져옴.
// 	- 단, startIdx가 지정되지 않으면 0부터 시작.
// 	- 찾는 문자가 없으면 -1 반환.

//2. lastIndexOf(char 또는 String, startIdx)
//	- 문자열의 끝 index부터 탐색 시작
public class StringBasic9 {
	public static void main(String[] args) {
		System.out.println("Welcome to Java".indexOf('W'));
		System.out.println("Welcome to Java".indexOf('o'));
		System.out.println("Welcome to Java".indexOf('o', 5));
		System.out.println("Welcome to Java".indexOf("come"));
		System.out.println("Welcome to Java".indexOf("comet"));
		System.out.println("Welcome to Java".indexOf("Java", 5));
		System.out.println("Welcome to Java".indexOf("java", 5));
		System.out.println("Welcome to Java".toUpperCase().indexOf("JAVA", 5));
		
		System.out.println();
		
		System.out.println("Welcome to Java".lastIndexOf('W'));
		System.out.println("Welcome to Java".lastIndexOf('o'));
		System.out.println("Welcome to Java".lastIndexOf('o', 5));
		System.out.println("Welcome to Java".lastIndexOf("come"));
		System.out.println("Welcome to Java".lastIndexOf("comet"));
		System.out.println("Welcome to Java".lastIndexOf("Java", 5));
		System.out.println("Welcome to Java".lastIndexOf("java", 5));
		System.out.println("Welcome to Java".toUpperCase().lastIndexOf("JAVA", 5));
	}
}

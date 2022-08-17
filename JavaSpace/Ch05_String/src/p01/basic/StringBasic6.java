package p01.basic;

// 문자열 내용 비교하기 : s1.equals(s2)
// 같으면 true, 다르면 false 리턴
// s1.toUpperCase()는 String 리턴.
public class StringBasic6 {
	public static void main(String[] args) {
		String s1 = "Welcome to Java";
		String s2 = "Welcome to Java";
		String s3 = "welcome to java";
		
		if(s1.equals(s2)) {
			System.out.println("s1과 s2내용이 같다.");
		}else System.out.println("s1과 s2내용이 같지 않다.");
		
		if(s1.toUpperCase().equals(s3.toUpperCase())) {
			System.out.println("s1과 s3 내용의 대문자 버전이 같다.");
		}else System.out.println("s1과 s2내용이 같지 않다.");
	}
}

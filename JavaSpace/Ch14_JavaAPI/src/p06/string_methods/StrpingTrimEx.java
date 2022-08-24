package p06.string_methods;

// trim() : 문자열의 앞 뒤의 공백(space)을 제거하는 메서드.
public class StrpingTrimEx {
	public static void main(String[] args) {
		String tel1 = "    02";
		String tel2 = "123         ";
		String tel3 = "     1234   	";
		
		String tel = tel1 + tel2+ tel3;
		System.out.println(tel);
		
		tel = tel1.trim() + tel2.trim() + tel3.trim();
		System.out.println(tel);
	}
}

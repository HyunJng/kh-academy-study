package p07.string_tokenizer;

// 문자열 분할
// "&|,|-"  => & or , or -

public class StringSplitEx {
	public static void main(String[] args) {
		String text = "홍길동&이수용,박연수,김자바-최숳용";
		String[] names = text.split("&|,|-");
		
		for(String name: names) {
			System.out.println(name);
		}
	}
}

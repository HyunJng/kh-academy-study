package p07.string_tokenizer;

import java.util.StringTokenizer;
// nextToken() : 메모리에서 해당 데이터를 읽고 제거하는 메서드;
// => Oracle 등 table 에서 데이터를 읽어오거나, collection에서 등 framework에서도 사용.
public class StringTokenizerEx {
	public static void main(String[] args) {
		String text = "홍길동/이수홍/박연수";
		StringTokenizer st = new StringTokenizer(text, "/");
		
		int lenth = st.countTokens();
		for(int i = 0 ;i<lenth; i++) {
			String token = st.nextToken();
			System.out.println(token);
		}
		
		System.out.println();
		
		st = new StringTokenizer(text, "/");
		while(st.hasMoreElements()) {
			String token = st.nextToken();
			System.out.println(token);
		}
	}
}

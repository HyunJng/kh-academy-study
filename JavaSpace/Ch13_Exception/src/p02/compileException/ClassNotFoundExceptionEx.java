package p02.compileException;

//Compile Exception 처리 방법
// - 프로그램 소스코드 안에 전체적으로 try ~ catch 문법을 만들어서 사용해야함.
public class ClassNotFoundExceptionEx {
	public static void main(String[] args) {
		
		try {
			// cls에 java.lang.String 클래스의 field, constructor, method관련 정보를 갖고 있는 instance
			// forName 메서드에서 parameter로 넘겨온 class가 없으면 ClassNotFoundException 인스턴스 발생
			Class  cls = Class.forName("java.lang.String");
			System.out.println("클래스가 존재합니다.");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("클래스가 존재하지 않습니다.");
		}
	}
}

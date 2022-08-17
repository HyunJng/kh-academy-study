package p05.local_variable_scope;

// 변수의 live cycle(생명주기) : 변수가 생성, 사용, 소멸되는 과정
// 1. 변수는 메모리에 있을 경우에만 존재(읽기, 쓰기 가능)
// 2. Java에서 변수의 생명주기는 변수가 생성된 {} 에서만 존재.

public class LocalVariableScopeEx {
	public static void main(String[] args) {
		int parentNum = 20;

		if (parentNum > 10) {
			int childNum = parentNum - 10;
			System.out.println("parentNum = " + parentNum);
			System.out.println("childNum = " + childNum);
		}
	}
}

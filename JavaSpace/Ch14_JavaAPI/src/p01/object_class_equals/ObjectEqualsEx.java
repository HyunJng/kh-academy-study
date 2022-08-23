package p01.object_class_equals;

// 1. Object class equals메서드 동작 방식
// 	-> '==' 연산자와 같은 결과를 도출
// 2. String class의 equals 메서드는 오버라이딩되어 문자열 내용이 같으면 true를 return 함.
// 
public class ObjectEqualsEx {
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		int x = 10;
		int y = 10;
		String name1 = new String("홍길동");
		String name2 = new String("홍길동");
		String name3 = "홍길동";
		String name4 = "홍길동";	//String literal인 경우는 자바가 heap메모리에 한개만 만들어 놓음
		
		System.out.println(System.identityHashCode(obj1));
		System.out.println(System.identityHashCode(obj2));
		
		boolean result = obj2.equals(obj2);
		System.out.println("result : " + result);
		
		result = (obj1 == obj2);
		System.out.println("result : "+ result);
		
		result = (x == y);
		System.out.println("result : "+ result);

		result = name1.equals(name2);
		System.out.println("result : "+ result);
		
		result = (name1 == name2);
		System.out.println("result : "+ result);
		
		result = name3.equals(name4);
		System.out.println("result : "+ result);
		
		result = (name3 == name4);
		System.out.println("result : "+ result);
		
	}
}

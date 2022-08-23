package p02.object_class_tostring;

import java.util.Date;
import java.util.Objects;

//println(obj)인 경우는 obj가 class의 인스턴스라면, obj.toString() 실행
// 1. Object class의 toString의 결과
// - package 명 + class 이름 + @ + 힙메모리주소
// 2. String, Date class는 Object class의 toString읠 오버라이드.
public class ToStringEx {
	public static void main(String[] args) {
		Object obj = new Object();
		String name = "홍길동";
		Date  date = new Date();
		
		System.out.println(Objects.hash(obj));
		System.out.println(System.identityHashCode(obj));	//힙메모리주소 출력값(deci)
		System.out.println(System.identityHashCode(obj.toString()));
		System.out.println(obj.toString());	//힙메모리주소 추력값(Hex)
		System.out.println(obj);
		
		System.out.println(name.toString());
		System.out.println(name);
		
		System.out.println(date.toString());
		System.out.println(date);
	}
}

package p11.wrapper_class;

import java.util.Comparator;

// primitive 값이 통일하더라도 Wrapper class로 변환한 후에는 힙메모리에 인스턴스로 별도로 생성딤.
// Wrapper class 의 instance 값을 비교하는 방법
// 1) primitive로 변환하여 비교
// 2) wrapper class의 equals() 메서드 사용
public class ValueCompareEx {
	public static void main(String[] args) {
		Integer obj1 = 300;	// auto boxing할 때 자동으로 힙메모리에 인스턴스 새로 생성.
		Integer obj2 = 300;
		
		System.out.println("obj1 == obj2 : " + (obj1 == obj2));
		System.out.println("unboxing 후 obj1 == obj2 : " + (obj1.intValue() == obj2.intValue()));
		System.out.println("(obj1.equals(obj2) : " + (obj1.equals(obj2)));
		
	}
}

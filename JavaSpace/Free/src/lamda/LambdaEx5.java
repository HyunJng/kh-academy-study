package lamda;

import java.util.*;
import java.util.function.*;

public class LambdaEx5 {
	public static void main(String[] args) {
		Supplier<Integer> s = () -> (int)(Math.random() * 100) + 1;
		Consumer<Integer> c = i -> System.out.print(i + ", "); 
		Predicate<Integer> p = i -> i%2 == 0;
		Function<Integer, Integer> f = i -> i/10 * 10; // 1의 자리를 삭제.
		
		List<Integer> list = new ArrayList<Integer>();
		makeRandomList(s, list);
		System.out.println(list);
		printEvenNum(p, c, list);
		List<Integer> newList = doSomething(f, list);
		System.out.println(newList);
		
	}
	
	public static <T> void makeRandomList(Supplier<T> s, List<T> list) {
		// supplier : return값만 존재
		for(int i = 0; i<10; i++)
			list.add(s.get());	// return값만 필요하므로 Supplier사용
	}
	
	public static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
		System.out.print("[");
		for(T t : list)
			if(p.test(t))
				c.accept(t);
		System.out.println("]");
	}
	
	public static <T> List<T> doSomething(Function<T, T> f, List<T> list){
		List<T> newList = new ArrayList<T>();
		
		for(T i: list) {
			newList.add(f.apply(i));
		}
		return newList;
	}
}

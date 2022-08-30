package collection;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Free{
	public static void main(String[] args) {
		List<String> list = Arrays.asList("aaa","ccc","abc","ddd");
		
//		Collections.sort(list, new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return o1.compareTo(o2);
//			}
//		});
		
		Collections.sort(list, (o1, o2) -> o2.compareTo(o1));
		System.out.println(list);
		
//		Function<String, Integer> f1 = (String s) -> Integer.parseInt(s);
		Function<String, Integer> f1 = Integer::parseInt;
		
		BiFunction<String, String, Boolean> f2 = String::equals;
		System.out.println(f2.apply("aaa", "aaa"));
	}
}
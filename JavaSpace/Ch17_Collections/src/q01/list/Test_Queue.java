package q01.list;

import java.util.*;
public class Test_Queue {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		
		queue.add("JAVA");
		queue.add("SCRIPT");
		queue.add("JSP");
		
		while(!queue.isEmpty())
			System.out.println(queue.remove());
	}
}

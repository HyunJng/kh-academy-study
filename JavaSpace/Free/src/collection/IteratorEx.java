package collection;
import java.util.Iterator;
import java.util.Vector;

public class IteratorEx {
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();
		
		v.add(4);
		v.add(2);
		v.add(1);
		v.add(1, 3);
		
		Iterator<Integer> it = v.iterator(); // Iterator객체 얻기
		while(it.hasNext()) {	//vector의 방문할 요소가 있으면 true
			int n = it.next();
			System.out.print(n + " ");
		}

	}
}

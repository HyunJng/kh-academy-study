package p01.vector_ex2;

import java.util.*;

public class PointVectorEx {
	public static void main(String[] args) {
		Vector<Point> pv = new Vector<Point>();

		pv.add(new Point(1, 3));
		pv.add(new Point(5, -8));
		pv.add(new Point(3, 2));
		pv.add(new Point(-5, 20));

		for (Point p : pv) {
			System.out.println(p);
		}
		System.out.println();
		pv.remove(1);

		for (int i = 0; i < pv.size(); i++)
			System.out.println(pv.get(i));

		if(pv.contains(new Point(1, 3))) {
			System.out.println(pv.indexOf(new Point(1,  3)));
		}
	}
}

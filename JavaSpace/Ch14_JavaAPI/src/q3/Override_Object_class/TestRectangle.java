package q3.Override_Object_class;

public class TestRectangle {
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(3, 4);
		Rectangle r2 = new Rectangle(3, 4);
		Rectangle r3 = new Rectangle(3, 5);
		
		if(r1.equals(r2)){
			System.out.println("r1과 r2는 같은 도형");
		}else {
			System.out.println("r1과 r2는 다른 도형");
		}

		if(r1.equals(r3)){
			System.out.println("r1과 r3는 같은 도형");
		}else {
			System.out.println("r1과 r3는 다른 도형");
		}
		System.out.println();
		System.out.println("[r1의 정보]");
		System.out.println(r1);
		System.out.println("[r2의 정보]");
		System.out.println(r2);
		System.out.println("[r3의 정보]");
		System.out.println(r3);
	}
		
	}

package collection;

public class Anoymous {
	public static void main(String[] args) {
		
		Rectangle a = new Rectangle();
		
		Rectangle anonymous1 = new Rectangle() {
			
			@Override
			int get() {
				return width;
			}
		};
		
		System.out.println(a.get());
		System.out.println(anonymous1.get());
	}
	
	static Rectangle anonymous2 = new Rectangle() {
		
		int depth = 30;
		@Override
		int get() {
			return width * height * depth;
		}
	};
}

class Rectangle {
	int width =10;
	int height = 20;
	
	int get() {
		return height;
	}
}

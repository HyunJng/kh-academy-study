package q3.Override_Object_class;

public class Rectangle {
	private int width, height;
	
	public Rectangle() {

	}
	
	public Rectangle(int width, int height) {
		this.height = height;
		this.width = width;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj instanceof Rectangle) {
			Rectangle temp = (Rectangle) obj;
			return (width == temp.width) && (height== temp.height);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "width: "+ width + " height: " + height;
	}
}

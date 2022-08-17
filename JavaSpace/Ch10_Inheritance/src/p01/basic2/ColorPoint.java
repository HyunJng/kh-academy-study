package p01.basic2;

public class ColorPoint extends Point {
	private String color;

	public void setColor(String color) {
		this.color = color;
	}

	public void setColorAndPoint(String color, int x, int y) {
		this.color = color;
		// 자식 클래스에서 부모 필드 사용 가능
		this.x = x;
		this.y = y;
	}

	public void showColorPoint() {
		System.out.print("color : " + color + ",");
		// 자식 클래스에서 부모 클래스 메소드 사용 가능
		showPoint();
	}
}

package p11.practice;

import java.util.Date;

public class GeometricObject {
	private String color = "white";
	private boolean filled;
	private Date dateCreated;
	
	{
		dateCreated = new Date();
	}
	
	public GeometricObject() {
	}
	
	public GeometricObject(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
	}

	
	public Date getDateCreated() {
		return dateCreated;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	// instance에 저장된 현재 상태의 모든 field 정보 제공
	@Override
	public String toString() {
		return "dateCreated : " + dateCreated + "\n color : "
				+ color + ", color filled : " + filled;
	}
}

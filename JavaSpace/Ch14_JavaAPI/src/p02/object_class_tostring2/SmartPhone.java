package p02.object_class_tostring2;

import java.util.Objects;
// toString method사용 목적
// 1. class 를 new로 인스턴스를 만들어 사용할 때, 현재 인스턴스의 모든 field정보를 얻고잫 할 떄 사용
public class SmartPhone {
	private String company;
	private String os;
	
	public SmartPhone(String comparny, String os) {
		this.company = comparny;
		this.os = os;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(company, os);
	}

	@Override
	public String toString() {
		return company + ", " + os;
	}
}

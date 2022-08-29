package p06.generic_inheritance;

// 부모 generic 클래스에서 선언되지 않은 새로운 generic을 추가로 지정이 가능하다.
public class ChildProduct<T, M, C> extends Product<T, M>{
	private C company;

	public C getCompany() {
		return company;
	}

	public void setCompany(C company) {
		this.company = company;
	}
	
}

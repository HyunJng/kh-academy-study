package Q5.q02;

public class Person {
	private String name;
	private String address;
	private String phoneNo;
	private String email;
	
	public Person() {}
	
	public Person(String name, String address, String phoneNo, String email) {
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
	}
	public String toString() {
		return name +"의 주소: "+ address + ", 폰번호 : "+ phoneNo + ", 이메일 : "+email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

package Q5.q02;

public class Student extends Person{
	final static int FRESHMAN = 1, SOPHOMORE = 2, JUNIOR = 3, SENIOR = 4;
	private int status;
	
	public Student(String name, String address, String phone, String email, int status) {
		super(name, address, phone, email);
		this.status = status;
	}

	public String toString() {
		return super.toString() + ", status : "+ status;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}

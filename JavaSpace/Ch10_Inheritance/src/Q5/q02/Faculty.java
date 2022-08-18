package Q5.q02;

public class Faculty extends Employee{
	private String officeHour, rank;
	
	public Faculty(String name, String address, 
				String phone, String email, int office, double salary, String officeHour, String rank) {
		super(name, address, phone, email, office, salary);
		this.officeHour = officeHour;
		this.rank = rank;
	}
	
	public String toString() {
		return super.toString() + ", 근무시간: "+ officeHour + ", 직위: "+ rank;
	}

	public String getOfficeHour() {
		return officeHour;
	}

	public void setOfficeHour(String officeHour) {
		this.officeHour = officeHour;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	
}

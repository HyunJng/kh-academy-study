package member;

import java.util.Date;

/*Java Bean 정의
 * - 순수 자바 클래스로
 * - field들은 private으로 선언
 * - default constructor 가지고 있음
 * - getter/setter method 가짐
*/
public class MemberInfo {
	private String id;
	private String name;
	private Date registerDate;
	private String email;
	
	public MemberInfo() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

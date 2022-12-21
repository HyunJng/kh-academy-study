package user.model;

public class UserVO {
	private String name;
	private String id;
	private String password;
	private String email;
	private String tel;
	private String level;

	public UserVO() {

	}
	public UserVO(String name, String id, String pwd, String email, String tel, String level) {
		this.name = name; this.id = id;
		this.password = pwd; this.email = email;
		this.tel = tel; this.level = level;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
}

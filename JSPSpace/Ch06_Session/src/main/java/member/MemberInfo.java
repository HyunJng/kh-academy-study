package member;

public class MemberInfo {
	private String id;
	private String passwd;
	
	public MemberInfo() {}
	public MemberInfo(String id, String passwd) {
		this.id = id;
		this.passwd = passwd;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
}	

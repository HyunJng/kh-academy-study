package p01.object_class_equals2;

import java.util.Objects;

public class Member {
	public String id;
	
	public Member() {}
	
	public Member(String id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member otherMember = (Member) obj;
			return (this.id.equals(otherMember.id));
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public String toString() {
		return id;
	}
}

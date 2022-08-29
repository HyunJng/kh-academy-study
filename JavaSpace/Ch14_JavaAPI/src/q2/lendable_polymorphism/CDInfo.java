package q2.lendable_polymorphism;

public class CDInfo {
	String registerNo;	//관련번호
	String title; 		//제목
	
	public CDInfo() {
		this("Null", "Null");
	}
	public CDInfo(String title, String registerNo) {
		this.title = title;
		this.registerNo = registerNo;
	}
}

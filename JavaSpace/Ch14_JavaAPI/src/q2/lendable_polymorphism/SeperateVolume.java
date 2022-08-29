package q2.lendable_polymorphism;

public class SeperateVolume implements Lendable{
	String requestNo;	//청구번호
	String bookTitle; 	//제목
	String writer; 		//저자
	String borrower;	//대출인
	String checkOutDate;//대출일
	byte state;			//대출상태
	
	public SeperateVolume() {
		this("Null", "Null", "Null");
	}
	public SeperateVolume(String bookTitle) {
		this(bookTitle, "Null", "Null");
	}
	public SeperateVolume(String bookTitle, String requestNo, String writer) {
		this.bookTitle = bookTitle;
		this.requestNo = requestNo;
		this.writer = writer;
	}
	@Override
	public void checkOut(String borrower, String date) {
		if(state != 0)
			return;
		this.borrower = borrower;
		this.checkOutDate = date;
		this.state = 1;
		
		System.out.println("* " + bookTitle + "이(가) 대출되었습니다.");
		System.out.println("대출인: " + borrower);
		System.out.println("대출일: " + date + "\n");
	}
	
	@Override
	public void checkIn() {
		this.borrower = null;
		this.checkOutDate = null;
		this.state = 0;
		
		System.out.println("* " + bookTitle + "이(가) 반납되었습니다.\n");
	}
	
}

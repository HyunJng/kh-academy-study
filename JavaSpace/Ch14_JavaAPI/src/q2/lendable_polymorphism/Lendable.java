package q2.lendable_polymorphism;

public interface Lendable {
	void checkOut(String borrower, String date); //대출
	void checkIn(); //반납
}

package Q5.q03;

public class PolyMain {
	public static void main(String[] args) {
		Account obj1 = new Account("111-22-3333", "임꺽정", 10000);
		CheckingAccount obj2 = new CheckingAccount("444-55-666", "홍길동", 20000, "5555-666-777-888");
		CreditLineAccount obj3 = new CreditLineAccount("777-22-333", "김선달", 3000, 2000000);
		BonusPointAccount obj4 = new BonusPointAccount("000-00-00000", "김미영", 0, 0);
		
		printAccountInfo(obj1);
		printAccountInfo(obj2);
		printAccountInfo(obj3);
		printAccountInfo(obj4);
		
	}
	
	static void printAccountInfo(Account obj) {
		System.out.println(obj);
	}
}

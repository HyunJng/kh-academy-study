package p06.user_defined_exception;

// Account : 은행 계좌 잔고 관리 클래스
public class Account {
	private long balance;	// 잔고
	
	public Account() {}

	public long getBalance() {
		return balance;
	}
	
	public void deposit(int money) {
		balance += money;
	}
	public void withdraw(int money) throws BalanceInsufficientException {
		if(balance >= money)
			balance -= money;
		else 
			throw new BalanceInsufficientException("잔고부족 : "+ (money- balance )+" 부족");
	}	
}

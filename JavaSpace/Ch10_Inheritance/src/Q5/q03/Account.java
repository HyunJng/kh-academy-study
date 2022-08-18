package Q5.q03;

public class Account {
	String accountNo;
	String ownerName;
	public int balance;
	
	public Account() {}
	
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	public void deposit(int amount) {
			balance += amount;
	}
	
	public int withdraw(int amount) throws Exception {
		if(balance <amount)
			throw new Exception("잔액이 부족합니다.");
		else 
			balance -= amount;
		
		return amount;	// 돈 뽑은 거니까 돈 나와야 하는 건가???
	}
	
	public String toString() {
		return "계좌번호 :" + accountNo +"\n"
				+ "예금주 : "+ ownerName + "\n"
				+ "잔액 : "+ balance +"\n";
	}
}

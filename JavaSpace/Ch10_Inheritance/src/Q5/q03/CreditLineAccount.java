package Q5.q03;

public class CreditLineAccount extends Account{
	public int creditLine;	//신용한도
	
	public CreditLineAccount(String accountNo, String ownerName, int balance, int creditLine) {
		super(accountNo, ownerName, balance);
		this.creditLine = creditLine;
	}
	
	@Override
	public int withdraw(int amount) throws Exception {
		if((balance + creditLine) <amount)
			throw new Exception("인출이 불가능합니다.");
		else if(balance <amount) {
			creditLine += (balance - amount);
			balance = 0;
		}else balance -= amount;
		
		return amount; 
	}
}

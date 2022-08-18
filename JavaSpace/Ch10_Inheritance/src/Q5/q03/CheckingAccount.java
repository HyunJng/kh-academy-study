package Q5.q03;

public class CheckingAccount extends Account{
	String carNo;
	
	public CheckingAccount(String accountNo, String ownerName, int balance,  String carNo) {
		super(accountNo, ownerName, balance); 
		this.carNo = carNo;
	}
	
	int pay(String carNo, int amount) throws Exception {
		if(!carNo.equals(this.carNo) || balance <amount)
			throw new Exception("지불이 불가능합니다.");
		return withdraw(amount);
	}
}

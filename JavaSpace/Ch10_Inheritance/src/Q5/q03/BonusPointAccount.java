package Q5.q03;

public class BonusPointAccount extends Account{
	int bonusPoint;
	
	public BonusPointAccount(String accountNo, String ownerName, int balance, int bonusPoint) {
		super(accountNo, ownerName, balance);
		this.bonusPoint = bonusPoint;
	}
	
	public void deposit(int amount) {
		balance += amount;
		super.deposit(amount);
		bonusPoint += (int)(amount* 0.001 );
	}
}

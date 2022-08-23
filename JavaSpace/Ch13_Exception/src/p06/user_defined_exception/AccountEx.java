package p06.user_defined_exception;

public class AccountEx {
	public static void main(String[] args) {
		Account account = new Account();
		
		// 예금;
		account.deposit(10000);
		System.out.println("예금액 : "+ account.getBalance());
		
		// 출금;
		try {
			account.withdraw(30000);
		} catch (BalanceInsufficientException e) {
			String message = e.getMessage();
			System.out.println(message);
		}
		
//		try {
//			account.withdraw(20000);
//		} catch (BalanceInsufficientException e) {
//			e.printStackTrace();
//		}
	}
}

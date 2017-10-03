
public class Account {
	
	float balance;
	String date;
	int notifications;
	
	private String accountBalance(int accountNumber) {
		String accountBal = "Your account balance is %f" + balance;
		return accountBal;
	}
	
	private String creationDate(int accountNumber) {
		String createDate = "Your account was created on %s" + date;
		return createDate;
	}
	
	private String lastAccessed(int accountNumber) {
		String lastAccess = "Your account was last accessed %s" + date;
		return lastAccess;
	}
	
	private String printNotifications(int accountNumber) {
		String printNot = "You have %i notifications", notifications;
		return printNot;
	}
	
}

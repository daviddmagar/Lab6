
public class Customer {
	String custName, phone, card, address;
	
	private String name(int accountNumber) {
		String nameReturn = "Your name is %s" + custName;
		return nameReturn;
	}
	
	private String address(int accountNumber) {
		String addressReturn = "Your address is %s" + address;
		return addressReturn;
	}
	
	private String phonenum(int accountNumber) {
		String phoneReturn = "Your phone number is %s" + phone;
		return phoneReturn;
	}
	
	private String creditCard(int accountNumber) {
		String cardReturn = "Your card number is %s" + card;
		return cardReturn;
	}

}

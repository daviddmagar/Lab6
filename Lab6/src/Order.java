
public class Order {

	String date;
	int orderNum;

	private String getCreationDate(int orderNumber) {
		String doc = "Order date is: %s" + date;
		return doc;
	}

	private String printShipDate(int orderNumber) {
		String shipped = "Order shipped on %s" + date;
		return shipped;
	}
	
	private String estimatedDelivery(int orderNumber) {
		String estDelivery = "Order should arrive on %s" + date;
		return estDelivery;
	}
	
	private String lastOrderNum(int customerNum) {
		String lastOrder = "Your last order was %i " + orderNum;
		return lastOrder;
	}

}

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/


import java.util.*;

// line 22 "lab6.ump"
public class Account
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Account Attributes
  private float balance;
  private String date;
  private int notifications;

  //Account Associations
  private Customer customer;
  private List<Order> orders;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Account(float aBalance, String aDate, int aNotifications, Customer aCustomer)
  {
    balance = aBalance;
    date = aDate;
    notifications = aNotifications;
    if (aCustomer == null || aCustomer.getAccount() != null)
    {
      throw new RuntimeException("Unable to create Account due to aCustomer");
    }
    customer = aCustomer;
    orders = new ArrayList<Order>();
  }

  public Account(float aBalance, String aDate, int aNotifications, String aCustNameForCustomer, String aPhoneForCustomer, String aCardForCustomer, String aAddressForCustomer)
  {
    balance = aBalance;
    date = aDate;
    notifications = aNotifications;
    customer = new Customer(aCustNameForCustomer, aPhoneForCustomer, aCardForCustomer, aAddressForCustomer, this);
    orders = new ArrayList<Order>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setBalance(float aBalance)
  {
    boolean wasSet = false;
    balance = aBalance;
    wasSet = true;
    return wasSet;
  }

  public boolean setDate(String aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setNotifications(int aNotifications)
  {
    boolean wasSet = false;
    notifications = aNotifications;
    wasSet = true;
    return wasSet;
  }

  public float getBalance()
  {
    return balance;
  }

  public String getDate()
  {
    return date;
  }

  public int getNotifications()
  {
    return notifications;
  }

  public Customer getCustomer()
  {
    return customer;
  }

  public Order getOrder(int index)
  {
    Order aOrder = orders.get(index);
    return aOrder;
  }

  public List<Order> getOrders()
  {
    List<Order> newOrders = Collections.unmodifiableList(orders);
    return newOrders;
  }

  public int numberOfOrders()
  {
    int number = orders.size();
    return number;
  }

  public boolean hasOrders()
  {
    boolean has = orders.size() > 0;
    return has;
  }

  public int indexOfOrder(Order aOrder)
  {
    int index = orders.indexOf(aOrder);
    return index;
  }

  public static int minimumNumberOfOrders()
  {
    return 0;
  }

  public Order addOrder(int aOrderNumber, int aCustomerNum)
  {
    return new Order(aOrderNumber, aCustomerNum, this);
  }

  public boolean addOrder(Order aOrder)
  {
    boolean wasAdded = false;
    if (orders.contains(aOrder)) { return false; }
    Account existingAccount = aOrder.getAccount();
    boolean isNewAccount = existingAccount != null && !this.equals(existingAccount);
    if (isNewAccount)
    {
      aOrder.setAccount(this);
    }
    else
    {
      orders.add(aOrder);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOrder(Order aOrder)
  {
    boolean wasRemoved = false;
    //Unable to remove aOrder, as it must always have a account
    if (!this.equals(aOrder.getAccount()))
    {
      orders.remove(aOrder);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addOrderAt(Order aOrder, int index)
  {  
    boolean wasAdded = false;
    if(addOrder(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOrderAt(Order aOrder, int index)
  {
    boolean wasAdded = false;
    if(orders.contains(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOrderAt(aOrder, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Customer existingCustomer = customer;
    customer = null;
    if (existingCustomer != null)
    {
      existingCustomer.delete();
    }
    for(int i=orders.size(); i > 0; i--)
    {
      Order aOrder = orders.get(i - 1);
      aOrder.delete();
    }
  }

  // line 31 "lab6.ump"
   private String accountBalance(){
    
  }

  // line 34 "lab6.ump"
   private String creationDate(){
    
  }

  // line 37 "lab6.ump"
   private String lastAccessed(){
    
  }

  // line 40 "lab6.ump"
   private String printNotifications(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "balance" + ":" + getBalance()+ "," +
            "date" + ":" + getDate()+ "," +
            "notifications" + ":" + getNotifications()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "customer = "+(getCustomer()!=null?Integer.toHexString(System.identityHashCode(getCustomer())):"null");
  }
}
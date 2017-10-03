/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/



// line 1 "lab6.ump"
public class Customer
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Customer Attributes
  private String custName;
  private String phone;
  private String card;
  private String address;

  //Customer Associations
  private Account account;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Customer(String aCustName, String aPhone, String aCard, String aAddress, Account aAccount)
  {
    custName = aCustName;
    phone = aPhone;
    card = aCard;
    address = aAddress;
    if (aAccount == null || aAccount.getCustomer() != null)
    {
      throw new RuntimeException("Unable to create Customer due to aAccount");
    }
    account = aAccount;
  }

  public Customer(String aCustName, String aPhone, String aCard, String aAddress, float aBalanceForAccount, String aDateForAccount, int aNotificationsForAccount)
  {
    custName = aCustName;
    phone = aPhone;
    card = aCard;
    address = aAddress;
    account = new Account(aBalanceForAccount, aDateForAccount, aNotificationsForAccount, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCustName(String aCustName)
  {
    boolean wasSet = false;
    custName = aCustName;
    wasSet = true;
    return wasSet;
  }

  public boolean setPhone(String aPhone)
  {
    boolean wasSet = false;
    phone = aPhone;
    wasSet = true;
    return wasSet;
  }

  public boolean setCard(String aCard)
  {
    boolean wasSet = false;
    card = aCard;
    wasSet = true;
    return wasSet;
  }

  public boolean setAddress(String aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public String getCustName()
  {
    return custName;
  }

  public String getPhone()
  {
    return phone;
  }

  public String getCard()
  {
    return card;
  }

  public String getAddress()
  {
    return address;
  }

  public Account getAccount()
  {
    return account;
  }

  public void delete()
  {
    Account existingAccount = account;
    account = null;
    if (existingAccount != null)
    {
      existingAccount.delete();
    }
  }

  // line 10 "lab6.ump"
   private String name(){
    
  }

  // line 13 "lab6.ump"
   private String address(){
    
  }

  // line 16 "lab6.ump"
   private String phoneNum(){
    
  }

  // line 19 "lab6.ump"
   private String creditCard(){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "custName" + ":" + getCustName()+ "," +
            "phone" + ":" + getPhone()+ "," +
            "card" + ":" + getCard()+ "," +
            "address" + ":" + getAddress()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "account = "+(getAccount()!=null?Integer.toHexString(System.identityHashCode(getAccount())):"null");
  }
}


/**
 * 
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * 
 * Modified by Louis Symons
 * 09/10/2020
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    //coin refernce 
    private Coin coin;
    //Ticket type
    private Ticket aylesburyTicket;
    //Ticket type
    private Ticket amershamTicket;
    //Ticket type
    private Ticket highWycombeTicket;
    //Ticket type
    private Ticket issuedTicket;
    
    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine(int price)
    {
         price = price;
         Ticket aylesburyTicket=new Ticket("Aylesbury", 220);
         Ticket amershamTicket=new Ticket("Amersham" , 300);
         Ticket highWycombeTicket=new Ticket("High Wycombe" , 330);
         
        
         

    }
    
   
    public void purchaseTicket(String destination)
    
    //select ticket at set price.
    {
    if (destination.equals("Aylesbury")) 
    
    
        if (balance<220){
      System.out.println("Please"+ "insert" + (220 - balance)
            + "more cents");
                        }
        else{
     System.out.println("Payment Sucessful Thankyou");
            aylesburyTicket.printTicket();
            balance = balance - 220;
            }
            
    if (destination.equals("Amersham")) 
    
    
     if (balance<220){
     System.out.println("Please"+ "insert" + (220 - balance)
            + "more cents");
                        }
    else{
    System.out.println("Payment Sucessful Thankyou");
    amershamTicket.printTicket();
    balance = balance - 220;
            }

    if (destination.equals("High Wycombe")) 
    
    
        if (balance<220){
            System.out.println("Please"+ "insert" + (220 - balance)
            + "more cents");
                        }
        else{
            System.out.println("Payment Sucessful Thankyou");
            highWycombeTicket.printTicket();
            balance = balance - 220;
            }
    }        
    public static void insertCoin(String Coin)
    
    {
       String s1="1p";
       String s2="10p";
       String s3="50p";
       String s4="£1";
       String s5="£2";
       System.out.println("You Have Entered" +  s1);
       System.out.println("You Have Entered" +  s2);
       System.out.println("You Have Entered" +  s3);
       System.out.println("You Have Entered" +  s4);
       System.out.println("You Have Entered" +  s5);
   
    }
    
     /**
     * 
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) 
        {
            balance = balance + amount;
        }
        else 
        {
            System.out.println("Use a positive amount rather than: " +
                               amount);
        }
    }
    


    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
    
    /**
     * Empty the machine of money.
     * Machine balance should be cleared.
     */
    public void total ()
    
    {
         int total = 0;
        
    }
}


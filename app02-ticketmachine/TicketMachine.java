

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
    public Ticket aylesburyTicket;
    //Ticket type
    private Ticket amershamTicket;
    //Ticket type
    private Ticket highWycombeTicket;
    //Ticket type
    private Ticket issuedTicket;
    
    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine()
    {
         balance = 0;
         total = 0;
         createTicket();
  
    }
    
    public  void createTicket()
    {
        amershamTicket = new Ticket("Amersham" , 300);
        aylesburyTicket = new Ticket("Aylesbury" , 200);
        highWycombeTicket = new Ticket("High Wycombe" , 330);
     
    }
    
      /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        
     if(balance >= price) 
     {
            // Simulate the printing of a ticket.


            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the price.
            balance = balance - price;
        }
        else 
        {
            System.out.println("You must insert at least: " +
                               (price - balance) + " more cents.");
     }
                    
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


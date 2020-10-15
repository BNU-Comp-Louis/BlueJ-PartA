

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
    //Ticket type "destination"
    private Ticket amershamTicket;
    //Ticket type "destination"
    private Ticket highWycombeTicket;
  
    
    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine()
    {
         balance = 0;
         total = 0;
         createTickets();
  
    }
    
    /**
     * Tickets created 
     */
    private void createTickets()
    {
        amershamTicket = new Ticket("Amersham" , 300);
        aylesburyTicket = new Ticket("Aylesbury" , 220);
        highWycombeTicket = new Ticket("High Wycombe" , 330);
     
    }
    
    public void insert10p()
    {//Insert money method 
        balance = balance + 10;
    }
    
    public void insert20p()
    {//Insert money method 
        balance = balance + 20;
    }
    
    public void insert100p()
    {//Insert money method 
        balance = balance + 100;
    }
    
    public void insert200p()
    {//Insert money method 
        balance = balance + 200;
        
    }
    
    public void selectTicket(String destination)
    {
        if (destination.equals ("Amersham"))
        {
            if (balance<300)
            {
                System.out.println("Please Insert" +(300- balance) + 
                "more pence");
            }
            else
            {
                System.out.println("Your Transation has been approved");
                amershamTicket.print();
                balance = balance - 300;
                
            } 
        }
        if (destination.equals ("Aylesbury"))
        {
            if (balance<220)
            {
                System.out.println("Please Insert" + (220 - balance) +
                "more pence");
            }
            else
            {
                System.out.println("Your Transation has been approved");
                aylesburyTicket.print();
                balance = balance - 220;
            }
        }
        if (destination.equals ("High Wycombe"))
        {
            if (balance<330)
            {
                System.out.println("Please Insert" + (330 - balance) +
                "more pence");
            }
            else
            {
                System.out.println("Your Transation has been approved");
                highWycombeTicket.print();
                balance = balance - 330;
            }
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
    
    /**
     * Method to print all available desitnations and the heading of Ticket
     */
    public void printAllAvavilableTickets()
    {
        printHeading();
        amershamTicket.print();
        aylesburyTicket.print(); 
        highWycombeTicket.print();
        printMessage();
    }   
    
    /**
     * Heading of Ticket 
     */
    public void printHeading()
    {
        System.out.println("####Destinination Request####");
        System.out.println("We have Three avavilble destintaions");
        System.out.println("See Availble Tickets Below:");
    }
        
    /**
     * Ending Print Line 
     */    
    public void printMessage()
    {
        System.out.println("Thankyou for choosing TicketMachine");
    }
   
    
}


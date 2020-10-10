/**
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
    
    private Ticket ticket;
    
    private Ticket aylesburyTicket;
    
    private Ticket amershamTicket;
    
    private Ticket highWycombeTicket;
    
    private Ticket issuedTicket;

    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine(int cost)
    {
        /*
         * Aylesbury costing 220
         * Amersham costing  300
         * High Wycombe costing 330
         */   
             price = cost; // cost is a parameter, what is used to call Ticketmachiene i.e Ticketmachiene(400), will be the price
             balance = 0; // we don't do anything with this yet
             total = 0; // we don't do anythign with this yet
             
             // define new tickets with prices and names
             aylesburyTicket = new Ticket("Aylesbury", 220);
             amershamTicket = new Ticket("Amersham", 300);
             highWycombeTicket = new Ticket("High Wycombe", 330);
             
             
             // create conditional checks to decide which ticket shoud be issued
                 if(price  == 220){
                 issuedTicket = aylesburyTicket; // if price == 220, its for aylesbury
                }
                else if(price  == 300){
                    issuedTicket = amershamTicket;// if price == 300, its for amersham
                }
                else if(price  == 330){
                    issuedTicket = highWycombeTicket; // if price == 330, its for wycombe,
                }
                else{
                    issuedTicket = null; // if its not any of the other values, the ticket is void.
                }
    }
    /**
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
    
    public void selectAylesburyTicket()
    {
        issuedTicket = aylesburyTicket;
    }

    public void selectHighWycombeTicket()
    {
        issuedTicket = highWycombeTicket;
    }
    
    public void selectAmershamTicket()
    {
        issuedTicket = amershamTicket;
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
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

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

